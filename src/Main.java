//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {


    Bank bank = new Bank("Nepal Bank");

    SavingsAccount ram        = new SavingsAccount("1", "Ram", 5000, 0.05);
    LoanAccount sita          = new LoanAccount("2", "Sita", 20000, 0.12);
    PremiumSavingAccount hari = new PremiumSavingAccount("3", "Hari", 8000, 0.05, 0.02);

    bank.addAccount(ram);
    bank.addAccount(sita);
    bank.addAccount(hari);

// Filter
    bank.findAccountAboveBalance(2500).forEach(System.out::println);

// Display all
    bank.displayAllAccounts();

// Transaction history
    System.out.println(ram.getTransactionHistory());

// Deposit
    bank.findAccount("1").deposit(3000);
    System.out.println("Ram after deposit: " + bank.findAccount("1"));

// Withdraw
    bank.findAccount("2").withdraw(200);  // consistent — through bank
    System.out.println("Sita after withdraw: " + bank.findAccount("2"));

    bank.findAccount("3").withdraw(200);
    System.out.println("Hari after withdraw: " + bank.findAccount("3"));

// Transfer — Ram to Hari (not to Sita — loan account)
    SavingsAccount ramAcc = (SavingsAccount) bank.findAccount("1");
    boolean success = ramAcc.transfer(bank.findAccount("3"), 300);
    System.out.println("Transfer successful: " + success);
    System.out.println("Hari after transfer: " + bank.findAccount("3"));

// Repayment
    LoanAccount sitaAcc = (LoanAccount) bank.findAccount("2");
    sitaAcc.Repayment(5000);  // ← fixed: makeRepayment not Repayment
    System.out.println("Remaining loan: Rs " + sitaAcc.getLoanAmount());
    System.out.println("Sita latest: " + bank.findAccount("2"));

// Interest
    System.out.println("Ram interest:  Rs " + bank.findAccount("1").calculateInterest());
    System.out.println("Sita interest: Rs " + bank.findAccount("2").calculateInterest());
    System.out.println("Hari interest: Rs " + bank.findAccount("3").calculateInterest());

// Display all again
    bank.displayAllAccounts();

// History
    bank.printTarnsactionHistory("1");
}