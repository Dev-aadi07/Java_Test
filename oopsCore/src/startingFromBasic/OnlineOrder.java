package startingFromBasic;

abstract class Order {
    protected String orderId;
    protected int quantity;
    protected double amount;

    Order(String orderId, int quantity, double amount) throws InvalidQuantityException {
        if (quantity <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than zero.");
        }
        this.orderId = orderId;
        this.quantity = quantity;
        this.amount = amount;
    } 

    boolean isInStock() {
        return quantity > 0;
    }

    abstract boolean canPlaceOrder();

    void placeOrder(int qty)
            throws InvalidQuantityException, OutOfStockException, PaymentFailedException {

        if (qty <= 0) {
            throw new InvalidQuantityException("Quantity must be greater than zero.");
        }

        if (!isInStock()) {
            throw new OutOfStockException("Currently out of stock.");
        }

        if (qty > quantity) {
            throw new OutOfStockException("Requested quantity not available.");
        }

        if (!canPlaceOrder()) {
            throw new PaymentFailedException("Order cannot be placed.");
        }

        quantity -= qty;
    }

    void show() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Available Quantity: " + quantity);
        System.out.println("Amount: ₹" + amount);
    }
}

class CODOrder extends Order {

    CODOrder(String orderId, int quantity, double amount)
            throws InvalidQuantityException {
        super(orderId, quantity, amount);
    }

    @Override
    boolean canPlaceOrder() {
        return amount <= 5000;
    }
}

class PrepaidOrder extends Order {

    PrepaidOrder(String orderId, int quantity, double amount)
            throws InvalidQuantityException {
        super(orderId, quantity, amount);
    }

    @Override
    boolean canPlaceOrder() {
        return true;
    }
}

public class OnlineOrder {

    public static void main(String[] args) {
        try {
            Order order = new CODOrder("A1", 10, 4000);
            order.show();

            order.placeOrder(2);

        } catch (InvalidQuantityException |
                 OutOfStockException |
                 PaymentFailedException e) {

            System.out.println(e.getMessage());
        }
    }
}

class InvalidQuantityException extends Exception {
    public InvalidQuantityException(String message) {
        super(message);
    }
}

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class PaymentFailedException extends Exception {
    public PaymentFailedException(String message) {
        super(message);
    }
}
