package main.java.ru.archi.model;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Черный on 19.10.2017.
 */
public class Book {
    private String name;
    private LocalDate yearOfIssue;
    private List<Author> authors;

    public Book(String name, LocalDate yearOfIssue, List<Author> authors){
        this.name = name;
        this.yearOfIssue = yearOfIssue;
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYearOfIssue() {
        return yearOfIssue;
    }

    public void setYearOfIssue(LocalDate yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
