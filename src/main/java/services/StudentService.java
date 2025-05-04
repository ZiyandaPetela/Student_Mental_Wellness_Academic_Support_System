package services;

import core.Student;
import repositories.StudentRepository;

import java.util.List;
import java.util.Optional;

public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public List<Student> getStudentsByAcademicYear(String academicYear) {
        return studentRepository.findByAcademicYear(academicYear);
    }

    public List<Student> getStudentsByMajor(String major) {
        return studentRepository.findByMajor(major);
    }

    public Student createStudent(Student student) {
        // Validate data before saving
        if (student.getStudentId() == null || student.getStudentId().trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty");
        }
        
        if (student.getEmail() == null || student.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Student email cannot be empty");
        }
        
        // Check if student already exists
        if (studentRepository.findById(student.getStudentId()).isPresent()) {
            throw new IllegalArgumentException("Student with ID " + student.getStudentId() + " already exists");
        }
        
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, Student updatedStudent) {
        // Validate student exists
        Student existingStudent = studentRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Student with ID " + id + " not found"));
        
        // Update fields
        existingStudent.setEmail(updatedStudent.getEmail());
        existingStudent.setAcademicYear(updatedStudent.getAcademicYear());
        existingStudent.setMajor(updatedStudent.getMajor());
        
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(String id) {
        // Check if student exists before deletion
        if (!studentRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("Student with ID " + id + " not found");
        }
        
        studentRepository.deleteById(id);
    }
}