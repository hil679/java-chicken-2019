package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ %s ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            String signal = "#";

            if(table.hasNotOrders()){
                signal = "─";
            }
            System.out.printf(BOTTOM_LINE, signal);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printMainFeatures() {
        System.out.println("## 메인화면");

        StringBuilder mainFeatures = new StringBuilder();
        mainFeatures.append("1 - 주문등록\n");
        mainFeatures.append("2 - 결제하기\n");
        mainFeatures.append("3 - 프로그램 종료\n");
        System.out.println(mainFeatures.toString());
    }

    public static void printTotalPayment(Table table, int paymentMethod) {
        System.out.println("## 최종 결제할 금액");
        System.out.println(table.getTotalPayment(paymentMethod) + "원");
    }

    public static void printOrders(Table table) {
        System.out.println("## 주문 내역");
        System.out.println("메뉴 수량 금액");
        System.out.println(table.getOrders());
    }
}
