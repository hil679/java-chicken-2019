package domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    Map<Integer, Integer> orders = new HashMap<>();

    public int getOrderMenuNum(int menuUniqueNumber) {
        return orders.get(menuUniqueNumber);
    }
}
