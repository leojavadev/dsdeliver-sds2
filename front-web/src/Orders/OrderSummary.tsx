import { formatPrice } from './helpers';

type Props = {
    amount: number;
    totalPrice: number;
    onSubmit: () => void;
}

export default function OrderSummary({amount, totalPrice, onSubmit}: Props) {

    const disabledButton = (amount !== 0) ? false : true;

    return (
        <div className="order-summary-container">
            <div className="order-summary-content">
                <div>
                    <span className="amount-selected-container">
                        <strong className="amount-selected">{amount}</strong>
                        PRODUTOS SELECIONADOS
                    </span>
                    <span className="order-summary-total">
                        <strong className="amount-selected">{formatPrice(totalPrice)}</strong>
                        VALOR TOTAL
                    </span>
                </div>
                <button 
                    className={`order-summary-make-order ${(amount !== 0) ? '' : 'disabled'}`} 
                    onClick={onSubmit} 
                    disabled={disabledButton}
                >
                    FAZER PEDIDO
                </button>
            </div>
        </div>
    )
}