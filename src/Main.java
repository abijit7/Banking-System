//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Bank bank = new Bank("Nepal Rastra Bank");
    SavingsAccount Ram = new SavingsAccount("1", "Raj", 2000, 0.20);
    LoanAccount Sita = new LoanAccount("2", "Sita", 5000, 0.15);
    PremiumSavingAccount Hari = new PremiumSavingAccount("3", "Hari", 3000, 0.25, 0.02);
    bank.addAccount(Ram);
    bank.addAccount(Sita);
    bank.addAccount(Hari);
    bank.findAccountAboveBalance(2500);
    bank.displayAllAccounts();
    System.out.println(Ram.getTransactionHistory());
    System.out.println(bank);
    bank.findAccount("1").deposit(3000);
    System.out.println("Ram account after deposit :" + bank.findAccount("1"));
    Sita.withdraw(200);
    System.out.println("Sita account after withdraw :" + bank.findAccount("2"));
    Hari.withdraw(200);
    System.out.println("Hari account after withdraw :" + bank.findAccount("3"));
    SavingsAccount ramAcc = (SavingsAccount) bank.findAccount("1");
    boolean success = ramAcc.transfer(bank.findAccount("2"), 300);
    System.out.println("Transferred sucessfully:" + success);
    System.out.println(bank.findAccount("2"));
    LoanAccount sitaAcc = (LoanAccount) bank.findAccount("2");
    sitaAcc.Repayment(5000);
    System.out.println("Remaining loan amount after repayment:" + sitaAcc.getLoanAmount());
    System.out.println("latest account detail of Sita" + bank.findAccount("2"));

    System.out.println("Ram interest:   Rs " + bank.findAccount("1").calculateInterest());
    System.out.println("Sita interest: Rs " + bank.findAccount("2").calculateInterest());
    System.out.println("Hari interest: Rs " + bank.findAccount("3").calculateInterest());
    System.out.println(bank.displayAllAccounts());
    bank.printTarnsactionHistory("1");
}