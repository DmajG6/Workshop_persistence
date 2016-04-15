package modelLayer;

public class CopyProduct {
	
	private int productID;
	private String name;
	private float salesPrice;
	private float rentPrice;
	private int amountInOrder;
	private int warranty;
	private String productType;
	
	
	public CopyProduct(int productID, String name, float salesPrice, float rentPrice, int amountInOrder, int warranty,
			String productType) {
		super();
		this.productID = productID;
		this.name = name;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.amountInOrder = amountInOrder;
		this.warranty = warranty;
		this.productType = productType;
	}

	public CopyProduct(Product product, int amount){
		super();
		this.productID = 000;
		this.name = product.getName();
		this.salesPrice = product.getSalesPrice();
		this.rentPrice = product.getRentPrice();
		this.amountInOrder = amount;
		this.warranty = product.getWarranty();
		this.productType = product.getProductType();
		
	}
	
	public CopyProduct(){
		
	}

	public int getProductID() {
		return productID;
	}


	public void setProductID(int productID) {
		this.productID = productID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getSalesPrice() {
		return salesPrice;
	}


	public void setSalesPrice(float salesPrice) {
		this.salesPrice = salesPrice;
	}


	public float getRentPrice() {
		return rentPrice;
	}


	public void setRentPrice(float rentPrice) {
		this.rentPrice = rentPrice;
	}


	public int getAmountInOrder() {
		return amountInOrder;
	}


	public void setAmountInOrder(int amountInOrder) {
		this.amountInOrder = amountInOrder;
	}


	public int getWarranty() {
		return warranty;
	}


	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}


	public String getProductType() {
		return productType;
	}


	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	
	
	
}
