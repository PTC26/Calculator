import { DivideOperation } from '../../src/operations/DivideOperation.js';

describe('DivideOperation', () => {
    const op = new DivideOperation();

    it('should correctly divide two numbers', () => {
        expect(op.execute(10, 2)).toBe(5);
    });

    it('should throw an error when dividing by zero', () => {
        expect(() => op.execute(10, 0)).toThrow("Division by zero");
    });
});