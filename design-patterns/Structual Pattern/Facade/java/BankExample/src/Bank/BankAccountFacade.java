package Bank;

public class BankAccountFacade {
    private String accountNumber;
    private int securityCheck;

    private AccountNumberCheck accountNumberCheck;
    private SecurityCodeCheck securityCodeCheck;
    private FundCheck fundCheck;


    public BankAccountFacade(String accountNumber, int securityCheck) {
        this.accountNumber = accountNumber;
        this.securityCheck = securityCheck;
        accountNumberCheck = new AccountNumberCheck();
        securityCodeCheck = new SecurityCodeCheck();
        fundCheck = new FundCheck();
    }

    public String getAccountNumber() {
        return accountNumber;
    }



    public int getSecurityCheck() {
        return securityCheck;
    }


    public void withDrawCash(double cashToWithDraw) throws BankAccountNotFound {
        if(accountNumberCheck.isValid(getAccountNumber())
                && accountNumberCheck.isValid(getAccountNumber())
        ) {
            fundCheck.cashWithdraw(cashToWithDraw);
        } else {
            throw new BankAccountNotFound("Bank Details Does Not Exist");
        }
    }

    public void depositCash(double cashToWithDraw) throws BankAccountNotFound {
        if(accountNumberCheck.isValid(getAccountNumber())
                && accountNumberCheck.isValid(getAccountNumber())
        ) {
            fundCheck.depositCash(cashToWithDraw);
        } else {
            throw new BankAccountNotFound("Bank Details Does Not Exist");
        }
    }

}
