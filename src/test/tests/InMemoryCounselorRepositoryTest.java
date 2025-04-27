package test.tests;

import core.Counselor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.CounselorRepository;
import repositories.inmemory.InMemoryCounselorRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryCounselorRepositoryTest {
    
    private CounselorRepository repository;
    
    @BeforeEach
    void setUp() {
        repository = new InMemoryCounselorRepository();
    }
    
    @Test
    void testSaveAndFindById() {
        Counselor counselor = new Counselor("C123", "Anxiety");
        repository.save(counselor);
        
        Optional<Counselor> found = repository.findById("C123");
        assertTrue(found.isPresent());
        assertEquals("Anxiety", found.get().getSpecialization());
    }
    
    @Test
    void testFindAll() {
        repository.save(new Counselor("C123", "Anxiety"));
        repository.save(new Counselor("C456", "Depression"));
        
        List<Counselor> counselors = repository.findAll();
        assertEquals(2, counselors.size());
    }
    
    @Test
    void testDelete() {
        Counselor counselor = new Counselor("C123", "Anxiety");
        repository.save(counselor);
        repository.delete("C123");
        
        assertFalse(repository.findById("C123").isPresent());
    }
    
    @Test
    void testFindBySpecialization() {
        repository.save(new Counselor("C123", "Anxiety"));
        repository.save(new Counselor("C456", "Depression"));
        repository.save(new Counselor("C789", "Anxiety"));
        
        List<Counselor> anxietySpecialists = repository.findBySpecialization("Anxiety");
        assertEquals(2, anxietySpecialists.size());
    }
}
