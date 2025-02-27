package kz.onelab.repository.impl;

import kz.onelab.dto.Book;
import kz.onelab.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final List<Book> books = new ArrayList<>();

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public void saveBook(Book book) {
        books.add(book);
    }
}
