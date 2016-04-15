package modelLayer;

public class Invoice {

	private int invoiceNumber;
	private int orderNumber;
	private String paymentDate;
	private int amount;
	

	  public Invoice(int invoiceNumber, int orderNumber, String paymentDate, int amount) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.orderNumber = orderNumber;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public void setInvoiceNumber(int invoiceNumber){
		  this.invoiceNumber=invoiceNumber;
	  }
	  
	  public int getInvoiceNumber(){
		  return invoiceNumber;
	  }
	  
	  public void setOrderNumber(int orderNumber){
		  this.orderNumber=orderNumber;
	  }
	  
	  public int getOrderNumber(){
		  return orderNumber;
	  }
	 
	  public void setPaymentDate(String paymentDate){
		  this.paymentDate=paymentDate;
	  }
	  
	  public String getPaymentDate(){
		  return paymentDate;
	  }
	 
	  public void setAmount(int amount){
		  this.amount=amount;
	  }
	  
	  public int getAmount(){
		  return amount;
	  }
	  
	 	  
}