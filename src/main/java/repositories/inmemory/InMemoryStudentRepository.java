package repositories.inmemory;

import core.Student;
import repositories.StudentRepository;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryStudentRepository extends InMemoryRepository<Student, String> implements StudentRepository {
    
    @Override
    protected String getId(Student entity) {
        return entity.getStudentId();
    }
    
    @Override
    public List<Student> findByAcademicYear(String academicYear) {
        return storage.values().stream()
                .filter(student -> academicYear.equals(student.getAcademicYear()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<Student> findByMajor(String major) {
        return storage.values().stream()
                .filter(student -> major.equals(student.getMajor()))
                .collect(Collectors.toList());
    }
}