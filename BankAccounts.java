/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankofhellengui;

/**
 *
 * @author Admin
 */
public  abstract class BankAccounts implements Accounts{
    protected double balance;
    protected String accountType;
    protected int acctId;
    private static int nextAcctNum;
    
    public BankAccounts (double balance,String accountType)
    {
        this.balance =balance;
        this.acctId = BankAccounts.nextAcctNum;
        BankAccounts.nextAcctNum++;
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public int getAcctNumber() {
        return acctId;
    }

    public void setAcctNumber(int acctNumber) {
        this.acctId = acctNumber;
    }
    @Override 
    //increase the bank account
    public void deposit (double moneyIn)
    {
        this.balance+= moneyIn;
        if (moneyIn <=0){
            System.out.println("Amount to be despoited should be postive");
        }
        else{
            balance += moneyIn;
            }
    }
    @Override
    //descrease the bank account
    public void withdraw (double moneyOut)
    {
        if (moneyOut <= balance)
        this.balance -= moneyOut;

    else
        System.out.println("insuffient funds in account.");
        
    }
    @Override
    public abstract void addInterest ();

    @Override
    public String toString() {
        return "BankAccounts{" + "balance=" + balance + ", accountType=" + accountType + ", acctId=" + acctId + '}';
    }
    
}
