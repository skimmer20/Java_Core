package lesson6_2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuriismac on 1/18/21.
 * @project Java_Core_tasks
 */
public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("BMW", 170, 35000, 2013, new Driver("Vasia", 28, 4));
        Car car2 = new Car("BMW", 240, 40000, 2015, new Driver("Roma", 31, 5));
        Car car3 = new Car("Audi", 220, 41000, 2015, new Driver("Yura", 24, 4));
        Car car4 = new Car("Mercedes", 320, 55000, 2017, new Driver("Kate", 23, 4));
        Car car5 = new Car("Toyota", 150, 30000, 2012, new Driver("Alex", 27, 3));
        Car car6 = new Car("Skoda", 170, 27000, 2016, new Driver("Max", 32, 7));
        Car car7 = new Car("BMW", 170, 34000, 2017, new Driver("Vova", 28, 4));
        Car car8 = new Car("Audi", 350, 64000, 2019, new Driver("Alex", 34, 9));
        Car car9 = new Car("Kia", 160, 31000, 2014, new Driver("Max", 30, 6));
        Car car10 = new Car("Fiat", 120, 21000, 2015, new Driver("Vadim", 40, 14));

        List<Car> listCars = Arrays.asList(car1, car2, car3, car4, car5, car6, car7, car8, car9, car10);

        //Далі необхідно брати кожну другу машинку (цикл з кроком в 2), та робити їй підвищення потужності двигуна на 10% та ціну на 5%

        for (int i = 0; i < listCars.size(); i += 2) {
            Car value = listCars.get(i);
            value.setHorsePower((int) value.getHorsePower() * 1.1);
            value.setPrice((int) value.getPrice() * 1.05);
        }
        listCars.forEach(System.out::println);

        System.out.println("-------");

        //Після того зробити перевірку досвіду ВСІХ наших водіїв.
        // Якщо досвід водія менший за 5 років, але його вік більший за 25,
        // то необідно відправити його на курси підвищення кваліфікації, що збільшить йому досвід на 1 рік.

        List<Object> increaseDriveExperience = listCars.stream()
                .filter(car -> car.getDriver().getDriveExperience() < 5 && car.getDriver().getAge() > 25)
                .peek(car -> car.getDriver().setDriveExperience(car.getDriver().getDriveExperience() + 1))
                .collect(Collectors.toList());

        increaseDriveExperience.forEach(System.out::println);

    }
}
