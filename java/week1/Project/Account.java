public abstract class Account {
    int accountNumber;
    String accountHolder;
    double balance;
    public abstract void deposit(double amount) throws Exception;
    public abstract void withdraw(double amount) throws Exception;
    public double getBalance(){
        return balance;
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

    public static void main(String[] args) {

        SavingsAccount savingsaccount = new SavingsAccount(123456, "Jagan", 600000, 8);
        try {
            savingsaccount.deposit(10000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(savingsaccount.getBalance());

        CheckingAccount checkingaccount = new CheckingAccount(123456789, "Siva", 300000, 50000);
        try {
            checkingaccount.deposit(5000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
}
            System.out.println(checkingaccount.getBalance());
        }
    }