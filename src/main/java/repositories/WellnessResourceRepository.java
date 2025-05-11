package repositories;

import core.WellnessResource;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WellnessResourceRepository extends JpaRepository<WellnessResource, String> {
    // Resource-specific methods
    List<WellnessResource> findByType(String type);
    List<WellnessResource> findByTopic(String topic);
}