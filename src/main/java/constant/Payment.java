package constant;

public enum Payment {
    DISCOUNT_PRICE(10000),
    DISCOUNT_CHICKEN_NUM(10),
    CARD(1),
    CASH(2);

    int value;

    Payment(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
