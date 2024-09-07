package bankingfinalassignmentapp;


public class Account
{
    
    private int accountNumber;
    private double balance;
    
    public Account(int an, double b)
    {
        //accountOwner = owner;
        accountNumber = an;
        balance = b;
    }
    
    //getters and setters
    
    public void setAccountNumber(int an)
    {
        accountNumber = an;
    }
    
    public void setBalance(double b)
    {
        balance = b;
    }

    
    public void updateBalance(double amount) 
    {
        balance += amount;
    }
    

    public int getAccountNumber()
    {
        return accountNumber;
    }
    
    public double getBalance()
    {
        return balance;
    }
    
    @Override
    public String toString()
    {
        return "Account #: " + accountNumber + "\nBalance: $" + Math.round(balance * 100)/100;
    }
    
    
    
}
