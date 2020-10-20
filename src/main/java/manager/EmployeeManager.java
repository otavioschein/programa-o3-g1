package manager;

import entities.Employee;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {

    public static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    static String employeeCpf;
    static String employeeName;
    static String employeeEmail;
    static String employeePhoneNumber;

    static Scanner reader = new Scanner(System.in);

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }

    public static void insert() throws ParseException {
        clearBuffer(reader);
        Employee employee = new Employee();

        readAndSetEmployeeName(employee);

        readAndSetEmployeeCPF(employee);

        readAndSetEmployeePhoneNumber(employee);

        readAndSetEmail(employee);

        employeeList.add(employee);

    }

    public static void consult() {
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println("\nName: " + employeeList.get(i).getName());
            System.out.println("CPF: " + employeeList.get(i).getCpf());
            System.out.println("Phone Number: " + employeeList.get(i).getPhoneNumber());
            System.out.println("Email: " + employeeList.get(i).getEmail());
        }
    }

    public static void remove() {
        clearBuffer(reader);
        System.out.println("Type the customer CPF to remove it: ");
        String cpfEmployeeToRemove = reader.nextLine();

        removeCustomer(cpfEmployeeToRemove);

    }

    public static void edit() throws ParseException {
        clearBuffer(reader);
        System.out.println("Type the customer CPF to edit it: ");
        String customerToEdit = reader.nextLine();

        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCpf().equals(customerToEdit) ) {
                menuEdit(employeeList.get(i));
            }
        }
    }

    protected static void readAndSetEmployeeName(Employee employee) {
        System.out.println("Type the employee name: ");
        employeeName = reader.nextLine();
        employee.setName(employeeName);
    }

    protected static void readAndSetEmployeeCPF(Employee employee){
        System.out.println("Type the employee CPF: ");
        employeeCpf = reader.nextLine();
        employee.setCpf(employeeCpf);
    }

    protected static void readAndSetEmployeePhoneNumber(Employee employee){
        System.out.println("Type the employee phone number: ");
        employeePhoneNumber = reader.nextLine();
        employee.setPhoneNumber(employeePhoneNumber);
    }

    protected static void readAndSetEmail(Employee employee){
        System.out.println("Type the employee email: ");
        employeeEmail = reader.nextLine();
        employee.setEmail(employeeEmail);
    }

    private static void removeCustomer(String cpfToRemove) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getCpf().equals(cpfToRemove)) {
                employeeList.remove(i);
            }
        }
    }

    private static void menuEdit(Employee employee) throws ParseException {
        int option = 1;
        int action = 1;

        while (option == 1) {
            System.out.println("Choose the option: 1 - Edit name | 2 - Edit CPF | 3 - Edit Phone Number | 4 - Edit email");

            action = reader.nextInt();

            clearBuffer(reader);

            switch (action) {
                case 1:
                    readAndSetEmployeeName(employee);
                    break;

                case 2:
                    readAndSetEmployeeCPF(employee);
                    break;

                case 3:
                    readAndSetEmployeePhoneNumber(employee);
                    break;

                case 4:
                    readAndSetEmail(employee);
                    break;

            }

            System.out.println("Do you want to leave from the edit mode? 1 - NO  2 - YES ");
            option = reader.nextInt();

        }
    }
        public static void menuManager() throws ParseException {
            int option = 1;
            int action = 1;

            while (option == 1) {
                System.out.println("Choose the option: 1 - Add employee | 2 - Consult employees | 3 - Remove employee | 4 - Edit employee");

                action = reader.nextInt();

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

                System.out.println("Do you want to leave from the Employee mode? 1 - NO  2 - YES ");
                option = reader.nextInt();

        }
    }

}
