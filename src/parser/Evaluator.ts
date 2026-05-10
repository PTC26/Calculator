import { Operation } from '../operations/Operation.js';

export class Evaluator {
    constructor(private operations: Record<string, Operation>) {}

    evaluate(tokens: string[]): number {
        const processedTokens: string[] = [];

        for (let i = 0; i < tokens.length; i++) {
            const token = tokens[i];

            if (token === '*' || token === '/') {
                const prevNum = parseFloat(processedTokens.pop()!);
                const nextNum = parseFloat(tokens[++i]);
                const result = this.operations[token].execute(prevNum, nextNum);
                processedTokens.push(result.toString());
            } else {
                processedTokens.push(token);
            }
        }

        
        if (processedTokens.length === 0) return 0;

        let finalResult = parseFloat(processedTokens[0]);
        
        for (let j = 1; j < processedTokens.length; j += 2) {
            const operator = processedTokens[j];
            const nextValue = parseFloat(processedTokens[j + 1]);
            
            finalResult = this.operations[operator].execute(finalResult, nextValue);
        }

        return finalResult;
    }
}