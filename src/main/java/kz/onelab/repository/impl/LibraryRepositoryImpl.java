package kz.onelab.repository.impl;

import kz.onelab.dto.Book;
import kz.onelab.dto.Library;
import kz.onelab.repository.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public LibraryRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Library> getAllLibrary() {
        return jdbcTemplate.query("SELECT * FROM libraries",
                (rs, rowNum) -> new Library(rs.getLong("id"), rs.getString("name"), new ArrayList<>()));
    }

    @Override
    public void saveLibrary(Library library) {
        jdbcTemplate.update("INSERT INTO libraries (name) VALUES (?)", library.getName());
        for (Book book : library.getBooks()) {
            jdbcTemplate.update("INSERT INTO library_books (library_id, book_id) VALUES (?, ?)",
                    library.getId(), book.getId());
        }
    }
}
