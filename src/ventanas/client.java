package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class client extends JFrame {
	
	private JTabbedPane tab;
	metodos_db metodo = new metodos_db(); 
	String username = login.user;

	public client() {
		//Frame
		getContentPane().setLayout(null);
		setResizable(false);
		setUndecorated(false);
		setBounds(0, 0, 640, 540);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.setFont(new Font("Andale Mono", 0, 14));
		tab.setBackground(new Color(224, 224, 224));
		tab.setBounds(0, 0, 640, 540);
		getContentPane().add(tab);
		
		client_interface ClientInterface = new client_interface();
		tab.addTab(username, ClientInterface);
		
		client_purchase ClientPurchase = new client_purchase();
		tab.addTab("Purchases", ClientPurchase);

	}

}
