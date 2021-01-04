package lesson5;

import lesson5.enums.Days;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @author yuriismac on 1/4/21.
 * @project Java_Core_tasks
 */
public class Cinema {
    private TreeMap<Days, Schedule> scheduleTreeMap;
    private Time open;
    private Time close;

    public Cinema(Time open, Time close) {
        this.scheduleTreeMap = new TreeMap<>();
        this.setOpen(open);
        this.setClose(close);
    }

    public Time getOpen() {
        return open;
    }

    public void setOpen(Time open) {
        if (open.getHour() < 10 || open.getHour() > 12) {
            System.out.println("Incorrect open time");
        }
        this.open = open;
    }

    public Time getClose() {
        return close;
    }

    public void setClose(Time close) {
        if (close.getHour() < 21 || close.getHour() > 24) {
            System.out.println("Incorrect close time");
        }
        this.close = close;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cinema cinema = (Cinema) o;
        return Objects.equals(scheduleTreeMap, cinema.scheduleTreeMap) &&
                Objects.equals(open, cinema.open) &&
                Objects.equals(close, cinema.close);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleTreeMap, open, close);
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "scheduleTreeMap=" + scheduleTreeMap +
                ", open=" + open +
                ", close=" + close +
                '}';
    }

    public void addSeances(Days day, Seance... seance) {
        if (this.getOpen() == null || this.getClose() == null) {
            System.out.println("Please, set the correct open and close time and add the films to such a cinema");
        }
        //if (!this.scheduleTreeMap.containsKey(day)) {
        Schedule schedule = new Schedule();
        for (Seance seance1 : seance) {
            schedule.addSeance(seance1);
        }
        //}
    }

    public void addSeance(Seance seance, Days day) {
        if (this.getOpen() == null || this.getClose() == null) {
            System.out.println("Please, set the correct open and close time and add the films to such a cinema");
        }
        this.scheduleTreeMap.get(day).addSeance(seance);
    }

    /*removeMovie(Movie) (повністю видаляє усі сеанси вказаного фільму з розкладу)*/
    public void removeMovie(Movie movie) {
        if (this.scheduleTreeMap.values().isEmpty()) {
            System.out.println("There're no such a movie in the schedule");
        }

        Iterator<Schedule> scheduleIterator = this.scheduleTreeMap.values().iterator();
        while (scheduleIterator.hasNext()) {
            Schedule schedule = scheduleIterator.next();
            if (schedule.equals(movie)) {
                scheduleIterator.remove();
            }
        }
    }
    /*removeSeance(Seance,String)(видаляє конкретний сеанс фільму в конкретний день,який задається параметром String).*/
    public void removeSeance(Seance seance, Days day){
        if (this.scheduleTreeMap.values().isEmpty()) {
            System.out.println("There're no such a movie in the schedule");
        }
        Iterator<Seance> seanceIterator = this.scheduleTreeMap.get(day).getSeanceSet().iterator();
            Seance film = seanceIterator.next();
            if (film.equals(seance)){
                seanceIterator.remove();
        }
    }
}
