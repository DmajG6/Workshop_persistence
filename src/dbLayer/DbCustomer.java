package dbLayer;


import java.util.ArrayList;
import java.sql.*;
import modelLayer.*;

public class DbCustomer {
	
	private Connection con;
	
	public DbCustomer() {
		con = DbConnection.getInstance().getDBcon();
	}
	
	public int getNewID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(customerID)"
				+ "FROM Customer Table";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			stmt.close();
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("CustomerID");
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("ID not found");
			
		}
		
		return rc;
		
	}
	
	public int insertCustomer(Customer customer){
		int rc = -1;
		String query = "";
		query = "INSERT INTO Customer (CustomerID, firstName, lastName, zip, address, phoneNo, type, active) VALUES (" 
		+ customer.getCustomerID() + ",'"
		+ customer.getFirstName() + "',"
		+ customer.getLastName() + ","
		+ customer.getZip() + ","
		+ customer.getAddress() + ",'"
		+ customer.getPhoneNo() + "',"
		+ customer.getType() + ","
		+ customer.getActive() + ",";
		
		
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Product not inserted");
		}
		
		return rc;
		
	}
	
	public ArrayList<Customer> getAllCustomers() {
		return miscWhere(""); 
	}
	
	public Customer findCustomer(String name) {
		String wClause = "  name = '" + name + "'";
		return singleWhere(wClause);
	}
	
	public Customer findCustomerByCustomerID(int customerID) {
		String wClause = "  cutomerID = '" + customerID + "'";
		return singleWhere(wClause);
	}
	
	public int updateCustomer(String firstName, Customer customer) {
		String q = "update Customer set customerID = ?, firstName = ?, lastName = ?, zip = ?, address = ?, phoneNo = ? type = ?, active = ? where name='" + customer.getFirstName()+"'";
		int res = 0;
		try (PreparedStatement s = DbConnection.getInstance().getDBcon()
				.prepareStatement(q)) {
			s.setInt(1, customer.getCustomerID());
			s.setString(2, customer.getFirstName());
			s.setString(3, customer.getLastName());
			s.setString(4, customer.getZip());
			s.setString(5, customer.getAddress());
			s.setString(6, customer.getPhoneNo());
			s.setByte(7, customer.getType());
			s.setString(8, customer.getActive());			
			
			res = s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {

		}
		return res;
	}
	
    // misc where
	private ArrayList<Customer> miscWhere(String wClause) {
		ResultSet results;
		ArrayList<Customer> list = new ArrayList<Customer>();
		String query = buildQuery(wClause);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Customer customerObj = new Customer();
				customerObj = buildCustomer(results);
				list.add(customerObj);
			}// end while
			stmt.close();
		}// end try
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}
	
	// Single where is used when we only select one thing
		private Customer singleWhere(String wClause) {
			ResultSet results;
			Customer customerObj = new Customer();
			String query = buildQuery(wClause);
			System.out.println(query);
			try {
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				results = stmt.executeQuery(query);
				if (results.next()) {
					customerObj = buildCustomer(results);
					stmt.close();
				} else {
					customerObj = null;
				}
			}// end try
			catch (Exception e) {
				System.out.println("Query exception: " + e);
			}
			return customerObj;
		}
		
		// method to build the query
		private String buildQuery(String wClause) {
			String query = "SELECT *  FROM Customer";

			if (wClause.length() > 0)
				query = query + " WHERE " + wClause;

			return query;
		}
		
		// method to build a product object
		private Customer buildCustomer(ResultSet results) {
			Customer customerObj = new Customer();
			try {
				customerObj.setCustomerID(results.getInt("customerID"));
				customerObj.setFirstName(results.getString("firstName"));
				customerObj.setLastName(results.getString("lastName"));
				customerObj.setZip(results.getString("zip"));
				customerObj.setAddress(results.getString("address"));
				customerObj.setPhoneNo(results.getString("phoneNo"));
				customerObj.setType(results.getByte("type"));
				customerObj.setActive(results.getString("active"));
				

			} catch (Exception e) {
				System.out.println("Error in building the product object");
			}
			return customerObj;
		}

}


