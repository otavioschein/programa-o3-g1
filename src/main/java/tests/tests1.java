package tests;

import manager.CustomerManager;
import manager.EmployeeManager;
import manager.CustomerServiceManager;

import java.util.Date;
import java.text.ParseException;

import entities.Address;
import entities.Customer;
import entities.Employee;
import enums.Status;

public class tests1 {

    public static void main(String[] args) throws ParseException {
    	
    	Date date = new Date(01/03/2000);

    	Employee employee = new Employee("11", "joel", "11", "joel@");
    	
    	Address address = new Address("Taq", 99, "Taq", "RS");
    	
    	Customer customer1 = new Customer("22", "schein", "22", "schein@", date, "m", "c", Status.ACTIVE, address);
    	
    	Customer customer2 = new Customer("33", "otavio", "33", "otavio@", date, "m", "c", Status.ACTIVE, address);
    	
    	EmployeeManager.employeeList.add(employee);
    	CustomerManager.customerList.add(customer1);
    	CustomerManager.customerList.add(customer2);
    	
        System.out.println("--------- TEST ----------\n");
        
        EmployeeManager.consult();
        
        CustomerManager.consult();
        
        CustomerServiceManager.insert();
        CustomerServiceManager.consult();
        CustomerServiceManager.edit();
        CustomerServiceManager.consult();

    }
    
}