package repositories.inmemory;

import core.Appointment;
import repositories.AppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryAppointmentRepository extends InMemoryRepository<Appointment, String> implements AppointmentRepository {
    
    @Override
    protected String getId(Appointment entity) {
        return entity.getAppointmentId();
    }
    
    @Override
    public List<Appointment> findByStudentId(String studentId) {
        return storage.values().stream()
                .filter(appointment -> appointment.getStudent() != null && 
                        studentId.equals(appointment.getStudent().getStudentId()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Appointment> findByCounselorId(String counselorId) {
        return storage.values().stream()
                .filter(appointment -> appointment.getCounselor() != null && 
                        counselorId.equals(appointment.getCounselor().getCounselorId()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Appointment> findByStatus(String status) {
        return storage.values().stream()
                .filter(appointment -> status.equals(appointment.getStatus()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Appointment> findByDateRange(LocalDateTime start, LocalDateTime end) {
        return storage.values().stream()
                .filter(appointment -> {
                    LocalDateTime appointmentTime = appointment.getDatetime();
                    return !appointmentTime.isBefore(start) && !appointmentTime.isAfter(end);
                })
                .collect(Collectors.toList());
    }
}