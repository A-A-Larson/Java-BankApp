package bankingfinalassignmentapp;


public class Customer 
{
 private String firstName;
 private String lastName;
 private String address;
 private String phone;
 private int customerID;
 private int accountNumber;
 
 public Customer()
 {
     this("", "", "", "", 0, 0);
 }

 public Customer(String fn, String ln, String ad, String ph, int cu, int an)
 {
     firstName = fn;
     lastName = ln; 
     address = ad;
     phone = ph;
     customerID = cu;
     accountNumber = an;
     
 }
 
 //getters and setters
 
 public String getFirstName()
 {
     return firstName;
 }
 
 public void setFirstName(String fn)
 {
     firstName = fn;
 }
 
 public String getLastName()
 {
     return lastName;
 }
 
 public void setLastName(String ln)
 {
     lastName = ln;
 }
 
 public String getAddress()
 {
     return address;
 }
 
 public void setAddress(String ad)
 {
     address = ad;
 }
 
 public String getPhone()
 {
     return phone;
 }
 
 public void setPhone(String ph)
 {
     phone = ph;
 }
 
 public int getCustomerID()
 {
     return customerID;
 }
 
 public void setCustomerID(int cu)
 {
     customerID = cu;
 }
 
public int getAccountNumber()
 {
     return accountNumber;
 }

public void setAccountNumber(int an)
{
    accountNumber = an;
}
 
 @Override
 public String toString()
 {
     return "Name: " + lastName + ", " + firstName + 
             "\nAddress: " + address + 
             "\nPhone: " + phone;
 }
 
 @Override
 public boolean equals(Object obj)
 {
     if (obj instanceof Customer)
     {
         Customer p = (Customer) obj;
         if(customerID == p.getCustomerID())
         {
             return true;
         }
     }
     return false;
 }
 
}
