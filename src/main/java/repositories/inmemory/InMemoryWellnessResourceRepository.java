package repositories.inmemory;

import core.WellnessResource;
import repositories.WellnessResourceRepository;
import java.util.List;
import java.util.stream.Collectors;

public class InMemoryWellnessResourceRepository extends JpaRepository<WellnessResource, String> 
        implements WellnessResourceRepository {
    
    @Override
    protected String getId(WellnessResource entity) {
        return entity.getResourceId();
    }
    
    @Override
    public List<WellnessResource> findByType(String type) {
        return storage.values().stream()
                .filter(resource -> type.equals(resource.getType()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<WellnessResource> findByTopic(String topic) {
        return storage.values().stream()
                .filter(resource -> resource.getTitle().contains(topic))
                .collect(Collectors.toList());
    }
}