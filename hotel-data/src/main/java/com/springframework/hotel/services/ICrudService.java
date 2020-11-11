package com.springframework.hotel.services;

import java.util.List;

public interface ICrudService<T, ID> {
    List<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
