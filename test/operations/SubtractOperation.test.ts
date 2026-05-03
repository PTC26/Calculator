import { SubtractOperation } from '../../src/operations/SubtractOperation.js';

describe('SubtractOperation', () => {
    const op = new SubtractOperation();

    it('should correctly subtract two numbers', () => {
        expect(op.execute(20, 5)).toBe(15);
    });

    it('should return a negative result when subtracting a larger number', () => {
        expect(op.execute(5, 10)).toBe(-5);
    });
});