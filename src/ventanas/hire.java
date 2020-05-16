package ventanas;

import gestion_db.metodos_db;
import clases.comprobaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class hire extends JFrame implements ActionListener {

	public static boolean hired = false;
	private JLabel lblBjh, lblDNI, lblName, lblLastnames, lblAddress, lblEmail, lblUsername, lblPassword, lblNoDNI, lblNoEmail, lblNoPass, lblExist, lblFooter;
	private JTextField txtDNI, txtName, txtLastnames, txtAddress, txtEmail, txtUsername;
	private JPasswordField txtPassword;
	private JButton btnSave, btnCancel;
	metodos_db metodo = new metodos_db();
	comprobaciones comprob = new comprobaciones();
	String dni, name, last_names, address, email, username, password, empleado = "si";
	
	public hire() {
		//Frame
		setLayout(null);
		setResizable(false);
		setTitle("Recruitment panel");
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
		
		lblDNI = new JLabel("DNI: ");
		lblDNI.setFont(fields);
		lblDNI.setBounds(50, 100, 110, 30);
		lblDNI.setForeground(new Color(54, 54, 54));
		add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(170, 100, 110, 30);
		txtDNI.setForeground(new Color(54, 54, 54));
		txtDNI.setBackground(new Color (224, 224, 224));
		txtDNI.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtDNI);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(fields);
		lblName.setBounds(50, 160, 110, 30);
		lblName.setForeground(new Color(54, 54, 54));
		add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(170, 160, 110, 30);
		txtName.setForeground(new Color(54, 54, 54));
		txtName.setBackground(new Color (224, 224, 224));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtName);
		
		lblLastnames = new JLabel("Last names: ");
		lblLastnames.setFont(fields);
		lblLastnames.setBounds(50, 220, 110, 30);
		lblLastnames.setForeground(new Color(54, 54, 54));
		add(lblLastnames);
		
		txtLastnames = new JTextField();
		txtLastnames.setBounds(170, 220, 110, 30);
		txtLastnames.setForeground(new Color(54, 54, 54));
		txtLastnames.setBackground(new Color (224, 224, 224));
		txtLastnames.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtLastnames);
		
		lblAddress = new JLabel("Address: ");
		lblAddress.setFont(fields);
		lblAddress.setBounds(50, 280, 110, 30);
		lblAddress.setForeground(new Color(54, 54, 54));
		add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBounds(170, 280, 110, 30);
		txtAddress.setForeground(new Color(54, 54, 54));
		txtAddress.setBackground(new Color (224, 224, 224));
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtAddress);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(fields);
		lblEmail.setBounds(310, 130, 110, 30);
		lblEmail.setForeground(new Color(54, 54, 54));
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(410, 130, 110, 30);
		txtEmail.setForeground(new Color(54, 54, 54));
		txtEmail.setBackground(new Color (224, 224, 224));
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtEmail);
		
		lblUsername = new JLabel("Username: ");
		lblUsername.setFont(fields);
		lblUsername.setBounds(310, 190, 110, 30);
		lblUsername.setForeground(new Color(54, 54, 54));
		add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(410, 190, 110, 30);
		txtUsername.setForeground(new Color(54, 54, 54));
		txtUsername.setBackground(new Color (224, 224, 224));
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtUsername);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setFont(fields);
		lblPassword.setBounds(310, 250, 110, 30);
		lblPassword.setForeground(new Color(54, 54, 54));
		add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(410, 250, 110, 30);
		txtPassword.setEchoChar('⬛');
		txtPassword.setForeground(new Color(54, 54, 54));
		txtPassword.setBackground(new Color (224, 224, 224));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtPassword);
		
		lblNoDNI = new JLabel("The employee's DNI is incorrect.");
		lblNoDNI.setFont(fields);
		lblNoDNI.setBounds(180, 350, 350, 30);
		lblNoDNI.setForeground(new Color(255, 0, 0));
		lblNoDNI.setVisible(false);
		add(lblNoDNI);
		
		lblNoEmail = new JLabel("The employee's email is incorrect.");
		lblNoEmail.setFont(fields);
		lblNoEmail.setBounds(180, 350, 350, 30);
		lblNoEmail.setForeground(new Color(255, 0, 0));
		lblNoEmail.setVisible(false);
		add(lblNoEmail);
		
		lblNoPass = new JLabel("The password must be at least 6 chars.");
		lblNoPass.setFont(fields);
		lblNoPass.setBounds(150, 350, 350, 30);
		lblNoPass.setForeground(new Color(255, 0, 0));
		lblNoPass.setVisible(false);
		add(lblNoPass);
		
		lblExist = new JLabel("There's already an employee with this DNI.");
		lblExist.setFont(fields);
		lblExist.setBounds(150, 350, 350, 30);
		lblExist.setForeground(new Color(255, 0, 0));
		lblExist.setVisible(false);
		add(lblExist);
		
		btnSave = new JButton("Save employee");
		btnSave.setBorder(null);
		btnSave.setFocusable(false);
		btnSave.addActionListener(this);
		btnSave.setBounds(170, 420, 115, 30);
		btnSave.setForeground(new Color(54, 54, 54));
		btnSave.setBackground(new Color(246, 190, 82));
		add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(310, 420, 115, 30);
		btnCancel.setForeground(new Color(54, 54, 54));
		btnCancel.setBackground(new Color(246, 190, 82));
		add(btnCancel);
		
		
		lblFooter = new JLabel("© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(250, 480, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		add(lblFooter);

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
										hired = true;
										management FrameManagement = new management();
										FrameManagement.setVisible(true);
										this.setVisible(false);
									}
								} else {
									lblNoDNI.setVisible(false);
									lblNoEmail.setVisible(false);
									lblNoPass.setVisible(true);
									lblExist.setVisible(false);
								}
							} else {
								lblNoDNI.setVisible(false);
								lblNoEmail.setVisible(true);
								lblNoPass.setVisible(false);
								lblExist.setVisible(false);
							}
						} else {
							lblNoDNI.setVisible(false);
							lblNoEmail.setVisible(false);
							lblNoPass.setVisible(false);
							lblExist.setVisible(true);
						}
					} else {
						lblNoDNI.setVisible(true);
						lblNoEmail.setVisible(false);
						lblNoPass.setVisible(false);
						lblExist.setVisible(false);
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
