public class CurrentAccount extends Account {
    private  double overdraftLimit;

    public CurrentAccount(String accountId, String ownerName, double initalBalance,double overdraftLimit) {
        super(accountId, ownerName, initalBalance);
this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if(amount<=0){
            throw new IllegalArgumentException("amount should be positive");
        }
        if (getBalance()-amount <-overdraftLimit){
            throw new IllegalStateException(
                    "Exceeds overdraft limit"+overdraftLimit);

        }
        setBalance(getBalance()-amount);
        logTransaction("withdraw amount = "+amount+"balance ="+getBalance());
    }

    @Override
    public double calculateInterest() {
        return 0;
    }

}
