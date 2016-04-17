package modelLayer;

public class Supplier {
	
	private String name;
	private String address;
	private String country;
	private int phoneNumber;
	private String email;
	private int supplierID;
	private int zip;
	
	// constructor 
	
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public Supplier(int id){
		super();
		this.supplierID = id;
	}
	public Supplier(){
	}
	
	
	
	public void setName(String name){
		this.name = name;
	}
	
	public Supplier(String name) {
		super();
		this.name = name;
	}

	public String getName(){
		return name;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setCountry(String country){
		this.country = country;
	}
	
	public String getCountry(){
		return country;
	}
	
	public void setPhoneNumber(int phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public int getPhoneNumber(){
		return phoneNumber;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setsupplierID(int supplierID){
		this.supplierID = supplierID;
	}
	
	public int supplierID(){
		return supplierID;
	}
}
