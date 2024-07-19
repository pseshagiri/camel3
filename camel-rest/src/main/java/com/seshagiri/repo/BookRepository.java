package com.seshagiri.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.seshagiri.pojo.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
