/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankofhellengui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Hellen Harry
 */
public class Teller {
    public ArrayList<Customer> customer = new ArrayList<Customer> ();
    public ArrayList<Customer>searchList = new ArrayList<>();

    public Teller() {

    }
    
    //method to add a new Customer to the an account 
    public void addNewCustomer(String lastName,String firstName,String middleName,String Street,
        String city,String province,String postalCode,long phoneNumber,String dateOfBirth,String email,
        Gender gender,double Chequing,double Investment, double Saving){
        customer.add(new Customer(customer.size(),lastName,firstName,middleName,Street,city,province,postalCode,phoneNumber,
                 dateOfBirth,email,gender,Chequing,Investment,Saving));
        
           
    }
    public void writeCustomers( ){
        try {
            PrintWriter pw = new PrintWriter("indo.txt");

            for(Customer cust:customer){
             pw.println(cust.toFile());   
            }
   
            pw.close();
          } catch (IOException e) {
          }
        }
    
    public void readCustomer() throws FileNotFoundException{
        
            Scanner sc = new Scanner(new File("indo.txt"));
            sc.useDelimiter(System.lineSeparator());
           
            while (sc.hasNext()){
                String[] data = sc.nextLine().split(",");
                
                addNewCustomer(data[1],data[2],data[3],data[4],data[5],
                        data[6],data[7],Long.parseLong(data[8]),data[9],data[10],Gender.valueOf(data[11].toUpperCase()),
                        Double.parseDouble(data[12]),Double.parseDouble(data[13]),Double.parseDouble(data[14]));

            }
            
            sc.close();
                
            }
      
            
            
    public void openAccount(String firstName, String accountType,double x) throws Exception{
       for(Customer cust:customer){
           if (cust.getFirstName().equalsIgnoreCase(firstName)){
               cust.makeNewAccount(accountType, x);
               return;
               
            }
           
       }
        throw new Exception ("\n sorry cant open an account you may have already created one"
                + "already ");         
            
              
        
    }
    public void editCustomer(String firstName,String Street,String city,String province,
            String postalCode,String email,int phoneNumber) throws Exception{
      for (Customer cust :customer) {
            if (cust.getFirstName().equalsIgnoreCase(firstName)){
                cust.setStreet(Street);
                cust.setCity(city);
                cust.setProvince(province);
                cust.setPostalCode(postalCode);
                cust.setEmail(email);
                cust.setPhoneNumber(phoneNumber);
                
                
            }
      }
            throw new Exception ("\n sorry can't change information please check it again");
        
    }
    //method to transfer funds into customers accounts
   public void transferFunds(String firstName, double x, String accountType1,String accountType2 ) throws Exception{
      for(Customer cust : customer){
          if (cust.getFirstName().equalsIgnoreCase(firstName)){
              cust.TransferFunds(accountType1, x, accountType2);
              return;
              
          }
         
          } 
         
    //does not need to be else if, because if not <=, it MUST be >.
        throw new Exception("\nSwitching bank accounts  failed, not enough balance!");
       
    }
   //method to close account for customers
    public void closeAccount(String firstName,String accountType) throws Exception{
       for(Customer cust : customer){
           if (cust.getFirstName().equalsIgnoreCase(firstName)){
               cust.closeAccount(accountType);
               return;
       }
          
    }
       throw new Exception("\nbank accounts couldn't be closed!Please check to"
               + " make sure you have enter the right custId.");
    }
    //method to let customer or teller despoit into account
    public void despoit(String firstName, double amount,String accountType) throws Exception{
        for(Customer cust : customer){
            if (cust.getFirstName().equalsIgnoreCase(firstName)){
                cust.deposit(amount, accountType);
                return;
            }
            
    }
       throw new Exception("\n Amount couldn't be despoit!Please check to"
               + " make sure you have enter the right custId and account type");
    }
       
    //method to let customer or teller to  withdraw from account    
    public void withdrawal (String firstName,double amount, String accountType) throws Exception{
      for(Customer cust : customer){
           if (cust.getFirstName().equalsIgnoreCase(firstName)){
           cust.withdraw(amount, accountType);
              return;
          }
         
    }
       throw new Exception("\n Amount couldn't be withdrawal!Please check to"
               + " make sure you have enter the right custId and account type"
               + "or account may not have funds");
    }
    //method to get the balance in an account
    public void balance(String firstName,String accountType) throws Exception{
         for(Customer cust : customer){
             if (cust.getFirstName().equalsIgnoreCase(firstName)){
                 cust.getBalance(accountType);
                 return;
             }
             throw new Exception ("\n Your balance is "+ cust.getBalance(accountType));
         }
        
        
    }
    public void searchInList(String searchString){
        System.out.println(searchString);
        System.out.println(customer.size());
        for (int i = 0; i < customer.size(); i++) {
            System.out.println(customer.get(i).getFirstName());
            if (customer.get(i).getFirstName().equalsIgnoreCase(searchString)){
                //System.out.println(customer.get(i).getFirstName());
                searchList.add(customer.get(i));

                
            }
        }
  
    }
    

   
    

 
}
