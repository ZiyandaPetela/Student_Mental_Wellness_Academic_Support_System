package repositories;

import core.Student;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends Repository<Student, String> {
    // Student-specific methods
    List<Student> findByAcademicYear(String academicYear);
    List<Student> findByMajor(String major);
}
