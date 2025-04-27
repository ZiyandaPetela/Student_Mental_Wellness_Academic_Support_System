package repositories;

import core.MentalHealthAssessment;
import java.util.List;

public interface MentalHealthAssessmentRepository extends Repository<MentalHealthAssessment, String> {
    // Assessment-specific methods
    List<MentalHealthAssessment> findByType(String type);
    List<MentalHealthAssessment> findByScoreGreaterThan(int threshold);
}