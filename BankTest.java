public class BankTest{
    public static void main(String[] args){
        BankAccount account1 = new BankAccount();
        account1.deposit(500);
        account1.deposit(600, "savings");
        account1.deposit(433, "mistake");

        account1.withdraw(450);
        account1.withdraw(800, "savings");

        System.out.printf("Total Account Sum: $%.2f \n", account1.seeAccountsTotal());

        System.out.printf("Account Number: %s", account1.getAccountNumber());
    }
}