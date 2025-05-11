package services;

import core.Appointment;
import core.Counselor;
import core.Student;
import exceptions.*;
import repositories.AppointmentRepository;
import repositories.CounselorRepository;
import repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final StudentRepository studentRepository;
    private final CounselorRepository counselorRepository;

    public AppointmentService(
            AppointmentRepository appointmentRepository,
            StudentRepository studentRepository,
            CounselorRepository counselorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.studentRepository = studentRepository;
        this.counselorRepository = counselorRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Optional<Appointment> getAppointmentById(String id) {
        return appointmentRepository.findById(id);
    }

    public List<Appointment> getAppointmentsByStudentId(String studentId) {
        return appointmentRepository.findByStudentId(studentId);
    }

    public List<Appointment> getAppointmentsByCounselorId(String counselorId) {
        return appointmentRepository.findByCounselorId(counselorId);
    }

    public List<Appointment> getAppointmentsByStatus(String status) {
        return appointmentRepository.findByStatus(status);
    }

    public List<Appointment> getAppointmentsByDateRange(LocalDateTime start, LocalDateTime end) {
        return appointmentRepository.findByDateRange(start, end);
    }

    @Transactional
    public Appointment createAppointment(String appointmentId, LocalDateTime dateTime, 
                                         String studentId, String counselorId) {
        // Validate inputs
        if (appointmentId == null || appointmentId.trim().isEmpty()) {
            throw new InvalidDataException("Appointment ID cannot be empty");
        }
        
        if (dateTime == null) {
            throw new InvalidDataException("Appointment date/time cannot be empty");
        }
        
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new InvalidDataException("Appointment cannot be scheduled in the past");
        }
        
        // Check duplicate appointment
        if (appointmentRepository.existsById(appointmentId)) {
            throw new DuplicateAppointmentException("Appointment with ID " + appointmentId + " already exists");
        }
        
        // Retrieve student and counselor
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + studentId));
        
        Counselor counselor = counselorRepository.findById(counselorId)
            .orElseThrow(() -> new CounselorNotFoundException("Counselor not found with ID: " + counselorId));
        
        // Check student's appointment limit
        if (student.getAppointments().size() >= 3) {
            throw new AppointmentLimitExceededException("Student has reached the maximum limit of 3 appointments");
        }
        
        // Create appointment
        Appointment appointment = new Appointment(appointmentId, dateTime);
        
        // Schedule appointment for student
        boolean scheduled = student.addAppointment(appointment);
        if (!scheduled) {
            throw new AppointmentSchedulingException("Failed to schedule appointment for student");
        }
        
        // Confirm appointment for counselor
        boolean confirmed = counselor.confirmAppointment(appointment);
        if (!confirmed) {
            throw new AppointmentSchedulingException("Failed to confirm appointment with counselor");
        }
        
        // Save entities
        studentRepository.save(student);
        counselorRepository.save(counselor);
        
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment updateAppointmentStatus(String id, String status) {
        Appointment appointment = appointmentRepository.findById(id)
            .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + id));
        
        appointment.setStatus(status);
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment rescheduleAppointment(String id, LocalDateTime newDateTime) {
        Appointment appointment = appointmentRepository.findById(id)
            .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + id));
        
        if (newDateTime == null) {
            throw new InvalidDataException("New appointment date/time cannot be empty");
        }
        
        if (newDateTime.isBefore(LocalDateTime.now())) {
            throw new InvalidDataException("Appointment cannot be rescheduled to a past date/time");
        }
        
        appointment.setDateTime(newDateTime);
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment cancelAppointment(String id) {
        Appointment appointment = appointmentRepository.findById(id)
            .orElseThrow(() -> new AppointmentNotFoundException("Appointment not found with ID: " + id));
        
        boolean cancelled = appointment.cancel();
        if (!cancelled) {
            throw new AppointmentCancellationException("Appointment is already cancelled");
        }
        
        return appointmentRepository.save(appointment);
    }
}