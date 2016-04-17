package guiLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import controlLayer.*;
import modelLayer.*;

public class ProductMenu extends JFrame {

	private JPanel contentPane;
	private JTextField txtf_name;
	private JTextField txtf_price;
	private JTextField txtf_stock;
	private JTextField txtf_warranty;
	private JTextField txtf_country;

	private ProductController prdctr = new ProductController();
	private JTextField txtf_salesPrice;
	private JTextField txtf_rentPrice;
	private JTextField txtf_type;
	private JTextField txtf_description;
	private JTextField txtf_supplierID;
	private JTextField txtf_id;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductMenu frame = new ProductMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ProductMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 471, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtf_name = new JTextField();
		txtf_name.setBounds(139, 75, 116, 22);
		contentPane.add(txtf_name);
		txtf_name.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(32, 78, 97, 16);
		contentPane.add(lblName);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findProduct();
			}
		});
		btnFind.setBounds(290, 109, 97, 25);
		contentPane.add(btnFind);
		
		JLabel lblPurchasePrice = new JLabel("Purchase price");
		lblPurchasePrice.setBounds(32, 108, 117, 16);
		contentPane.add(lblPurchasePrice);
		
		txtf_price = new JTextField();
		txtf_price.setBounds(139, 107, 116, 22);
		contentPane.add(txtf_price);
		txtf_price.setColumns(10);
		
		JLabel lblAmountInStock = new JLabel("Amount in Stock");
		lblAmountInStock.setBounds(32, 199, 97, 16);
		contentPane.add(lblAmountInStock);
		
		txtf_stock = new JTextField();
		txtf_stock.setBounds(139, 196, 116, 22);
		contentPane.add(txtf_stock);
		txtf_stock.setColumns(10);
		
		JLabel lblWarranty = new JLabel("Warranty");
		lblWarranty.setBounds(32, 229, 76, 16);
		contentPane.add(lblWarranty);
		
		txtf_warranty = new JTextField();
		txtf_warranty.setBounds(139, 226, 116, 22);
		contentPane.add(txtf_warranty);
		txtf_warranty.setColumns(10);
		
		txtf_country = new JTextField();
		txtf_country.setBounds(139, 259, 116, 22);
		contentPane.add(txtf_country);
		txtf_country.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(32, 262, 76, 16);
		contentPane.add(lblCountry);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createProduct();
			}
		});
		btnCreate.setBounds(290, 74, 97, 25);
		contentPane.add(btnCreate);
		
		JLabel lblSalesPrice = new JLabel("Sales price");
		lblSalesPrice.setBounds(32, 140, 92, 14);
		contentPane.add(lblSalesPrice);
		
		txtf_salesPrice = new JTextField();
		txtf_salesPrice.setBounds(139, 136, 116, 22);
		contentPane.add(txtf_salesPrice);
		txtf_salesPrice.setColumns(10);
		
		JLabel lblRentPrice = new JLabel("Rent Price");
		lblRentPrice.setBounds(32, 172, 76, 14);
		contentPane.add(lblRentPrice);
		
		txtf_rentPrice = new JTextField();
		txtf_rentPrice.setBounds(139, 169, 116, 20);
		contentPane.add(txtf_rentPrice);
		txtf_rentPrice.setColumns(10);
		
		JLabel lblType = new JLabel("Type");
		lblType.setBounds(32, 289, 66, 14);
		contentPane.add(lblType);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(32, 314, 76, 14);
		contentPane.add(lblDescription);
		
		txtf_type = new JTextField();
		txtf_type.setBounds(139, 286, 116, 20);
		contentPane.add(txtf_type);
		txtf_type.setColumns(10);
		
		txtf_description = new JTextField();
		txtf_description.setBounds(139, 311, 116, 20);
		contentPane.add(txtf_description);
		txtf_description.setColumns(10);
		
		JLabel lblSupplierId = new JLabel("Supplier ID");
		lblSupplierId.setBounds(32, 340, 76, 14);
		contentPane.add(lblSupplierId);
		
		txtf_supplierID = new JTextField();
		txtf_supplierID.setBounds(139, 337, 116, 20);
		contentPane.add(txtf_supplierID);
		txtf_supplierID.setColumns(10);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setBounds(32, 40, 76, 14);
		contentPane.add(lblProductId);
		
		txtf_id = new JTextField();
		txtf_id.setEditable(false);
		txtf_id.setBounds(136, 37, 116, 20);
		contentPane.add(txtf_id);
		txtf_id.setColumns(10);
	}
	
	private void findProduct(){
		String input = txtf_name.getText();
		Product product = prdctr.findProductByName(input);
		if(product!= null){
		txtf_id.setText(""+product.getProductID());
		txtf_price.setText(""+product.getPurchasePrice());
		txtf_salesPrice.setText(""+product.getSalesPrice());
		txtf_rentPrice.setText(""+product.getRentPrice());
		txtf_country.setText(""+product.getCountryOfOrigin());
		txtf_stock.setText(""+product.getMinStock());
		txtf_supplierID.setText(""+product.getSupplier().supplierID());
		txtf_warranty.setText(""+product.getWarranty());
		txtf_type.setText(""+product.getProductType());
		txtf_description.setText(""+product.getTypeDescription());
		}
	}
	
	private void createProduct(){
		
		prdctr.createProduct(txtf_name.getText(), Float.parseFloat(txtf_price.getText()), Float.parseFloat(txtf_salesPrice.getText()), Float.parseFloat(txtf_rentPrice.getText()), txtf_country.getText(), Integer.parseInt(txtf_stock.getText()), new Supplier(Integer.parseInt(txtf_supplierID.getText())), Integer.parseInt(txtf_warranty.getText()),txtf_type.getText(), txtf_description.getText());
		
	}
}
