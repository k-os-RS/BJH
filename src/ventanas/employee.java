package ventanas;

import gestion_db.metodos_db;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class employee extends JFrame implements ActionListener {

	private JLabel lblBjh, lblWelcome, lblIDClient, lblStock, lblIDEmpty, lblIDExist, lblFooter, lblFondo;
	private JTextField txtIDClient;
	private JButton btnComplete, btnUpdateList, btnChangePass, btnLogout;
	private ResultSet result, result2;
	private JTable table;
	private JScrollPane scrollpane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] data = new String [6];
	metodos_db metodo = new metodos_db();
	String username = login.user, id_product, id_client;

	public employee() {
		//Frame
		setLayout(null);
		setResizable(false);
		setTitle("Employee Panel | "+username);
		setBounds(0, 0, 840, 640);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());

		//Fonts
		Font title = new Font("Frank Ruehl CLM", 1, 62);
		Font fields = new Font("Comic Sans MS", 1, 16);
		Font scroll = new Font("Andale Mono", 0, 18);
		Font tabled = new Font("Andale Mono", 2, 12);
		Font text_message = new Font("Comic Sans MS", 3, 16);

		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(320, 10, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);

		lblWelcome = new JLabel("Welcome "+username+" to the employee panel");
		lblWelcome.setFont(fields);
		lblWelcome.setBounds(260, 80, 300, 20);
		lblWelcome.setForeground(new Color(0, 0, 0));
		add(lblWelcome);

		lblIDClient = new JLabel("Purchase code: ");
		lblIDClient.setFont(scroll);
		lblIDClient.setBounds(50, 143, 130, 30);
		lblIDClient.setForeground(new Color(54, 54, 54));
		add(lblIDClient);

		txtIDClient = new JTextField();
		txtIDClient.setBorder(null);
		txtIDClient.setBounds(100, 198, 130, 30);
		txtIDClient.setForeground(new Color(54, 54, 54));
		txtIDClient.setBackground(new Color (224, 224, 224));
		txtIDClient.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtIDClient);

		btnComplete = new JButton("Complete purchase");
		btnComplete.setBorder(null);
		btnComplete.setFocusable(false);
		btnComplete.addActionListener(this);
		btnComplete.setBounds(50, 330, 180, 30);
		btnComplete.setForeground(new Color(54, 54, 54));
		btnComplete.setBackground(new Color(246, 190, 82));
		add(btnComplete);
		
		btnUpdateList = new JButton("Update list");
		btnUpdateList.setBorder(null);
		btnUpdateList.setFocusable(false);
		btnUpdateList.addActionListener(this);
		btnUpdateList.setBounds(50, 400, 180, 30);
		btnUpdateList.setForeground(new Color(54, 54, 54));
		btnUpdateList.setBackground(new Color(246, 190, 82));
		add(btnUpdateList);

		table = new JTable();
		modelo.addColumn("Purchase code");
		modelo.addColumn("Product");
		modelo.addColumn("Quantity product");
		modelo.addColumn("Quantity sold");
		modelo.addColumn("Date");
		modelo.addColumn("State");
		table.setFont(tabled);
		table.setModel(modelo);
		try {

			result = metodo.ShowPurchases();
			modelo.setRowCount(0);
			while (result.next()) {
				result2 = metodo.ShowProduct(result.getString(2));
				data[0] = result.getString(3);
				while (result2.next()) {
					data[1] = result2.getString(3);
					data[2] = result2.getString(4);
				}
				data[3] = result.getString(4);
				data[4] = result.getString(5);
				data[5] = result.getString(6);
				modelo.addRow(data);
			}
			
		} catch (Exception e2) {
			e2.getStackTrace();
		}

		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(258, 111, 535, 332);
		add(scrollpane);
		
		lblStock = new JLabel("Still in stock, no need to order.");
		lblStock.setFont(scroll);
		lblStock.setVisible(false);
		lblStock.setBounds(269, 454, 260, 30);
		lblStock.setForeground(new Color(255, 0, 0));
		add(lblStock);
		
		lblIDEmpty = new JLabel("Please fill in the ID Product field.");
		lblIDEmpty.setFont(scroll);
		lblIDEmpty.setVisible(false);
		lblIDEmpty.setBounds(258, 454, 260, 30);
		lblIDEmpty.setForeground(new Color(255, 0, 0));
		add(lblIDEmpty);
		
		lblIDExist = new JLabel("This ID Product don't exists.");
		lblIDExist.setFont(scroll);
		lblIDExist.setVisible(false);
		lblIDExist.setBounds(288, 454, 230, 30);
		lblIDExist.setForeground(new Color(255, 0, 0));
		add(lblIDExist);
		
		btnChangePass = new JButton("Change Password");
		btnChangePass.setBorder(null);
		btnChangePass.setFocusable(false);
		btnChangePass.addActionListener(this);
		btnChangePass.setBounds(212, 495, 130, 30);
		btnChangePass.setForeground(new Color(54, 54, 54));
		btnChangePass.setBackground(new Color(246, 190, 82));
		add(btnChangePass);

		btnLogout = new JButton("Log out");
		btnLogout.setBorder(null);
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(this);
		btnLogout.setBounds(480, 495, 130, 30);
		btnLogout.setForeground(new Color(54, 54, 54));
		btnLogout.setBackground(new Color(246, 190, 82));
		add(btnLogout);

		lblFooter = new JLabel("© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(439, 570, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		add(lblFooter);

		ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_panel.png"));
		lblFondo = new JLabel(fondo);
		lblFondo.setBounds(0, 0, 834, 611);
		add(lblFondo);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		if (event.equals(btnComplete) ) {
			try {

				id_client = txtIDClient.getText().trim();
				
				if (!id_client.isEmpty() || !id_product.isEmpty()) {
					if (metodo.PurchaseExist(id_client)) {
						metodo.PurchaseAccept(id_client);
						txtIDClient.setText("");
						
						result = metodo.ShowPurchases();
						modelo.setRowCount(0);
						while (result.next()) {
							result2 = metodo.ShowProduct(result.getString(2));
							data[0] = result.getString(3);
							while (result2.next()) {
								data[1] = result2.getString(3);
								data[2] = result2.getString(4);
							}
							data[3] = result.getString(4);
							data[4] = result.getString(5);
							data[5] = result.getString(6);
							modelo.addRow(data);
						}
						
					} else {
						JOptionPane.showConfirmDialog(null, "Fallo al agregar");
					}
				} else {
					JOptionPane.showConfirmDialog(null, "Empty");
				}
				
			} catch (Exception e2) {
				e2.getStackTrace();
			}
			
		}
		
		if (event.equals(btnUpdateList) ) {
			try {

				result = metodo.ShowPurchases();
				modelo.setRowCount(0);
				while (result.next()) {
					result2 = metodo.ShowProduct(result.getString(2));
					data[0] = result.getString(3);
					while (result2.next()) {
						data[1] = result2.getString(3);
						data[2] = result2.getString(4);
					}
					data[3] = result.getString(4);
					data[4] = result.getString(5);
					data[5] = result.getString(6);
					modelo.addRow(data);
				}
				
			} catch (Exception e2) {
				e2.getStackTrace();
			}
			
		}
		
		if (event.equals(btnChangePass) ) {
			changepass FrameChangePass = new changepass();
			FrameChangePass.setVisible(true);
			this.setVisible(false);
		}

		if (event.equals(btnLogout) ) {
			login FrameLogin = new login();
			FrameLogin.setVisible(true);
			this.setVisible(false);
		}
		
	}
	
}
