package kz.onelab.repository.impl;

import kz.onelab.dto.Library;
import kz.onelab.repository.LibraryRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LibraryRepositoryImpl implements LibraryRepository {
    private final List<Library> libraries = new ArrayList<>();

    @Override
    public List<Library> getAllLibrary() {
        return libraries;
    }

    @Override
    public void saveLibrary(Library library) {
        libraries.add(library);
    }

}
