package bank;

import java.util.*;
import java.time.*;


public class BankAccount {

    // members
    private final String holderName;
    private final String accountNumber;
    private float accountBalance;
    private List<String> transactions;
    private boolean closed;
    private Date creatingDate;
    private Date closingDate;

    // read only properties, account name and account number cannot be changed
    // getters and setters
    public String getHolderName() {
        return holderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public float getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }
    public List<String> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
    public boolean isClosed() {
        return closed;
    }
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
    public Date getCreatingDate() {
        return creatingDate;
    }
    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }
    public Date getClosingDate() {
        return closingDate;
    }
    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    //constructor

    public BankAccount(String holderName){
        this.accountNumber = generateAccountNo();
        this.holderName = holderName;
        setAccountBalance(0);

        // getting the default time zone
        // so we can append the timezone info with the date
        ZoneId defaultZone = ZoneId.systemDefault();
        // get the date
        // atStartOfDay() -- append the time with the date
        // LocalDate to Date
        this.creatingDate = Date.from(LocalDate.now().atStartOfDay(defaultZone).toInstant());

        if (transactions == null){
            transactions = new LinkedList<>();
        }
    }

    public BankAccount(String holderName, float accountBalance){
        this.accountNumber = generateAccountNo();
        this.holderName = holderName;
        setAccountBalance(accountBalance);

        if (transactions == null){
            transactions = new LinkedList<>();
        }
    }

    //methods
    private String generateAccountNo() {
        // A to Z
        int startAsciiNo = 65;
        int endAsciiNo = 90; 
        int accountNoLength = 10;

        Random random = new Random();
        String accountNo = " ";

        for (int i = 0; i < accountNoLength; i++){
            int randomValue = startAsciiNo + random.nextInt(endAsciiNo - startAsciiNo + 1);
            accountNo = accountNo + (char) randomValue;
        }
        return accountNo;
    }

    public void printTransactions(){
        System.out.printf("%s's account: \n", this.holderName);
        for (String s : transactions){
            System.out.println(s);
        }
    }

    @Override
    public String toString() {
        return "Bank Account [Account Number = %s, holder name = %s, balance = %.2f, isClosed = %s, accountStart = %s, accountEnd = %s]".formatted(accountNumber, holderName, accountBalance, closed, creatingDate, closingDate);
    }

    public void deposit(float depositAmount){
        if (depositAmount < 0){
            throw new IllegalArgumentException("Deposits only accepts positive amount.");
        } else if (isClosed()){
            throw new IllegalArgumentException("Account is closed.");
        } else{
            transactions.add("deposited $" + depositAmount + " at <" + LocalDate.now() + ">");
            this.accountBalance += depositAmount;
        }
    }

    public void withdraw(float withdrawAmount){
        if (withdrawAmount > getAccountBalance()) {
            throw new IllegalArgumentException("Withdrawals cannot be more than your account balance.");
        } else if (withdrawAmount <= 0){
            throw new IllegalArgumentException("Withdrawals can only accept positive amount");
        } else if (isClosed()){
            throw new IllegalArgumentException("Account is closed.");
        } else{
            transactions.add("withdrawed $" + withdrawAmount + " at <" + LocalDate.now() + ">");
            this.accountBalance -= withdrawAmount;
        }
        
    }

}
