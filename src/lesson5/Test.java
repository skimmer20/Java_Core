package lesson5;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author yuriismac on 12/29/20.
 * @project Java_Core_tasks
 */
public class Test {
    public static void main(String[] args) {
        /*Set<String> stringSet = new HashSet<>();
        stringSet.add("1 - One");
        stringSet.add("2 - Two");
        stringSet.add("3 - Three");
        stringSet.add("4 - Four");

        for (String s : stringSet) {
            System.out.println(s);
        }*/
        Set<PersonTest> stringSet = new TreeSet<>();
        stringSet.add(new PersonTest(24, "Vera"));
        stringSet.add(new PersonTest(26, "Ira"));
        stringSet.add(new PersonTest(22, "Alex"));
        stringSet.add(new PersonTest(29, "Bob"));
        stringSet.add(new PersonTest(33, "Bob"));

        for (PersonTest p : stringSet) {
            System.out.println(p);
        }
    }
}
