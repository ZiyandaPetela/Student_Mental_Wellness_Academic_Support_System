package repositories.inmemory;

import repositories.Repository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class InMemoryRepository<T, ID> implements Repository<T, ID> {
    protected final Map<ID, T> storage = new HashMap<>();
    
    @Override
    public void save(T entity) {
        ID id = getId(entity);
        storage.put(id, entity);
    }
    
    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(storage.get(id));
    }
    
    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
    
    @Override
    public void delete(ID id) {
        storage.remove(id);
    }
    
    // This method needs to be implemented by subclasses 
    // to extract the ID from an entity
    protected abstract ID getId(T entity);
}