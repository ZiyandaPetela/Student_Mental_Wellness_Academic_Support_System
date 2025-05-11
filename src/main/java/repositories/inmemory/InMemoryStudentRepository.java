package repositories.inmemory;

import core.Student;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Profile("inmemory")
public class InMemoryStudentRepository extends InMemoryJpaRepository<Student, String> {

    @Override
    protected String getId(Student student) {
        return student.getStudentId();
    }

    // Custom query methods
    public List<Student> findByAcademicYear(String academicYear) {
        return storage.values().stream()
            .filter(s -> academicYear.equals(s.getAcademicYear()))
            .toList();
    }
}