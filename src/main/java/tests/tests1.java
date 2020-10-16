package tests;

import manager.CustomerManager;
import manager.EmployeeManager;
import manager.CustomerServiceManager;
import java.text.ParseException;


public class tests1 {

    public static void main(String[] args) throws ParseException {

        System.out.println("--------- TEST ----------\n");
        EmployeeManager.insert();
        EmployeeManager.consult();
        
        CustomerManager.insert();
        CustomerManager.consult();
        CustomerManager.insert();
        CustomerManager.consult();
        
        CustomerServiceManager.insert();
        CustomerServiceManager.consult();
        CustomerServiceManager.edit();
        CustomerServiceManager.consult();

    }
    
}