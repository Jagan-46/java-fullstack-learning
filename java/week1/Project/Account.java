import java.util.*;
public abstract class Account {
    public int accountNumber;
    public String accountHolder;
    public double balance;
    public abstract void deposit(double amount) throws Exception;
    public abstract void withdraw(double amount) throws Exception;
    public double getBalance(){
        return balance;
    }
    public int getAccountNumber(){
        return accountNumber;
    }
    @Override
    public String toString(){
        return "Account{"+"accountNumber= "+accountNumber+", accountHolder= "+accountHolder+", balance= "+balance+" }";
    }
}
class SavingsAccount extends Account {
    double interestRate;

    public SavingsAccount(int accountNumber, String accountHolder, double balance, double interestRate) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Deposit Amount Should be Greater than 0");
        }
        balance = balance + amount + (amount * interestRate);
    }
    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Balance is Low");
        }
        balance = balance - amount;
    }
}
class CheckingAccount extends Account {
    double overdraftLimit;

    public CheckingAccount(int accountNumber, String accountHolder, double balance, double overdraftLimit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.overdraftLimit = overdraftLimit;
    }

    public void deposit(double amount) throws Exception {
        if (amount <= 0) {
            throw new Exception("Deposit amount should be greater than 0");
        }
        balance = balance + amount;
    }

    public void withdraw(double amount) throws Exception {
        if (amount > (balance + overdraftLimit)) {
            throw new Exception("Low BankAccount Balance");
        }
        balance = balance - amount;
    }
}
    class Bank {
        ArrayList<Account> account = new ArrayList<>();

        public void addAccount(Account acc) {
            account.add(acc);
        }

        public Account findAccount(int accountNumber) {
            for (Account acc : account) {
                if (acc.getAccountNumber() == accountNumber) {
                    return acc;
                }
            }
            return null;
        }

        public double getBalance(int accountNumber) {
            for (Account acc : account) {
                if (acc.getAccountNumber() == accountNumber) {
                    return acc.getBalance();
                }
            }
            return 0;
        }

        public void deposit(int accountNumber, double amount) throws Exception {
            for (Account acc : account) {
                if (acc.getAccountNumber() == accountNumber) {
                        acc.deposit(amount);
                        return;
                }
            }
        }

        public void withdraw(int accountNumber, double amount) throws Exception {
            for (Account acc : account) {
                if (acc.getAccountNumber() == accountNumber) {
                        acc.withdraw(amount);
                        return;
                }
            }
        }
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingsAccount savings = new SavingsAccount(10023, "Jagan", 600000, 8);
        SavingsAccount savings1 = new SavingsAccount(10003,"Arun",500000,2);
        CheckingAccount checking = new CheckingAccount(10054, "Siva", 300000, 50000);
        CheckingAccount checking1 = new CheckingAccount(1002,"Durai",100000,5000);
         bank.addAccount(savings);
         bank.addAccount(checking);
         bank.addAccount(savings1);
         bank.addAccount(checking1);
         try {
             bank.deposit(10023, 30000);
             System.out.println("Transaction Successful");
             System.out.println("Balance: "+bank.getBalance(10023));
             bank.withdraw(10054,36000);
             System.out.println("Transaction Successful");
             System.out.println("Balance: "+ bank.getBalance(10054));
         }
         catch(Exception e){
            System.out.println( e.getMessage());
         }
        System.out.println("Balance: "+bank.getBalance(10054));
        System.out.println("Balance: "+bank.getBalance(1002));
        System.out.println("Balance: "+bank.getBalance(10003));
        System.out.println(bank.findAccount(10054));

        }
    }