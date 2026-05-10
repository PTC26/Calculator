import { Request, Response } from 'express';
import { Calculator } from '../calculator.js';

const calc = new Calculator();

export const calculate = (req: Request, res: Response) => {
    const { expression } = req.body;

    try {
        const result = calc.calculate(expression);
        res.json({ result });
    } catch (error: any) {
        res.status(400).json({ error: error.message || "Invalid expression" });
    }
};