import { Calculator } from '../src/calculator.js';
describe('Calculator Integration Tests', () => {
    let calc: Calculator;
    beforeEach(() => {
        calc = new Calculator();
    });

    it('should handle negative numbers and multiplication: -5 * -5 = 25', () => {
        expect(calc.calculate("-5*-5")).toBe(25);
    });

    it('should respect operator precedence: 2 + 3 * 4 = 14', () => {
        expect(calc.calculate("2+3*4")).toBe(14);
    });

    it('should handle double minus: 10 - -5 = 15', () => {
        expect(calc.calculate("10--5")).toBe(15);
    });

    it('should solve a long mixed expression: -10 + 20 / 2 * 3 = 20', () => {
        expect(calc.calculate("-10+20/2*3")).toBe(20);
    });

    it('should throw error on division by zero', () => {
        expect(() => calc.calculate("8+7+9/2/0")).toThrow("Division by zero");
    });
});