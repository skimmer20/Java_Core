package lesson5;

/**
 * @author yuriismac on 12/31/20.
 * @project Java_Core_tasks
 */
public class Time {

    private int minutes;
    private int hour;

    public Time(int hour, int minutes) {
        this.minutes = minutes;
        this.hour = hour;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        if (minutes >= 0 && 59 >= minutes) {
            this.minutes = minutes;
        } throw new NumberFormatException();
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        if (0 <= hour && hour <= 23){
            this.hour = hour;
        } throw new NumberFormatException();
    }

    @Override
    public String toString() {
        return "Time{" +
                "min=" + minutes +
                ", hour=" + hour +
                '}';
    }
}
