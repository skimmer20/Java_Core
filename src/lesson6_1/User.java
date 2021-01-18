package lesson6_1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

/**
 * @author yuriismac on 1/17/21.
 * @project Java_Core_tasks
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String name;
    private int age;
    private boolean status;

}
