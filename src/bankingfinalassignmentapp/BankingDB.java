
package bankingfinalassignmentapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BankingDB 
{
    public static SavingsAccount createSavingsAccountObject()
    {
        SavingsAccount object = new SavingsAccount();
        return object;
    }
    private static Connection getConnection() throws SQLException 
    
    {
        String dbUrl = "jdbc:sqlite:bankingactualdb.sqlite";
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }
    
    public List<Customer> getAll()
    {
        String sql = "SELECT FirstName, LastName, Address, Phone, CustomerID, "
                + "AccountNumber FROM Customer ORDER BY CustomerID ASC";
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql);
                ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
                    {
                        String firstName = rs.getString("FirstName");
                        String lastName = rs.getString("LastName");
                        String address = rs.getString("Address");
                        String phone = rs.getString("Phone");
                        int customerID = rs.getInt("CustomerID");
                        int accountNumber = rs.getInt("AccountNumber");
                        
                        Customer c = new Customer(firstName, lastName, address, 
                                phone, customerID, accountNumber);
                        customers.add(c);
                    }
                    return customers;
        }
        catch (SQLException e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public static Customer get(String firstName, String lastName)
    {
        String sql = "SELECT * FROM Customer WHERE FirstName = ? AND LastName = ?";
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                String address = rs.getString("Address");
                String phone = rs.getString("Phone");
                int customerID = rs.getInt("CustomerID");
                int accountNumber = rs.getInt("AccountNumber");
                Customer c = new Customer(firstName, lastName, address, 
                                phone, customerID, accountNumber);
                rs.close();
                return c;
            }
            else 
            {
                rs.close();
                return null;
            }
        }
        catch (SQLException e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public static SavingsAccount getSavingsAccount(int ac)
    {
        String sql = "SELECT * FROM SavingsAccount WHERE AccountNumber = ?";
        try (Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1, ac);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            {
                int an = rs.getInt("AccountNumber");
                double bal = rs.getFloat("Balance");
                double ir = rs.getFloat("InterestRate");
                
                SavingsAccount sa = new SavingsAccount(an, bal, ir);
                rs.close();
                return sa;
            }
            else 
            {
                rs.close();
                return null;
            }
        }
        catch (SQLException e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public static boolean add(Customer c)
    {
        String sql = "INSERT INTO Customer (FirstName, LastName, Address, Phone"
                + ", CustomerID, AccountNumber) VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1, c.getFirstName());
            ps.setString(2, c.getLastName());
            ps.setString(3, c.getAddress());
            ps.setString(4, c.getPhone());
            //ps.setInt(5, c.getCustomerID());
            ps.setInt(6, c.getAccountNumber());
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            System.err.println(e);
            return false;
        }
        
    }
    //method to add savings account with new customer
    public static boolean openAccount(SavingsAccount sa)
    {
        String sql = "INSERT INTO SavingsAccount (AccountNumber, Balance, "
                + "InterestRate) VALUES (?, ?, ?)";
        try(Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql))
        {
            
            ps.setDouble(2, sa.getBalance());
            ps.setDouble(3, sa.getInterestRate());
            
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }
    
    public static boolean delete(Customer c)
    {
        String sql = "DELETE FROM Customer "
                + "WHERE CustomerID = ?";
        try(Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1, c.getCustomerID());
            ps.executeUpdate();
            return true;
        }
        catch (SQLException e)
        {
            System.err.println(e);
            return false;
        }
    }
    
    /*public static boolean update(Customer C)
    {
        String sql = "UPDATE Customer SET "
                + " FirstName = ?, "
                + " LastName = ?, "
                + " Address = ?, "
                + " Phone = ?, "
                + "WHERE CustomerID = ?";
        try(Connection connection = getConnection();
                PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1, c.getFirstName());
        }
    }*/
}
