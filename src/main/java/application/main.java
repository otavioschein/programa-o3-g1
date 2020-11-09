package application;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import entities.Address;
import entities.Customer;
import entities.Employee;
import entities.Service;
import enums.Status;
import manager.CustomerManager;
import manager.CustomerServiceManager;
import manager.EmployeeManager;
import manager.ServiceManager;

public class main {
	static int option = 1;
	static int action = 1;
	static Scanner reader = new Scanner(System.in);
	 
	public static void main(String[] args) throws ParseException{
    	
		while (option != 0) {
			System.out.println("----------------------------------------");
	        System.out.println("                  MENU");
	        System.out.println("----------------------------------------");
	        
			System.out.println("| 1 - Schedule service \n| 2 - Show schedule for specific date \n| 3 - Module Employee \n| 4 - Module Customer \n| 5 - Module Service \n| "
					+ "6 - Module Customer Service Schedule \n| 0 - Exit application");
			
			System.out.printf("--> ");
			option = reader.nextInt();
			
			clearBuffer(reader);
			
			switch (option) {
				case 1:
					CustomerServiceManager.insert();
					break;
					
				case 2:
					CustomerServiceManager.consultSchedule();
					break;
					
				case 3:
					EmployeeManager.menuManager();
					break;
					
				case 4:
					CustomerManager.menuManager();
					break;
					
				case 5:
					ServiceManager.menuManager();
					break;
					
				case 6:
					CustomerServiceManager.menuManager();
					break;
					
				case 0:
					System.out.println("You have closed the application");
					break;
			    	
			} 
		
			
		}
	}
	
	private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
	 
}
