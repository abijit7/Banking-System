//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Bank bank = new Bank("Nepal Rastra Bank");
    SavingsAccount Ram = new SavingsAccount("1","Raj",2000,0.20);
    LoanAccount Sita  = new LoanAccount("2","Sita",5000,0.15);
    PremiumSavingAccount Hari = new PremiumSavingAccount("3","Hari",3000,0.25,1000);
    bank.addAccount(Ram);
    bank.addAccount(Sita);
    bank.addAccount(Hari);

    System.out.println(bank);


}
