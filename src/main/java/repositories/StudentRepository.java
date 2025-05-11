package repositories;

import core.Student;
import org.springframework.data.jpa.repository.JpaRepository; // Correct import
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> { // Extend JpaRepository
    // Custom methods (Spring auto-implements these based on naming conventions)
    List<Student> findByAcademicYear(String academicYear);
    List<Student> findByMajor(String major);
}