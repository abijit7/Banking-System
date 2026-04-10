import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Bank {
    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", accounts=" + accounts +
                '}';
    }

    private String bankName;
    private Map<String,Account> accounts;
    public Bank(String bankName){
        this.bankName = bankName;
        this.accounts = new HashMap<>();
    }
    public  void addAccount(Account account){
        accounts.put(account.getAccountId(),account);
    }
    public Account findAccount(String accountId){
        Account account = accounts.get(accountId);
        if (account == null){
            throw new IllegalArgumentException("Account not found");
        }
        return  account;
    }
    public List<Account> findAccountAboveBalance(double thresold){
        return accounts.values().stream().filter(a->a.getBalance()>thresold).collect(Collectors.toList());
    }
    public List<Account> displayAllAccounts(){
        return accounts.values().stream().filter(a->a.getBalance()>0).collect(Collectors.toList());

    }
    public void printTarnsactionHistory(String accountId){
        Account account = findAccount(accountId);
        System.out.println("history of "+account.getOwnerName());
        account.getTransactionHistory().forEach(System.out::println);
    }
}
