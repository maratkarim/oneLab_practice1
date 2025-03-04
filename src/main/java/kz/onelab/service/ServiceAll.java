package kz.onelab.service;

import kz.onelab.dto.Book;
import kz.onelab.dto.City;
import kz.onelab.dto.Library;
import kz.onelab.repository.BookRepository;
import kz.onelab.repository.CityRepository;
import kz.onelab.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceAll {
    private final BookRepository bookRepository;
    private final LibraryRepository libraryRepository;
    private final CityRepository cityRepository;

    public ServiceAll(BookRepository bookRepository, LibraryRepository libraryRepository, CityRepository cityRepository) {
        this.bookRepository = bookRepository;
        this.libraryRepository = libraryRepository;
        this.cityRepository = cityRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.getAllBooks();
    }
    public List<Library> getAllLibraries(){
        return libraryRepository.getAllLibrary();
    }
    public List<City> getAllCity(){
        return cityRepository.getAllCity();
    }
    public void saveBook(Book book){
        bookRepository.saveBook(book);
    }
    public void saveLibrary(Library library){
        library.getBooks().forEach(bookRepository::saveBook);
        libraryRepository.saveLibrary(library);
    }
    public void saveCity(City city){
        city.getLibraries().forEach(libraryRepository::saveLibrary);
        cityRepository.saveCity(city);
    }

}
