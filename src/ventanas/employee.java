package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class employee extends JFrame implements ActionListener {

	private JLabel lblBjh, lblWelcome, lblFooter;
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
		Font text_message = new Font("Comic Sans MS", 3, 16);

		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(230, 20, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);

		lblWelcome = new JLabel("Welcome "+username+" to the employee panel");
		lblWelcome.setFont(fields);
		lblWelcome.setBounds(150, 100, 340, 30);
		lblWelcome.setForeground(new Color(0, 0, 0));
		add(lblWelcome);
		
		lblFooter = new JLabel("© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(250, 480, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		add(lblFooter);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		
		
	}
	
}
