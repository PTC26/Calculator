import { Calculator } from '../src/calculator';

describe('Calculator', () => {
    let calc: Calculator;

    beforeEach(() => {
        calc = new Calculator();
    });

    // --- פעולות בסיסיות ---
    it('should return 3 when input is "1+2"', () => {
        expect(calc.calculate('1+2')).toBe(3);
    });

    it('should return 3 when input is "5-2"', () => {
        expect(calc.calculate('5-2')).toBe(3);
    });

    it('should return 10 when input is "2*5"', () => {
        expect(calc.calculate('2*5')).toBe(10);
    });

    it('should return 4 when input is "8/2"', () => {
        expect(calc.calculate('8/2')).toBe(4);
    });

    // --- טיפול ברווחים (Clean Input) ---
    it('should ignore whitespace', () => {
        expect(calc.calculate(' 1 + 2 ')).toBe(3);
    });

    it('should handle multiple whitespaces: " 10  /  2 "', () => {
        expect(calc.calculate(' 10  /  2 ')).toBe(5);
    });

    // --- מקרי קצה ושגיאות ---
    it('should throw error when dividing by zero', () => {
        // אנחנו מצפים שהקוד יזרוק שגיאה עם מסר ספציפי
        expect(() => calc.calculate('8/0')).toThrow("Division by zero");
    });

    // --- אתגרים מתקדמים (שיכריחו אותנו ל-OOP אמיתי) ---
    it('should handle multiple numbers: 1+2+1', () => {
        expect(calc.calculate('1+2+1')).toBe(4);
    });

    it('should handle precedence: multiplication before addition (1+2*6)', () => {
        expect(calc.calculate('1+2*6')).toBe(13);
    });
});