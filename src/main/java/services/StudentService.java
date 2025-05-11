package services;

import core.Student;
import exceptions.DuplicateStudentException;
import exceptions.StudentNotFoundException;
import exceptions.InvalidDataException;
import repositories.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@Transactional
public class StudentService {

    private final StudentRepository studentRepository;
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$");

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Get all students with pagination support
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public List<Student> getStudentsByAcademicYear(String academicYear) {
        validateAcademicYear(academicYear);
        return studentRepository.findByAcademicYear(academicYear);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.findByMajor(major);
    }

    @Transactional
    public Student createStudent(Student student) {
        validateStudentData(student);
        checkDuplicateStudent(student.getStudentId());
        return studentRepository.save(student);
    }

    @Transactional
    public Student updateStudent(String id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
            .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));

        validateUpdateData(updatedStudent);
        updateStudentFields(existingStudent, updatedStudent);
        return studentRepository.save(existingStudent);
    }

    @Transactional
    public void deleteStudent(String id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }
        studentRepository.deleteById(id);
    }

    // Validation methods
    private void validateStudentData(Student student) {
        if (student.getStudentId() == null || student.getStudentId().trim().isEmpty()) {
            throw new InvalidDataException("Student ID cannot be empty");
        }

        if (student.getEmail() == null || !EMAIL_PATTERN.matcher(student.getEmail()).matches()) {
            throw new InvalidDataException("Invalid email format");
        }

        validateAcademicYear(student.getAcademicYear());
    }

    private void validateAcademicYear(String academicYear) {
        if (academicYear == null || !academicYear.matches("\\d{4}-\\d{4}")) {
            throw new InvalidDataException("Academic year must be in format YYYY-YYYY");
        }
    }

    private void checkDuplicateStudent(String studentId) {
        if (studentRepository.existsById(studentId)) {
            throw new DuplicateStudentException("Student already exists with ID: " + studentId);
        }
    }

    private void validateUpdateData(Student updatedStudent) {
        if (updatedStudent.getEmail() != null && !EMAIL_PATTERN.matcher(updatedStudent.getEmail()).matches()) {
            throw new InvalidDataException("Invalid email format");
        }
    }

    private void updateStudentFields(Student existing, Student updated) {
        if (updated.getEmail() != null) existing.setEmail(updated.getEmail());
        if (updated.getAcademicYear() != null) existing.setAcademicYear(updated.getAcademicYear());
        if (updated.getMajor() != null) existing.setMajor(updated.getMajor());
    }
}