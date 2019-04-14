package com.example.demo.Dao;

import java.util.List;

public interface DaoInterface<K, T> {
    T getById(K id);
    T create(T entity);
    T modify(K id, T entity);
    List<T> getAll();
}
