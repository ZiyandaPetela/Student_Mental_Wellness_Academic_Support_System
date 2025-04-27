package repositories;

import core.Student;
import java.util.List;

public interface StudentRepository extends Repository<Student, String> {
    // Student-specific methods
    List<Student> findByAcademicYear(String academicYear);
    List<Student> findByMajor(String major);
}