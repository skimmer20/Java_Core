package lesson6_1;

/**
 * @author yuriismac on 1/17/21.
 * @project Java_Core_tasks
 */
public class Calculator {

    static double calculate(double num1, double num2, String action) {
        switch (action) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
            default:
                return -1;
        }
    }

    static double calculate2Elem(double num1, double num2, String action) {
        return calculate(num1, num2, action);
    }

    static double calculate3Elem(double num1, double num2, double num3, String action, String action2) {

        double res = calculate(num1, num2, action);
        return calculate(res, num3, action2);
    }

}
