const display = document.getElementById('display') as HTMLInputElement;

(window as any).append = (value: string) => {
    if (display) {
        display.value += value;
    }
};

document.getElementById('backspace')?.addEventListener('click', () => {
    if (display.value) {
        display.value = display.value.slice(0, -1);
    }
});

document.getElementById('clear')?.addEventListener('click', () => {
    display.value = '';
}); 

document.getElementById('calculate')?.addEventListener('click', async () => {
    const expression = display.value;
    if (!expression) return;

    try {
        const response = await fetch('http://localhost:3000/api/calculate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ expression })
        });

        if (!response.ok) {
            const errorData = await response.json();
            throw new Error(errorData.error || 'Calculation failed');
        }

        const data = await response.json();
        display.value = data.result.toString();

    } catch (error: any) {
        console.error("Calculation Error:", error);
        display.value = "Error"; 
        setTimeout(() => display.value = '', 1500);
    }
});