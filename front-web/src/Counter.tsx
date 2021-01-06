import { useState } from "react";

function Counter() {

    const [counter, setCounter] = useState(0);

    const handleIncrease = () => {
        setCounter(counter + 1);
    }

    const handleDecrease = () => {
        if(counter >= 1){
            setCounter(counter - 1);
        }
    }

    return (
        <div>
            <h1>Counter</h1>
            <button onClick={handleIncrease}>Increment</button>
            <button onClick={handleDecrease}>Decrement</button>
            <p>Valor do contador: {counter}</p>
        </div>
    )
}

export default Counter;