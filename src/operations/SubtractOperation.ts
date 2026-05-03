import { Operation } from './Operation.js';
export class SubtractOperation implements Operation {
    execute(a: number, b: number): number {
        return a - b;
    }
}