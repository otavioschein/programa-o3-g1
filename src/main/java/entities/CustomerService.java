package entities;
import java.util.Date;

import enums.CustomerServiceStatus;

public class CustomerService {
	
	private Date dateOfService;
	private Date hourOfService;
	private Customer customer;
	private Employee employee;
	private CustomerServiceStatus status;
	private Service description;
	
	public CustomerService(Date dateOfService, Date hourOfService, Customer customer, Employee employee, CustomerServiceStatus status,
			Service description) {
		
		this.dateOfService = dateOfService;
		this.hourOfService = hourOfService;
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

	public Date getHourOfService() {
		return hourOfService;
	}

	public void setHourOfService(Date hourOfService) {
		this.hourOfService = hourOfService;
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

	public Service getDescription() {
		return description;
	}

	public void setDescription(Service description) {
		this.description = description;
	}
	
}
