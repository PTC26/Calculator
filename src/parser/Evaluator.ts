import { Operation } from '../operations/Operation.js';

export class Evaluator {
    constructor(private operations: Record<string, Operation>) {}

    evaluate(tokens: string[]): number {
        const workTokens = [...tokens];

        let i = 0;
        while (i < workTokens.length) {
            if (workTokens[i] === '*' || workTokens[i] === '/') {
                const result = this.operations[workTokens[i]].execute(
                    parseFloat(workTokens[i - 1]),
                    parseFloat(workTokens[i + 1])
                );
                workTokens.splice(i - 1, 3, result.toString());
                i--;
            }
            i++;
        }

        let finalResult = parseFloat(workTokens[0]);
        for (let j = 1; j < workTokens.length; j += 2) {
            finalResult = this.operations[workTokens[j]].execute(
                finalResult, 
                parseFloat(workTokens[j + 1])
            );
        }
        return finalResult;
    }
}