package repositories;

import core.WellnessResource;
import java.util.List;

public interface WellnessResourceRepository extends Repository<WellnessResource, String> {
    // Resource-specific methods
    List<WellnessResource> findByType(String type);
    List<WellnessResource> findByTopic(String topic);
}