package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class management extends JFrame implements ActionListener {

	private JLabel lblBjh, lblFooter;
	private JButton btnHire, btnFired, btnShow, btnShowFired, btnShowAll, btnModify, btnRequest, btnShowItem, btnShowAllItem, btnChangePass, btnLogout;
	private JTextArea txtaShow;
	private JScrollPane spShow;
	metodos_db metodo = new metodos_db();
	
	public management() {
		//Frame
		setLayout(null);
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
		add(lblBjh);
		
		btnHire = new JButton("Hire employee");
		btnHire.setBorder(null);
		btnHire.setFocusable(false);
		btnHire.addActionListener(this);
		btnHire.setBounds(50, 120, 115, 30);
		btnHire.setForeground(new Color(54, 54, 54));
		btnHire.setBackground(new Color(246, 190, 82));
		add(btnHire);

		btnFired = new JButton("Fire employee");
		btnFired.setBorder(null);
		btnFired.setFocusable(false);
		btnFired.addActionListener(this);
		btnFired.setBounds(50, 170, 115, 30);
		btnFired.setForeground(new Color(54, 54, 54));
		btnFired.setBackground(new Color(246, 190, 82));
		add(btnFired);
		
		btnModify = new JButton("Modify employee");
		btnModify.setBorder(null);
		btnModify.setFocusable(false);
		btnModify.addActionListener(this);
		btnModify.setBounds(50, 220, 115, 30);
		btnModify.setForeground(new Color(54, 54, 54));
		btnModify.setBackground(new Color(246, 190, 82));
		add(btnModify);
		
		btnShow = new JButton("Show employee");
		btnShow.setBorder(null);
		btnShow.setFocusable(false);
		btnShow.addActionListener(this);
		btnShow.setBounds(50, 270, 115, 30);
		btnShow.setForeground(new Color(54, 54, 54));
		btnShow.setBackground(new Color(246, 190, 82));
		add(btnShow);
		
		btnShowFired = new JButton("Show fired employee");
		btnShowFired.setBorder(null);
		btnShowFired.setFocusable(false);
		btnShowFired.addActionListener(this);
		btnShowFired.setBounds(50, 320, 115, 30);
		btnShowFired.setForeground(new Color(54, 54, 54));
		btnShowFired.setBackground(new Color(246, 190, 82));
		add(btnShowFired);

		btnShowAll = new JButton("Show all employees");
		btnShowAll.setBorder(null);
		btnShowAll.setFocusable(false);
		btnShowAll.addActionListener(this);
		btnShowAll.setBounds(50, 370, 115, 30);
		btnShowAll.setForeground(new Color(54, 54, 54));
		btnShowAll.setBackground(new Color(246, 190, 82));
		add(btnShowAll);
		
		btnRequest = new JButton("Request Item");
		btnRequest.setBorder(null);
		btnRequest.setFocusable(false);
		btnRequest.addActionListener(this);
		btnRequest.setBounds(435, 120, 115, 30);
		btnRequest.setForeground(new Color(54, 54, 54));
		btnRequest.setBackground(new Color(246, 190, 82));
		add(btnRequest);
		
		btnShowItem = new JButton("Show Item");
		btnShowItem.setBorder(null);
		btnShowItem.setFocusable(false);
		btnShowItem.addActionListener(this);
		btnShowItem.setBounds(435, 170, 115, 30);
		btnShowItem.setForeground(new Color(54, 54, 54));
		btnShowItem.setBackground(new Color(246, 190, 82));
		add(btnShowItem);
		
		btnShowAllItem = new JButton("Show inventory");
		btnShowAllItem.setBorder(null);
		btnShowAllItem.setFocusable(false);
		btnShowAllItem.addActionListener(this);
		btnShowAllItem.setBounds(435, 220, 115, 30);
		btnShowAllItem.setForeground(new Color(54, 54, 54));
		btnShowAllItem.setBackground(new Color(246, 190, 82));
		add(btnShowAllItem);
		
		btnChangePass = new JButton("Change Password");
		btnChangePass.setBorder(null);
		btnChangePass.setFocusable(false);
		btnChangePass.addActionListener(this);
		btnChangePass.setBounds(170, 420, 115, 30);
		btnChangePass.setForeground(new Color(54, 54, 54));
		btnChangePass.setBackground(new Color(246, 190, 82));
		add(btnChangePass);
		
		btnLogout = new JButton("Log out");
		btnLogout.setBorder(null);
		btnLogout.setFocusable(false);
		btnLogout.addActionListener(this);
		btnLogout.setBounds(310, 420, 115, 30);
		btnLogout.setForeground(new Color(54, 54, 54));
		btnLogout.setBackground(new Color(246, 190, 82));
		add(btnLogout);
		
		txtaShow = new JTextArea();
		txtaShow.setFont(scroll);
		txtaShow.setEditable(false);
		txtaShow.setBackground(new Color (224, 224, 224));
		spShow = new JScrollPane(txtaShow);
		spShow.setBounds(190, 90, 220, 320);
		add(spShow);
		
		lblFooter = new JLabel("© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(240, 470, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		add(lblFooter);

	}

	public void actionPerformed(ActionEvent e) {
		//Object event = e.getSource();
		
		
		
	}
	
}
