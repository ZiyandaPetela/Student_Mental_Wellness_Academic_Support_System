package services;

import core.Appointment;
import core.Counselor;
import core.Student;
import repositories.AppointmentRepository;
import repositories.CounselorRepository;
import repositories.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Appointment createAppointment(String appointmentId, LocalDateTime dateTime, 
                                         String studentId, String counselorId) {
        // Validate inputs
        if (appointmentId == null || appointmentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Appointment ID cannot be empty");
        }
        
        if (dateTime == null) {
            throw new IllegalArgumentException("Appointment date/time cannot be empty");
        }
        
        if (dateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Appointment cannot be scheduled in the past");
        }
        
        // Check if appointment with same ID exists
        if (appointmentRepository.findById(appointmentId).isPresent()) {
            throw new IllegalArgumentException("Appointment with ID " + appointmentId + " already exists");
        }
        
        // Retrieve student and counselor
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new IllegalArgumentException("Student with ID " + studentId + " not found"));
        
        Counselor counselor = counselorRepository.findById(counselorId)
            .orElseThrow(() -> new IllegalArgumentException("Counselor with ID " + counselorId + " not found"));
        
        // Check if student already has 3 appointments
        if (student.getAppointments().size() >= 3) {
            throw new IllegalArgumentException("Student has reached the maximum limit of 3 appointments");
        }
        
        // Create appointment
        Appointment appointment = new Appointment(appointmentId, dateTime);
        appointment.setStudent(student);
        appointment.setCounselor(counselor);
        
        // Schedule appointment for student
        boolean scheduled = student.scheduleAppointment(appointment);
        if (!scheduled) {
            throw new IllegalStateException("Failed to schedule appointment for student");
        }
        
        // Confirm appointment for counselor
        boolean confirmed = counselor.confirmAppointment(appointment);
        if (!confirmed) {
            throw new IllegalStateException("Failed to confirm appointment with counselor");
        }
        
        // Save updated entities
        studentRepository.save(student);
        counselorRepository.save(counselor);
        
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointmentStatus(String id, String status) {
        // Validate appointment exists
        Appointment appointment = appointmentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Appointment with ID " + id + " not found"));
        
        // Update status
        appointment.setStatus(status);
        
        return appointmentRepository.save(appointment);
    }

    public Appointment rescheduleAppointment(String id, LocalDateTime newDateTime) {
        // Validate appointment exists
        Appointment appointment = appointmentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Appointment with ID " + id + " not found"));
        
        // Validate new date/time
        if (newDateTime == null) {
            throw new IllegalArgumentException("New appointment date/time cannot be empty");
        }
        
        if (newDateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Appointment cannot be rescheduled to a past date/time");
        }
        
        // Cancel current appointment
        appointment.cancel();
        
        // Create new appointment with same IDs but new date/time
        Appointment newAppointment = new Appointment(appointment.getAppointmentId(), newDateTime);
        newAppointment.setStudent(appointment.getStudent());
        newAppointment.setCounselor(appointment.getCounselor());
        
        return appointmentRepository.save(newAppointment);
    }

    public void cancelAppointment(String id) {
        // Validate appointment exists
        Appointment appointment = appointmentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Appointment with ID " + id + " not found"));
        
        // Cancel the appointment
        boolean cancelled = appointment.cancel();
        if (!cancelled) {
            throw new IllegalStateException("Failed to cancel appointment - it may already be cancelled");
        }
        
        appointmentRepository.save(appointment);
    }
}