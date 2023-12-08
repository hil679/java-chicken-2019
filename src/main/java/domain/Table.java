package domain;

public class Table {
    private final int number;
    private Order orders;

    public Table(final int number) {
        this.number = number;
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
}
