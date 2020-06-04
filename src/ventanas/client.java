package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class client extends JFrame implements ActionListener {
	
	private JButton btnLogout;
	private JTabbedPane tab;
	metodos_db metodo = new metodos_db(); 
	String username = login.user;

	public client() {
		//Frame
		getContentPane().setLayout(null);
		setResizable(false);
		setUndecorated(false);
		setBounds(0, 0, 840, 640);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());
		
		tab = new JTabbedPane(JTabbedPane.TOP);
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tab.setFont(new Font("Andale Mono", 0, 14));
		tab.setBackground(new Color(224, 224, 224));
		tab.setBounds(0, 0, 840, 640);
		getContentPane().add(tab);
		
		client_interface ClientInterface = new client_interface();
		tab.addTab(username, ClientInterface);
		
				btnLogout = new JButton("Log out");
				btnLogout.setBounds(460, 492, 120, 30);
				ClientInterface.add(btnLogout);
				btnLogout.setBorder(null);
				btnLogout.setFocusable(false);
				btnLogout.addActionListener(this);
				btnLogout.setForeground(new Color(54, 54, 54));
				btnLogout.setBackground(new Color(246, 190, 82));

		client_purchase ClientPurchase = new client_purchase();
		tab.addTab("Purchases", ClientPurchase);

	}
	
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		if (event.equals(btnLogout) ) {
			login FrameLogin = new login();
			FrameLogin.setVisible(true);
			dispose();
			
		}
		
	}

}
