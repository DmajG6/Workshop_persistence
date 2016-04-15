package controlLayer;

import java.util.ArrayList;
import modelLayer.Invoice;

public class InvoiceController {
	
	private ArrayList <Invoice> invoices;
	
		
	public Invoice createInvoice(int invoiceNumber, int orderNumber, String paymentDate, int amount){
		Invoice invoice = new Invoice(invoiceNumber, orderNumber, paymentDate, amount);
		invoices.add(invoice);
		return invoice;
	}
	
	//public void InvoiceControl(){
      //  invoices = InvoiceContainer.getInstance().getInvoices();
   // }
	
	public Invoice findInvoice(int invoiceNumber){
		Invoice invoice = null;
		for(int index = 0; index < invoices.size(); index++){
	    invoice = invoices.get(index);
		if(invoice.getInvoiceNumber() == (invoiceNumber)){
		break;
	}
	}
		return invoice;
	}
	
	
	public boolean invoiceExists(int invoiceNumber){
		boolean test = false;
		Invoice invoice = null;
		for(int index = 0; index < invoices.size(); index++){
		invoice = invoices.get(index);
		if(invoice.getInvoiceNumber() == (invoiceNumber)){ 
		test = true;
		break;
	}
	}
		return test;
	}
	
	public void deleteInvoice(Invoice invoice){
		invoices.remove(invoice);
	}
	

}


