import { Operation } from './Operation.js';

export class DivideOperation implements Operation {
    execute(left: number, right: number): number {
        if (right === 0) {
            throw new Error("Division by zero");
        }
        return left / right;
    }
}