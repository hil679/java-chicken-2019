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
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
    }

    public static int inputMenu() {
        return 0;
    }


    public static int inputMenuNum() {
        return 0;
    }
}
