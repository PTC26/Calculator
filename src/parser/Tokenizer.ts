export class Tokenizer {
    tokenize(expression: string): string[] {
        const cleanExpr = expression.replace(/\s+/g, '');
        const tokens: string[] = [];
        let currentNumber = "";

        for (let i = 0; i < cleanExpr.length; i++) {
            const char = cleanExpr[i];
            const isNegativeSign = char === '-' && (i === 0 || ['+', '-', '*', '/'].includes(cleanExpr[i - 1]));

            if (/[0-9.]/.test(char) || isNegativeSign) {
                currentNumber += char;
            } else {
                if (currentNumber !== "") {
                    tokens.push(currentNumber);
                    currentNumber = "";
                }
                tokens.push(char);
            }
        }
        if (currentNumber !== "") tokens.push(currentNumber);
        return tokens;
    }
}