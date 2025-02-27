package kz.onelab.repository;

import kz.onelab.dto.Book;
import java.util.List;

public interface BookRepository {
    List<Book> getAllBooks();
    void saveBook(Book book);
}
