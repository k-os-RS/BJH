package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class management extends JFrame implements ActionListener {

	private JLabel lblBjh, lblFooter, lblFondo;
	private JButton btnHire, btnFired, btnEmployees, btnModifyEmployee, btnModifyProduct, btnShowStock, btnChangePass, btnLogout;
	metodos_db metodo = new metodos_db();

	public management() {
		//Frame
		setLayout(null);
		setResizable(false);
		setTitle("Administration Panel | Admin");
		setBounds(0, 0, 840, 640);
		setLocationRelativeTo(null);
		setBackground(new Color(54, 54, 54));
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());
		
		//Fonts
		Font title = new Font("Frank Ruehl CLM", 1, 62);
		Font text_message = new Font("Comic Sans MS", 3, 16);
		
		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(236, 20, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);

		btnHire = new JButton("Hire employee");
		btnHire.setBorder(null);
		btnHire.setFocusable(false);
		btnHire.addActionListener(this);
		btnHire.setBounds(150, 150, 130, 30);
		btnHire.setForeground(new Color(54, 54, 54));
		btnHire.setBackground(new Color(246, 190, 82));
		add(btnHire);

		btnFired = new JButton("Fire employee");
		btnFired.setBorder(null);
		btnFired.setFocusable(false);
		btnFired.addActionListener(this);
		btnFired.setBounds(150, 200, 130, 30);
		btnFired.setForeground(new Color(54, 54, 54));
		btnFired.setBackground(new Color(246, 190, 82));
		add(btnFired);
		
		btnModifyEmployee = new JButton("Modify employee");
		btnModifyEmployee.setBorder(null);
		btnModifyEmployee.setFocusable(false);
		btnModifyEmployee.addActionListener(this);
		btnModifyEmployee.setBounds(150, 250, 130, 30);
		btnModifyEmployee.setForeground(new Color(54, 54, 54));
		btnModifyEmployee.setBackground(new Color(246, 190, 82));
		add(btnModifyEmployee);
		
		btnEmployees = new JButton("Employees");
		btnEmployees.setBorder(null);
		btnEmployees.setFocusable(false);
		btnEmployees.addActionListener(this);
		btnEmployees.setBounds(350, 150, 130, 30);
		btnEmployees.setForeground(new Color(54, 54, 54));
		btnEmployees.setBackground(new Color(246, 190, 82));
		add(btnEmployees);
		
		btnShowStock = new JButton("Stock");
		btnShowStock.setBorder(null);
		btnShowStock.setFocusable(false);
		btnShowStock.addActionListener(this);
		btnShowStock.setBounds(350, 200, 130, 30);
		btnShowStock.setForeground(new Color(54, 54, 54));
		btnShowStock.setBackground(new Color(246, 190, 82));
		add(btnShowStock);
		
		btnModifyProduct = new JButton("Modify product");
		btnModifyProduct.setBorder(null);
		btnModifyProduct.setFocusable(false);
		btnModifyProduct.addActionListener(this);
		btnModifyProduct.setBounds(350, 250, 130, 30);
		btnModifyProduct.setForeground(new Color(54, 54, 54));
		btnModifyProduct.setBackground(new Color(246, 190, 82));
		add(btnModifyProduct);

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
	
	@Override
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

		if (event.equals(btnHire) ) {
			hire FrameHire = new hire();
			FrameHire.setVisible(true);
			this.setVisible(false);
		}

		if (event.equals(btnFired) ) {
			fire FrameFire = new fire();
			FrameFire.setVisible(true);
			this.setVisible(false);
		}

		if (event.equals(btnModifyEmployee)) {
			modify_employee FrameModifyEmployee = new modify_employee();
			FrameModifyEmployee.setVisible(true);
			this.setVisible(false);
		}

		if (event.equals(btnEmployees)) {
			workers FrameWorkers = new workers();
			FrameWorkers.setVisible(true);
			this.setVisible(false);
		}

		if (event.equals(btnModifyProduct)) {
			modify_product FrameModifyProduct = new modify_product();
			FrameModifyProduct.setVisible(true);
			this.setVisible(false);
		}

		if (event.equals(btnShowStock)) {
			stock FrameStock = new stock();
			FrameStock.setVisible(true);
			this.setVisible(false);
		}

	}

}
