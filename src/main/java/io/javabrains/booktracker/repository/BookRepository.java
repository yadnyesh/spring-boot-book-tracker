package io.javabrains.booktracker.repository;

import io.javabrains.booktracker.model.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;


public interface BookRepository extends CassandraRepository<Book, String> {

}
