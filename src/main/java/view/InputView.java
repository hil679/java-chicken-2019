package view;

import view.validator.InputValidator;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final InputValidator inputValidator = new InputValidator();

    public static int inputMain() {
        while(true) {
            System.out.println("## 원하는 기능을 선택하세요.");

            int mainFeatureNum = scanner.nextInt();
            try {
                inputValidator.checkMainFeatures(mainFeatureNum);
                return mainFeatureNum;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static int inputTableNumber() {
        while(true) {
            System.out.println("## 주문할 테이블을 선택하세요.");

            int tableNum = scanner.nextInt();
            try {
                inputValidator.checkTableNumber(tableNum);
                return tableNum;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public static int inputMenu() {
        while(true) {
            System.out.println("## 등록할 메뉴를 선택하세요.");

            int menuNum = scanner.nextInt();
            try {
                inputValidator.checkMenu(menuNum);
                return menuNum;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }


    public static int inputMenuNum(int tableNumber, int menuUniqueNumber) {
        while(true) {
            System.out.println("## 메뉴의 수량을 입력하세요.");

            int menuNum = scanner.nextInt();
            try {
                inputValidator.checkMenuNumber(menuNum, tableNumber, menuUniqueNumber);
                return menuNum;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
