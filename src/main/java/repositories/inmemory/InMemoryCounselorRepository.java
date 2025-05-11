package repositories.inmemory;

import core.Counselor;
import repositories.CounselorRepository;

import java.util.List;
import java.util.stream.Collectors;

public class InMemoryCounselorRepository extends InMemoryRepository<Counselor, String> implements CounselorRepository {
    
    @Override
    protected String getId(Counselor entity) {
        return entity.getCounselorId();
    }
    
    @Override
    public List<Counselor> findBySpecialization(String specialization) {
        return storage.values().stream()
                .filter(counselor -> specialization.equals(counselor.getSpecialization()))
                .collect(Collectors.toList());
    }
}