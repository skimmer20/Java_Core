package lesson5;

import java.util.Objects;

/**
 * @author yuriismac on 12/31/20.
 * @project Java_Core_tasks
 */
public class Seance implements Comparable<Seance> {
    private Movie movie;
    private Time startTime;
    private Time endTime;

    public Seance(Movie movie, Time startTime) {
        this.movie = movie;
        this.startTime = startTime;
        this.setEndTime();
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
        this.setEndTime();
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime() {
        int minutes = startTime.getMinutes() + movie.getDuration().getMinutes();
        int hours = startTime.getHour() + movie.getDuration().getHour();

        if (hours > 23) {
            hours -= 24;
        }

        if (minutes > 59) {
            hours += 1;
            minutes -= 60;
        }
        this.endTime = new Time(minutes, hours);
    }

    @Override
    public String toString() {
        return "Seance{" +
                "movie=" + movie +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seance seance = (Seance) o;
        return Objects.equals(movie, seance.movie) &&
                Objects.equals(startTime, seance.startTime) &&
                Objects.equals(endTime, seance.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, startTime, endTime);
    }

    @Override
    public int compareTo(Seance seance) {
        int compareByStartHour = this.startTime.getHour() - seance.startTime.getHour();

        if (compareByStartHour != 0) {
            return compareByStartHour;
        }
        return this.startTime.getMinutes() - seance.startTime.getMinutes();
    }
}
