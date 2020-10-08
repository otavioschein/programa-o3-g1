package tests;

import manager.CustomerManager;
import manager.EmployeeManager;

import java.text.ParseException;


public class tests1 {

    public static void main(String[] args) throws ParseException {

        System.out.println("--------- TEST ----------\n");
        EmployeeManager.insert();
        EmployeeManager.insert();
        EmployeeManager.consult();
        EmployeeManager.edit();
        EmployeeManager.remove();
        EmployeeManager.consult();

    }
    
}