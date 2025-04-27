
package test.tests;

import core.Appointment;
import core.Counselor;
import core.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.AppointmentRepository;
import repositories.inmemory.InMemoryAppointmentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryAppointmentRepositoryTest {

    private AppointmentRepository repository;
    private Appointment appointment1;
    private Appointment appointment2;
    private Appointment appointment3;
    private Student student1;
    private Student student2;
    private Counselor counselor1;
    private LocalDateTime now;

    @BeforeEach
    void setUp() {
        repository = new InMemoryAppointmentRepository();
        now = LocalDateTime.now();
        LocalDateTime tomorrow = now.plusDays(1);
        LocalDateTime nextWeek = now.plusWeeks(1);

        // Assuming your Student class needs ID, Name, Email, Major, Academic Year
        student1 = new Student("S1001", "John Doe", "john@example.com", "Computer Science", "Junior");
        student2 = new Student("S1002", "Jane Smith", "jane@example.com", "Psychology", "Senior");

        // Assuming your Counselor class needs ID, Specialization
        counselor1 = new Counselor("C1001", "Anxiety");

        // Appointments
        appointment1 = new Appointment("A1001", now);
        appointment1.setStudent(student1);
        appointment1.setCounselor(counselor1);
        appointment1.setStatus("CONFIRMED");

        appointment2 = new Appointment("A1002", tomorrow);
        appointment2.setStudent(student1);
        appointment2.setCounselor(counselor1);
        appointment2.setStatus("REQUESTED");

        appointment3 = new Appointment("A1003", nextWeek);
        appointment3.setStudent(student2);
        appointment3.setCounselor(counselor1);
        appointment3.setStatus("CONFIRMED");

        repository.save(appointment1);
        repository.save(appointment2);
        repository.save(appointment3);
    }

    @Test
    void testFindById() {
        Optional<Appointment> found = repository.findById("A1001");
        assertTrue(found.isPresent());
        assertEquals("CONFIRMED", found.get().getStatus());
    }

    @Test
    void testFindAll() {
        List<Appointment> all = repository.findAll();
        assertEquals(3, all.size());
    }

    @Test
    void testSave() {
        LocalDateTime twoWeeksLater = now.plusWeeks(2);
        Appointment newAppointment = new Appointment("A1004", twoWeeksLater);
        newAppointment.setStudent(student2);
        newAppointment.setCounselor(counselor1);
        newAppointment.setStatus("REQUESTED");

        repository.save(newAppointment);

        Optional<Appointment> found = repository.findById("A1004");
        assertTrue(found.isPresent());
    }

    @Test
    void testDelete() {
        repository.delete("A1001");
        Optional<Appointment> found = repository.findById("A1001");
        assertFalse(found.isPresent());
        assertEquals(2, repository.findAll().size());
    }

    @Test
    void testFindByStudentId() {
        List<Appointment> results = repository.findByStudentId("S1001");
        assertEquals(2, results.size());
    }

    @Test
    void testFindByCounselorId() {
        List<Appointment> results = repository.findByCounselorId("C1001");
        assertEquals(3, results.size());
    }

    @Test
    void testFindByStatus() {
        List<Appointment> results = repository.findByStatus("CONFIRMED");
        assertEquals(2, results.size());
    }

    @Test
    void testFindByDateRange() {
        LocalDateTime start = now.minusDays(1);
        LocalDateTime end = now.plusDays(2);

        List<Appointment> results = repository.findByDateRange(start, end);
        assertEquals(2, results.size());
    }
}
