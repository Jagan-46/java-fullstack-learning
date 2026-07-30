public class BankAccount {
    String accountHolder;
    double balance;
    public BankAccount(String accountHolder,double balance){
        this.accountHolder=accountHolder;
        this.balance=balance;
    }
    public void withdraw(double amount)throws Exception{
       if(amount > balance) {
         throw new Exception("Insufficient Balance");
       }
       balance = balance-amount;
    }
    public void deposit(double amount)throws Exception{
        if(amount<=0){
            throw new Exception("Deposit amount should be Greater than'0'");
        }
        balance=amount+balance;
    }
    public double displayBalance(){
        return balance;
    }
    public static void main(String[]args){
        BankAccount account = new BankAccount("Jagan",1275000);
        try{
            account.withdraw(5000);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        try{
            account.deposit(150000);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Final Balance: "+account.displayBalance());
    }
}
