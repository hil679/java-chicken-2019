package domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    Map<Menu, Integer> orders = new HashMap<>();

    public void orderMenu(int menuUniqueNumber, int menuNum) {
        Menu menu = MenuRepository.findByNumber(menuUniqueNumber);
        orders.put(menu, orders.getOrDefault(menu, 0) + menuNum);
    }

    public int getOrderMenuNum(int menuUniqueNumber) {
        Menu menu = MenuRepository.findByNumber(menuUniqueNumber);
        return orders.getOrDefault(menu, 0);
    }
}
