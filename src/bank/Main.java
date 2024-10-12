package bank;

public class Main {
    public static void main(String[] args) {
        BankAccount fredAccount = new BankAccount("Fred");
        System.out.println(fredAccount.toString());
        fredAccount.deposit(100.0f);
        //fredAccount.deposit(-50.0f);

        BankAccount juneAccount = new BankAccount("June", 500.0f);

        System.out.println(fredAccount.toString());
        System.out.println(juneAccount.toString());

        fredAccount.withdraw(50.0f);
        // fredAccount.withdraw(60.0f);
        fredAccount.printTransactions();

        FixedDepositAccount deenDepositAccount = new FixedDepositAccount("Deen", 100.0f);
        deenDepositAccount.withdraw(1000.0f);
        deenDepositAccount.deposit(1000000.0f);
        deenDepositAccount.showAccountInfo();

        
    }
}
