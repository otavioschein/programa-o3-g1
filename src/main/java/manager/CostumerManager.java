package manager;

import entities.Customer;
import entities.Address;
import enums.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CostumerManager {

    static ArrayList<Customer> customerList = new ArrayList<Customer>();
    static String customerName;
    static String customerCPF;
    static String customerPhoneNumber;
    static String customerEmail;
    static Date customerBirthday;
    static String customerBirthdayString;
    static String customerGender;
    static String customerMaritalStatus;
    static Status customerStatus;
    static Address customerAddress;
    static String addressStreet;
    static int addressNumber;
    static String addressCity;
    static String addressState;
    static int optionStatus;
    
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    static Scanner reader = new Scanner(System.in);

    public static void insert() throws ParseException {
    	Customer customer = new Customer();

        System.out.println("Type the customer name: ");
        customerName = reader.nextLine();
        
        System.out.println("Type the customer CPF: ");
        customerCPF = reader.nextLine();
        
        System.out.println("Type the customer phone number: ");
        customerPhoneNumber = reader.nextLine();
        
        System.out.println("Type the customer birthday: ");
        customerBirthdayString = reader.nextLine();
        
        customerBirthday = sdf.parse(customerBirthdayString);
        
        System.out.println("Type the customer email: ");
        customerEmail = reader.nextLine();
        
        System.out.println("Type the customer gender: ");
        customerGender = reader.nextLine();
        
        System.out.println("Type the customer marital status: ");
        customerMaritalStatus = reader.nextLine();
        	
        do {
        	System.out.println("Define the customer status:  1 - ACTIVE | 2 - INACTIVE ");
            if (optionStatus == 1) {
            	customer.setStatus(Status.ACTIVE);
            } else if (optionStatus == 2){
            	customer.setStatus(Status.INACTIVE);
            }
        } while (optionStatus > 2 || optionStatus < 1);
        
        
        System.out.println("Type the customer address: ");
        
        System.out.println("Street: ");
        addressStreet = reader.nextLine();
        
        System.out.println("Number: ");
        addressNumber = reader.nextInt();
        
        System.out.println("City: ");
        addressCity = reader.nextLine();
        
        System.out.println("State: ");
        addressState = reader.nextLine();
        
        Address customerAddress = new Address(addressStreet, addressNumber, addressCity, addressState);
        

        customer.setName(customerName);
        customer.setCpf(customerCPF);
        customer.setPhoneNumber(customerPhoneNumber);
        customer.setGender(customerGender);
        customer.setMaritalStatus(customerMaritalStatus);
        customer.setEmail(customerEmail);
        customer.setBirthday(customerBirthday);
        customer.setAddress(customerAddress);

        customerList.add(customer);

        clearBuffer(reader);
    }
    
    public static void consult() {
        for (int i = 0; i < customerList.size(); i++) {
            System.out.println("\nName: " + customerList.get(i).getName());
            System.out.println("\nCPF: " + customerList.get(i).getCpf());
            System.out.println("\nPhone Number: " + customerList.get(i).getPhoneNumber());
            System.out.println("\nEmail: " + customerList.get(i).getEmail());
            System.out.println("\nBirthday: " + customerList.get(i).getBirthday());
            System.out.println("\nGender: " + customerList.get(i).getGender());
            System.out.println("\nMarital Status: " + customerList.get(i).getMaritalStatus());
            System.out.println("\nStatus: " + customerList.get(i).getStatus());
            System.out.println("\nAddress: " + customerList.get(i).getAddress());
            System.out.println("\n -------------------------------------");

        }
    }
    
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
