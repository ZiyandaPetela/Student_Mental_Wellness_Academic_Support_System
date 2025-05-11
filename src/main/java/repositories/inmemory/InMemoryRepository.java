package repositories.inmemory;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import repositories.Repository;
import java.util.*;
import java.util.function.Function;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import repositories.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import java.util.stream.Collectors;
public abstract class InMemoryRepository<T, ID> implements Repository<T, ID> {
    
    
    protected final Map<ID, T> storage = new HashMap<>();
    

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
    public void deleteById(ID id) {
        storage.remove(id);
    }

    // Add remaining required method implementations
    @Override
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        List<S> result = new ArrayList<>();
        entities.forEach(entity -> result.add(save(entity)));
        return result;
    }

    @Override
    public List<T> findAll(Sort sort) {
        return findAll();
    }

    @Override
    public void delete(T entity) {
        deleteById(getId(entity));
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }

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