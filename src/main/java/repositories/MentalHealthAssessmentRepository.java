package repositories;

import core.MentalHealthAssessment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentalHealthAssessmentRepository extends JpaRepository<MentalHealthAssessment, String> {
    // Assessment-specific methods
    List<MentalHealthAssessment> findByType(String type);
    List<MentalHealthAssessment> findByScoreGreaterThan(int threshold);
}