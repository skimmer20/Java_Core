package lesson5;

import lesson5.enums.Days;

import java.util.Map;

/**
 * @author yuriismac on 1/4/21.
 * @project Java_Core_tasks
 */
public class Main {
    public static void main(String[] args) {
        Time duration = new Time(2, 25);
        Time duration2 = new Time(1, 45);

        Movie movie = new Movie("Hobbit", new Time(2, 40));
        Movie movie2 = new Movie("Robbers", new Time(2, 15));

        Time startTime = new Time(12, 40);
        Time startTime2 = new Time(19, 10);

        Seance seance = new Seance(movie, startTime);
        Seance seance2 = new Seance(movie, startTime2);




        Cinema cinema = new Cinema(new Time(10, 0), new Time(22, 0));
        cinema.addSeances(Days.FRIDAY, seance2, seance);
    }

}
