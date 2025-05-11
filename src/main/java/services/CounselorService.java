package services;

import core.Counselor;
import exceptions.CounselorNotFoundException;
import exceptions.DuplicateCounselorException;
import exceptions.InvalidDataException;
import repositories.CounselorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
        validateSpecialization(specialization);
        return counselorRepository.findBySpecialization(specialization);
    }

    @Transactional
    public Counselor createCounselor(Counselor counselor) {
        validateCounselorData(counselor);
        checkDuplicateCounselor(counselor.getCounselorId());
        return counselorRepository.save(counselor);
    }

    @Transactional
    public Counselor updateCounselor(String id, Counselor updatedCounselor) {
        Counselor existingCounselor = counselorRepository.findById(id)
            .orElseThrow(() -> new CounselorNotFoundException("Counselor not found with ID: " + id));

        validateUpdateData(updatedCounselor);
        updateCounselorFields(existingCounselor, updatedCounselor);
        return counselorRepository.save(existingCounselor);
    }

    @Transactional
    public void deleteCounselor(String id) {
        if (!counselorRepository.existsById(id)) {
            throw new CounselorNotFoundException("Counselor not found with ID: " + id);
        }
        counselorRepository.deleteById(id);
    }

    // Validation methods
    private void validateCounselorData(Counselor counselor) {
        if (counselor.getCounselorId() == null || counselor.getCounselorId().trim().isEmpty()) {
            throw new InvalidDataException("Counselor ID cannot be empty");
        }

        if (counselor.getSpecialization() == null || counselor.getSpecialization().trim().isEmpty()) {
            throw new InvalidDataException("Counselor specialization cannot be empty");
        }
    }

    private void validateSpecialization(String specialization) {
        // Add specific validation rules if needed (e.g., predefined list)
        if (specialization == null || specialization.trim().isEmpty()) {
            throw new InvalidDataException("Specialization cannot be empty");
        }
    }

    private void checkDuplicateCounselor(String counselorId) {
        if (counselorRepository.existsById(counselorId)) {
            throw new DuplicateCounselorException("Counselor already exists with ID: " + counselorId);
        }
    }

    private void validateUpdateData(Counselor updatedCounselor) {
        if (updatedCounselor.getSpecialization() != null && updatedCounselor.getSpecialization().trim().isEmpty()) {
            throw new InvalidDataException("Specialization cannot be empty");
        }
    }

    private void updateCounselorFields(Counselor existing, Counselor updated) {
        if (updated.getSpecialization() != null) {
            existing.setSpecialization(updated.getSpecialization());
        }
        // Add other field updates as needed
    }
}