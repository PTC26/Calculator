import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class Calculator {

    private final Map<String, BiFunction<Double, Double, Double>> operations = new HashMap<>();

    public Calculator()
    {
    operations.put("+", this::add);
    operations.put("-", this::subtract);
    operations.put("*", this::multiply);
    operations.put("/", this::divide);
    }
    public double calculate(String expression) {

        for (String op : operations.keySet()) {
            if (expression.contains(op)) {

                int index = expression.indexOf(op);
                double num1 = Double.parseDouble(expression.substring(0, index));
                double num2 = Double.parseDouble(expression.substring(index + 1));
                return operations.get(op).apply(num1, num2);
            }
        }
        throw new IllegalArgumentException("Invalid expression");
    }

    public double add(double num1,double num2){
        return num1+num2;
    }
    public double subtract(double num1,double num2){
        return num1-num2;
    }
    public double multiply(double num1,double num2){
        return num1*num2;
    }
    public double divide(double num1,double num2){
        return num1/num2;
    }
}