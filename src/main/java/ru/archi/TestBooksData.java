package main.java.ru.archi;

import main.java.ru.archi.model.Author;
import main.java.ru.archi.model.Book;
import main.java.ru.archi.model.Sex;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Черный on 19.10.2017.
 */
public class TestBooksData {
    public static List<Book> fillingBooks(List<Book> books){
        List<Author> authors;
        authors = Arrays.asList(new Author("Walter Isaacson", LocalDate.of(1951, Month.MAY, 20), null, Sex.MALE));
        books.add(new Book("Leonardo da Vinci", LocalDate.of(1991, Month.APRIL, 10), authors));

        authors = Arrays.asList(new Author("Margaret Wise Brown", LocalDate.of(1910, Month.MAY, 23), LocalDate.of(1952, Month.NOVEMBER, 13), Sex.FEMALE));
        books.add(new Book("Goodnight Moon", LocalDate.of(2007, Month.JANUARY, 23), authors));

        authors = Arrays.asList(new Author("Chevy Stevens", LocalDate.of(1973, Month.MAY, 20), null, Sex.FEMALE));
        books.add(new Book("Never Let You Go", LocalDate.of(2014, Month.MARCH, 14), authors));

        authors = Arrays.asList(new Author("Lisa Ko", LocalDate.of(1977, Month.MAY, 20), null, Sex.FEMALE));
        books.add(new Book("The Leavers: A Novel", LocalDate.of(2017, Month.MAY, 2), authors));
        books.add(new Book("The Leav", LocalDate.of(2017, Month.MAY, 2), authors));

        authors = new ArrayList<>();
        authors.add(new Author("Catherine Donnelly", LocalDate.of(1956, Month.FEBRUARY, 7), null, Sex.FEMALE));
        authors.add(new Author("Mateo Kehler", LocalDate.of(1956, Month.MAY, 17), null, Sex.MALE));
        books.add(new Book("The Oxford Companion to Cheese ", LocalDate.of(2016, Month.NOVEMBER, 22), authors));

        return books;
    }
}
