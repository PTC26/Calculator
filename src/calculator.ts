import { Tokenizer } from './parser/Tokenizer.js';
import { Evaluator } from './parser/Evaluator.js';
import { AddOperation } from './operations/AddOperation.js';
import { SubtractOperation } from './operations/SubtractOperation.js';
import { MultiplyOperation } from './operations/MultiplyOperation.js';
import { DivideOperation } from './operations/DivideOperation.js';

export class Calculator{
    private tokenizer = new Tokenizer();
    private evaluator: Evaluator;

    constructor() {
        const operations = {
            '+': new AddOperation(),
            '-': new SubtractOperation(),
            '*': new MultiplyOperation(),
            '/': new DivideOperation()
        };
        this.evaluator = new Evaluator(operations);
    }

    calculate(expression: string): number {
        const tokens = this.tokenizer.tokenize(expression);
        return this.evaluator.evaluate(tokens);
    }
}