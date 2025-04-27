package factories;

import repositories.*;
import repositories.inmemory.*;

public class RepositoryFactory {

    public static <T, ID> Repository<T, ID> getRepository(String storageType, Class<T> entityClass) {
        switch (storageType) {
            case "MEMORY": 
                return getInMemoryRepository(entityClass);
            case "FILE":
                return getFileSystemRepository(entityClass);
            case "DATABASE":
                return getDatabaseRepository(entityClass);
            default: 
                throw new IllegalArgumentException("Invalid storage type: " + storageType);
        }
    }

    @SuppressWarnings("unchecked")
    private static <T, ID> Repository<T, ID> getInMemoryRepository(Class<T> entityClass) {
        if (entityClass.getSimpleName().equals("Student")) {
            return (Repository<T, ID>) new InMemoryStudentRepository();
        } else if (entityClass.getSimpleName().equals("Counselor")) {
            return (Repository<T, ID>) new InMemoryCounselorRepository();
        } else if (entityClass.getSimpleName().equals("Appointment")) {
            return (Repository<T, ID>) new InMemoryAppointmentRepository();
        } else if (entityClass.getSimpleName().equals("MentalHealthAssessment")) {
            return (Repository<T, ID>) new InMemoryMentalHealthAssessmentRepository();
        } else if (entityClass.getSimpleName().equals("EmergencyAlert")) {
            return (Repository<T, ID>) new InMemoryEmergencyAlertRepository();
        } else if (entityClass.getSimpleName().equals("WellnessResource")) {
            return (Repository<T, ID>) new InMemoryWellnessResourceRepository();
        } else {
            throw new IllegalArgumentException("Unsupported entity type: " + entityClass.getSimpleName());
        }
    }

    @SuppressWarnings("unchecked")
    private static <T, ID> Repository<T, ID> getFileSystemRepository(Class<T> entityClass) {
        // Stub implementation for future file system repositories
        throw new UnsupportedOperationException("File system repositories not yet implemented");
    }

    @SuppressWarnings("unchecked")
    private static <T, ID> Repository<T, ID> getDatabaseRepository(Class<T> entityClass) {
        // Stub implementation for future database repositories
        throw new UnsupportedOperationException("Database repositories not yet implemented");
    }

    // Convenience methods for specific repository types
    public static StudentRepository getStudentRepository(String storageType) {
        if ("MEMORY".equals(storageType)) {
            return new InMemoryStudentRepository();
        } else if ("FILE".equals(storageType)) {
            // Will be implemented in the future
            throw new UnsupportedOperationException("File system repositories not yet implemented");
        } else if ("DATABASE".equals(storageType)) {
            // Will be implemented in the future
            throw new UnsupportedOperationException("Database repositories not yet implemented");
        } else {
            throw new IllegalArgumentException("Invalid storage type: " + storageType);
        }
    }

    public static CounselorRepository getCounselorRepository(String storageType) {
        if ("MEMORY".equals(storageType)) {
            return new InMemoryCounselorRepository();
        } else {
            throw new UnsupportedOperationException("Other storage types not yet implemented");
        }
    }

    public static AppointmentRepository getAppointmentRepository(String storageType) {
        if ("MEMORY".equals(storageType)) {
            return new InMemoryAppointmentRepository();
        } else {
            throw new UnsupportedOperationException("Other storage types not yet implemented");
        }
    }
    
    public static MentalHealthAssessmentRepository getMentalHealthAssessmentRepository(String storageType) {
        if ("MEMORY".equals(storageType)) {
            return new InMemoryMentalHealthAssessmentRepository();
        } else {
            throw new UnsupportedOperationException("Other storage types not yet implemented");
        }
    }
    
    public static EmergencyAlertRepository getEmergencyAlertRepository(String storageType) {
        if ("MEMORY".equals(storageType)) {
            return new InMemoryEmergencyAlertRepository();
        } else {
            throw new UnsupportedOperationException("Other storage types not yet implemented");
        }
    }
    
    public static WellnessResourceRepository getWellnessResourceRepository(String storageType) {
        if ("MEMORY".equals(storageType)) {
            return new InMemoryWellnessResourceRepository();
        } else {
            throw new UnsupportedOperationException("Other storage types not yet implemented");
        }
    }
}