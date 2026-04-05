import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Account implements Auditable{
    private String accountId;
    private String ownerName;
    private double balance;
    private List<String> transitionHistory;
    public Account(String accountId, String ownerName,double initalBalance){
        this.accountId = accountId;
        this.ownerName = ownerName;
        this.balance = initalBalance;
        this.transitionHistory = new ArrayList<>();
    logTransaction("Account created with balance : Rs"+initalBalance);
    }
    @Override
    public List<String> getTransactionHistory() {
        return Collections.unmodifiableList(transitionHistory);
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<String> getTransitionHistory() {
        return transitionHistory;
    }

    public void setTransitionHistory(List<String> transitionHistory) {
        this.transitionHistory = transitionHistory;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
            if (amount < 0){
                throw new IllegalArgumentException("Deposit amount must br positive");
            } balance+=amount;
            logTransaction("Deposited Rs "+ amount +"| Balance :"+balance);
        }
        public void withdraw(double amount){
        if(amount <=0){
         throw new IllegalArgumentException("amount must be positive");
        }
        if (balance<amount){
            System.out.println("Insufficient funds");
        }
        balance-= amount;
        logTransaction ("with drew Rs. :"+amount+ "Balance :"+ balance);
        }
protected void logTransaction(String message){
        transitionHistory.add(LocalDateTime.now()+" -- "+message);
}
protected void setBalance (double balance){
        this.balance = balance;
}
public abstract double calculateInterest();
}
