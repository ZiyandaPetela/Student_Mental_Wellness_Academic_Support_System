package repositories;

import core.Appointment;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends Repository<Appointment, String> {
    // Appointment-specific methods
    List<Appointment> findByStudentId(String studentId);
    List<Appointment> findByCounselorId(String counselorId);
    List<Appointment> findByStatus(String status);
    List<Appointment> findByDateRange(LocalDateTime start, LocalDateTime end);
}