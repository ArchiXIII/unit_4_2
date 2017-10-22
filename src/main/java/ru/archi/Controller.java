package main.java.ru.archi;

import main.java.ru.archi.model.Author;
import main.java.ru.archi.model.Book;

import java.util.ArrayList;
import java.util.List;
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
        double averageAge = allAuthors.stream()
                .filter(a -> a.getDateOfDeath() == null)
                .mapToInt(Author::getAge)
                .average()
                .getAsDouble();

        System.out.println("Average age = " + averageAge + "\n");
    }

    private static void printAscendingAuthors(List<Author> allAuthors){
        List<Author> ascendingAuthors;

        ascendingAuthors = allAuthors.stream()
                .filter(a -> a.getDateOfDeath() == null)
                .sorted((a1,a2) -> a1.getAge().compareTo(a2.getAge()))
                .collect(Collectors.toList());

        Author author;
        for (int i = 0; i<ascendingAuthors.size(); i++) {
            author = ascendingAuthors.get(i);
            System.out.println(author.getName() + ": Age = " + author.getAge());
        }
        System.out.println();
    }

    private static void printAuthorsPensioners(List<Author> allAuthors){
        List<Author> pensioners;

        pensioners = allAuthors.stream()
                .filter(a -> (a.getGender() == Gender.MALE && a.getAge() > 65)
                        || (a.getGender() == Gender.FEMALE && a.getAge() > 63)
                        && a.getDateOfDeath() == null)
                .collect(Collectors.toList());

        for (int i = 0; i<pensioners.size(); i++) {
            System.out.println(pensioners.get(i).getName() + ": Age pensioner = " + pensioners.get(i).getAge());
        }
        System.out.println();
    }

    private static void printBooksNameAngAge(List<Book> books){
        System.out.println(books.stream()
                .map(b -> b.getName() + " - "
                        + (LocalDate.now().getYear() - b.getYearOfIssue().getYear()) + " year")
                .collect(Collectors.toList()) + "\n");
    }

    private static void printCollaborators(List<Book> books){
        System.out.println(books.stream()
                .filter(b -> b.getAuthors().size() > 1)
                .map(Book::getAuthors)
                .flatMap(authors -> authors.stream().map(Author::getName))
                .distinct()
                .collect(Collectors.toList()) + "\n");
    }

    private static void printAuthorWithBook(List<Book> books){
        System.out.println(books.stream()
                .collect(Collectors.groupingBy(Book::getName, Collectors.mapping(book -> book.getAuthors(), Collectors.toList())))

//                .flatMap(book -> book.getAuthors().stream().map(Author::getName))
//                .distinct()
//                .peek(s -> s.concat("213123"))



//                .map(Book::getAuthors)
//                .flatMap(a -> a.stream().map(Author::getName))
//                .collect(Collectors.groupingBy(a -> a.stream().map(Author::getName), books.stream().map(Book::getName)))

//                .map(Book::getAuthors)
//                .flatMap(authors -> authors.stream().map(Author::getName))
//                .distinct()

                /*.collect(Collectors.toList())*/ + "\n");
    }
}
