import express from 'express';
import cors from 'cors';
import calcRoutes from './routes/calcRoutes.js';

const app = express();
const port = 3000;

app.use(cors());
app.use(express.json());

app.use('/api', calcRoutes); 

app.listen(port, () => {
    console.log(`🚀 Calculator API is running at http://localhost:${port}`);
});