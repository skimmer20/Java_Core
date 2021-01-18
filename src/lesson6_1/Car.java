package lesson6_1;

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

    private String producer;
    private String model;
    private int year;
    private String color;
    private CarType carType;
    private String engine;
    private double engineVolume;
    private double horsePower;

}
