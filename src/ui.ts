import { Calculator } from './calculator.js';

const calc = new Calculator();
const display = document.getElementById('display') as HTMLInputElement;

(window as any).append = (value: string) => {
    display.value += value;
};

document.getElementById('clear')?.addEventListener('click', () => {
    display.value = '';
});

document.getElementById('calculate')?.addEventListener('click', () => {
    try {
        const expression = display.value;
        const result = calc.calculate(expression);
        display.value = result.toString();
    } catch (error: any) {
        display.value = "Error"; 
        setTimeout(() => display.value = '', 1500);
    }
});
