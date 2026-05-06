package operations;

import operations.Operation;

public class DivideOperation implements Operation {
    @Override
    public double compute(double num1,double num2){
        return num1/num2;
    }
}
