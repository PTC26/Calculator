import { MultiplyOperation } from '../../src/operations/MultiplyOperation.js';

describe('MultiplyOperation', () => {
    const op = new MultiplyOperation();

    it('should correctly multiply two positive numbers', () => {
        expect(op.execute(4, 5)).toBe(20);
    });

    it('should return zero when multiplying by zero', () => {
        expect(op.execute(10, 0)).toBe(0);
    });
});