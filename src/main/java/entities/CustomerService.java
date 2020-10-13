package entities;
import java.util.Date;

import enums.CustomerServiceStatus;

public class CustomerService {
	
	private Date dateOfService;
	private Customer customer;
	private Employee employee;
	private CustomerServiceStatus status;
	private String description;
	
	public CustomerService(Date dateOfService, Customer customer, Employee employee, CustomerServiceStatus status,
			String description) {
		
		this.dateOfService = dateOfService;
		this.customer = customer;
		this.employee = employee;
		this.status = status;
		this.description = description;
	}
	
	public CustomerService() {
		
	}

	public Date getDateOfService() {
		return dateOfService;
	}

	public void setDateOfService(Date dateOfService) {
		this.dateOfService = dateOfService;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public CustomerServiceStatus getStatus() {
		return status;
	}

	public void setStatus(CustomerServiceStatus status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
