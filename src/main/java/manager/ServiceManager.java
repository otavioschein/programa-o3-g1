package manager;

import entities.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class ServiceManager {

    public static ArrayList<Service> serviceList = new ArrayList<Service>();
    static String serviceName;
    static Scanner reader = new Scanner(System.in);

    public static void insert() {
        Service service = new Service();

        readAndSetServiceName(service);
        
        serviceList.add(service);

        clearBuffer(reader);
    }

    public static void consult() {
        for (int i = 0; i < serviceList.size(); i++) {
            System.out.println("\nService: " + serviceList.get(i).getName());
        }
    }

    public static void remove() {
        System.out.println("Type the service name to remove it: ");
        String serviceNameToRemove = reader.nextLine();

        removeService(serviceNameToRemove);
    }

    public static void edit(){
        System.out.println("Type the service name to edit it: ");
        String serviceNameToEdit = reader.nextLine();
        
        editServiceName(serviceNameToEdit);
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
    private static void readAndSetServiceName(Service service) {
    	System.out.println("Type the service name: ");
        serviceName = reader.nextLine();

        service.setName(serviceName);
    }
    
    private static void editServiceName(String name) {
    	for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).getName().equals(name)) {

                System.out.println("New service name: ");
                String newServiceName = reader.nextLine();

                serviceList.get(i).setName(newServiceName);

            }
        }
    }
    
    private static void removeService(String nameToRemove) {
    	for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).getName().equals(nameToRemove)) {
                serviceList.remove(i);
            }
        }
    }
    
    public static void menuManager() throws ParseException {
        int option = 1;
        int action = 1;

        while (option == 1) {
            System.out.println("Choose the option: 1 - Add Service | 2 - Consult Service | 3 - Remove Service | 4 - Edit Service");

            action = reader.nextInt();

            clearBuffer(reader);

            switch (action) {
                case 1:
                    insert();
                    break;

                case 2:
                    consult();
                    break;

                case 3:
                    remove();
                    break;

                case 4:
                    edit();
                    break;

            }

            System.out.println("Do you want to leave from the Service mode? 1 - NO  2 - YES ");
            option = reader.nextInt();

    }
    
    }
    
    
}
