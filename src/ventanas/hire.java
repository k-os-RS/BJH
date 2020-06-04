package ventanas;

import gestion_db.metodos_db;
import java.sql.*;
import clases.comprobaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class hire extends JFrame implements ActionListener {

	private JLabel lblBjh, lblDNI, lblName, lblLastnames, lblAddress, lblEmail, lblUsername, lblPassword, lblNoDNI, lblNoEmail, lblNoPass, lblExist, lblHired, lblFooter, lblFondo;
	private JTextField txtDNI, txtName, txtLastnames, txtAddress, txtEmail, txtUsername;
	private JPasswordField txtPassword;
	private JButton btnSave, btnCancel;
	private ResultSet data;
	metodos_db metodo = new metodos_db();
	comprobaciones comprob = new comprobaciones();
	String dni, name, last_names, address, email, username, password, empleado = "si";
	
	public hire() {
		//Frame
		getContentPane().setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setTitle("Recruitment panel");
		setBounds(0, 0, 840, 640);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());
		
		//Fonts
		Font title = new Font("Frank Ruehl CLM", 1, 62);
		Font fields = new Font("Comic Sans MS", 1, 16);
		Font text_message = new Font("Comic Sans MS", 3, 16);

		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(334, 42, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		getContentPane().add(lblBjh);
		
		lblDNI = new JLabel("DNI: ");
		lblDNI.setFont(fields);
		lblDNI.setBounds(175, 155, 110, 30);
		lblDNI.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBorder(null);
		txtDNI.setBounds(295, 155, 110, 30);
		txtDNI.setForeground(new Color(54, 54, 54));
		txtDNI.setBackground(new Color (224, 224, 224));
		txtDNI.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtDNI);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(fields);
		lblName.setBounds(175, 215, 110, 30);
		lblName.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setBorder(null);
		txtName.setBounds(295, 215, 110, 30);
		txtName.setForeground(new Color(54, 54, 54));
		txtName.setBackground(new Color (224, 224, 224));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtName);
		
		lblLastnames = new JLabel("Last names: ");
		lblLastnames.setFont(fields);
		lblLastnames.setBounds(175, 275, 110, 30);
		lblLastnames.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblLastnames);
		
		txtLastnames = new JTextField();
		txtLastnames.setBorder(null);
		txtLastnames.setBounds(295, 275, 110, 30);
		txtLastnames.setForeground(new Color(54, 54, 54));
		txtLastnames.setBackground(new Color (224, 224, 224));
		txtLastnames.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtLastnames);
		
		lblAddress = new JLabel("Address: ");
		lblAddress.setFont(fields);
		lblAddress.setBounds(175, 335, 110, 30);
		lblAddress.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBorder(null);
		txtAddress.setBounds(295, 335, 110, 30);
		txtAddress.setForeground(new Color(54, 54, 54));
		txtAddress.setBackground(new Color (224, 224, 224));
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtAddress);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(fields);
		lblEmail.setBounds(435, 185, 110, 30);
		lblEmail.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setText("@bjh.com");
		txtEmail.setBounds(535, 185, 110, 30);
		txtEmail.setForeground(new Color(54, 54, 54));
		txtEmail.setBackground(new Color (224, 224, 224));
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtEmail);
		
		lblUsername = new JLabel("Username: ");
		lblUsername.setFont(fields);
		lblUsername.setBounds(435, 245, 110, 30);
		lblUsername.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setBounds(535, 245, 110, 30);
		txtUsername.setForeground(new Color(54, 54, 54));
		txtUsername.setBackground(new Color (224, 224, 224));
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtUsername);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setFont(fields);
		lblPassword.setBounds(435, 305, 110, 30);
		lblPassword.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.setEchoChar('⬛');
		txtPassword.setBounds(535, 305, 110, 30);
		txtPassword.setForeground(new Color(54, 54, 54));
		txtPassword.setBackground(new Color (224, 224, 224));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtPassword);
		
		lblNoDNI = new JLabel("The employee's DNI is incorrect.");
		lblNoDNI.setFont(fields);
		lblNoDNI.setBounds(282, 466, 269, 30);
		lblNoDNI.setForeground(new Color(255, 0, 0));
		lblNoDNI.setVisible(false);
		getContentPane().add(lblNoDNI);
		
		lblNoEmail = new JLabel("The employee's email is incorrect.");
		lblNoEmail.setFont(fields);
		lblNoEmail.setBounds(279, 466, 286, 30);
		lblNoEmail.setForeground(new Color(255, 0, 0));
		lblNoEmail.setVisible(false);
		getContentPane().add(lblNoEmail);
		
		lblNoPass = new JLabel("The password must be at least 6 chars.");
		lblNoPass.setFont(fields);
		lblNoPass.setBounds(279, 466, 322, 30);
		lblNoPass.setForeground(new Color(255, 0, 0));
		lblNoPass.setVisible(false);
		getContentPane().add(lblNoPass);
		
		lblExist = new JLabel("There's already an employee with this DNI.");
		lblExist.setFont(fields);
		lblExist.setBounds(251, 466, 350, 30);
		lblExist.setForeground(new Color(255, 0, 0));
		lblExist.setVisible(false);
		getContentPane().add(lblExist);
		
		lblHired = new JLabel("The employee has been successfully hired.");
		lblHired.setFont(fields);
		lblHired.setBounds(251, 466, 350, 30);
		lblHired.setForeground(new Color(0, 255, 0));
		lblHired.setVisible(false);
		getContentPane().add(lblHired);
		
		btnSave = new JButton("Save employee");
		btnSave.setBorder(null);
		btnSave.setFocusable(false);
		btnSave.addActionListener(this);
		btnSave.setBounds(236, 507, 115, 30);
		btnSave.setForeground(new Color(54, 54, 54));
		btnSave.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(485, 507, 115, 30);
		btnCancel.setForeground(new Color(54, 54, 54));
		btnCancel.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnCancel);
		
		lblFooter = new JLabel("© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(445, 599, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		getContentPane().add(lblFooter);
		
		ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_panel.png"));
		lblFondo = new JLabel(fondo);
		lblFondo.setBounds(0, 0, 840, 640);
		getContentPane().add(lblFondo);

	}

	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		if (event.equals(btnSave)) {
			try {
			
				char[] ArrayPass = txtPassword.getPassword();
				dni = txtDNI.getText().trim();
				name = txtName.getText().trim();
				last_names = txtLastnames.getText();
				address = txtAddress.getText();
				email = txtEmail.getText().trim();
				username = txtUsername.getText().trim();
				password = new String(ArrayPass);
				
				if (!dni.isEmpty() && !name.isEmpty() && !last_names.isEmpty() && !address.isEmpty() && !email.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
					if (comprob.isDNI(dni)) {
						if (!metodo.EmployeeExist(dni)) { 
							if (comprob.isEmail(email)) {
								if (password.length() >= 6) {
									if (metodo.HireEmployee(dni, name, last_names, address, email, username, password, empleado)) {
										data = metodo.ShowEmployee(dni);
										data.next();
										String id = data.getString(1);
										metodo.EmployeesConnect(id);
										txtDNI.setText("");
										txtName.setText("");
										txtLastnames.setText("");
										txtAddress.setText("");
										txtEmail.setText("@bjh.com");
										txtUsername.setText("");
										txtPassword.setText("");
										lblNoDNI.setVisible(false);
										lblNoEmail.setVisible(false);
										lblNoPass.setVisible(false);
										lblExist.setVisible(false);
										lblHired.setVisible(true);
									}
								} else {
									lblNoDNI.setVisible(false);
									lblNoEmail.setVisible(false);
									lblNoPass.setVisible(true);
									lblExist.setVisible(false);
									lblHired.setVisible(false);
								}
							} else {
								lblNoDNI.setVisible(false);
								lblNoEmail.setVisible(true);
								lblNoPass.setVisible(false);
								lblExist.setVisible(false);
								lblHired.setVisible(false);
							}
						} else {
							lblNoDNI.setVisible(false);
							lblNoEmail.setVisible(false);
							lblNoPass.setVisible(false);
							lblExist.setVisible(true);
							lblHired.setVisible(false);
						}
					} else {
						lblNoDNI.setVisible(true);
						lblNoEmail.setVisible(false);
						lblNoPass.setVisible(false);
						lblExist.setVisible(false);
						lblHired.setVisible(false);
					}
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		if (event.equals(btnCancel) ) {
			management FrameManagement = new management();
			FrameManagement.setVisible(true);
			this.setVisible(false);
		}
		
	}
	
}
