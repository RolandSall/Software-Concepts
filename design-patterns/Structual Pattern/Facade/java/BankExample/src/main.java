import Bank.BankAccountFacade;
import Bank.BankAccountNotFound;

public class main {
    public static void main(String[] args) {

        BankAccountFacade bankAccess = new BankAccountFacade("11242FDA",454);

        try {
            bankAccess.withDrawCash(50.00);
            bankAccess.withDrawCash(300);
            bankAccess.depositCash(55);
            bankAccess.withDrawCash(950);
        } catch (BankAccountNotFound e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
