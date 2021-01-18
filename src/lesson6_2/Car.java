package lesson6_2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yuriismac on 1/17/21.
 * @project Java_Core_tasks
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Car {

    private String model;
    private double horsePower;
    private double price;
    private int year;
    private Driver driver;
}
