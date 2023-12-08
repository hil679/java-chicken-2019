package view.validator;

import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;

public class InputValidator {
    public void checkMainFeatures(int mainFeatureNum){
        if(isNotMainFeatureNum(mainFeatureNum)) {
            throw new IllegalArgumentException("[ERROR] 메인 화면 기능 목록에 있는 숫자만 입력해주세요.");
        }
    }

    private boolean isNotMainFeatureNum(int mainFeatureNum) {
        return 1 > mainFeatureNum && mainFeatureNum > 3;
    }

    public void checkTableNumber(int tableNumber) {
        if(isNotTableNumber(tableNumber)) {
            throw new IllegalArgumentException("[ERROR] 정확한 테이블 숫자를 입력해주세요.");
        }
    }

    private boolean isNotTableNumber(int tableNumber) {
        return !TableRepository.tables()
                .stream()
                .anyMatch(table -> table.isEqualTableNumber(tableNumber));
    }

    public void checkMenu(int menuUniqueNumber) {
        if(isNotMenu(menuUniqueNumber)) {
            throw new IllegalArgumentException("[ERROR] 정확한 메뉴 번호를 입력해주세요.");
        }
    }

    private boolean isNotMenu(int menuUniqueNumber) {
        return !MenuRepository.menus()
                .stream()
                .anyMatch(menu -> menu.isEqualMenuNumber(menuUniqueNumber));
    }


    public void checkMenuNumber(int menuNumber, int tableNumber, int menuUniqueNumber) {
        if(isNotMenuNumber(menuNumber, tableNumber, menuUniqueNumber)) {
            throw new IllegalArgumentException("[ERROR] 메뉴 가능 개수 범위를 벗어났습니다.");
        }
    }

    private boolean isNotMenuNumber(int menuNumber, int tableNumber, int menuUniqueNumber) {
        Table table = TableRepository.findByNumber(tableNumber);
        int totalMunuNum = menuNumber + table.getOrderMenuNum(menuUniqueNumber);
        return menuNumber < 1 || totalMunuNum > 99;
    }
}
