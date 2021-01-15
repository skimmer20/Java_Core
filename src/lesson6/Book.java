package lesson6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yuriismac on 1/11/21.
 * @project Java_Core_tasks
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @NonNull
    private String title;
    @NonNull
    private int pagesCount;
    @NonNull
    private String author;

}
