public class PremiumSavingAccount extends SavingsAccount{
    private double bonusRate;
    private static final double FINE_DISCOUNT = 0.20;
    public PremiumSavingAccount(String accountId, String ownerName, double initalBalance, double interestRate,double bonusRate) {
        super(accountId, ownerName, initalBalance, interestRate);
        this.bonusRate = bonusRate;
    }

    @Override
    public double calculateInterest() {
        double baseInterest =  super.calculateInterest();
    double bonusInterest = bonusRate* getBalance();
    return baseInterest=bonusInterest;
    }
    public double applyDiscount(double amount){
        return  amount * (1-FINE_DISCOUNT);
    }
}
