package operations;

import operations.Operation;

public class MultiplyOperation implements Operation {
    @Override
    public double compute(double num1,double num2){
        return num1*num2;
    }
}
