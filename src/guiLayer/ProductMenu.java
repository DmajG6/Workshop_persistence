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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	private ProductController prdctr = new ProductController();
	
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
		
		textField = new JTextField();
		textField.setBounds(141, 110, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(73, 113, 56, 16);
		contentPane.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(141, 75, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(73, 78, 56, 16);
		contentPane.add(lblId);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findProduct();
			}
		});
		btnFind.setBounds(290, 109, 97, 25);
		contentPane.add(btnFind);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(73, 148, 56, 16);
		contentPane.add(lblPrice);
		
		textField_2 = new JTextField();
		textField_2.setBounds(141, 145, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAmountInStock = new JLabel("Amount in Stock");
		lblAmountInStock.setBounds(32, 187, 97, 16);
		contentPane.add(lblAmountInStock);
		
		textField_3 = new JTextField();
		textField_3.setBounds(141, 184, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblWarranty = new JLabel("Warranty");
		lblWarranty.setBounds(73, 222, 56, 16);
		contentPane.add(lblWarranty);
		
		textField_4 = new JTextField();
		textField_4.setBounds(141, 219, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(141, 260, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(73, 263, 56, 16);
		contentPane.add(lblCountry);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				createProduct();
			}
		});
		btnCreate.setBounds(290, 74, 97, 25);
		contentPane.add(btnCreate);
	}
	
	private void findProduct(){
		String input = textField.getText();
		Product product = prdctr.findProductByName(input);
		textField_1.setText(""+product.getProductID());
		textField_2.setText(""+product.getSalesPrice());
		textField_3.setText(""+product.getMinStock());
		textField_4.setText(""+product.getWarranty());
		textField_5.setText(""+product.getCountryOfOrigin());
	}
	
	private void createProduct(){
		
		prdctr.createProduct(textField.getText(), 00, Integer.parseInt(textField_2.getText()), 00, textField_5.getText(), Integer.parseInt(textField_3.getText()), new Supplier(101), Integer.parseInt(textField_4.getText()), "1", "1");
		
	}
	
}
