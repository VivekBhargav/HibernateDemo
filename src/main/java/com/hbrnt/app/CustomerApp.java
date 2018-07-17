package com.hbrnt.app;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.hbrnt.dao.CustomerDAO;
import com.hbrnt.dao.ICustomerDAO;
import com.hbrnt.pojo.Address;
import com.hbrnt.pojo.Customer;

public class CustomerApp {
	static Scanner scan;
	ICustomerDAO customerDao;

	public CustomerApp() {
		customerDao = new CustomerDAO();
		scan = new Scanner(System.in);
	}

	public static void main(String[] args) throws Exception{
		
		CustomerApp cust = new CustomerApp();
		
		
		System.out.println("Choose your operation");
    	int option;
    	
    	do {
        	System.out.println("\n 1. Add \n 2. DELETE \n 3. UPDATE \n 4. Load Customer "
        			+ "\n 5. List Customers \n 6. Get Monthly Sales \n 7. Query Report \n 8. Exit");
        	option = scan.nextInt();
        	
        	switch(option) {
        	case 1:
        		cust.addCustomer(); break;
        		
        	case 2:
        		cust.deleteCustomer(); break;
        		
        	case 3:
        		cust.updateCustomer(); break;
        		
        	case 4:
        		cust.loadCustomer(); break;
        		
        	case 5:
        		
        		cust.getCustomers(); break;
        	
        	case 6:
        		cust.getMonthlySales(); break;
        		
        	case 7:
        		cust.getReport(); break;
        		
        		default:
        			System.exit(0);
        	}
        	
    	} while(true);
	}
	
	private void getCustomers() {
		System.out.println("Enter Zip: ");
		String zip = scan.next();
		List<Customer> customers = customerDao.getCustomers(zip);
		System.out.println(customers);
	}

	private void loadCustomer() {
		System.out.println("Enter Customer id: ");
		int id = scan.nextInt();
		Customer cust = customerDao.loadCustomer(id);
		System.out.println(cust);
	}

	private void updateCustomer() {
		System.out.println("Enter Customer ID: ");
        int custId = scan.nextInt();
        Address address = new Address("1214", "San Jacinto", "Irving", "75063");
        Customer customer = new Customer("Mr.", "Vivek", "K", "B", "vivek@gmail.com", "IMCS", "ViVek", "Vivek B K",
				"nothing");   
        customer.setAddress(address);
        customer.setCustID(custId);
        System.out.println(customerDao.updateCustomer(customer));
	}

	private void deleteCustomer() {
		System.out.println("Enter Customer ID: ");
		int custId = scan.nextInt();
    	System.out.println(customerDao.deleteCustomer(custId));
	}

	public void addCustomer() {
		Customer customer = new Customer("Mr.", "Vivek", "K", "B", "vivek@gmail.com", "IMCS", "ViVek", "Vivek B K",
				"nothing");
		Address address = new Address("1214", "San Jacinto", "Irving", "75063");
		customer.setAddress(address);
		System.out.println(customerDao.addCustomer(customer));
	}
	
	public void getMonthlySales() {
		System.out.println("Enter year: ");
		int year = scan.nextInt();
		Map<String, Double> result = customerDao.getMonthlySales(year);
		result.forEach((k,v) -> System.out.println("Month = "
                + k + ", Sales = " + v));
	}
	
	private void getReport() {
		System.out.println("Enter Month: ");
		int month = scan.nextInt();
		customerDao.getReport(month).stream().forEach(System.out::println);
	}

}
