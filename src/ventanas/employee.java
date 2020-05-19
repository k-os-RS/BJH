package ventanas;

import gestion_db.metodos_db;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class employee extends JFrame implements ActionListener {

	private JLabel lblBjh, lblWelcome, lblIDClient ,lblIDProduct, lblFooter, lblFondo;
	private JTextField txtIDClient, txtIDProduct;
	private JButton btnComplete, btnApply, btnChangePass, btnLogout;
	private ResultSet result;
	private JTable table;
	private JScrollPane scrollpane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] data = new String [4];
	metodos_db metodo = new metodos_db();
	String username = login.user;
	
	public employee() {
		//Frame
		setLayout(null);
		setResizable(false);
		setTitle("Employee Panel | "+username);
		setBounds(0, 0, 640, 540);
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
		lblBjh.setBounds(236, 20, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);

		lblWelcome = new JLabel("Welcome "+username+" to the employee panel");
		lblWelcome.setFont(fields);
		lblWelcome.setBounds(170, 80, 300, 20);
		lblWelcome.setForeground(new Color(0, 0, 0));
		add(lblWelcome);

		lblIDClient = new JLabel("ID Client: ");
		lblIDClient.setFont(scroll);
		lblIDClient.setBounds(50, 110, 100, 30);
		lblIDClient.setForeground(new Color(54, 54, 54));
		add(lblIDClient);

		txtIDClient = new JTextField();
		txtIDClient.setBorder(null);
		txtIDClient.setBounds(100, 210, 130, 30);
		txtIDClient.setForeground(new Color(54, 54, 54));
		txtIDClient.setBackground(new Color (224, 224, 224));
		txtIDClient.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtIDClient);

		lblIDProduct = new JLabel("ID Product: ");
		lblIDProduct.setFont(scroll);
		lblIDProduct.setBounds(50, 180, 100, 30);
		lblIDProduct.setForeground(new Color(54, 54, 54));
		add(lblIDProduct);

		txtIDProduct = new JTextField();
		txtIDProduct.setBorder(null);
		txtIDProduct.setBounds(100, 140, 130, 30);
		txtIDProduct.setForeground(new Color(54, 54, 54));
		txtIDProduct.setBackground(new Color (224, 224, 224));
		txtIDProduct.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtIDProduct);

		btnComplete = new JButton("Complete purchase");
		btnComplete.setBorder(null);
		btnComplete.setFocusable(false);
		btnComplete.addActionListener(this);
		btnComplete.setBounds(50, 280, 180, 30);
		btnComplete.setForeground(new Color(54, 54, 54));
		btnComplete.setBackground(new Color(246, 190, 82));
		add(btnComplete);

		btnApply = new JButton("Request product");
		btnApply.setBorder(null);
		btnApply.setFocusable(false);
		btnApply.addActionListener(this);
		btnApply.setBounds(50, 330, 180, 30);
		btnApply.setForeground(new Color(54, 54, 54));
		btnApply.setBackground(new Color(246, 190, 82));
		add(btnApply);
		
		table = new JTable();
		modelo.addColumn("ID");
		modelo.addColumn("Type");
		modelo.addColumn("Stock");
		modelo.addColumn("Price");
		table.setFont(tabled);
		table.setModel(modelo);

		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(250, 110, 350, 250);
		add(scrollpane);

		btnChangePass = new JButton("Change Password");
		btnChangePass.setBorder(null);
		btnChangePass.setFocusable(false);
		btnChangePass.addActionListener(this);
		btnChangePass.setBounds(180, 420, 130, 30);
		btnChangePass.setForeground(new Color(54, 54, 54));
		btnChangePass.setBackground(new Color(246, 190, 82));
		add(btnChangePass);

		btnLogout = new JButton("Log out");
		btnLogout.setBorder(null);
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(this);
		btnLogout.setBounds(320, 420, 130, 30);
		btnLogout.setForeground(new Color(54, 54, 54));
		btnLogout.setBackground(new Color(246, 190, 82));
		add(btnLogout);

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
	
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
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
