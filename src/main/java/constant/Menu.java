package constant;

public enum Menu {
    MAX_MENU_NUMBER(99),
    UNABLE_MENU_NUMBER(0),
    ;

    int value;

    Menu(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
