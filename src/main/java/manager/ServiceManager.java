package manager;

import entities.Service;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceManager {

    static ArrayList<Service> serviceList = new ArrayList<Service>();
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

    public static void edit(Service service){
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
    
    
    
}
