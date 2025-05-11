package repositories.inmemory;

import java.util.*;

public abstract class BaseInMemoryRepository<T> {
    protected final Map<Long, T> storage = new HashMap<>();
    protected long currentId = 1;

    public T save(T entity) {
        if (entity.getId() == null) {  // Assuming entities have getId()
            entity.setId(currentId++); // and setId()
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
}