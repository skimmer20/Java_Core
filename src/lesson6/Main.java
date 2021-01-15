package lesson6;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yuriismac on 1/5/21.
 * @project Java_Core_tasks
 */

public class Main {

    public static void main(String... args) {

        Book book1 = new Book("War and Peace 1", 740, "Lev Tolstoy");
        Book book2 = new Book("Java", 1120, "Philosophy");
        Book book3 = new Book("War and Peace 2", 848, "Lev Tolstoy");
        Book book4 = new Book("Head First", 650, "For beginners");
        Book book5 = new Book("War and Peace 3", 1079, "Lev Tolstoy");
        Book book6 = new Book("Math", 1200, "Technical");

        List<Book> bookList1 = Arrays.asList(book1, book2, book3, book4, book5, book6);
        List<Book> bookList2 = Arrays.asList(book1, book3, book4);
        List<Book> bookList3 = Arrays.asList(book2, book3, book6);
        List<Book> bookList4 = Arrays.asList(book1, book3);
        List<Book> bookList5 = Arrays.asList(book1, book3, book4, book5);

        Person person1 = new Person("Vasia", 30, bookList1, Gender.MALE);
        Person person2 = new Person("Roma", 22, bookList2, Gender.MALE);
        Person person3 = new Person("Maria", 30, bookList1, Gender.FEMALE);
        Person person4 = new Person("Alex", 33, bookList3, Gender.MALE);
        Person person5 = new Person("Kate", 24, bookList4, Gender.FEMALE);
        Person person6 = new Person("Igor", 25, bookList5, Gender.MALE);

        List<Person> personList = Arrays.asList(person1, person2, person3, person4, person5, person6);

        /*long authorCount = bookList.stream().filter(book -> book.getPagesCount() > 1000 && book.getAuthor().equals("Lev Tolstoy"))
                .count();
        System.out.println(authorCount);*/
        /*List<Book> collectList = bookList.stream().filter(book -> book.getPagesCount() < 1000 && book.getAuthor().equals("Lev Tolstoy"))
                .collect(Collectors.toList());
        collectList.forEach(System.out::println);*/

        /*List<@NonNull String> stringList = bookList.stream().map(Book::getTitle).collect(Collectors.toList());

        for (String s : stringList) {
            System.out.println(s);
        }*/

        /*List<@NonNull String> uniqueAuthor = bookList.stream()
                .map(Book::getAuthor)
                .distinct()
                .collect(Collectors.toList());

        for (String s : uniqueAuthor) {
            System.out.println(s);
        }*/

        //1. згенерувати мапу <Person, Integer>, де Integer - кількість сторінок усіх книжок, які має людина

        Map<Person, Integer> peopleBookPages = personList.stream()
                .collect(Collectors.toMap(person -> person, //or Function.identity()
                        person -> {
                            int count = 0;
                            for (Book book : person.getBooks()) {
                                count += book.getPagesCount();
                            }
                            return count;
                        }));

        peopleBookPages.forEach((k, v) -> System.out.println("name: " + k.getName() + " - amount of book pages: " + v));

        //2. згенерувати мапу <String, Book>, де String - ім'я людини, Book - книжка з найбільшою кількістю сторінок

        Map<String, Book> stringBookMap = personList.stream()
                .collect(Collectors.toMap(Person::getName, person -> {
                    person.getBooks()
                            .sort((o1, o2) -> o2.getPagesCount() - o1.getPagesCount());
                    return person.getBooks().stream().findFirst().orElseGet(Book::new);
                }));

        Map<Person, Book> stringBookMap2 = personList.stream().collect(Collectors.toMap(person -> person, person -> {
            new Comparator<Book>() {
                @Override
                public int compare(Book o1, Book o2) {
                    return o2.getPagesCount() - o1.getPagesCount();
                }
            };
            return person.getBooks().stream().findFirst().orElseGet(Book::new);

        }));
        stringBookMap2.forEach((k, v) -> System.out.println("name: " + k.getName()
                + " - the biggest number of pages has: " + v.getTitle()));

        //3. згенерувати List<Book> відфільтрувавши тільких тих людей, хто старше 25 років і книжки які мають більше 500 сторінок

        List<Book> bookList = personList.stream()
                .filter(person -> person.getAge() > 25)
                .map(Person::getBooks)
                .flatMap(Collection::stream)
                .filter(book -> book.getPagesCount() > 500)
                .collect(Collectors.toList());

        bookList.forEach(System.out::println);

        //4. згенерувати Map<Person, Book> відфільтрувавши тільких людей чоловічого роду, хто старше 25 років
        // і книжки які починаються з букви L

        //.filter(person -> person.getAge() > 25 && person.getGender() == Gender.MALE)
        //                .map(Person::getBooks)
        //                .flatMap(Collection::stream)
        //                .filter(book -> book.getAuthor().startsWith("L"))

        /*Map<Person, String> makeStream = personList.stream()
                .filter(person -> person.getAge() > 25 && person.getGender() == Gender.MALE)
                .map(Person::getBooks)
                .flatMap(Collection::stream)
                .filter(book -> book.getAuthor().startsWith("L"))
                .collect();*/



    }
}
