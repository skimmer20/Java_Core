package lesson6_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author yuriismac on 1/17/21.
 * @project Java_Core_tasks
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int pick = random.nextInt(100);
            integerList.add(pick);
        }
        System.out.println(integerList);

        //-- при помощи метода sort и колбека  отсортировать массив.
        List<Integer> integers = integerList.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());
        System.out.println(integers);

        //-- при помощи метода sort и колбека отсортировать массив в ниспадающем напралении.

        List<Integer> integers1 = integerList.stream()
                .sorted((o1, o2) -> o2 - o1)
                .collect(Collectors.toList());
        System.out.println(integers1);

        //-- при помощи filter получить числа кратные 3
        List<Integer> intergersDevBy3 = integerList.stream()
                .filter(integer -> integer % 3 == 0)
                .collect(Collectors.toList());
        System.out.println(intergersDevBy3);

        //-- при помощи filter получить числа кратные 10
        List<Integer> intergersDevideBy10 = integerList.stream()
                .filter(integer -> integer % 10 == 0)
                .collect(Collectors.toList());
        System.out.println(intergersDevideBy10);

        //-- перебрать (проитерировать) массив при помощи foreach()
        integerList.forEach(System.out::println);

        //-- перебрать массив при помощи map() и получить новый массив в котором все значения будут в 3 раза больше
        List<Integer> mult3 = integerList.stream().map(integer -> integer * 3).collect(Collectors.toList());
        System.out.println(mult3);

        System.out.println("-----------------------");

        //- создать массив со словами на 15-20 элементов.

        List<String> stringList = new ArrayList<>();
        stringList.add("Vasia");
        stringList.add("Roma");
        stringList.add("Petia");
        stringList.add("Alex");
        stringList.add("Vova");
        stringList.add("Jora");
        stringList.add("Tolia");
        stringList.add("Katia");
        stringList.add("Maria");
        stringList.add("Julia");
        stringList.add("Tom");
        stringList.add("Lusia");
        stringList.add("Vera");
        stringList.add("Yura");
        stringList.add("Matt");

        //-- отсортировать его по алфавиту в восходящем порядке.
        List<String> sortNamesAsc = stringList.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(sortNamesAsc);

        //-- отсортировать его по алфавиту  в нисходящем порядке.
        List<String> sortNamesDesc = stringList.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(sortNamesDesc);

        //-- отфильтровать слова длиной менее 5х символов

        List<String> filerNamesByLength = stringList.stream()
                .filter(s -> s.length() < 5)
                .collect(Collectors.toList());
        System.out.println(filerNamesByLength);

        //-- перебрать массив при помощи map() и получить новый массив в котором все значения будут со знаком "!" в конце

        List<String> stringsWithSpecialChar = stringList.stream()
                .map(s -> s + "!")
                .collect(Collectors.toList());
        System.out.println(stringsWithSpecialChar);

        System.out.println("------------------");

        //Дан масив :
        List<User> userList = new ArrayList<>();
        userList.add(new User("vasya", 31, false));
        userList.add(new User("petya", 30, true));
        userList.add(new User("kolya", 29, true));
        userList.add(new User("olya", 28, false));
        userList.add(new User("max", 30, true));
        userList.add(new User("anya", 31, false));
        userList.add(new User("oleg", 28, false));
        userList.add(new User("andrey", 29, true));
        userList.add(new User("veronika", 28, true));
        userList.add(new User("olya", 31, false));
        userList.add(new User("max", 31, true));

        //- відсортувати його за  віком (зростання , а потім окремо спадання)

        List<User> sortUsersByAgeAsc = userList.stream()
                .sorted(Comparator.comparingInt(User::getAge))
                .collect(Collectors.toList());

        sortUsersByAgeAsc.forEach(System.out::println);
        //System.out.println(sortUsersByAgeAsc);
        System.out.println("---------------");

        //спадання
        List<User> sortUsersByAgeDesc = userList.stream()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .collect(Collectors.toList());

        sortUsersByAgeDesc.forEach(System.out::println);

        System.out.println("---------------");

        //- відсортувати його за кількістю знаків в імені  (зростання , а потім окремо спадання)

        List<User> sortUsersByNameLengthAsc = userList.stream()
                .sorted(Comparator.comparingInt(o -> o.getName().length()))
                .collect(Collectors.toList());

        sortUsersByNameLengthAsc.forEach(System.out::println);
        System.out.println("---------------");

        //спадання
        List<User> sortUsersByNameLengthDesc = userList.stream()
                .sorted((o1, o2) -> o2.getName().length() - o1.getName().length())
                .collect(Collectors.toList());

        sortUsersByNameLengthDesc.forEach(System.out::println);
        System.out.println("---------------");

        //-- наисать функцию калькулятора с 2мя числами и колбеком

        double a = Calculator.calculate2Elem(4, 5, "+");
        System.out.println(a);

        //-- наисать функцию калькулятора с 3мя числами и колбеком

        double b = Calculator.calculate3Elem(4, 2, 1, "*", "-");
        System.out.println(b);

        //Відфільтрувати class Cars за наступними крітеріями :
        // {producer:"subaru",model: "wrx",year: 2010, color:"blue",type: "sedan",engine: "ej204x",volume: 2,power: 400},

        Car car1 = new Car("subaru", "wrx", 2010, "blue", CarType.SEDAN, "ej204x", 2.0, 400);
        Car car2 = new Car("subaru", "legacy", 2007, "silver", CarType.SEDAN, "ez30", 3, 250);
        Car car3 = new Car("subaru", "tribeca", 2011, "white", CarType.PICKUP_TRUCK, "ej20", 2, 300);
        Car car4 = new Car("subaru", "leone", 1998, "yellow", CarType.SEDAN, "ez20x", 2, 140);
        Car car5 = new Car("subaru", "impreza", 2014, "red", CarType.SEDAN, "ej204x", 2, 200);
        Car car6 = new Car("subaru", "outback", 2014, "red", CarType.HATCHBACK, "ej204", 2, 165);
        Car car7 = new Car("bmw", "115", 2013, "red", CarType.HATCHBACK, "f15", 1.5, 120);
        Car car8 = new Car("bmw", "315", 2010, "white", CarType.COUPE, "f15", 1.5, 120);
        Car car9 = new Car("bmw", "650", 2009, "black", CarType.SEDAN, "f60", 6, 350);
        Car car10 = new Car("bmw", "320", 2012, "red", CarType.SPORTS_CAR, "f20", 2, 180);
        Car car11 = new Car("mercedes", "e200", 1990, "silver", CarType.MINIVAN, "eng200", 2, 180);
        Car car12 = new Car("mercedes", "amg63", 2017, "yellow", CarType.COUPE, "amg63", 3, 400);
        Car car13 = new Car("mercedes", "c250", 2017, "red", CarType.SPORTS_CAR, "eng25", 2.5, 230);

        List<Car> listCars = Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10, car11, car12, car13);

        //- двигун більше 3х літрів
        List<Car> getEngine3 = listCars.stream()
                .filter(car -> car.getEngineVolume() >= 3)
                .collect(Collectors.toList());

        getEngine3.forEach(System.out::println);
        System.out.println("---------------");

        //- двигун = 2л
        List<Car> getEngine2 = listCars.stream()
                .filter(car -> car.getEngineVolume() == 2)
                .collect(Collectors.toList());
        getEngine2.forEach(System.out::println);
        System.out.println("---------------");

        //- виробник мерс
        List<Car> getMercedesCars = listCars.stream()
                .filter(car -> car.getProducer().equals("mercedes"))
                .collect(Collectors.toList());

        getMercedesCars.forEach(System.out::println);
        System.out.println("---------------");

        //- двигун більше 3х літрів + виробник мерседес
        List<Car> getMercedesCarsAndEng3 = listCars.stream()
                .filter(car -> car.getProducer().equals("mercedes") && car.getEngineVolume() > 3)
                .collect(Collectors.toList());

        getMercedesCarsAndEng3.forEach(System.out::println);
        System.out.println("---------------");

        //- двигун більше 3х літрів + виробник субару
        //car -> car.getProducer().equals("subaru") && car.getEngineVolume() > 3

        //- сили більше ніж 200 + виробник субару
        List<Car> getSubaruWith200Hp = listCars.stream()
                .filter(car -> car.getHorsePower() > 200 && car.getProducer().equals("subaru"))
                .collect(Collectors.toList());

        getSubaruWith200Hp.forEach(System.out::println);
        System.out.println("---------------");

        //- сили більше ніж 300 + виробник субару + мотор серіі ej
        List<Car> getSubaruWith300HpEg = listCars.stream()
                .filter(car -> car.getHorsePower() > 300 && car.getProducer().equals("subaru") && car.getEngine().contains("ej"))
                .collect(Collectors.toList());

        getSubaruWith300HpEg.forEach(System.out::println);
        System.out.println("---------------");
    }
}
