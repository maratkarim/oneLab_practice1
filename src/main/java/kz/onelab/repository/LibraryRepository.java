package kz.onelab.repository;

import kz.onelab.dto.Library;
import java.util.List;

public interface LibraryRepository{
    List<Library> getAllLibrary();
    void saveLibrary(Library library);
}
