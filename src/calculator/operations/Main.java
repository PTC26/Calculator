package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Calculator calc = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Enter expression (or exit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                double result = calc.calculate(input);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}