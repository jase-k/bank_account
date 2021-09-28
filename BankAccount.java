import java.lang.Math;

public class BankAccount{
    private double checkingBalance;
    private double savingsBalance;
    private static int numOfAccounts;
    private long accountNumber; 

    BankAccount(){
        this.checkingBalance = 0.0;
        this.savingsBalance = 0.0;
        numOfAccounts++;
        this.accountNumber = randomizeAccountNumber();
    }
    private static long randomizeAccountNumber(){
        double randNum = Math.random()* 10000000000L;
        long account = (long) randNum;
        return account;
    }

    public static int getNumberOfAccounts(){
        return numOfAccounts;
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }

    public void deposit(double amount){
        this.checkingBalance += amount;
        System.out.printf("Deposited %s in Checking Account \n", amount);
    }

    public void deposit(double amount, String account){
        if(account == "checking"){
            this.checkingBalance += amount;
            System.out.printf("Deposited %s in Checking Account \n", amount);
        }
        else if(account == "savings"){
            this.savingsBalance += amount;
            System.out.printf("Deposited %s in Savings Account \n", amount);
        }
        else {
            System.out.println("Transaction Failed");
        }
    }
    
    public void withdraw(double amount){
        if(this.checkingBalance >= amount){
            this.checkingBalance -= amount;
            System.out.printf("Transaction Succeed! new balance: %.2f \n", this.getCheckingBalance());
        }
        else{
            System.out.printf("Transaction Failed. Insufficient Funds current balance: %.2f \n", this.getCheckingBalance());
        }
    }

    public void withdraw(double amount, String account){
        if(account == "checking"){
            if(this.checkingBalance >= amount){
                this.checkingBalance -= amount;
                System.out.printf("Transaction Succeed! new balance: %.2f \n", this.getCheckingBalance());
            }
            else{
                System.out.printf("Transaction Failed. Insufficient Funds current balance: %.2f \n", this.getCheckingBalance());
            }
        }
        else if(account == "savings"){
            if(this.savingsBalance >= amount){
                this.savingsBalance -= amount;
                System.out.printf("Transaction Succeed! new balance: %.2f \n", this.getSavingsBalance());
            }
            else{
                System.out.printf("Transaction Failed. Insufficient Funds current balance: %.2f \n", this.getSavingsBalance());
            }
        }
        else{
            System.out.println("Transaction Failed. Account Name not Recognized");
        }
    }

    public double seeAccountsTotal(){
        return this.getSavingsBalance() + this.getCheckingBalance();
    }

}

