package com.victortello.repositories;

import java.util.List;

public interface Repositorio<T> {
    List<T> Find();
    T FindById(Long id);
    void save(T t);
    void delete(Long id);
    
}
