package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class management extends JFrame implements ActionListener {

	private JLabel lblBjh, lblFooter;
	private JButton btnHire, btnFired, btnShow, btnShowAll, btnModify, btnRequest, btnChangePass, btnLogout;
	private JTextArea txtaShow;
	private JScrollPane spShow;
	metodos_db metodo = new metodos_db();
	
	public management() {
		//Frame
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Administration Panel | Admin");
		setBounds(0, 0, 640, 540);
		setLocationRelativeTo(null);
		//setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());
		
		//Fonts
		Font title = new Font("Frank Ruehl CLM", 1, 62);
		Font scroll = new Font("Andale Mono", 0, 14);
		Font text_message = new Font("Comic Sans MS", 3, 16);
		
		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(220, 20, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		getContentPane().add(lblBjh);
		
		btnHire = new JButton("Hire employee");
		btnHire.setBorder(null);
		btnHire.setFocusable(false);
		btnHire.addActionListener(this);
		btnHire.setBounds(50, 120, 115, 30);
		btnHire.setForeground(new Color(54, 54, 54));
		btnHire.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnHire);

		btnFired = new JButton("Fire employee");
		btnFired.setBorder(null);
		btnFired.setFocusable(false);
		btnFired.addActionListener(this);
		btnFired.setBounds(50, 170, 115, 30);
		btnFired.setForeground(new Color(54, 54, 54));
		btnFired.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnFired);
		
		btnModify = new JButton("Modify employee");
		btnModify.setBorder(null);
		btnModify.setFocusable(false);
		btnModify.addActionListener(this);
		btnModify.setBounds(50, 220, 115, 30);
		btnModify.setForeground(new Color(54, 54, 54));
		btnModify.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnModify);
		
		btnShow = new JButton("Show employee");
		btnShow.setBorder(null);
		btnShow.setFocusable(false);
		btnShow.addActionListener(this);
		btnShow.setBounds(50, 270, 115, 30);
		btnShow.setForeground(new Color(54, 54, 54));
		btnShow.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnShow);
		
		btnShowAll = new JButton("Show all employees");
		btnShowAll.setBorder(null);
		btnShowAll.setFocusable(false);
		btnShowAll.addActionListener(this);
		btnShowAll.setBounds(50, 320, 115, 30);
		btnShowAll.setForeground(new Color(54, 54, 54));
		btnShowAll.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnShowAll);
		
		btnRequest = new JButton("Request Item");
		btnRequest.setBorder(null);
		btnRequest.setFocusable(false);
		btnRequest.addActionListener(this);
		btnRequest.setBounds(435, 120, 115, 30);
		btnRequest.setForeground(new Color(54, 54, 54));
		btnRequest.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnRequest);
		
		btnChangePass = new JButton("Change Password");
		btnChangePass.setBorder(null);
		btnChangePass.setFocusable(false);
		btnChangePass.addActionListener(this);
		btnChangePass.setBounds(170, 420, 115, 30);
		btnChangePass.setForeground(new Color(54, 54, 54));
		btnChangePass.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnChangePass);
		
		btnLogout = new JButton("Log out");
		btnLogout.setBorder(null);
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(this);
		btnLogout.setBounds(310, 420, 115, 30);
		btnLogout.setForeground(new Color(54, 54, 54));
		btnLogout.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnLogout);
		
		txtaShow = new JTextArea();
		txtaShow.setFont(scroll);
		txtaShow.setEditable(false);
		txtaShow.setBackground(new Color (224, 224, 224));
		spShow = new JScrollPane(txtaShow);
		spShow.setBounds(190, 90, 220, 320);
		getContentPane().add(spShow);
		
		lblFooter = new JLabel("© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(240, 470, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		getContentPane().add(lblFooter);
		
	}

	public void actionPerformed(ActionEvent e) {
		//Object event = e.getSource();
		
		
		
	}
	
}
