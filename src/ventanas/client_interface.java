package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class client_interface extends JPanel implements ActionListener {

	private JLabel lblBjh, lblIDProduct, lblQuantity, lblEmpty, lblIDExist, lblNoQuantity, lblSuccess, lblFooter, lblFondo;
	private JButton btnPurchase, btnReserv, btnUpdateList, btnChangePass;
	private JTextField txtIDProduct, txtQuantity;
	private ResultSet result, result2;
	private JTable table;
	private JScrollPane scrollpane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] data = new String [5];
	metodos_db metodo = new metodos_db();
	String username = login.user;
	String id_product, quantity_product;
	int cliente_quantity, quant_pro;
	
	public client_interface() {
		//Frame
		setLayout(null);
		setBounds(0, 0, 840, 640);
		
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

		lblIDProduct = new JLabel("Product code: ");
		lblIDProduct.setFont(scroll);
		lblIDProduct.setBounds(50, 110, 120, 30);
		lblIDProduct.setForeground(new Color(54, 54, 54));
		add(lblIDProduct);

		txtIDProduct = new JTextField();
		txtIDProduct.setBorder(null);
		txtIDProduct.setBounds(100, 140, 130, 30);
		txtIDProduct.setForeground(new Color(54, 54, 54));
		txtIDProduct.setBackground(new Color (224, 224, 224));
		txtIDProduct.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtIDProduct);

		lblQuantity = new JLabel("Quantity: ");
		lblQuantity.setFont(scroll);
		lblQuantity.setBounds(50, 180, 100, 30);
		lblQuantity.setForeground(new Color(54, 54, 54));
		add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setBorder(null);
		txtQuantity.setBounds(100, 210, 130, 30);
		txtQuantity.setForeground(new Color(54, 54, 54));
		txtQuantity.setBackground(new Color (224, 224, 224));
		txtQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtQuantity);
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.setBorder(null);
		btnPurchase.setFocusable(false);
		btnPurchase.addActionListener(this);
		btnPurchase.setBounds(50, 299, 180, 30);
		btnPurchase.setForeground(new Color(54, 54, 54));
		btnPurchase.setBackground(new Color(246, 190, 82));
		add(btnPurchase);

		btnReserv = new JButton("Reserve");
		btnReserv.setBorder(null);
		btnReserv.setFocusable(false);
		btnReserv.addActionListener(this);
		btnReserv.setBounds(50, 358, 180, 30);
		btnReserv.setForeground(new Color(54, 54, 54));
		btnReserv.setBackground(new Color(246, 190, 82));
		add(btnReserv);
		
		btnUpdateList = new JButton("Update list");
		btnUpdateList.setBorder(null);
		btnUpdateList.setFocusable(false);
		btnUpdateList.addActionListener(this);
		btnUpdateList.setBounds(50, 412, 180, 30);
		btnUpdateList.setForeground(new Color(54, 54, 54));
		btnUpdateList.setBackground(new Color(246, 190, 82));
		add(btnUpdateList);
		
		table = new JTable();
		modelo.addColumn("Product code");
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
					data[2] = result2.getString(2);
				}
				data[1] = result.getString(3);
				data[3] = result.getString(4);
				data[4] = result.getString(5);
				modelo.addRow(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(250, 110, 550, 332);
		add(scrollpane);
		
		lblEmpty = new JLabel("Please fill all fields.");
		lblEmpty.setFont(scroll);
		lblEmpty.setVisible(false);
		lblEmpty.setBounds(330, 453, 159, 30);
		lblEmpty.setForeground(new Color(255, 0, 0));
		add(lblEmpty);
		
		lblNoQuantity = new JLabel("Insufficient quantity, needs to be reserved.");
		lblNoQuantity.setFont(scroll);
		lblNoQuantity.setVisible(false);
		lblNoQuantity.setBounds(250, 453, 340, 30);
		lblNoQuantity.setForeground(new Color(255, 0, 0));
		add(lblNoQuantity);

		lblIDExist = new JLabel("This ID Product don't exists.");
		lblIDExist.setFont(scroll);
		lblIDExist.setVisible(false);
		lblIDExist.setBounds(314, 453, 230, 30);
		lblIDExist.setForeground(new Color(255, 0, 0));
		add(lblIDExist);
		
		lblSuccess = new JLabel("The purchase was successful.");
		lblSuccess.setFont(scroll);
		lblSuccess.setVisible(false);
		lblSuccess.setBounds(314, 453, 250, 30);
		lblSuccess.setForeground(new Color(0, 255, 0));
		add(lblSuccess);
		
		btnChangePass = new JButton("Change Password");
		btnChangePass.setBorder(null);
		btnChangePass.setFocusable(false);
		btnChangePass.addActionListener(this);
		btnChangePass.setBounds(260, 494, 120, 30);
		btnChangePass.setForeground(new Color(54, 54, 54));
		btnChangePass.setBackground(new Color(246, 190, 82));
		add(btnChangePass);
		
		lblFooter = new JLabel("© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(445, 599, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		add(lblFooter);
		
		ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_panel.png"));
		lblFondo = new JLabel(fondo);
		lblFondo.setBounds(0, 0, 840, 640);
		add(lblFondo);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		if (event.equals(btnChangePass) ) {
			changepass FrameChangePass = new changepass();
			FrameChangePass.setVisible(true);
			this.setVisible(false);
			
		}

		if (event.equals(btnPurchase) ) {
			try {

				id_product = txtIDProduct.getText().trim();
				quantity_product = txtQuantity.getText().trim();
				quant_pro = metodo.ShowQuantityProduct(id_product);
				if (!id_product.isEmpty() || !quantity_product.isEmpty()) {
					if (metodo.IDProductExist(id_product)) {
						cliente_quantity = Integer.parseInt(quantity_product);
						if (cliente_quantity <= quant_pro) {
							metodo.addPurchase(username, id_product, cliente_quantity);
							lblEmpty.setVisible(false);
							lblNoQuantity.setVisible(false);
							lblIDExist.setVisible(false);
							lblSuccess.setVisible(true);
						} else {
							lblEmpty.setVisible(false);
							lblNoQuantity.setVisible(true);
							lblIDExist.setVisible(false);
							lblSuccess.setVisible(false);
						}
					} else {
						lblEmpty.setVisible(false);
						lblNoQuantity.setVisible(false);
						lblIDExist.setVisible(true);
						lblSuccess.setVisible(false);
					}
				} else {
					lblEmpty.setVisible(true);
					lblNoQuantity.setVisible(false);
					lblIDExist.setVisible(false);
					lblSuccess.setVisible(false);
				}
				
			} catch (Exception e2) {
				e2.getStackTrace();
			}
			
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
				e2.getStackTrace();
			}
			
		}

		
		
	}

}
