package repositories.inmemory;

import core.MentalHealthAssessment;
import repositories.MentalHealthAssessmentRepository;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryMentalHealthAssessmentRepository extends InMemoryRepository<MentalHealthAssessment, String> 
        implements MentalHealthAssessmentRepository {
    
    @Override
    protected String getId(MentalHealthAssessment entity) {
        return entity.getAssessmentId();
    }
    
    @Override
    public List<MentalHealthAssessment> findByType(String type) {
        return storage.values().stream()
                .filter(assessment -> type.equals(assessment.getType()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<MentalHealthAssessment> findByScoreGreaterThan(int threshold) {
        return storage.values().stream()
                .filter(assessment -> assessment.getScore() > threshold)
                .collect(Collectors.toList());
    }
}