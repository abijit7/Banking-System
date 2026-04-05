public class LoanAccount extends Account{
private double loanAmount;
private double interestRate;
    public LoanAccount(String accountId, String ownerName, double initalBalance,double loanAmount,double interestRate) {
        super(accountId, ownerName, -loanAmount);
    this.interestRate = interestRate;
    this.loanAmount = loanAmount;
    }
    public double calculateInterest(){
        return loanAmount * interestRate;
    }
    public double calculateTax(){
        return calculateInterest() *0.10;
    }
    public void Repayment(double amount){
        if(amount <=0){
         throw new IllegalArgumentException("amount must be positive");
        }
        loanAmount -= amount;
        deposit(amount);
        logTransaction("repayment of Rs "+amount+"Remaining Loan :"+loanAmount);
    }
}
