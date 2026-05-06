import operations.*;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

    private final Map<String, Operation> operations = new HashMap<>();

    public Calculator()
    {
    operations.put("+",new AddOperation());
    operations.put("-",new SubtractOperation());
    operations.put("*",new MultiplyOperation());
    operations.put("/",new DivideOperation());
    }
    public double calculate(String expression) {

        for (String op : operations.keySet()) {
            if (expression.contains(op)) {

                int index = expression.indexOf(op);
                double num1 = Double.parseDouble(expression.substring(0, index));
                double num2 = Double.parseDouble(expression.substring(index + 1));
                return operations.get(op).compute(num1, num2);
            }
        }
        throw new IllegalArgumentException("Invalid expression");
    }

}