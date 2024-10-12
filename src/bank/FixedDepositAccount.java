package bank;

import java.util.*;

public class FixedDepositAccount extends BankAccount {


    // default interest and duration is 3 and 6
    private float interest = 3;
    private int duration = 6;
    private float accountBalance;

    public float getInterest() {
        return interest;
    }

    public int getDuration() {
        return duration;
    }

    private boolean interestSet = false;
    private boolean durationSet = false;
    private boolean balanceSet = false;

    // method to set interest, only allows setting once
    public void setInterest(float newInterest){
        if (interestSet) {
            throw new IllegalArgumentException("Interest can only be set once.");
        }
        this.interest = newInterest;
        interestSet = true;
    }

    // method to set duration, only allows setting once
    public void setDuration(int newDuration){
        if (durationSet) {
            throw new IllegalArgumentException("Duration can only be set once.");
        }
        this.duration = newDuration;
        durationSet = true;
    }

    // override set account balance
    @Override
    public void setAccountBalance(float newBalance){
        if (balanceSet) {
            throw new IllegalArgumentException("Balance cannot be changed once it is set.");
        }
        this.accountBalance = newBalance;
        balanceSet = true;
    }

    // constructors
    public FixedDepositAccount(String holderName, float accountBalance){
        super(holderName);
        setAccountBalance(accountBalance);
    }

    public FixedDepositAccount(String holderName, float accountBalance, float interest){
        super(holderName);
        setAccountBalance(accountBalance);
        if (interest == 3){
            this.interest = interest;
        } else
        setInterest(interest);
    }

    public FixedDepositAccount(String holderName, float accountBalance, float interest, int duration){
        super(holderName, accountBalance);
        if (interest == 3){
            this.interest = interest;
        } else
        setInterest(interest);
        if (duration == 6){
            this.duration = duration;
        } else
        setDuration(duration);
    }

    // override withdraw() and deposit() methods
    // perform a no operation
    // methods
    @Override
    public void deposit(float depositAmount){
        System.out.println("Operation is not allowed");
    }

    @Override
    public void withdraw(float withdrawAmount){
        System.out.println("Opeartion is not allowed");
    }

    @Override
    public float getAccountBalance(){
        // 100.0f -- treat 100 as float
        float balance = this.accountBalance + this.interest;
        return balance;
    }

    public void showAccountInfo(){
        System.out.println("Account type: fixed deposit");
        System.out.println("Account No: " + getAccountNumber());
        System.out.println("Account Balance: " + getAccountBalance());

    }
    
}
