package bankingfinalassignmentapp;


public class SavingsAccount extends Account
{
    
    double interestRate; 
    
    public SavingsAccount()
    {
        this(0, 0, 0);
    }
    //constructor
    public SavingsAccount(int ac, double b, double i)
    {
        super(ac, b);
        interestRate  = i;
    }     
    
    //get and set
    public void setAccountNumber(int a)
    {
        super.setAccountNumber(a);
    }
    public void setInterestRate(double i)
    {
        interestRate = i;
    }
    
    public double getInterestRate()
    {
        return interestRate;
    }
    
    public void addMonthlyInterest()
    {
        double balance = super.getBalance();
        
        super.updateBalance(balance *(interestRate/100));
    }
    
    @Override
    public String toString()
    {
        return "Savings Account\n" + super.toString() + "\nInterest Rate: " + interestRate + "%";
    }
}
