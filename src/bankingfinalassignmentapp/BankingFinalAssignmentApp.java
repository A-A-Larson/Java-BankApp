package bankingfinalassignmentapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class BankingFinalAssignmentApp extends JFrame
{
/*create JtextField variables
	-First name, Last name, address, phone, account number, withdraw/deposit	
        -non editable = interest month, calculated interest, balance
        */
    
    private JTextField firstName;
    private JTextField lastName;
    private JTextField address;
    private JTextField phone;
    private JTextField accountNumber;
    private JTextField balance;
    private JTextField withdrawDeposit;
    private JTextField interestMonth;
    private JTextField calculatedInterest;
    private JTextField interestRate;
    private JLabel interestLabel;
   
    
    
    
    public BankingFinalAssignmentApp() 
            //setLookAndFeel to current OS
    {
        try 
        {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) 
        {
            System.out.println(e);
        }
        initComponents();
    }
    
    private void initComponents() 
    {
       /*Set title, make program end when window is closed, make OS decide 
       location of the frame*/
        
        setTitle("Banking Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        
        // components go here
        
        //constructors for fields
        firstName = new JTextField();
        lastName = new JTextField();
        address = new JTextField();
        phone = new JTextField();
        accountNumber = new JTextField();
        balance = new JTextField();
        withdrawDeposit = new JTextField();
        interestMonth = new JTextField(4);
        calculatedInterest = new JTextField(10);
        interestRate = new JTextField();
        //interestRate.setVisible(true);
        interestLabel = new JLabel ("Interest Rate");
        //interestLabel.setVisible(true);
        
        //make some fields not editable
        balance.setEditable(false);
        
        //set preferred and minimum size of text fields or components
        Dimension dim = new Dimension(120, 20);
        firstName.setPreferredSize(dim); 
        lastName.setPreferredSize(dim); 
        address.setPreferredSize(dim); 
        phone.setPreferredSize(dim); 
        accountNumber.setPreferredSize(dim); 
        balance.setPreferredSize(dim); 
        withdrawDeposit.setPreferredSize(dim); 
        interestMonth.setPreferredSize(dim);
        calculatedInterest.setPreferredSize(dim);
        interestRate.setPreferredSize(dim);
        firstName.setMinimumSize(dim); 
        lastName.setMinimumSize(dim); 
        address.setMinimumSize(dim); 
        phone.setMinimumSize(dim);
        accountNumber.setMinimumSize(dim); 
        balance.setMinimumSize(dim); 
        withdrawDeposit.setMinimumSize(dim); 
        interestMonth.setMinimumSize(dim);
        calculatedInterest.setMinimumSize(dim);
        interestRate.setMinimumSize(dim);
        
        /*Construct buttons: Search Customer, Previous Customer, Next Customer, 
        Add Customer, Update Customer, Open Account, Deposit, Withdraw, 
        Calculate Interest*/
        
        JButton searchButton = new JButton("Search Customer");
        searchButton.setMinimumSize(dim);
        searchButton.setPreferredSize(dim);
        JButton previousButton = new JButton("Previous Customer");
        previousButton.setMinimumSize(dim);
        previousButton.setPreferredSize(dim);
        JButton nextButton = new JButton("Next Customer");
        nextButton.setMinimumSize(dim);
        nextButton.setPreferredSize(dim);
        JButton addButton = new JButton("Add Customer");
        addButton.setMinimumSize(dim);
        addButton.setPreferredSize(dim);
        JButton updateButton = new JButton("Update Customer");
        updateButton.setMinimumSize(dim);
        updateButton.setPreferredSize(dim);
        JButton openAccountButton = new JButton("Open Account");
        openAccountButton.setMinimumSize(dim);
        openAccountButton.setPreferredSize(dim);
        JButton depositButton = new JButton("Deposit");
        depositButton.setMinimumSize(dim);
        depositButton.setPreferredSize(dim);
        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setMinimumSize(dim);
        withdrawButton.setPreferredSize(dim);
        JButton calculateButton = new JButton("Calculate Interest");
        
        
        //create action listeners for buttons
        searchButton.addActionListener(e -> searchButtonClicked());
        previousButton.addActionListener(e -> previousButtonClicked());
        nextButton.addActionListener(e -> nextButtonClicked());
        addButton.addActionListener(e -> addButtonClicked());
        updateButton.addActionListener(e -> updateButtonClicked());
        openAccountButton.addActionListener(e -> openAccountButtonClicked());
        depositButton.addActionListener(e -> depositButtonClicked());
        withdrawButton.addActionListener(e -> withdrawButtonClicked());
        calculateButton.addActionListener(e -> calculateButtonClicked());
        
        //main panel buttons 
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(searchButton, getConstraints(2, 0));
        panel.add(previousButton, getConstraints(2, 1));
        panel.add(nextButton, getConstraints(2, 2));
        panel.add(addButton, getConstraints(2, 3));
        panel.add(updateButton, getConstraints(2, 4));
        panel.add(openAccountButton, getConstraints(2, 5));
        panel.add(depositButton, getConstraints(2, 6));
        panel.add(withdrawButton, getConstraints(2, 7));
        panel.add(calculateButton, getConstraints(2, 8));
        
        /*main panel, create labels for fields: Customer First Name, 
        Customer Last Name, Address, Phone Number, Account Number, Balance, 
        Withdraw/Deposit, Interest Month, Calculate Interest */
        
        

        panel.add(new JLabel ("Customer First Name"), getConstraints(0, 0));
        panel.add(new JLabel("Customer Last Name"), getConstraints(0, 1));
        panel.add(new JLabel("Address"), getConstraints(0, 2));
        panel.add(new JLabel("Phone Number"), getConstraints(0, 3));
        panel.add(new JLabel ("Account Number"), getConstraints(0, 4));
        panel.add(new JLabel ("Balance"), getConstraints(0, 5));
        panel.add(new JLabel ("Withdraw/Deposit"), getConstraints(0, 6));
        
        panel.add(interestLabel, getConstraints(0, 7));
        
        
        
        
        panel.add(firstName, getConstraints(1, 0));
        panel.add(lastName, getConstraints(1, 1));
        panel.add(address, getConstraints(1, 2));
        panel.add(phone, getConstraints(1, 3));
        panel.add(accountNumber, getConstraints(1, 4));
        panel.add(balance, getConstraints(1, 5));
        panel.add(withdrawDeposit, getConstraints(1, 6));
        panel.add(interestRate, getConstraints(1, 7));
        
        /*
        hiddenPanel.setLayout(new GridBagLayout());
        hiddenPanel.add(interestRate, getConstraints(1, 0));
        hiddenPanel.add(new JLabel ("Interest Rate"), getConstraints(0, 0));
        hiddenPanel.setVisible(true);
        */
        
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridBagLayout());
        bottomPanel.add(new JLabel ("Interest Month"), getConstraints(0, 0));
        bottomPanel.add(interestMonth, getConstraints(1, 0));
        bottomPanel.add(new JLabel ("Calculate Interest"), getConstraints(2, 0));
        bottomPanel.add(calculatedInterest, getConstraints(3, 0));
        
        
        //place components in NORTH, WEST, SOUTH, EAST or CENTER 
        add(panel, BorderLayout.NORTH);
        //add(hiddenPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        
        //set size of frame and make frame visible
        pack();
        setVisible(true);
        
    }
    
    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(() -> 
        {
            JFrame frame = new BankingFinalAssignmentApp();
        }); 
        
        
    }
    
    private void searchButtonClicked() 
    {
        String fN = firstName.getText();
        String lN = lastName.getText();
        Customer c = BankingDB.get(fN, lN);
        address.setText(c.getAddress());
        phone.setText(c.getPhone());
        SavingsAccount sa = BankingDB.getSavingsAccount(c.getAccountNumber());
        String bal = NumberFormat.getCurrencyInstance().format(sa.getBalance());
                NumberFormat intRate = NumberFormat.getPercentInstance();
                intRate.setMaximumFractionDigits(1);
                String intR = intRate.format(sa.getInterestRate());
                balance.setText(bal);
                calculatedInterest.setText(intR);
        
    }
    
    private void previousButtonClicked() 
    {
        System.out.println("Previous button clicked!");
    }

    private void nextButtonClicked() 
    {
        System.out.println("Next button clicked!");
    }
    
    //conditional statement for creating a new account or using an existing one
    
    private void addButtonClicked() 
    {
        String fN = firstName.getText();
        String lN = lastName.getText();
        String aD = address.getText();
        String pH = phone.getText();
        int cID = 0;
        int aN = Integer.parseInt(accountNumber.getText());
        Customer c = new Customer(fN, lN, aD, pH, cID, aN);
        boolean success = BankingDB.add(c); 
        if (success) 
        {
            System.out.println("New account was added.\n"); 
        }
        else 
        {
            System.out.println("Error! Unable to add product.\n");
        }

    }

    private void updateButtonClicked() 
    {
        System.out.println("Update button clicked!");
    }

    private void openAccountButtonClicked() 
    {
        int aN = 0;
        double bal = 0.0;
        double iR = Double.parseDouble(interestRate.getText());
        SavingsAccount sa = new SavingsAccount(aN, bal, iR);
        boolean success = BankingDB.openAccount(sa);
        if (success) 
        {
            System.out.println("New account was added.\n"); 
        }
        else 
        {
            System.out.println("Error! Unable to add product.\n");
        }
    }

    private void depositButtonClicked() 
    {
        System.out.println("Deposit button clicked!");
    }

    private void withdrawButtonClicked() 
    {
        System.out.println("Withdraw button clicked!");
    }

    private void calculateButtonClicked() 
    {
        System.out.println("Calculate button clicked!");
    }

   // Helper method to return GridBagConstraints objects
    private GridBagConstraints getConstraints(int x, int y) 
    {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(8, 10, 8, 10);
        c.gridx = x;
        c.gridy = y;
        return c;
    }
    
}
