package main.java.ru.archi;

import javafx.util.Pair;
import main.java.ru.archi.model.Author;
import main.java.ru.archi.model.Book;
import main.java.ru.archi.model.Sex;

import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;

/**
 * Created by Черный on 19.10.2017.
 */
public class Controller {
    public static void executionProgramLogic() {
        List<Book> books = new ArrayList<>();
        books = TestBooksData.fillingBooks(books);

        List<Author> allAuthors = new ArrayList<>();
        for(int i = 0; i < books.size(); i++){
            allAuthors.addAll(books.get(i).getAuthors());
        }

        printAverageAgeAuthors(allAuthors);
        printAscendingAuthors(allAuthors);
        printAuthorsPensioners(allAuthors);
        printBooksNameAngAge(books);
        printCollaborators(books);
        printAuthorWithBook(books);
    }

    private static void printAverageAgeAuthors(List<Author> allAuthors){
        System.out.println("    Average age authors:");
        System.out.println("Average age = " + allAuthors.stream()
                .mapToInt(Author::getAge)
                .average()
                .getAsDouble() + "\n");
    }

    private static void printAscendingAuthors(List<Author> allAuthors){
        System.out.println("    Ascending authors:");
        allAuthors.stream()
                .sorted(Comparator.comparing(Author::getAge))
                .map(author -> author.getName() + " - " + author.getAge())
                .distinct()
                .forEach(System.out::println);
        System.out.println();
    }

    private static void printAuthorsPensioners(List<Author> allAuthors){
        System.out.println("    Authors pensioners:");
        allAuthors.stream()
                .filter(a -> ((a.getSex() == Sex.MALE && a.getAge() > 65)
                        || (a.getSex() == Sex.FEMALE && a.getAge() > 63))
                        && a.getDateOfDeath() == null)
                .map(author -> author.getName() + " - " + author.getAge())
                .distinct()
                .forEach(System.out::println);
        System.out.println();
    }

    private static void printBooksNameAngAge(List<Book> books){
        System.out.println("    Books name ang age:");
        books.stream()
                .map(b -> b.getName() + " - "
                        + (LocalDate.now().getYear() - b.getYearOfIssue().getYear()) + " year")
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();
    }

    private static void printCollaborators(List<Book> books){
        System.out.println("    Collaborators:");
        books.stream()
                .filter(b -> b.getAuthors().size() > 1)
                .map(Book::getAuthors)
                .flatMap(authors -> authors.stream().map(Author::getName))
                .distinct()
                .forEach(System.out::println);
        System.out.println();
    }

    private static void printAuthorWithBook(List<Book> books){
        System.out.println("    AuthorWithBooks:");
        books.stream()
                .flatMap(book -> book.getAuthors().stream()
                        .map(author -> new Pair<String, String>(author.getName(), book.getName())))
                .collect(Collectors.groupingBy(Pair::getKey, Collectors.mapping(Pair::getValue, Collectors.toList())))
                .forEach((s, strings) -> System.out.println(s + " - " + strings));
    }
}
