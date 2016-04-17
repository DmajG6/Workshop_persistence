package dbLayer;

import java.util.ArrayList;
import java.sql.*;
import modelLayer.Product;
import modelLayer.Supplier;


public class DbProduct {
	
	private Connection con;
	
	public DbProduct() {
		con = DbConnection.getInstance().getDBcon();
	}
	
	public int getNewID(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(productID)"
				+ "FROM ProductTable";
		System.out.println("SELECT : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);			
			stmt.close();
			
			
		} catch (SQLException ex) {
			System.out.println("ID not found"+ex.getMessage());
			
		}
		
		return rc;
		
	}
	
	public int insertProduct(Product product){
		int rc = -1;
		String query = "";
		query = "INSERT INTO ProductTable (name, purchasePrice, salesPrice, rentPrice, countryOfOrigin, minStock, supplierID, warranty, productType, typeDescription) VALUES (" 
		+ "'"
		+ product.getName() + "',"
		+ product.getPurchasePrice() + ","
		+ product.getSalesPrice() + ","
		+ product.getRentPrice() + ",'"
		+ product.getCountryOfOrigin() + "',"
		+ product.getMinStock() + ","
		+ product.getSupplier().supplierID() + ","
		+ product.getWarranty() + ",'"
		+ product.getProductType() + "','"
		+ product.getTypeDescription()+ "')";
		
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Product not inserted"+ex.getMessage());
		}
		
		return rc;
		
	}
	
	public ArrayList<Product> getAllProducts() {
		return miscWhere("");
	}

	public Product findProduct(String name) {
		String wClause = "  name = '" + name + "'";
		return singleWhere(wClause);
	}

	public Product findProductBySupplier(Supplier supplier) {
		String wClause = "  supplier = '" + supplier.getName() + "'";
		return singleWhere(wClause);
	}


	public int updateProduct(String name, Product product) {
		String q = "update ProductTable set productID=?, purchasePrice=?, salesPrice=?, rentPrice=?, countryOfOrigin=?, minStock=? supplierID=?, warranty-?, productType=?, typeDescription=? where name='"+product.getName()+"'";
		int res = 0;
		try (PreparedStatement s = DbConnection.getInstance().getDBcon()
				.prepareStatement(q)) {
			s.setInt(1, product.getProductID());
			s.setFloat(2, product.getPurchasePrice());
			s.setFloat(3, product.getSalesPrice());
			s.setFloat(4, product.getRentPrice());
			s.setString(5, product.getCountryOfOrigin());
			s.setInt(6, product.getMinStock());
			s.setInt(7, product.getSupplier().supplierID());
			s.setInt(8, product.getWarranty());
			s.setString(9, product.getProductType());
			s.setString(10, product.getTypeDescription());
			
			res = s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {

		}
		return res;
	}

	//  misc where
	private ArrayList<Product> miscWhere(String wClause) {
		ResultSet results;
		ArrayList<Product> list = new ArrayList<Product>();
		String query = buildQuery(wClause);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Product productObj = new Product();
				productObj = buildProduct(results);
				list.add(productObj);
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
	private Product singleWhere(String wClause) {
		ResultSet results;
		Product productObj = new Product();
		String query = buildQuery(wClause);
		System.out.println(query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			if (results.next()) {
				productObj = buildProduct(results);
				stmt.close();
			} else {
				productObj = null;
			}
		}// end try
		catch (Exception e) {
			System.out.println("Query exception: " + e);
		}
		return productObj;
	}


	// method to build the query
	private String buildQuery(String wClause) {
		String query = "SELECT *  FROM ProductTable";
		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;

		return query;
	}

	// method to build a product object
	private Product buildProduct(ResultSet results) {
		Product productObj = new Product();
		try {
			productObj.setProductID(results.getInt("productID"));
			productObj.setName(results.getString("name"));
			productObj.setPurchasePrice(results.getFloat("purchasePrice"));
			productObj.setSalesPrice(results.getFloat("salesPrice"));
			productObj.setRentPrice(results.getFloat("rentPrice"));
			productObj.setCountryOfOrigin(results.getString("countryOfOrigin"));
			productObj.setMinStock(results.getInt("minStock"));
			productObj.setSupplier(new Supplier(results.getInt("supplierID")));
			productObj.setWarranty(results.getInt("warranty"));
			productObj.setProductType(results.getString("productType"));
			productObj.setTypeDescription(results.getString("typeDescription"));

			System.out.println(productObj.toString());
		} catch (Exception e) {
			System.out.println("Error in building the product object");
		}
		return productObj;
	}

	
	
	/*// private method
		private Product getProduct(String wClause) {
			ResultSet results;
			Product productObj = new Product();

			String query = buildQuery(wClause);
			try {
				Statement stmt = con.createStatement();
				stmt.setQueryTimeout(5);
				results = stmt.executeQuery(query);
				if (results.next()) {
					productObj = buildProduct(results);
					stmt.close();
				} else {
					productObj = null;
				}
			} catch (Exception e) {
				System.out.println("Query exception: " + e);
			}
			return productObj;
		}*/
	
	

}
