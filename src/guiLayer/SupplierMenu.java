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
import java.awt.Font;
public class SupplierMenu extends JFrame{

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private SupplierController splctr = new SupplierController();
	private JTextField textField_4;
	
	
	private JTextField textFieldC;
	private JTextField textFieldC_1;
	private JTextField textFieldC_2;
	private JTextField textFieldC_3;
	private JTextField textFieldC_4;
	private JTextField textFieldC_5;
	private JTextField textFieldC_6;
	
	private JTextField textFieldF;
	private JTextField textFieldF_1;
	private JTextField textFieldF_2;
	private JTextField textFieldF_3;
	private JTextField textFieldF_4;
	private JTextField textFieldF_5;
	private JTextField textFieldF_6;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupplierMenu window = new SupplierMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SupplierMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnFindSupplier = new JButton("Find supplier");
		btnFindSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findSupplier();
			}
		});
		btnFindSupplier.setBounds(0, 95, 109, 23);
		frame.getContentPane().add(btnFindSupplier);
		
		JButton btnUpdateSupplier = new JButton("Update supplier");
		btnFindSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnUpdateSupplier.setBounds(0, 119, 109, 23);
		frame.getContentPane().add(btnUpdateSupplier);
		
		JButton btnFindProductsBy = new JButton("Find products by supplier ");
		btnFindSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findProductsW();
			}
		});
		btnFindProductsBy.setBounds(0, 70, 162, 23);
		frame.getContentPane().add(btnFindProductsBy);
		
		JButton btnDeleteSupplier = new JButton("Delete supplier");
		btnFindSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDeleteSupplier.setBounds(0, 144, 109, 23);
		frame.getContentPane().add(btnDeleteSupplier);
		
		JLabel lblNewLabel = new JLabel("Supplier Menu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(151, 11, 132, 23);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(170, 71, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(119, 96, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(119, 120, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(119, 145, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnCreateSupplier = new JButton("Create supplier");
		btnCreateSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createSupplierW();
			}
		});
		btnCreateSupplier.setBounds(0, 169, 109, 23);
		frame.getContentPane().add(btnCreateSupplier);
					
		textField_4 = new JTextField();
		textField_4.setBounds(119, 170, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		
		
		
	}

	
	private void findProductsW() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Find Products by Supplier");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(151, 11, 132, 23);
		frame.getContentPane().add(lblNewLabel);    
	}
	
	private void findSupplierW() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Find Supplier");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(151, 11, 132, 23);
		frame.getContentPane().add(lblNewLabel);        
        
		JLabel lblName = new JLabel("Name");
		
		lblName.setBounds(0, 70, 109, 23);
		frame.getContentPane().add(lblName);
		   
		
		JLabel lblAddress = new JLabel("Address");
		
		lblAddress.setBounds(0, 95, 109, 23);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCountry = new JLabel("Country");
		
		lblCountry.setBounds(0, 119, 109, 23);
		frame.getContentPane().add(lblCountry);
		
		JLabel lblPhone = new JLabel("Phone");
		
		lblPhone.setBounds(0, 144, 109, 23);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		
		lblEmail.setBounds(0, 169, 109, 23);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblID = new JLabel("Supplier ID");
		
		lblID.setBounds(0, 195, 109, 23);
		frame.getContentPane().add(lblID);
		
        JLabel lblZip = new JLabel("Zip");
		
		lblZip.setBounds(0, 228, 109, 23);
		frame.getContentPane().add(lblZip);
		
		textFieldF = new JTextField();
		textFieldF.setBounds(119, 71, 86, 20);
		frame.getContentPane().add(textFieldF);
		textFieldF.setColumns(10);
		
		textFieldF_1 = new JTextField();
		textFieldF_1.setBounds(119, 96, 86, 20);
		frame.getContentPane().add(textFieldF_1);
		textFieldF_1.setColumns(10);
		
		textFieldF_2 = new JTextField();
		textFieldF_2.setBounds(119, 120, 86, 20);
		frame.getContentPane().add(textFieldF_2);
		textFieldF_2.setColumns(10);
		
		textFieldF_3 = new JTextField();
		textFieldF_3.setBounds(119, 145, 86, 20);
		frame.getContentPane().add(textFieldF_3);
		textFieldF_3.setColumns(10);
					
		textFieldF_4 = new JTextField();
		textFieldF_4.setBounds(119, 170, 86, 20);
		frame.getContentPane().add(textFieldF_4);
		textFieldF_4.setColumns(10);
		
		textFieldF_5 = new JTextField();
		textFieldF_5.setBounds(119, 196, 86, 20);
		frame.getContentPane().add(textFieldF_5);
		textFieldF_5.setColumns(10);
		
		textFieldF_6 = new JTextField();
		textFieldF_6.setBounds(119, 229, 86, 20);
		frame.getContentPane().add(textFieldF_6);
		textFieldF_6.setColumns(10);
	}
	private void updateSupplierW() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Update Supplier");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(151, 11, 132, 23);
		frame.getContentPane().add(lblNewLabel);        
	}
	private void createSupplierW() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Supplier");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(151, 11, 132, 23);
		frame.getContentPane().add(lblNewLabel);    
		
		JLabel lblName = new JLabel("Name");
		
		lblName.setBounds(0, 70, 109, 23);
		frame.getContentPane().add(lblName);
		   
		
		JLabel lblAddress = new JLabel("Address");
		
		lblAddress.setBounds(0, 95, 109, 23);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblCountry = new JLabel("Country");
		
		lblCountry.setBounds(0, 119, 109, 23);
		frame.getContentPane().add(lblCountry);
		
		JLabel lblPhone = new JLabel("Phone");
		
		lblPhone.setBounds(0, 144, 109, 23);
		frame.getContentPane().add(lblPhone);
		
		JLabel lblEmail = new JLabel("Email");
		
		lblEmail.setBounds(0, 169, 109, 23);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblID = new JLabel("Supplier ID");
		
		lblID.setBounds(0, 195, 109, 23);
		frame.getContentPane().add(lblID);
		
        JLabel lblZip = new JLabel("Zip");
		
		lblZip.setBounds(0, 228, 109, 23);
		frame.getContentPane().add(lblZip);
		
		textFieldC = new JTextField();
		textFieldC.setBounds(119, 71, 86, 20);
		frame.getContentPane().add(textFieldC);
		textFieldC.setColumns(10);
		
		textFieldC_1 = new JTextField();
		textFieldC_1.setBounds(119, 96, 86, 20);
		frame.getContentPane().add(textFieldC_1);
		textFieldC_1.setColumns(10);
		
		textFieldC_2 = new JTextField();
		textFieldC_2.setBounds(119, 120, 86, 20);
		frame.getContentPane().add(textFieldC_2);
		textFieldC_2.setColumns(10);
		
		textFieldC_3 = new JTextField();
		textFieldC_3.setBounds(119, 145, 86, 20);
		frame.getContentPane().add(textFieldC_3);
		textFieldC_3.setColumns(10);
					
		textFieldC_4 = new JTextField();
		textFieldC_4.setBounds(119, 170, 86, 20);
		frame.getContentPane().add(textFieldC_4);
		textFieldC_4.setColumns(10);
		
		textFieldC_5 = new JTextField();
		textFieldC_5.setBounds(119, 196, 86, 20);
		frame.getContentPane().add(textFieldC_5);
		textFieldC_5.setColumns(10);
		
		textFieldC_6 = new JTextField();
		textFieldC_6.setBounds(119, 229, 86, 20);
		frame.getContentPane().add(textFieldC_6);
		textFieldC_6.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createSupplier();
			}
		});
		btnCreate.setBounds(269, 228, 89, 23);
		frame.getContentPane().add(btnCreate);
	}
	private void findSupplier(){
		findSupplierW();
		String input = textField.getText();
		Supplier supplier = splctr.findSupplierByName(input);
		if(supplier!= null){
	    textFieldF.setText(""+supplier.getName());
	    textFieldF_1.setText(""+supplier.getAddress());
	    textFieldF_2.setText(""+supplier.getCountry());
	    textFieldF_3.setText(""+supplier.getPhoneNumber());
	    textFieldF_4.setText(""+supplier.getEmail());
	    textFieldF_5.setText(""+supplier.supplierID());
	    textFieldF_6.setText(""+supplier.getZip());
		
        
		}
	}
	
	private void createSupplier(){
		
	splctr.createSupplier(textFieldC.getText(), Float.parseFloat(textFieldC_1.getText()), Float.parseFloat(textFieldC_2.getText()), Integer.parseInt(textFieldC_3.getText()), Float.parseFloat(textFieldC_4.getText()), Integer.parseInt(textFieldC_5.getText()), Integer.parseInt(textFieldC_6.getText()));
		
}
	}