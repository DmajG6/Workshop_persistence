package modelLayer;

public class Product {

	private int productID;
	private String name;
	private float purchasePrice;
	private float salesPrice;
	private float rentPrice;
	private String countryOfOrigin;
	private int minStock;
	private Supplier supplier;
	private int warranty;
	private String productType;
	private String typeDescription;
	
	//constructor
	public  Product(int productID, String name, float purchasePrice, float salesPrice, float rentPrice, String countryOfOrigin, int minStock, Supplier supplier, int warranty, String productType, String typeDescription){
	this.productID = productID;
	this.name = name;
	this.purchasePrice = purchasePrice;
	this.salesPrice = salesPrice;
	this.rentPrice = rentPrice;
	this.countryOfOrigin = countryOfOrigin;
	this.minStock = minStock;
	this.supplier = supplier;
	this.warranty = warranty;
	this.productType = productType;
	this.typeDescription = typeDescription;
	}
	
  public Product() {
		// TODO Auto-generated constructor stub
	}

public void setProductID(int productID){
	  this.productID = productID;
  }
	
  public int getProductID(){
	  return productID;
  }
  
  
  
  public void setName(String name){
	  this.name = name;
  }
  
  public String getName(){
	  return name;
  }

	public void setPurchasePrice(float purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public float getPurchasePrice() {
		return purchasePrice;
	}

	public void setSalesPrice(float salesPrice) {
		this.salesPrice = salesPrice;
	}
	
	public float getSalesPrice() {
		return salesPrice;
	}

	public void setRentPrice(float rentPrice) {
		this.rentPrice = rentPrice;
	}
	
	public float getRentPrice() {
		return rentPrice;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}
	
	public String getCountryOfOrigin() {
		return countryOfOrigin;
	}

	public void setMinStock(int minStock) {
		this.minStock = minStock;
	}
	
	public int getMinStock() {
		return minStock;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setWarranty(int warranty) {
		this.warranty = warranty;
	}
	
	public int getWarranty() {
		return warranty;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setTypeDescription(String typeDescription) {
		this.typeDescription = typeDescription;
	}
	
	public String getTypeDescription() {
		return typeDescription;
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", name=" + name + ", purchasePrice=" + purchasePrice
				+ ", salesPrice=" + salesPrice + ", rentPrice=" + rentPrice + ", countryOfOrigin=" + countryOfOrigin
				+ ", minStock=" + minStock + ", supplier=" + supplier + ", warranty=" + warranty + ", productType="
				+ productType + ", typeDescription=" + typeDescription + "]";
	}

	
	
}