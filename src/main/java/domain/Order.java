package domain;

import java.util.HashMap;
import java.util.Map;

import static constant.Payment.*;

public class Order {
    Map<Menu, Integer> orders = new HashMap<>();
    private final static int DEFAULT_NUM = 0;
    private final static double CASH_DISCOUNT_PERCENT = 0.95;

    public void orderMenu(int menuUniqueNumber, int menuNum) {
        Menu menu = MenuRepository.findByNumber(menuUniqueNumber);
        orders.put(menu, orders.getOrDefault(menu, DEFAULT_NUM) + menuNum);
    }

    public int getOrderMenuNum(int menuUniqueNumber) {
        Menu menu = MenuRepository.findByNumber(menuUniqueNumber);
        return orders.getOrDefault(menu, DEFAULT_NUM);
    }

    private int getOrderPriceBeforeDiscount() {
        int totalPrice = DEFAULT_NUM;
        for(Menu menu : orders.keySet()) {
            totalPrice += orders.get(menu) * menu.getPrice();
        }

        return totalPrice;
    }

    public int getOrderPrice(int paymentMethod) {
        int currentPrice = getOrderPriceBeforeDiscount() - getDiscountPriceByChicken();
        if(paymentMethod == CASH.getValue()) {
            return getDiscountPriceByCash(currentPrice);
        }
        return currentPrice;
    }

    private int getDiscountPriceByChicken() {
        int chickenNum = DEFAULT_NUM;
        for(Menu menu : orders.keySet()) {
            if(menu.isChicken()) {
                chickenNum += orders.get(menu);
            }
        }
        return DISCOUNT_PRICE.getValue() * (chickenNum / DISCOUNT_CHICKEN_NUM.getValue());
    }

    private int getDiscountPriceByCash(int currentPrice) {
        return (int) (currentPrice * CASH_DISCOUNT_PERCENT);
    }

    public void clearOrders() {
        orders.clear();
    }

    public boolean hasNotOrder() {
        return orders.size() <= DEFAULT_NUM;
    }

    @Override
    public String toString() {
        StringBuilder orderList = new StringBuilder();
        for(Menu menu : orders.keySet()) {
            int menuNum = orders.get(menu);
            orderList.append(menu.getName());
            orderList.append(" ");
            orderList.append(menuNum);
            orderList.append(" ");
            orderList.append(menuNum * menu.getPrice());
            orderList.append("\n");
        }

        return orderList.toString();
    }
}
