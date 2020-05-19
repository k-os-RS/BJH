package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class client extends JFrame implements ActionListener {
	
	private JLabel lblBjh, lblIDProduct, lblFooter, lblFondo;
	private JButton btnPurchase, btnReserv, btnChangePass, btnLogout;
	private JTextField txtIDProduct;
	private ResultSet result;
	private JTable table;
	private JScrollPane scrollpane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] data = new String [4];
	metodos_db metodo = new metodos_db(); 
	String username = login.user;
	
	public client() {
		//Frame
		setLayout(null);
		setResizable(false);
		setTitle("Client Panel | "+username);
		setBounds(0, 0, 640, 540);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		btnPurchase = new JButton("Purchase");
		btnPurchase.setBorder(null);
		btnPurchase.setFocusable(false);
		btnPurchase.addActionListener(this);
		btnPurchase.setBounds(50, 230, 180, 30);
		btnPurchase.setForeground(new Color(54, 54, 54));
		btnPurchase.setBackground(new Color(246, 190, 82));
		add(btnPurchase);

		btnReserv = new JButton("Reserve");
		btnReserv.setBorder(null);
		btnReserv.setFocusable(false);
		btnReserv.addActionListener(this);
		btnReserv.setBounds(50, 280, 180, 30);
		btnReserv.setForeground(new Color(54, 54, 54));
		btnReserv.setBackground(new Color(246, 190, 82));
		add(btnReserv);
		
		table = new JTable();
		modelo.addColumn("ID");
		modelo.addColumn("Type");
		modelo.addColumn("Quantity");
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
		btnChangePass.setBounds(170, 420, 120, 30);
		btnChangePass.setForeground(new Color(54, 54, 54));
		btnChangePass.setBackground(new Color(246, 190, 82));
		add(btnChangePass);
		
		btnLogout = new JButton("Log out");
		btnLogout.setBorder(null);
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(this);
		btnLogout.setBounds(310, 420, 120, 30);
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
