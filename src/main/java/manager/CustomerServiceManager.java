package manager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

import entities.CustomerService;
import enums.CustomerServiceStatus;

public class CustomerServiceManager {
	
    static ArrayList<CustomerService> customerServiceList = new ArrayList<CustomerService>();
    
    static Scanner reader = new Scanner(System.in);
    static int optionStatus;
    static String customerServiceDate;
    static Date customerServiceDateFormatted;
    static Date customerServiceDateFormattedToRemove;
    static Date customerServiceDateFormattedToEdit;
    static Date customerServiceHourFormattedToEdit;
    static Date customerServiceHourFormattedToRemove;
    static String serviceDescription;
    static String customerServiceCpf;
    static String employeeServiceCpf;
    
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    static SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm"); 

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public static void insert() throws ParseException {
        clearBuffer(reader);
        CustomerService customerService = new CustomerService();

        readAndSetCustomerServiceDate(customerService);
        
        readAndSetCustomerServiceHour(customerService);
        
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
            System.out.println("\nHour: " + customerServiceList.get(i).getHourOfService());
            System.out.println("Customer: " + customerServiceList.get(i).getCustomer().getName());
            System.out.println("Employee: " + customerServiceList.get(i).getEmployee().getName());
            System.out.println("Status: " + customerServiceList.get(i).getStatus());
            System.out.println("Description: " + customerServiceList.get(i).getDescription());
        }
    }
    
    public static void remove() throws ParseException {
    	System.out.println("Remove a customer service: ");
		clearBuffer(reader);
        System.out.println("\n	Type the customer service date: ");
        String costumerServiceDateToRemove = reader.nextLine();
        customerServiceDateFormattedToRemove = sdf.parse(costumerServiceDateToRemove);
       
        System.out.println("\n	Type the customer service hour: ");
        String costumerServiceHourToRemove = reader.nextLine();
        customerServiceHourFormattedToRemove = sdf2.parse(costumerServiceHourToRemove);
        
        removeCustomerService(customerServiceDateFormattedToRemove, customerServiceHourFormattedToRemove);
        
    }
    
    public static void edit() throws ParseException{
        System.out.println("Type the customer service date to edit it: ");
        String serviceDateToEdit = reader.nextLine();
        customerServiceDateFormattedToEdit = sdf.parse(serviceDateToEdit);
        
        System.out.println("\nType the customer service hour to edit it: ");
        String serviceHourToEdit = reader.nextLine();
        customerServiceHourFormattedToEdit = sdf2.parse(serviceHourToEdit);

        for (int i = 0; i < customerServiceList.size(); i++) {
        	if (customerServiceList.get(i).getDateOfService().equals(customerServiceDateFormattedToEdit) && 
        			customerServiceList.get(i).getHourOfService().equals(customerServiceHourFormattedToEdit)) {
            			menuEdit(customerServiceList.get(i));
            }
        }
    }
    
    private static void removeCustomerService(Date serviceDateToRemove, Date serviceHourToRemove) throws ParseException {
    	boolean validate = false;
    	for (int i = 0; i < customerServiceList.size(); i++) {
            if (customerServiceList.get(i).getDateOfService().equals(serviceDateToRemove) &&
            		customerServiceList.get(i).getHourOfService().equals(serviceHourToRemove)) {
            			customerServiceList.remove(i);
            			validate = true;
            }
        }
    	
    	if (validate == false) {
    		System.out.println("Customer service at this time does not exist! Try again.");
    		remove();
    	}
    }
    
    protected static void readAndSetCustomerServiceDate(CustomerService customerService) throws ParseException{

	    System.out.println("Type the service date: ");
	    customerServiceDate = reader.nextLine();	
	    customerServiceDateFormatted = sdf.parse(customerServiceDate);
	    	   
	    customerService.setDateOfService(customerServiceDateFormatted);
	    
	}
    
    protected static void readAndSetCustomerServiceHour(CustomerService customerService) throws ParseException{

    	boolean state;
	    System.out.println("Type the service hour: ");
	    customerServiceDate = reader.nextLine();	
	    customerServiceDateFormatted = sdf2.parse(customerServiceDate);
	    do {
	    	if (customerServiceList.contains(customerServiceDateFormatted)) {
	    		System.out.println("Retype the service hour as the previous one already exists: ");
	    	    customerServiceDate = reader.nextLine();	
	    	    customerServiceDateFormatted = sdf2.parse(customerServiceDate);
		    } else {
		    	state = true;
		    }
	    } while (state = false);
	   
	    customerService.setHourOfService(customerServiceDateFormatted);
	    
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
        clearBuffer(reader);
	    System.out.println("Type the customer Cpf to the service: ");
	    customerServiceCpf = reader.nextLine();	
	    boolean verification = false;
	    int i;
	    for (i = 0; i < CustomerManager.customerList.size(); i++) {
            if (CustomerManager.customerList.get(i).getCpf().equals(customerServiceCpf)) {
            	customerService.setCustomer(CustomerManager.customerList.get(i));
            	verification = true;
            }
        }
	    
	    if (verification == false) {
	    	CustomerManager.insert();
	    	customerService.setCustomer(CustomerManager.customerList.get(i++));
	    	CustomerManager.consult();
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

    private static void menuEdit(CustomerService customerService) throws ParseException {
		 int option = 1;
		 int action = 1;

		 while (option == 1) {
				System.out.println("Choose the option: 1 - Edit date | 2 - Edit hour | 3 - Edit description | 4 - Edit Status | 5 - Edit customer name | "
						+ "6 - Edit customer service employee");
				
				action = reader.nextInt();
				
				clearBuffer(reader);
				
				switch (action) {
					case 1:
						readAndSetCustomerServiceDate(customerService);
						break;
						
					case 2:
						readAndSetCustomerServiceHour(customerService);
						break;
						
					case 3:
						readAndSetCustomerServiceDescription(customerService);
						break;
						
					case 4:
						readAndSetCustomerServiceStatus(customerService);
						break;
						
					case 5:
						readAndSetCustomerServiceCustomerName(customerService);
						break;
						
					case 6:
						readAndSetCustomerServiceEmployee(customerService);
						break;
				    	
				}
				
				System.out.println("Do you want to leave from the edit mode? 1 - NO  2 - YES ");
				option = reader.nextInt();
				
			}
	 }
}
