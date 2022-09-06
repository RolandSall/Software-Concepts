package Bank;

public class FundCheck {

    // initial dummy amount
    private double cashInAccount = 1000;

    public double getCashInAccount() {
        return cashInAccount;
    }

    public void cashWithdraw(double cash){
         if (cash > getCashInAccount()){
            System.out.println("Not Enough Money, You Current Balance is: " + getCashInAccount());
            return;
        }
        cashInAccount -= cash;
        System.out.println("Withdraw Complete, Your current Balance: " + getCashInAccount());
    }

    public void depositCash(double cash){
        cashInAccount += cash;
        System.out.println("Withdraw Complete, Your current Balance: " + getCashInAccount());
    }


}
