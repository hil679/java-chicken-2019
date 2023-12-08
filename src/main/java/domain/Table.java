package domain;

public class Table {
    private final int number;
    private Order orders;

    public Table(final int number) {
        this.number = number;
        orders = new Order();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public boolean isEqualTableNumber(int number) {
        return this.number == number;
    }

    public int getOrderMenuNum(int menuUniqueNumber) {
        return orders.getOrderMenuNum(menuUniqueNumber);
    }

    public void orderMenu(int menuUniqueNumber, int menuNum) {
        orders.orderMenu(menuUniqueNumber, menuNum);
    }

    public int getTotalPayment(int paymentMethod) {
        return orders.getOrderPrice(paymentMethod);
    }

    public String getOrders() {
        return orders.toString();
    }
}
