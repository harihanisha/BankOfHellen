/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankofhellengui;

/**
 *
 * @author Hellen Harry
 */
public class InvestmentAcct extends BankAccounts {
    


    InvestmentAcct(double Investment, String investment) {
       super(Investment,investment);
    }

    

    @Override
    //add the interest rate its set too
    public void addInterest() {
        this.balance*=1.08;
    }

    
    
}
