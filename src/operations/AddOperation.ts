import { Operation } from './Operation.js';
export class AddOperation implements Operation {
    execute(a: number, b: number): number {
        return a + b;
    }
}