package kz.onelab;

import kz.onelab.dto.Book;
import kz.onelab.dto.City;
import kz.onelab.dto.Library;
import kz.onelab.service.ServiceAll;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("kz.onelab");

        ServiceAll serviceAll = context.getBean(ServiceAll.class);

        Book book1 = new Book(1L, "Harry Potter", "J.K. Rowling");
        Book book2 = new Book(2L, "1984", "George Orwell");
        Book book3 = new Book(3L, "The Catcher in the Rye", "J.D. Salinger");
        Book book4 = new Book(4L, "Brave New World", "Aldous Huxley");

        Library library1 = new Library(1L, "Almaty Library", new ArrayList<>(List.of(book1, book2)));
        Library library2 = new Library(2L, "Almaty Basic Library", new ArrayList<>(List.of(book3, book4)));

        City city = new City(1L, "Almaty", new ArrayList<>(List.of(library1, library2)));

        serviceAll.saveBook(book1);
        serviceAll.saveBook(book2);
        serviceAll.saveBook(book3);
        serviceAll.saveBook(book4);

        serviceAll.saveLibrary(library1);
        serviceAll.saveLibrary(library2);

        serviceAll.saveCity(city);

        System.out.println(serviceAll.getAllBooks());
        System.out.println(serviceAll.getAllLibraries());
        System.out.println(serviceAll.getAllCity());
    }
}