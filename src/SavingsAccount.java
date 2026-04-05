

public class SavingsAccount extends Account implements Transferable{
    double interestRate;
    public SavingsAccount(String accountId, String ownerName, double initalBalance , double interestRate) {
        super(accountId, ownerName, initalBalance);
        this.interestRate = interestRate;
    }

    @Override
    public boolean transfer(Account target, double amount) {
        if (getBalance()<amount){
            return false;
        }
        withdraw(amount);
        target.deposit(amount);
        logTransaction("transferred amount Rs"+amount+"to : "+ target);
        return true;
    }
    public double calculateInterest(){
        return getBalance()*interestRate;
    }

}
