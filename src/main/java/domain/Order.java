package domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    Map<Integer, Integer> orders = new HashMap<>();

    public void orderMenu(int menuUniqueNumber, int menuNum) {
        orders.put(menuUniqueNumber, orders.getOrDefault(menuUniqueNumber, 0) + menuNum);
    }

    public int getOrderMenuNum(int menuUniqueNumber) {
        return orders.getOrDefault(menuUniqueNumber, 0);
    }
}
