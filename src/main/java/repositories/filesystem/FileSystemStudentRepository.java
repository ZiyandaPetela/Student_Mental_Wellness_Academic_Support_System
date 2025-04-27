package repositories.filesystem;

import core.Student;
import repositories.StudentRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * JSON file-based implementation of StudentRepository with in-memory caching.
 * Uses synchronized methods for thread safety and periodic file synchronization.
 */
public class FileSystemStudentRepository implements StudentRepository {
    private final String filePath;
    private final ObjectMapper objectMapper;
    private final Map<String, Student> inMemoryCache = new HashMap<>();

    /**
     * Initializes repository with file storage and loads existing data into cache.
     * @param filePath Path to JSON storage file
     * @throws RuntimeException If file initialization fails
     */
    public FileSystemStudentRepository(String filePath) {
        this.filePath = filePath;
        this.objectMapper = new ObjectMapper();
        
        try {
            initializeStorageFile();
            loadCacheFromFile();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize file storage", e);
        }
    }

    /**
     * Creates storage file with empty array if it doesn't exist
     */
    private void initializeStorageFile() throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
            Files.write(Paths.get(filePath), "[]".getBytes());
        }
    }

    /**
     * Loads data from file into in-memory cache
     */
    private synchronized void loadCacheFromFile() {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            CollectionType listType = objectMapper.getTypeFactory()
                    .constructCollectionType(ArrayList.class, Student.class);
            List<Student> students = objectMapper.readValue(fis, listType);
            
            inMemoryCache.clear();
            students.forEach(student -> 
                inMemoryCache.put(student.getStudentId(), student)
            );
        } catch (JsonParseException e) {
            throw new RuntimeException("Invalid JSON format in file", e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load data from file", e);
        }
    }

    /**
     * Synchronizes in-memory cache with persistent file storage
     */
    private synchronized void syncCacheWithFile() {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            objectMapper.writeValue(fos, new ArrayList<>(inMemoryCache.values()));
        } catch (IOException e) {
            throw new RuntimeException("Failed to synchronize with file storage", e);
        }
    }

    @Override
    public synchronized void save(Student student) {
        inMemoryCache.put(student.getStudentId(), student);
        syncCacheWithFile();
    }

    @Override
    public synchronized void delete(String id) {
        inMemoryCache.remove(id);
        syncCacheWithFile();
    }

    @Override
    public Optional<Student> findById(String id) {
        return Optional.ofNullable(inMemoryCache.get(id));
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(inMemoryCache.values());
    }

    @Override
    public List<Student> findByAcademicYear(String academicYear) {
        return inMemoryCache.values().stream()
                .filter(student -> academicYear.equals(student.getAcademicYear()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> findByMajor(String major) {
        return inMemoryCache.values().stream()
                .filter(student -> major.equals(student.getMajor()))
                .collect(Collectors.toList());
    }
}