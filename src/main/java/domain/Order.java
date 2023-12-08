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

    private int getDiscountPriceByChicken() {
        int chickenNum = 0;
        for(Menu menu : orders.keySet()) {
            if(menu.isChicken()) {
                chickenNum += orders.get(menu);
            }
        }
        return 10000 * (chickenNum / 10);
    }

    private int getDiscountPriceByCash(int currentPrice) {
        return (int) (currentPrice * 0.95);
    }
}
