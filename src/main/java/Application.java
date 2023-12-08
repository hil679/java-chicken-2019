import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int mainFeature = getMainFeatures();
        while(mainFeature != 3) {
            final List<Table> tables = TableRepository.tables();
            OutputView.printTables(tables);

            final int tableNumber = InputView.inputTableNumber();
            Table table = TableRepository.findByNumber(tableNumber);
            if(mainFeature == 1) {
                final List<Menu> menus = MenuRepository.menus();
                OutputView.printMenus(menus);

                final int menuUniqueNumber = InputView.inputMenu();
                final int menuNumber = InputView.inputMenuNum(tableNumber, menuUniqueNumber);
                table.orderMenu(menuUniqueNumber, menuNumber);
            } else{
                int paymentMethod = InputView.inputPaymentMethod(tableNumber);
                OutputView.printOrders(table);
                OutputView.printTotalPayment(table, paymentMethod);
                table.clearOrders();
            }
            mainFeature = getMainFeatures();
        }

    }

    public static int getMainFeatures() {
        OutputView.printMainFeatures();
        return InputView.inputMain();
    }
}
