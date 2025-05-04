package services;

import core.Counselor;
import repositories.CounselorRepository;

import java.util.List;
import java.util.Optional;

public class CounselorService {
    private final CounselorRepository counselorRepository;

    public CounselorService(CounselorRepository counselorRepository) {
        this.counselorRepository = counselorRepository;
    }

    public List<Counselor> getAllCounselors() {
        return counselorRepository.findAll();
    }

    public Optional<Counselor> getCounselorById(String id) {
        return counselorRepository.findById(id);
    }

    public List<Counselor> getCounselorsBySpecialization(String specialization) {
        return counselorRepository.findBySpecialization(specialization);
    }

    public Counselor createCounselor(Counselor counselor) {
        // Validate data
        if (counselor.getCounselorId() == null || counselor.getCounselorId().trim().isEmpty()) {
            throw new IllegalArgumentException("Counselor ID cannot be empty");
        }
        
        if (counselor.getSpecialization() == null || counselor.getSpecialization().trim().isEmpty()) {
            throw new IllegalArgumentException("Counselor specialization cannot be empty");
        }
        
        // Check if counselor already exists
        if (counselorRepository.findById(counselor.getCounselorId()).isPresent()) {
            throw new IllegalArgumentException("Counselor with ID " + counselor.getCounselorId() + " already exists");
        }
        
        return counselorRepository.save(counselor);
    }

    public Counselor updateCounselor(String id, Counselor updatedCounselor) {
        // Validate counselor exists
        Counselor existingCounselor = counselorRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Counselor with ID " + id + " not found"));
        
        // In a real application, you would update all fields
        // For this assignment, we only have specialization to update
        if (updatedCounselor.getSpecialization() != null) {
            existingCounselor = new Counselor(existingCounselor.getCounselorId(), updatedCounselor.getSpecialization());
            
            // Copy over the appointments
            updatedCounselor.getManagedAppointments().forEach(existingCounselor::confirmAppointment);
        }
        
        return counselorRepository.save(existingCounselor);
    }

    public void deleteCounselor(String id) {
        // Check if counselor exists before deletion
        if (!counselorRepository.findById(id).isPresent()) {
            throw new IllegalArgumentException("Counselor with ID " + id + " not found");
        }
        
        counselorRepository.deleteById(id);
    }
}