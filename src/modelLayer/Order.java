package modelLayer;

import java.util.ArrayList;

public class Order {
	
	//list of items
		private int orderID;
		private Customer customer;
		private String deliveryStatus;
		private String deliveryDate;
		private String orderType;
		private float amount;
		private String dateOfPurchase;
		private ArrayList<CopyProduct> products;
		
	
	public Order(int orderID) {
		this.orderID = orderID;
	}

	public Order() {
	}
	
	
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customer=" + customer + ", deliveryStatus=" + deliveryStatus
				+ ", deliveryDate=" + deliveryDate + ", orderType=" + orderType + ", amount=" + amount
				+ ", dateOfPurchase=" + dateOfPurchase + ", products=" + products + "]";
	}

	public Order(Customer customer, String deliveryStatus, String deliveryDate, String orderType,
			float amount, String dateOfPurchase, ArrayList<CopyProduct> products) {
		this.customer = customer;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.orderType = orderType;
		this.amount = amount;
		this.dateOfPurchase = dateOfPurchase;
		this.products = products;;
	}

	
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(String dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public ArrayList<CopyProduct> getListOfItems() {
		return products;
	}

	public void setListOfItems(ArrayList<CopyProduct> products) {
		this.products = products;
	}
	
	public void addProduct(Product product, int quantity){
		this.products.add(new CopyProduct(00000000, 
											product.getName(), 
											product.getSalesPrice(), 
											product.getRentPrice(), 
											quantity, 
											product.getWarranty(),
											product.getProductType()));
	}
	
	
}
