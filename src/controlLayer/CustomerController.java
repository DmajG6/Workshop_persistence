package controlLayer;

import java.util.ArrayList;
import modelLayer.Customer;
import modelLayer.Order;

public class CustomerController {
	
	private ArrayList <Customer> customers;
	
	public Customer createCustomer(int customerId, String firstName, String lastName, String zip, String address, String city, String active, String phoneNo, byte type){
		Customer customer = new Customer(customerId, firstName, lastName, zip, address, phoneNo, type, active, new ArrayList<Order>(), city);
		customers.add(customer);
		return customer;
	}
	
	public Customer findCustomer(String name){
		Customer customer = null;
		for(int index = 0; index < customers.size(); index++){
			customer = customers.get(index);
			if(customer.getLastName().equals(name)){
				break;
			}
		}
		return customer;
		}
	
	
	public boolean customerExists(String name){
		boolean test = false;
		Customer customer = null;
		for(int index = 0; index < customers.size(); index++){
			customer = customers.get(index);
			if(customer.getLastName().equals(name)){
				test = true;
				break;
			}
		}
		return test;
	}
	
	public void deleteCustomer(Customer customer){
		customers.remove(customer);
	}
	
	public void updateCustomer(Customer customer, int customerId, String firstName, String lastName, String address, String zipCode, String city, String phoneNo, byte type){
		customer.setCustomerID(customerId);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setAddress(address);
		customer.setZip(zipCode);
		customer.setCity(city);
		customer.setPhoneNo(phoneNo);
		customer.setType(type);
	}

}


