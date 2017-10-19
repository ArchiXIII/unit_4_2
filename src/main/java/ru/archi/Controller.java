package main.java.ru.archi;

import main.java.ru.archi.model.Author;
import main.java.ru.archi.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    }

    private static void printAverageAgeAuthors(List<Author> allAuthors){
        double averageAge = allAuthors.stream()
                .mapToInt(Author::getAge)
                .average()
                .getAsDouble();

        System.out.println("Average age = " + averageAge + "\n");
    }

    private static void printAscendingAuthors(List<Author> allAuthors){
        List<Author> ascendingAuthors;

        ascendingAuthors = allAuthors.stream()
                .sorted((a1,a2) -> a1.getAge().compareTo(a2.getAge()))
                .collect(Collectors.toList());

        for (int i = 0; i<ascendingAuthors.size(); i++) {
            System.out.println(ascendingAuthors.get(i).getName() + ": Age = " + ascendingAuthors.get(i).getAge());
        }
        System.out.println();
    }

    private static void printAuthorsPensioners(List<Author> allAuthors){
        List<Author> pensioners;

        pensioners = allAuthors.stream()
                .filter(a -> a.getGender() == Gender.MALE)
                .filter(a -> a.getAge() > 65)
                .collect(Collectors.toList());
        pensioners.addAll(allAuthors.stream()
                .filter(a -> a.getGender() == Gender.FEMALE)
                .filter(a -> a.getAge() > 63)
                .collect(Collectors.toList()));

        for (int i = 0; i<pensioners.size(); i++) {
            System.out.println(pensioners.get(i).getName() + ": Age pensioner = " + pensioners.get(i).getAge());
        }
        System.out.println();
    }
}
