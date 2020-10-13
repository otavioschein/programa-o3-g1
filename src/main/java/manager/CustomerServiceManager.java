package manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

import entities.Customer;
import entities.CustomerService;
import entities.Employee;
import manager.CustomerManager;
import enums.CustomerServiceStatus;

public class CustomerServiceManager {
	
    static ArrayList<CustomerService> customerServiceList = new ArrayList<CustomerService>();
    
    static Scanner reader = new Scanner(System.in);
    static int optionStatus;
    static String customerServiceDate;
    static Date customerServiceDateFormatted;
    static String serviceDescription;
    static String customerServiceCpf;
    static String employeeServiceCpf;
    
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public static void insert() throws ParseException {
        clearBuffer(reader);
        CustomerService customerService = new CustomerService();

        readAndSetCustomerServiceDate(customerService);
        
        readAndSetCustomerServiceDescription(customerService);
        
    	readAndSetCustomerServiceStatus(customerService);

    	readAndSetCustomerServiceCustomerName(customerService);

    	readAndSetCustomerServiceEmployee(customerService);


        customerServiceList.add(customerService);

        clearBuffer(reader);
    }
    
    public static void consult() {
        for (int i = 0; i < customerServiceList.size(); i++) {
            System.out.println("\nDate: " + customerServiceList.get(i).getDateOfService());
            System.out.println("Customer: " + customerServiceList.get(i).getCustomer().getName());
            System.out.println("Employee: " + customerServiceList.get(i).getEmployee().getName());
            System.out.println("Status: " + customerServiceList.get(i).getStatus());
            System.out.println("Description: " + customerServiceList.get(i).getDescription());
        }
    }
    
    protected static void readAndSetCustomerServiceDate(CustomerService customerService) throws ParseException{
	    System.out.println("Type the service date: ");
	    customerServiceDate = reader.nextLine();	
	    customerServiceDateFormatted = sdf.parse(customerServiceDate);
	    customerService.setDateOfService(customerServiceDateFormatted);
	}
    
    protected static void readAndSetCustomerServiceDescription(CustomerService customerService){
	    System.out.println("Type the service description: ");
	    serviceDescription = reader.nextLine();	
	
	    customerService.setDescription(serviceDescription);
	}
    
    protected static void readAndSetCustomerServiceStatus(CustomerService customerService){
		do {
	    	System.out.println("Define the Customer Service status:  1 - SCHEDULED | 2 - FINISHED | 3 - CANCELED ");
	    	optionStatus = reader.nextInt();
	        if (optionStatus == 1) {
	        	customerService.setStatus(CustomerServiceStatus.SCHEDULED);
	        } else if (optionStatus == 2){
	        	customerService.setStatus(CustomerServiceStatus.FINISHED);
	        } else if (optionStatus == 3){
	        	customerService.setStatus(CustomerServiceStatus.CANCELED);
	        }
	        	
	    } while (optionStatus > 3 || optionStatus < 1);
	}
    
    protected static void readAndSetCustomerServiceCustomerName(CustomerService customerService) throws ParseException{
	    System.out.println("Type the customer service Cpf: ");
	    customerServiceCpf = reader.nextLine();	
	    
	    for (int i = 0; i < CustomerManager.customerList.size(); i++) {
            if (CustomerManager.customerList.get(i).getCpf().equals(customerServiceCpf)) {
            	customerService.setCustomer(CustomerManager.customerList.get(i));
            } else {
            	CustomerManager.insert();
            }
        }
	}
    
    protected static void readAndSetCustomerServiceEmployee(CustomerService customerService) throws ParseException{
    	System.out.println("Type the employee service Cpf: ");
	    employeeServiceCpf = reader.nextLine();	
	    
	    for (int i = 0; i < EmployeeManager.employeeList.size(); i++) {
            if (EmployeeManager.employeeList.get(i).getCpf().equals(employeeServiceCpf)) {
            	customerService.setEmployee(EmployeeManager.employeeList.get(i));
            } else {
            	EmployeeManager.insert();
            }
        }
	}

}
