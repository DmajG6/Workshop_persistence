package guiLayer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import modelLayer.*;
import controlLayer.*;

public class OrderMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private OrderController ordctr = new OrderController();
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private Order order = new Order();
	private ArrayList<CopyProduct> products = new ArrayList<CopyProduct>();
	private ProductController prdctr = new ProductController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderMenu frame = new OrderMenu();
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
	public OrderMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOrderid = new JLabel("OrderID");
		lblOrderid.setBounds(23, 42, 86, 16);
		contentPane.add(lblOrderid);
		
		JLabel lblCustomerid = new JLabel("CustomerID:");
		lblCustomerid.setBounds(23, 91, 86, 16);
		contentPane.add(lblCustomerid);
		
		textField = new JTextField();
		textField.setBounds(144, 39, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(144, 88, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				findOrder();
			}
		});
		btnFind.setBounds(310, 38, 97, 25);
		contentPane.add(btnFind);
		
		JLabel lblAddProduct = new JLabel("Add Product:");
		lblAddProduct.setBounds(23, 197, 77, 16);
		contentPane.add(lblAddProduct);
		
		textField_2 = new JTextField();
		textField_2.setBounds(144, 194, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToCart();
			}
		});
		btnAdd.setBounds(273, 241, 97, 25);
		contentPane.add(btnAdd);
		
		textField_3 = new JTextField();
		textField_3.setBounds(144, 131, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setBounds(23, 245, 56, 16);
		contentPane.add(lblAmount);
		
		textField_4 = new JTextField();
		textField_4.setBounds(144, 242, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(23, 134, 56, 16);
		contentPane.add(lblPrice);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pressBuy();
			}
		});
		btnBuy.setBounds(273, 298, 97, 25);
		contentPane.add(btnBuy);
		
		JButton btnAddCustomer = new JButton("Add Customer");
		btnAddCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCustomer();
			}
		});
		btnAddCustomer.setBounds(310, 87, 116, 25);
		contentPane.add(btnAddCustomer);
	}
	
	private void findOrder(){
		int input = Integer.parseInt(textField.getText());
		Order order = ordctr.findOrder(input);
		System.out.println(order.toString());
	}
	
	private void addToCart(){
		
		int amount = Integer.parseInt(textField_4.getText());
		String input = textField_2.getText();
		
		try{
			Product product = new Product();
			
			product = prdctr.findProductByName(input);
			
			CopyProduct cpProduct = new CopyProduct(product, amount);
			
			products.add(cpProduct);
			
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
		
		
		
		
	}
	
	private void pressBuy(){
		
		ordctr.createOrder(order.getCustomer(), "not delivered", "15651354", "one=time", getTotalPrice(), "now", products);
		
	}
	
	private void addCustomer(){
		
		order.setCustomer(new Customer(Integer.parseInt(textField_1.getText())));
		
	}
	
	private float getTotalPrice(){
		float total = 0;
		
		for(CopyProduct product: products){
			total += product.getSalesPrice();
		}
		return total;
	}
	
}
