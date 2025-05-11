package repositories.inmemory;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import java.util.*;
import java.util.function.Function;

public abstract class InMemoryJpaRepository<T, ID> implements JpaRepository<T, ID> {
    protected final Map<ID, T> storage = new HashMap<>();

    // Required methods from JpaRepository
    @Override
    public <S extends T> S save(S entity) {
        ID id = getId(entity);
        storage.put(id, entity);
        return entity;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public boolean existsById(ID id) {
        return storage.containsKey(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public List<T> findAll(Sort sort) {
        return findAll(); // Simplified (no sorting logic)
    }

    @Override
    public void deleteById(ID id) {
        storage.remove(id);
    }

    @Override
    public void delete(T entity) {
        deleteById(getId(entity));
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }

    // Other required methods (stubbed)
    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        List<S> savedEntities = new ArrayList<>();
        entities.forEach(entity -> savedEntities.add(save(entity)));
        return savedEntities;
    }

    @Override
    public void flush() {
        // No-op for in-memory
    }

    @Override
    public <S extends T> S saveAndFlush(S entity) {
        return save(entity);
    }

    @Override
    public <S extends T> List<S> saveAllAndFlush(Iterable<S> entities) {
        return saveAll(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<T> entities) {
        entities.forEach(this::delete);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<ID> ids) {
        ids.forEach(this::deleteById);
    }

    @Override
    public void deleteAllInBatch() {
        deleteAll();
    }

    @Override
    public T getReferenceById(ID id) {
        return findById(id).orElseThrow();
    }

    // QueryByExampleExecutor methods (stubbed)
    @Override
    public <S extends T> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return new ArrayList<>();
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return new ArrayList<>();
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends T, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    protected abstract ID getId(T entity);
}