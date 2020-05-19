package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class stock extends JFrame implements ActionListener {

	public static String id_pro;
	private JLabel lblBjh, lblIDProduct, lblStock, lblIDEmpty, lblIDExist, lblFooter, lblFondo;
	private JButton btnRequestProduct, btnAddProduct, btnUpdateList, btnCancel;
	private JTextField txtIDProduct;
	private ResultSet result, result2;
	private JTable table;
	private JScrollPane scrollpane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] data = new String [5];
	metodos_db metodo = new metodos_db();
	String id_product;
	
	public stock() {
		//Frame
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setTitle("Stock panel");
		setBounds(0, 0, 640, 540);
		setLocationRelativeTo(null);
		setBackground(new Color(54, 54, 54));
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());

		//Fonts
		Font title = new Font("Frank Ruehl CLM", 1, 62);
		Font scroll = new Font("Andale Mono", 0, 18);
		Font tabled = new Font("Andale Mono", 2, 12);
		Font text_message = new Font("Comic Sans MS", 3, 16);
		
		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(236, 20, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);

		lblIDProduct = new JLabel("ID Product: ");
		lblIDProduct.setFont(scroll);
		lblIDProduct.setBounds(50, 130, 100, 30);
		lblIDProduct.setForeground(new Color(54, 54, 54));
		add(lblIDProduct);
		
		txtIDProduct = new JTextField();
		txtIDProduct.setBorder(null);
		txtIDProduct.setBounds(100, 180, 130, 30);
		txtIDProduct.setForeground(new Color(54, 54, 54));
		txtIDProduct.setBackground(new Color (224, 224, 224));
		txtIDProduct.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtIDProduct);
		
		btnRequestProduct = new JButton("Request product");
		btnRequestProduct.setBorder(null);
		btnRequestProduct.setFocusable(false);
		btnRequestProduct.addActionListener(this);
		btnRequestProduct.setBounds(50, 230, 180, 30);
		btnRequestProduct.setForeground(new Color(54, 54, 54));
		btnRequestProduct.setBackground(new Color(246, 190, 82));
		add(btnRequestProduct);

		btnAddProduct = new JButton("Add new product");
		btnAddProduct.setBorder(null);
		btnAddProduct.setFocusable(false);
		btnAddProduct.addActionListener(this);
		btnAddProduct.setBounds(50, 280, 180, 30);
		btnAddProduct.setForeground(new Color(54, 54, 54));
		btnAddProduct.setBackground(new Color(246, 190, 82));
		add(btnAddProduct);
		
		btnUpdateList = new JButton("Update list");
		btnUpdateList.setBorder(null);
		btnUpdateList.setFocusable(false);
		btnUpdateList.addActionListener(this);
		btnUpdateList.setBounds(50, 330, 180, 30);
		btnUpdateList.setForeground(new Color(54, 54, 54));
		btnUpdateList.setBackground(new Color(246, 190, 82));
		add(btnUpdateList);
		
		table = new JTable();
		modelo.addColumn("ID");
		modelo.addColumn("Name");
		modelo.addColumn("Type");
		modelo.addColumn("Quantity");
		modelo.addColumn("Price");
		table.setFont(tabled);
		table.setModel(modelo);
		try {
			
			result = metodo.ShowProducts();
			modelo.setRowCount(0);
			while (result.next()) {
				result2 = metodo.ShowTypes(result.getInt(2));
				data[0] = result.getString(1);
				while (result2.next()) {
					data[1] = result2.getString(2);
				}
				data[2] = result.getString(3);
				data[3] = result.getString(4);
				data[4] = result.getString(5);
				modelo.addRow(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(250, 110, 385, 250);
		add(scrollpane);
		
		lblStock = new JLabel("Still in stock, no need to order.");
		lblStock.setFont(scroll);
		lblStock.setVisible(false);
		lblStock.setBounds(180, 380, 260, 30);
		lblStock.setForeground(new Color(255, 0, 0));
		add(lblStock);
		
		lblIDEmpty = new JLabel("Please fill in the ID Product field.");
		lblIDEmpty.setFont(scroll);
		lblIDEmpty.setVisible(false);
		lblIDEmpty.setBounds(180, 380, 260, 30);
		lblIDEmpty.setForeground(new Color(255, 0, 0));
		add(lblIDEmpty);
		
		lblIDExist = new JLabel("This ID Product don't exists.");
		lblIDExist.setFont(scroll);
		lblIDExist.setVisible(false);
		lblIDExist.setBounds(180, 380, 230, 30);
		lblIDExist.setForeground(new Color(255, 0, 0));
		add(lblIDExist);
		
		btnCancel = new JButton("Close");
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(230, 420, 130, 30);
		btnCancel.setForeground(new Color(54, 54, 54));
		btnCancel.setBackground(new Color(246, 190, 82));
		add(btnCancel);

		lblFooter = new JLabel("© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(250, 480, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		add(lblFooter);
		
		ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_panel.png"));
		lblFondo = new JLabel(fondo);
		lblFondo.setBounds(0, 0, 640, 540);
		add(lblFondo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		if (event.equals(btnRequestProduct) ) {
			try {
				
				id_product = txtIDProduct.getText().trim();
				
				if (!id_product.isEmpty()) {
					if (metodo.IDProductExist(id_product)) {
						int quantity_product = metodo.ShowQuantityProduct(id_product);
						if (quantity_product == 0) {
							id_pro = id_product;
							request_product FrameRequest = new request_product();
							FrameRequest.setVisible(true);
							this.setVisible(false);
						} else {
							lblStock.setVisible(true);
							lblIDEmpty.setVisible(false);
							lblIDExist.setVisible(false);
						}
					} else {
						lblStock.setVisible(false);
						lblIDEmpty.setVisible(false);
						lblIDExist.setVisible(true);
					}
				} else {
					lblStock.setVisible(false);
					lblIDEmpty.setVisible(true);
					lblIDExist.setVisible(false);
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		if (event.equals(btnAddProduct) ) {
			products FrameProducts = new products();
			FrameProducts.setVisible(true);
			this.setVisible(false);
			
		}
		
		if (event.equals(btnUpdateList) ) {
			try {
				
				result = metodo.ShowProducts();
				modelo.setRowCount(0);
				while (result.next()) {
					result2 = metodo.ShowTypes(result.getInt(2));
					data[0] = result.getString(1);
					while (result2.next()) {
						data[1] = result2.getString(2);
					}
					data[2] = result.getString(3);
					data[3] = result.getString(4);
					data[4] = result.getString(5);
					modelo.addRow(data);
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		if (event.equals(btnCancel) ) {
			management FrameManagement = new management();
			FrameManagement.setVisible(true);
			this.setVisible(false);
			
		}
		
	}

}
