package controlLayer;

import modelLayer.*;

import java.sql.Statement;
import java.util.ArrayList;

import dbLayer.DbCopyProduct;
import dbLayer.DbOrder;

public class OrderController {
	
	private ArrayList<Order> manyOrders = new ArrayList<Order>();
	
	private DbOrder dbOrder = new DbOrder();
	
	private DbCopyProduct dbCopy = new DbCopyProduct();
	
	//Constructor
	public OrderController() {
		//Empty Constructor
	}
	
	public void createOrder(Customer customer, String deliveryStatus, String deliveryDate, String orderType, float amount, String dateOfPurchase, ArrayList<CopyProduct> products){
		Order order = new Order(customer, deliveryStatus, deliveryDate, orderType, amount, dateOfPurchase, products);
		order.setOrderID(dbOrder.getNewID());
		
		//Transaction
		
		dbOrder.insertOrder(order);
		insertProducts(order.getOrderID(), order.getListOfItems());
		
		
		
	}
	
	//Get All orders
	public ArrayList<Order> getAllOrders(){
		manyOrders = dbOrder.getAll();
		return manyOrders;
	}
	
	//Get order by  order ID
	public Order findOrder(int OrderID){
		Order order = dbOrder.findOrder(OrderID);
		return order;
	}
	
	private void insertProducts(int orderID, ArrayList<CopyProduct> products){
		dbCopy.insertCopyProduct(products, orderID);
	}
}
