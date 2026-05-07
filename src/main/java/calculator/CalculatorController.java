package main.java.calculator;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class CalculatorController {

    private final Calculator calculator = new Calculator();

    @PostMapping("/calculate")
    public ResultDto calculate(@RequestBody ExpressionDto dto) {
        double result = calculator.calculate(dto.getExpression());
        return new ResultDto(result);
    }
}
