import { AddOperation } from '../../src/operations/AddOperation.js';

describe('AddOperation', () => {
    const op = new AddOperation();

    it('should return the sum of two positive numbers', () => {
        expect(op.execute(5, 10)).toBe(15);
    });

    it('should return the sum when one number is negative', () => {
        expect(op.execute(-5, 10)).toBe(5);
    });
});