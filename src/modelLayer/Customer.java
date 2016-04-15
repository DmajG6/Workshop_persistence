package modelLayer;
import java.util.ArrayList;

public class Customer {
	
    private int customerID;
	private String firstName;
	private String lastName;
	private String zip;
	private String address;	
	private String phoneNo;	
	private byte type;	
	private String active;
	private ArrayList <Order> orders;
	private String city;
	
	
	public Customer(){
		
	}
	
	public Customer(int ID){
		this.customerID = ID;
	}
	
	public Customer(int customerID, String firstName, String lastName, String zip, String address, String phoneNo,
			byte type, String active, ArrayList<Order> orders, String city) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.zip = zip;
		this.address = address;
		this.phoneNo = phoneNo;
		this.type = type;
		this.active = active;
		this.orders = orders;
		this.city = city;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getZip() {
		return zip;
	}


	public void setZip(String zip) {
		this.zip = zip;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public byte getType() {
		return type;
	}


	public void setType(byte type) {
		this.type = type;
	}


	public String getActive() {
		return active;
	}


	public void setActive(String active) {
		this.active = active;
	}


	public ArrayList<Order> getOrders() {
		return orders;
	}


	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	
}