package lesson6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

/**
 * @author yuriismac on 1/6/21.
 * @project Java_Core_tasks
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @NonNull
    private String name;
    @NonNull
    private int age;
    @NonNull
    private List<Book> books;
    @NonNull
    private Gender gender;


}
