package com.waa.assignments.services;

public interface BaseService<T, ID> {

    public void save(T t);

    public T getById(ID id);

    public void delete(T t);


    public void deleteByID(ID id);

    public void update(ID id, T t);


}
