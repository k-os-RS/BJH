package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import javax.swing.table.*;

import GRAFICOS.solicitud1;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class client extends JFrame implements ActionListener {
	
	private JLabel lblBjh, lblIDProduct, lblQuantity, lblFooter, lblFondo;
	private JButton btnPurchase, btnReserv, btnChangePass, btnLogout;
	private JTextField txtIDProduct, txtQuantity;
	private ResultSet result, result2;
	private JTable table;
	private JScrollPane scrollpane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTabbedPane tab;
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
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setFont(new Font("Gabriola", Font.BOLD, 25));
		tab.setBackground(new Color(224, 224, 224));
		tab.setBounds(0, 0, 640, 540);
		add(tab);
		
		client_interface ClientInterface = new client_interface();
		tab.addTab("Crear solicitud", ClientInterface);
		
		client_purchase ClientPurchase = new client_purchase();
		tab.addTab("Crear solicitud", ClientPurchase);

	}

	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
	}

}
