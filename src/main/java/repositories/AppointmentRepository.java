package repositories;

import core.Appointment;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, String> {
    // Appointment-specific methods
    List<Appointment> findByStudentId(String studentId);
    List<Appointment> findByCounselorId(String counselorId);
    List<Appointment> findByStatus(String status);
    List<Appointment> findByDateRange(LocalDateTime start, LocalDateTime end);
}