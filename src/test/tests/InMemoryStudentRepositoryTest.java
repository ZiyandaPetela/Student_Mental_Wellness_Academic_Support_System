package tests;

import core.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.StudentRepository;
import repositories.inmemory.InMemoryStudentRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryStudentRepositoryTest {
    
    private StudentRepository repository;
    
    @BeforeEach
    void setUp() {
        repository = new InMemoryStudentRepository();
    }
    
    @Test
    void testSaveAndFindById() {
        // Create a student
        Student student = new Student("S123", "John Doe", "john.doe@example.com", "Computer Science", "Junior");
        
        // Save the student
        repository.save(student);
        
        // Find by ID
        Optional<Student> found = repository.findById("S123");
        
        // Verify
        assertTrue(found.isPresent());
        assertEquals("John Doe", found.get().getName());
        assertEquals("Computer Science", found.get().getMajor());
    }
    
    @Test
    void testFindAll() {
        // Create students
        Student student1 = new Student("S123", "John Doe", "john.doe@example.com", "Computer Science", "Junior");
        Student student2 = new Student("S456", "Jane Smith", "jane.smith@example.com", "Psychology", "Senior");
        
        // Save students
        repository.save(student1);
        repository.save(student2);
        
        // Find all
        List<Student> students = repository.findAll();
        
        // Verify
        assertEquals(2, students.size());
        assertTrue(students.stream().anyMatch(s -> s.getStudentId().equals("S123")));
        assertTrue(students.stream().anyMatch(s -> s.getStudentId().equals("S456")));
    }
    
    @Test
    void testDelete() {
        // Create a student
        Student student = new Student("S123", "John Doe", "john.doe@example.com", "Computer Science", "Junior");
        
        // Save the student
        repository.save(student);
        
        // Verify it exists
        assertTrue(repository.findById("S123").isPresent());
        
        // Delete the student
        repository.delete("S123");
        
        // Verify it's gone
        assertFalse(repository.findById("S123").isPresent());
    }
    
    @Test
    void testFindByAcademicYear() {
        // Create students
        Student student1 = new Student("S123", "John Doe", "john.doe@example.com", "Computer Science", "Junior");
        Student student2 = new Student("S456", "Jane Smith", "jane.smith@example.com", "Psychology", "Senior");
        Student student3 = new Student("S789", "Bob Wilson", "bob.wilson@example.com", "Engineering", "Junior");
        
        // Save students
        repository.save(student1);
        repository.save(student2);
        repository.save(student3);
        
        // Find by academic year
        List<Student> juniors = repository.findByAcademicYear("Junior");
        
        // Verify
        assertEquals(2, juniors.size());
        assertTrue(juniors.stream().anyMatch(s -> s.getStudentId().equals("S123")));
        assertTrue(juniors.stream().anyMatch(s -> s.getStudentId().equals("S789")));
    }
    
    @Test
    void testFindByMajor() {
        // Create students
        Student student1 = new Student("S123", "John Doe", "john.doe@example.com", "Computer Science", "Junior");
        Student student2 = new Student("S456", "Jane Smith", "jane.smith@example.com", "Psychology", "Senior");
        Student student3 = new Student("S789", "Bob Wilson", "bob.wilson@example.com", "Computer Science", "Junior");
        
        // Save students
        repository.save(student1);
        repository.save(student2);
        repository.save(student3);
        
        // Find by major
        List<Student> csStudents = repository.findByMajor("Computer Science");
        
        // Verify
        assertEquals(2, csStudents.size());
        assertTrue(csStudents.stream().anyMatch(s -> s.getStudentId().equals("S123")));
        assertTrue(csStudents.stream().anyMatch(s -> s.getStudentId().equals("S789")));
    }
}