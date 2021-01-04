package lesson5;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author yuriismac on 12/31/20.
 * @project Java_Core_tasks
 */
public class Schedule {

    private Set<Seance> seanceSet;

    public Schedule() {
        this.seanceSet = new TreeSet<Seance>();
    }

    public Set<Seance> getSeanceSet() {
        return seanceSet;
    }

    public void setSeanceSet(Set<Seance> seanceSet) {
        this.seanceSet = seanceSet;
    }

    public void addSeance(Seance seance) {
        if (this.seanceSet.contains(seance)) {
            System.out.println(seance + " - This seance already exists \n");
        } else {
            this.seanceSet.add(seance);
            System.out.println(seance + " - The seance has been added");
        }
    }

    public void removeSeance(Seance seance) {
        if (this.seanceSet.isEmpty()) {
            System.out.println("There're no any films today");
        }

        Iterator<Seance> seanceIterator = this.seanceSet.iterator();
        while (seanceIterator.hasNext()) {
            Seance film = seanceIterator.next();
            if (film.equals(seance)) {
                seanceIterator.remove();
                System.out.println("\t" + film + " has been removed");
            }
        }
    }

}
