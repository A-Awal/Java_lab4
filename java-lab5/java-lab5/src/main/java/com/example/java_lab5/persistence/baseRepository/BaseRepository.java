package com.example.java_lab5.persistence.BaseRepository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BaseRepository<E, T> extends CrudRepository<E,T>, PagingAndSortingRepository<E, T> {
}
