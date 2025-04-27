package test.tests;

import core.Student;
import core.Counselor;
import core.Appointment;
import core.MentalHealthAssessment;
import core.EmergencyAlert;
import core.WellnessResource;
import factories.RepositoryFactory;
import org.junit.jupiter.api.Test;
import repositories.*;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryFactoryTest {
    
    @Test
    void testGetGenericRepositoryInMemory() {
        // When
        Repository<Student, String> studentRepo = RepositoryFactory.getRepository("MEMORY", Student.class);
        Repository<Counselor, String> counselorRepo = RepositoryFactory.getRepository("MEMORY", Counselor.class);
        
        // Then
        assertNotNull(studentRepo);
        assertNotNull(counselorRepo);
        assertTrue(studentRepo instanceof StudentRepository);
        assertTrue(counselorRepo instanceof CounselorRepository);
    }
    
    @Test
    void testGetSpecificRepositoriesInMemory() {
        // When
        StudentRepository studentRepo = RepositoryFactory.getStudentRepository("MEMORY");
        CounselorRepository counselorRepo = RepositoryFactory.getCounselorRepository("MEMORY");
        AppointmentRepository appointmentRepo = RepositoryFactory.getAppointmentRepository("MEMORY");
        MentalHealthAssessmentRepository assessmentRepo = RepositoryFactory.getMentalHealthAssessmentRepository("MEMORY");
        EmergencyAlertRepository alertRepo = RepositoryFactory.getEmergencyAlertRepository("MEMORY");
        WellnessResourceRepository resourceRepo = RepositoryFactory.getWellnessResourceRepository("MEMORY");
        
        // Then
        assertNotNull(studentRepo);
        assertNotNull(counselorRepo);
        assertNotNull(appointmentRepo);
        assertNotNull(assessmentRepo);
        assertNotNull(alertRepo);
        assertNotNull(resourceRepo);
    }
    
    @Test
    void testUnsupportedEntityType() {
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            RepositoryFactory.getRepository("MEMORY", String.class);
        });
    }
    
    @Test
    void testUnsupportedStorageType() {
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> {
            RepositoryFactory.getRepository("INVALID_STORAGE", Student.class);
        });
    }
    
    @Test
    void testFileSystemRepositoryNotImplemented() {
        // When & Then
        assertThrows(UnsupportedOperationException.class, () -> {
            RepositoryFactory.getRepository("FILE", Student.class);
        });
    }
    
    @Test
    void testDatabaseRepositoryNotImplemented() {
        // When & Then
        assertThrows(UnsupportedOperationException.class, () -> {
            RepositoryFactory.getRepository("DATABASE", Student.class);
        });
    }
}