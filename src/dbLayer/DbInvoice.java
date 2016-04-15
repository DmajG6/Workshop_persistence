package dbLayer;

import java.util.ArrayList;
import java.sql.*;
import modelLayer.Invoice;


public class DbInvoice {
	
	private Connection con;
	
	public DbInvoice() {
		con = DbConnection.getInstance().getDBcon();
	}
	
	public int getNewNumber(){
		int rc = -1;
		String query = "";
		query = "SELECT MAX(invoiceNumber)"
				+ "FROM InvoiceTable";
		System.out.println("insert : " + query);
		try {
			ResultSet results;
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			
			stmt.close();
			
			results = stmt.executeQuery(query);
			
			if (results.next()) {
				rc = results.getInt("InvoiceNumber");
			}
				stmt.close();
			
		} catch (SQLException ex) {
			System.out.println("Number not found");
			
		}
		
		return rc;
		
	}
	
	public int insertInvoice(Invoice invoice){
		int rc = -1;
		String query = "";
		query = "INSERT INTO Invoice (invoiceNumber, orderNumber, paymentDate, amount) VALUES (" 
		+ invoice.getInvoiceNumber() + ","
		+ invoice.getOrderNumber() + ","
		+ invoice.getPaymentDate() + "',"
		+ invoice.getAmount() + ")";
		
		
		
		System.out.println("insert : " + query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			stmt.close();
		} catch (SQLException ex) {
			System.out.println("Invoice not inserted");
		}
		
		return rc;
		
	}
	
	public ArrayList<Invoice> getAllInvoice() {
		return miscWhere("");
	}

	public Invoice findInvoice(int invoiceNumber) {
		String wClause = "  invoiceNumber = '" + invoiceNumber + "'";
		return singleWhere(wClause);
	}

	

	public int updateInvoice(String invoiceNumber, Invoice invoice) {
		String q = "update Invoice set invoiceNumber=?, orderNumber=?, paymentDate=?, amount=? where invoiceNumber='"+invoice.getInvoiceNumber()+"'";
		int res = 0;
		try (PreparedStatement s = DbConnection.getInstance().getDBcon()
				.prepareStatement(q)) {
			s.setInt(1, invoice.getInvoiceNumber());
			s.setInt(2, invoice.getOrderNumber());
			s.setString(3, invoice.getPaymentDate());
			s.setInt(4, invoice.getAmount());
			
			
			res = s.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException npe) {

		}
		return res;
	}


	private ArrayList<Invoice> miscWhere(String wClause) {
		ResultSet results;
		ArrayList<Invoice> list = new ArrayList<Invoice>();
		String query = buildQuery(wClause);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);

			while (results.next()) {
				Invoice invoiceObj = new Invoice(0, 0, query, 0);
				invoiceObj = buildInvoice(results);
				list.add(invoiceObj);
			}// end while
			stmt.close();
		}// end try
		catch (Exception e) {
			System.out.println("Query exception - select: " + e);
			e.printStackTrace();
		}
		return list;
	}

	
	private Invoice singleWhere(String wClause) {
		ResultSet results;
		Invoice invoiceObj = new Invoice(0, 0, wClause, 0);
		String query = buildQuery(wClause);
		System.out.println(query);
		try {
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			if (results.next()) {
				invoiceObj = buildInvoice(results);
				stmt.close();
			} else {
				invoiceObj = null;
			}
		}// end try
		catch (Exception e) {
			System.out.println("Query exception: " + e);
		}
		return invoiceObj;
	}

	
	private String buildQuery(String wClause) {
		String query = "SELECT *  FROM Invoice";

		if (wClause.length() > 0)
			query = query + " WHERE " + wClause;

		return query;
	}

	
	private Invoice buildInvoice(ResultSet results) {
		Invoice invoiceObj = new Invoice(0, 0, null, 0);
		try {
			invoiceObj.setInvoiceNumber(results.getInt("invoiceNumber"));
			invoiceObj.setOrderNumber(results.getInt("orderNumber"));
			invoiceObj.setPaymentDate(results.getString("paymentDate"));
			invoiceObj.setAmount(results.getInt("amount"));
			

		} catch (Exception e) {
			System.out.println("Error in building the invoice object");
		}
		return invoiceObj;
	}
	
	
	
	

}
