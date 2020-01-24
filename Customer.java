/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankofhellengui;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Hellen Harry
 */
public class Customer extends Person {
  private int custId;
  private double balance;
  ArrayList<BankAccounts> accounts = new ArrayList<BankAccounts> ();
  
  
 
    
    public Customer(int custId,String lastName,String firstName,String middleName,String Street,
        String city,String province,String postalCode,long phoneNumber,String dateOfBirth,String email,
        Gender gender,double Chequing,double Investment, double Saving)
    {
        super(lastName,firstName,middleName,Street,city,province,postalCode,dateOfBirth,gender,email,phoneNumber);
        this.custId = custId;
        BankAccounts newAccount = new ChequingAcct(Chequing,"Chequing");
        accounts.add(newAccount);
        newAccount = new InvestmentAcct(Investment,"Investment");
         accounts.add(newAccount);
        newAccount = new SavingAcct(Saving,"Saving");
        accounts.add(newAccount);
    }


    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }
    // to edit the persons firstName and lastName
    public void setName(String firstName,String lastName){
        super.firstName = firstName;
        super.lastName = lastName;
    }
    //to get customer full name
    public String getName(){
      return super.lastName +" " + super.firstName +" "+ super.middleName ;
     
    }
    //to get customer address
    public String getAddress(){
        return super.Street + " " + super.city + " " + super.province  + " "
                + super.postalCode;
    }
    // to edit the persons address
    public void setAddress(){
        super.Street = Street;
        super.city = city;
        super.province = province;
        super.postalCode = postalCode;
    }
    //to get customer phone number
    public long getPhoneNumber(){
        return super.phoneNumber;
    }
    // to edit customer phone number
    public void setPhoneNumber(){
        super.phoneNumber = phoneNumber;
    }
    // gets the account balance for which accounttype it is from
    public double getBalance(String accountType){
        return balance;
    }
    
    //increase the amount of money in the account Type selected
    public void deposit(double moneyIn,String accountType) throws Exception
    {

        
        if (moneyIn <=0 && accountType.equalsIgnoreCase("Chequing")){
            throw new Exception("Amount to be despoited should be postive");
        }
        else if(true){
            accounts.get(0).balance += moneyIn;
            return;
        }
            
     
        
        if (moneyIn <=0 && accountType.equalsIgnoreCase("Saving")){
            throw new Exception("Amount to be despoited should be postive");
        }
        else if(true){
            accounts.get(1).balance += moneyIn;
            return;
                    
        }
   
        
        if (moneyIn <=0 && accountType.equalsIgnoreCase("investment")){
            throw new Exception("Amount to be despoited should be postive");
        }
        else if(true){
            accounts.get(2).balance += moneyIn;
            return;
            
        
        }
    }
    
   
    //descrease the bank account
   
    
    public void withdraw (double moneyOut,String accountType) throws Exception {

        if (moneyOut <= balance && accountType.equalsIgnoreCase("chequing") ){
            accounts.get(0).balance -= moneyOut;
            return;
        }
        
        else if (false) {
            throw new Exception("insuffient funds in account.");
        
        }   
    
        else if (moneyOut <= balance && accountType .equalsIgnoreCase("saving")){
        accounts.get(1).balance -= moneyOut;
        return;
       
        }

        else if(false){
            throw new Exception("insuffient funds in account.");
        
        }
        else if (moneyOut <= balance && accountType.equalsIgnoreCase("investment")){
        accounts.get(2).balance -= moneyOut;
        return;
     
        }

        else{
         throw new Exception("insuffient funds in account.");
        
    }   
    }
    
    public void makeNewAccount(String accountType,double openingBalance) throws Exception
    {
        if ("Chequing Account".equals(accountType) && openingBalance >= 50 ){
            accounts.add(new ChequingAcct (openingBalance,"chequing"));
            }
        else if(false){
                 throw new Exception ("Sorry cant create an account");
                }
                  
        else if ("Saving Account".equals(accountType) && openingBalance >= 100 ){
            accounts.add(new SavingAcct (openingBalance,"saving"));
  
        }
        else if(false){
            throw new Exception("Sorry cant create an account");
                }  
         
        else if ("Investment ".equals(accountType) && openingBalance >= 3000){
            accounts.add(new InvestmentAcct (openingBalance,"Investment"));
        }
        else{
          throw new Exception("Sorry cant create an account");
         }
    }
        
    
    
    public void closeAccount( String accountType) throws Exception{
        for (BankAccounts acct :accounts) {
            if (acct.getAccountType().equals(accountType)){
                accounts.remove(acct);
                return;
  
            }  
        }
      throw new Exception("cant find accountType");
      
    }
    
    public void TransferFunds(String accountType1, double x, String accountType ) throws Exception {
    if (x <= this.balance ) {
        withdraw(x,accountType);
        deposit(x,accountType);
        
    } else { //does not need to be else if, because if not <=, it MUST be >.
        throw new Exception("\nSwitching bank accounts  failed, insuffient fund in account!");
        
    }
}

    @Override
    public String toString() {
        return super.toString()+ "\n Customer{" + "\n custId=" + custId + ", \nbalance=" + balance + ", \n accounts=" + accounts.toString();
    }
    
    public String toFile( ) {
        
        double inv =0;
        double chq =0;
        double sav =0;
        
        for(BankAccounts account: accounts){
            if(account.getAccountType().equalsIgnoreCase("Chequing Account")){
                chq = account.getBalance();
            }
            if(account.getAccountType().equalsIgnoreCase("Savings Account")){
                sav = account.getBalance();
            }
            if(account.getAccountType().equalsIgnoreCase("Investment Account")){
                inv = account.getBalance();
            }
        }
        
       return  firstName + "," + lastName+ "," + middleName /*...*/ + chq + "," + inv + "," + sav + "\n";
    }
}

    

    
    
        
    
    
    

