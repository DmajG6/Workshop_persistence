package dbLayer;

import java.util.ArrayList;
import java.sql.*;
import modelLayer.*;

public class DbOrder {

	private Connection con;
	private DbCopyProduct dbcp = new DbCopyProduct();
	
	public DbOrder(){
		con = DbConnection.getInstance().getDBcon();
	}
	
	public ArrayList<Order> getAll(){
		int rc = -1;
		ArrayList<Order> orders = new ArrayList<Order>();
		
		String query = "";
		query = "SELECT *"
				+ "FROM OrderTable";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			stmt.close();
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				Order newOrder = new Order(results.getInt("OrderID"));
				newOrder.setAmount(results.getFloat("amount"));
				newOrder.setDateOfPurchase(results.getString("dateOfPurchase"));
				newOrder.setCustomer(new Customer(results.getInt("customer")));
				newOrder.setDeliveryStatus(results.getString("deliveryStatus"));
				newOrder.setDeliveryDate(results.getString("deliveryDate"));
				newOrder.setOrderType(results.getString("orderType"));
				
				orders.add(newOrder);
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("ID not found: "+rc+" "+ex.getCause());
			
		}
		
		
		return orders;
	}
	
	public Order findOrder(int orderID){
		
		int rc = -1;
		Order order = new Order(orderID);
		
		String query = "";
		query = "SELECT * "
				+ "FROM OrderTable "
				+ "WHERE orderID = "+orderID;
		System.out.println("insert : " + query);
		
		try {
			
			ResultSet results;
			
			Statement stmt = con.createStatement();
			
			stmt.setQueryTimeout(5);
			

			//rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			
			results = stmt.executeQuery(query);

			if (results.next()) {
				order.setCustomer(new Customer(results.getInt("customerID")));
				order.setAmount(results.getInt("amount"));
				order.setDateOfPurchase(""+results.getInt("date/time"));
				order.setDeliveryDate(""+results.getInt("deliveryDate"));
				order.setDeliveryStatus(results.getString("deliveryStatus"));
				order.setOrderType(results.getString("orderType"));
				order.setListOfItems(dbcp.getAllProducctsInOrder(orderID));
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("Order not found "+ex.getMessage());
			
		}
		
		return order;
		
	}
	
	public int insertOrder(Order order){
		int rc = -1;
		String query = "";
		int date = 45616;
		int amount = (int) order.getAmount();
		query = "INSERT INTO OrderTable (orderID, customerID, deliveryStatus, deliveryDate, orderType, amount, active, date/time) VALUES (" 
		+ order.getOrderID() + ","
		+ order.getCustomer().getCustomerID() + ",'"
		+ order.getDeliveryStatus() + "',"
		+ order.getDeliveryDate().length() + ",'"
		+ order.getOrderType() + "',"
		+ amount + ",'"
		+ "yes',"
				+ date+") ";
		
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Order not inserted");
		}
		
		dbcp.insertCopyProduct(order.getListOfItems(), order.getOrderID());
		return rc;
		
	}
	
	public int getNewID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(orderID) "
				+ "AS highest "
				+ "FROM OrderTable";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			//rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			//stmt.close();
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("highest");
				rc++;
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("ID not found"+ex.getMessage());
			
		}
		
		return rc;
		
	}
	
//	private String buildOrderQuery(String wClause) {
//		String query = "SELECT *  FROM Order";
//		if (wClause.length() > 0)
//			query = query + " WHERE " + wClause;
//
//		return query;
//	}

	
	
}