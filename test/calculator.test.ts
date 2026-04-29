import { Calculator } from '../src/calculator';

describe('Calculator', () => {
    let calc: Calculator;

    beforeEach(() => {
        calc = new Calculator();
    });

    it('should return 3 when input is "1+2"', () => {
        const result = calc.calculate('1+2');
        expect(result).toBe(3);
    });
});