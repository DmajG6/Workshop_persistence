package dbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelLayer.CopyProduct;

public class DbCopyProduct {
	
	private Connection con;
	
	public DbCopyProduct(){
		con = DbConnection.getInstance().getDBcon();
	}

	
	public int insertCopyProduct(ArrayList<CopyProduct> products, int orderID){
		int rc = -1;
		String query = "";
		
		// Body
		for(int i = 0 ; i < products.size() ; i++){
			CopyProduct product = products.get(i);
			int productID = getCopyProductID(product);
			if(productID != -1){
				assignOrderProduct(orderID, productID, product.getAmountInOrder());
			}else{
				
				product.setProductID(getNewProductID());
				
				query = query + "INSERT INTO CopyProduct (productID, name, salesPrice rentPrice, warranty, productType) VALUES ('"
						+ product.getProductID() + ","
						+ product.getName() + ","
						+ product.getSalesPrice() + ","
						+ product.getRentPrice() + ","
						+ product.getWarranty() + ","
						+ product.getProductType() + "')";
				assignOrderProduct(orderID, product.getProductID(), product.getAmountInOrder());
			}
			try {
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
				stmt.close();
				
			} catch (SQLException ex) {
				System.out.println("Copy Product Not creaated");
				
			}
			
		}
		return rc;
	}
	
	private int getCopyProductID(CopyProduct product){
		int rc = -1;
		
		String query = "";
		
		query = "SELECT productID "
				+ "FROM CopyProductTable "
				+ "WHERE name = '"+product.getName()+"'"
				+ " salesPrice = "+product.getSalesPrice()
				+ " rentPrice = "+product.getRentPrice()
				+ " warranty = "+product.getWarranty()
				+ " productType = '"+product.getProductType()+"'";
				
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			stmt.close();
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("productID");
			}
				stmt.close();
		} catch (SQLException ex) {
			System.out.println("ID not found "+ex.getSQLState());
			
		}
		
		return rc;
	}
	
	private int getNewProductID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(productID) "
				+ "FROM CopyProductTable ";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			stmt.close();
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("productID");
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("ID not found");
			
		}
		
		return rc+1;
	}
	
	private int assignOrderProduct(int orderID, int productID, int amountInOrder){
		int rc = -1;
		
		//OrderIdem
		String query = "";
		query = "INSERT INTO OrderItemTable(CopyItemID, OrderID, quantity, OrderType) VALUES ("+productID+", "+orderID+", "+amountInOrder+", '1')";
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			stmt.close();
			
			
		} catch (SQLException ex) {
			System.out.println("ID not found");
			
		}
		
		
		
		
		return rc;
	}
	
	public ArrayList<CopyProduct> getAllProducctsInOrder(int orderNumber){
		int rc = -1;
		ArrayList<CopyProduct> products = new ArrayList<CopyProduct>();
		
		String query = "";
		
		query = "SELECT o.quantity, o.copyItemID, c.name, c.SalesPrice, c.rentPrice, c.warranty, c.productType "
				+ "FROM OrderItemTable o, CopyProductTable c "
				+ "WHERE orderID = " + orderNumber + " AND "
						+ " o.copyItemID = c.productID";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				CopyProduct item = new CopyProduct();
				item.setAmountInOrder(results.getInt("quantity"));
				item.setName(results.getString("name"));
				item.setProductID(results.getInt("CopyItemID"));
				item.setProductType(results.getString("productType"));
				item.setRentPrice(results.getFloat("rentPrice"));
				item.setSalesPrice(results.getFloat("SalesPrice"));
				item.setWarranty(results.getInt("warranty"));
				
				products.add(item);
				
			}
			
			
				stmt.close();
		} catch (SQLException ex) {
			System.out.println("ID not found "+rc+" "+ex.getMessage());
			
		}
		return products;
	}
}
