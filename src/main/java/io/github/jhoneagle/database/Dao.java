package io.github.jhoneagle.database;

import java.util.List;

public interface Dao<T, S> {
    T findOne(S key);
    List<T> findAll();
    boolean save(T newOne);
    boolean update(T update);
    void remove(S key);
}
