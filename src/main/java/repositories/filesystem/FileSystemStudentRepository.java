package repositories.filesystem;

import core.Student;
import repositories.StudentRepository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class FileSystemStudentRepository implements StudentRepository {
    private final String filePath;
    private final ObjectMapper objectMapper;

    public FileSystemStudentRepository(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        
        // Create the file if it doesn't exist
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
                // Initialize with empty array
                Files.write(Paths.get(filePath), "[]".getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize file storage", e);
        }
    }

    @Override
    public void save(Student student) {
        try {
            List<Student> students = findAll();
            
            // Update existing or add new
            boolean updated = false;
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).getStudentId().equals(student.getStudentId())) {
                    students.set(i, student);
                    updated = true;
                    break;
                }
            }
            
            if (!updated) {
                students.add(student);
            }
            
            // Write back to file
            objectMapper.writeValue(new File(filePath), students);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save student", e);
        }
    }

    @Override
    public Optional<Student> findById(String id) {
        return findAll().stream()
                .filter(student -> student.getStudentId().equals(id))
                .findFirst();
    }

    @Override
    public List<Student> findAll() {
        try {
            File file = new File(filePath);
            if (file.length() == 0) {
                return new ArrayList<>();
            }
            
            CollectionType listType = objectMapper.getTypeFactory()
                    .constructCollectionType(ArrayList.class, Student.class);
            return objectMapper.readValue(file, listType);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read students from file", e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            List<Student> students = findAll();
            List<Student> filtered = students.stream()
                    .filter(student -> !student.getStudentId().equals(id))
                    .collect(Collectors.toList());
            
            objectMapper.writeValue(new File(filePath), filtered);
        } catch (IOException e) {
            throw new RuntimeException("Failed to delete student", e);
        }
    }

    @Override
    public List<Student> findByAcademicYear(String academicYear) {
        return findAll().stream()
                .filter(student -> academicYear.equals(student.getAcademicYear()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> findByMajor(String major) {
        return findAll().stream()
                .filter(student -> major.equals(student.getMajor()))
                .collect(Collectors.toList());
    }
}