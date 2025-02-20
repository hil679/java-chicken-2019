import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

import static constant.MainFeature.EXIT;
import static constant.MainFeature.ORDER;

public class Application {
    public static void main(String[] args) {
        int mainFeature = getMainFeatures();
        while(mainFeature != EXIT.getFeature()) {
            final List<Table> tables = TableRepository.tables();
            OutputView.printTables(tables);

            final int tableNumber = InputView.inputTableNumber();
            Table table = TableRepository.findByNumber(tableNumber);

            if(mainFeature == ORDER.getFeature()) {
                order(tableNumber, table);
            } else{
                pay(tableNumber, table);
            }

            mainFeature = getMainFeatures();
        }
    }

    public static int getMainFeatures() {
        OutputView.printMainFeatures();
        return InputView.inputMain();
    }

    public static void order(int tableNumber, Table table) {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuUniqueNumber = InputView.inputMenu();
        final int menuNumber = InputView.inputMenuNum(tableNumber, menuUniqueNumber);
        table.orderMenu(menuUniqueNumber, menuNumber);
    }

    public static void pay(int tableNumber, Table table) {
        int paymentMethod = InputView.inputPaymentMethod(tableNumber);
        OutputView.printOrders(table);
        OutputView.printTotalPayment(table, paymentMethod);
        table.clearOrders();
    }
}
