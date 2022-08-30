# Single Responsibility Principle

This principle is self-explanatory; It means that a class, function, module or any given program should have one responsibility/purpose.

> Every Class Should have one reason to change



```java
public class BankService {

    public long deposit(long amount, String accountNo) {
        //deposit amount
        return 0;
    }

    public long withDraw(long amount, String accountNo) {
        //withdraw amount
        return 0;
    }
    
    public void getLoanInterestInfo(String loanType) {
        if (loanType.equals("homeLoan")) {
            //do some job
        }
        if (loanType.equals("personalLoan")) {
            //do some job
        }
        if (loanType.equals("car")) {
            //do some job
        }
    }
    
     public void sendOTP(String medium) {
        if (medium.equals("email")) {
            //write email related logic
           
        }
        if(medium.equals("mobile")){
            //write logic using twillio API
        }
    }

}
```

Take the code sample above. This class violates the Single Responsibility principles since the class has a whole lot of logic interconnected that we would have a hard time fixing errors. And as the codebase grows, so does the logic, making it even harder to understand what is going on.

