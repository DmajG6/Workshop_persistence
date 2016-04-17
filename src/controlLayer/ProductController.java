package controlLayer;

import java.util.ArrayList;
import dbLayer.DbConnection;
import dbLayer.DbProduct;
import modelLayer.Product;
import modelLayer.Supplier;

public class ProductController {

	
	DbProduct dbProduct = new DbProduct();
	
	public ArrayList<Product> getAllProducts(){
		return dbProduct.getAllProducts();
	}
	
	public Product findProductByName(String name){
		try {
			return dbProduct.findProduct(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Product findProductBySupplier(Supplier supplier){
		try {
			return dbProduct.findProductBySupplier(supplier);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	public Product createProduct(String name, float purchasePrice, float salesPrice, float rentPrice, String countryOfOrigin, int minStock, Supplier supplier, int warranty, String productType, String typeDescription){
		Product product = new Product();
		product.setProductID(0);
		product.setName(name);
		product.setPurchasePrice(purchasePrice);
		product.setSalesPrice(salesPrice);
		product.setRentPrice(rentPrice);
		product.setCountryOfOrigin(countryOfOrigin);
		product.setMinStock(minStock);
		product.setSupplier(supplier);
		product.setWarranty(warranty);
		product.setProductType(productType);
		product.setTypeDescription(typeDescription);

		try {
			DbConnection.startTransaction();
			dbProduct.insertProduct(product);
			DbConnection.commitTransaction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			DbConnection.rollbackTransaction();
			e.printStackTrace();
		}
		return product;
	}
	
	public int updateProduct(String name, Product product){
		return dbProduct.updateProduct(name, product);		
	}
	
	
}
