import { Calculator } from './calculator.js';
import * as readline from 'readline';

const calc = new Calculator();
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

rl.question('Enter your expression: ', (answer) => {
  try {
    const result = calc.calculate(answer);
    console.log(`Result: ${result}`);
  } catch (error: any) {
    console.error(`Error: ${error.message}`);
  }
  rl.close();
});