package kz.onelab.repository.impl;

import kz.onelab.dto.Book;
import kz.onelab.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * FROM BOOKS",
                (rs, rowNum) -> new Book(rs.getLong("id"), rs.getString("name"), rs.getString("author")));
    }

    @Override
    public void saveBook(Book book) {
        jdbcTemplate.update("INSERT INTO BOOKS (name, author) VALUES (?, ?)",
                book.getName(), book.getAuthor());
    }

}
