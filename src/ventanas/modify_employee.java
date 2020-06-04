package ventanas;

import gestion_db.metodos_db;
import clases.comprobaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class modify_employee extends JFrame implements ActionListener {

	private JLabel lblBjh, lblSelect, lblDNI, lblName, lblLastnames, lblAddress, lblEmail, lblUsername, lblPassword, lblFooter, lblFondo;
	private JTextField txtDNI, txtName, txtLastnames, txtAddress, txtEmail, txtUsername;
	private JButton btnChangeData, btnCancel;
	private JPasswordField txtPassword;
	private String dni,name,last_names,address,email,username,password;
	metodos_db metodo = new metodos_db();
	private JComboBox<String> cbbEdit;
	comprobaciones comprob = new comprobaciones();

	public modify_employee() {
		//Frame
		getContentPane().setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setTitle("Modidy employee panel");
		setBounds(0, 0, 840, 640);
		setLocationRelativeTo(null);
		setBackground(new Color(54, 54, 54));
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());

		//Fonts
		Font title = new Font("Frank Ruehl CLM", 1, 62);
		Font scroll = new Font("Andale Mono", 0, 18);
		Font text_message = new Font("Comic Sans MS", 3, 16);

		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(351, 54, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		getContentPane().add(lblBjh);

		lblSelect = new JLabel("Select to be modified");
		lblSelect.setFont(scroll);
		lblSelect.setBounds(345, 114, 170, 30);
		lblSelect.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblSelect);

		cbbEdit = new JComboBox<String>();
		cbbEdit.setBounds(315, 154, 220, 25);
		cbbEdit.setBackground(new Color(246, 190, 82));
		cbbEdit.setFont(scroll);
		cbbEdit.setForeground(new Color(54, 54, 54));
		cbbEdit.addItem("");
		cbbEdit.addItem(" Name");
		cbbEdit.addItem(" Last names");
		cbbEdit.addItem(" Address");
		cbbEdit.addItem(" Email");
		cbbEdit.addItem(" Username");
		cbbEdit.addItem(" Password");
		cbbEdit.addItem(" All");
		getContentPane().add(cbbEdit);
		cbbEdit.addActionListener(this);

		
		lblDNI = new JLabel("DNI: ");
		lblDNI.setFont(scroll);
		lblDNI.setBounds(165, 194, 110, 30);
		lblDNI.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblDNI);

		txtDNI = new JTextField();
		txtDNI.setBorder(null);
		txtDNI.setBounds(285, 194, 110, 30);
		txtDNI.setForeground(new Color(54, 54, 54));
		txtDNI.setBackground(new Color (224, 224, 224));
		txtDNI.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtDNI);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(scroll);
		lblName.setBounds(165, 244, 110, 30);
		lblName.setEnabled(false);
		lblName.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setBorder(null);
		txtName.setBounds(285, 244, 110, 30);
		txtName.setEnabled(false);
		txtName.setForeground(new Color(54, 54, 54));
		txtName.setBackground(new Color (224, 224, 224));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtName);
		
		lblLastnames = new JLabel("Last names: ");
		lblLastnames.setFont(scroll);
		lblLastnames.setBounds(165, 294, 110, 30);
		lblLastnames.setEnabled(false);
		lblLastnames.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblLastnames);
		
		txtLastnames = new JTextField();
		txtLastnames.setBorder(null);
		txtLastnames.setBounds(285, 294, 110, 30);
		txtLastnames.setEnabled(false);
		txtLastnames.setForeground(new Color(54, 54, 54));
		txtLastnames.setBackground(new Color (224, 224, 224));
		txtLastnames.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtLastnames);
		
		lblAddress = new JLabel("Address: ");
		lblAddress.setFont(scroll);
		lblAddress.setBounds(165, 344, 110, 30);
		lblAddress.setEnabled(false);
		lblAddress.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBorder(null);
		txtAddress.setBounds(285, 344, 110, 30);
		txtAddress.setEnabled(false);
		txtAddress.setForeground(new Color(54, 54, 54));
		txtAddress.setBackground(new Color (224, 224, 224));
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtAddress);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(scroll);
		lblEmail.setBounds(425, 194, 110, 30);
		lblEmail.setEnabled(false);
		lblEmail.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setBounds(525, 194, 110, 30);
		txtEmail.setEnabled(false);
		txtEmail.setForeground(new Color(54, 54, 54));
		txtEmail.setBackground(new Color (224, 224, 224));
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtEmail);
		
		lblUsername = new JLabel("Username: ");
		lblUsername.setFont(scroll);
		lblUsername.setBounds(425, 244, 110, 30);
		lblUsername.setEnabled(false);
		lblUsername.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBorder(null);
		txtUsername.setBounds(525, 244, 110, 30);
		txtUsername.setEnabled(false);
		txtUsername.setForeground(new Color(54, 54, 54));
		txtUsername.setBackground(new Color (224, 224, 224));
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtUsername);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setFont(scroll);
		lblPassword.setBounds(425, 294, 110, 30);
		lblPassword.setEnabled(false);
		lblPassword.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.setBounds(525, 294, 110, 30);
		txtPassword.setEnabled(false);
		txtPassword.setForeground(new Color(54, 54, 54));
		txtPassword.setBackground(new Color (224, 224, 224));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtPassword);
		
		btnChangeData = new JButton("Change Data");
		btnChangeData.setBorder(null);
		btnChangeData.setFocusable(false);
		btnChangeData.addActionListener(this);
		btnChangeData.setBounds(258, 514, 130, 30);
		btnChangeData.setForeground(new Color(54, 54, 54));
		btnChangeData.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnChangeData);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(479, 514, 130, 30);
		btnCancel.setForeground(new Color(54, 54, 54));
		btnCancel.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnCancel);
		
		lblFooter = new JLabel("Â© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(445, 599, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		getContentPane().add(lblFooter);
		
		ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_panel.png"));
		lblFondo = new JLabel(fondo);
		lblFondo.setBounds(0, 0, 840, 640);
		getContentPane().add(lblFondo);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		/*-- Acciones para el combobox --*/
		if (event.equals(cbbEdit)) {
			
			String text = cbbEdit.getSelectedItem().toString();
			
			if (text == " Name") {
				
				lblName.setEnabled(true);
				lblLastnames.setEnabled(false);
				lblAddress.setEnabled(false);
				lblEmail.setEnabled(false);
				lblUsername.setEnabled(false);
				lblPassword.setEnabled(false);
				txtName.setEnabled(true);
				txtLastnames.setEnabled(false);
				txtAddress.setEnabled(false);
				txtEmail.setEnabled(false);
				txtUsername.setEnabled(false);
				txtPassword.setEnabled(false);

			}
			else if (text == " Last names") {
				
				lblLastnames.setEnabled(true);
				lblName.setEnabled(false);
				lblAddress.setEnabled(false);
				lblEmail.setEnabled(false);
				lblUsername.setEnabled(false);
				lblPassword.setEnabled(false);
				txtName.setEnabled(false);
				txtLastnames.setEnabled(true);
				txtAddress.setEnabled(false);
				txtEmail.setEnabled(false);
				txtUsername.setEnabled(false);
				txtPassword.setEnabled(false);
			}
			else if (text == " Address") {
				
				lblAddress.setEnabled(true);
				lblName.setEnabled(false);
				lblLastnames.setEnabled(false);
				lblEmail.setEnabled(false);
				lblUsername.setEnabled(false);
				lblPassword.setEnabled(false);
				txtName.setEnabled(false);
				txtLastnames.setEnabled(false);
				txtAddress.setEnabled(true);
				txtEmail.setEnabled(false);
				txtUsername.setEnabled(false);
				txtPassword.setEnabled(false);
			}
			else if (text == " Email") {
				
				lblEmail.setEnabled(true);
				lblName.setEnabled(false);
				lblLastnames.setEnabled(false);
				lblAddress.setEnabled(false);
				lblUsername.setEnabled(false);
				lblPassword.setEnabled(false);
				txtName.setEnabled(false);
				txtLastnames.setEnabled(false);
				txtAddress.setEnabled(false);
				txtEmail.setEnabled(true);
				txtUsername.setEnabled(false);
				txtPassword.setEnabled(false);
			}
			else if (text == " Username") {
				
				lblUsername.setEnabled(true);
				lblName.setEnabled(false);
				lblLastnames.setEnabled(false);
				lblAddress.setEnabled(false);
				lblEmail.setEnabled(false);
				lblPassword.setEnabled(false);
				txtName.setEnabled(false);
				txtLastnames.setEnabled(false);
				txtAddress.setEnabled(false);
				txtEmail.setEnabled(false);
				txtUsername.setEnabled(true);
				txtPassword.setEnabled(false);
			}
			else if (text == " Password") {
				lblPassword.setEnabled(true);
				lblName.setEnabled(false);
				lblLastnames.setEnabled(false);
				lblAddress.setEnabled(false);
				lblEmail.setEnabled(false);
				lblUsername.setEnabled(false);
				txtName.setEnabled(false);
				txtLastnames.setEnabled(false);
				txtAddress.setEnabled(false);
				txtEmail.setEnabled(false);
				txtUsername.setEnabled(false);
				txtPassword.setEnabled(true);
			}
			else if (text == " All") {
				
				lblName.setEnabled(true);
				lblLastnames.setEnabled(true);
				lblAddress.setEnabled(true);
				lblEmail.setEnabled(true);
				lblUsername.setEnabled(true);
				lblPassword.setEnabled(true);
				txtName.setEnabled(true);
				txtLastnames.setEnabled(true);
				txtAddress.setEnabled(true);
				txtEmail.setEnabled(true);
				txtUsername.setEnabled(true);
				txtPassword.setEnabled(true);
			}
		}
		if (event.equals(btnChangeData) ) {
			try {
				
			char[] ArrayPass = txtPassword.getPassword();
			dni = txtDNI.getText().trim();
			name = txtName.getText().trim();
			last_names = txtLastnames.getText().trim();
			address = txtAddress.getText().trim();
			email = txtEmail.getText().trim();
			username = txtUsername.getText().trim();
			password = new String(ArrayPass);

				if (!txtDNI.getText().isEmpty()) {
					if (comprob.isDNI(dni)) {
						if(metodo.EmployeeExist(dni)) {
							if (txtName.isEnabled() == true && txtLastnames.isEnabled() == true && txtAddress.isEnabled() == true && txtEmail.isEnabled() == true && txtUsername.isEnabled() == true && txtPassword.isEnabled() == true) {
								if (txtName.getText().isEmpty() || txtLastnames.getText().isEmpty() || txtAddress.getText().isEmpty() || txtEmail.getText().isEmpty() || txtUsername.getText().isEmpty() || password.isEmpty()) {
									JOptionPane.showMessageDialog(null, "if you don't introduce anything, you don't change anything.");
								}
								else if (!comprob.isEmail(email)) {
									JOptionPane.showMessageDialog(null, "Fix the email.");
								}
								else if (password.length() >= 6) {
									JOptionPane.showMessageDialog(null, "The password must be more than 6 characters.");
								}
								else {
									if (metodo.UpdateEmployee(dni, name, last_names, address, email, username, password)) {
										JOptionPane.showMessageDialog(null,"Data successfully changed.");
									}
								}
							}
							else if (txtName.isEnabled() == true) {

								last_names = "0";
								address = "0";
								email = "0";
								username = "0";
								password = "0";
								if (txtName.getText().isEmpty()) {
									JOptionPane.showMessageDialog(null, "if you don't introduce anything, you don't change anything.");
									
								}
								else {
									if (metodo.UpdateEmployee(dni, name, last_names, address, email, username, password)) {
										JOptionPane.showMessageDialog(null,"Data successfully changed.");
									}
								}
							}
							else if (txtLastnames.isEnabled() == true) {
								
								name = "0";
								address = "0";
								email = "0";
								username = "0";
								password = "0";
								if (txtLastnames.getText().isEmpty()) {
									JOptionPane.showMessageDialog(null, "if you don't introduce anything, you don't change anything.");
									
								}
								else {
									if (metodo.UpdateEmployee(dni, name, last_names, address, email, username, password)) {
										JOptionPane.showMessageDialog(null,"Data successfully changed.");
									}
								}
							}
							else if (txtAddress.isEnabled() == true) {
								
								name = "0";
								last_names = "0";
								email = "0";
								username = "0";
								password = "0";
								if (txtAddress.getText().isEmpty()) {
									JOptionPane.showMessageDialog(null, "if you don't introduce anything, you don't change anything.");
									
								}
								else {
									if (metodo.UpdateEmployee(dni, name, last_names, address, email, username, password)) {
										JOptionPane.showMessageDialog(null,"Data successfully changed.");
									}
								}
							}
							else if (txtEmail.isEnabled() == true) {
								
								name = "0";
								last_names = "0";
								address = "0";
								username = "0";
								password = "0";
								if (txtEmail.getText().isEmpty()) {
									JOptionPane.showMessageDialog(null, "if you don't introduce anything, you don't change anything.");
									
								}
								else {
									if (!comprob.isEmail(email)) {
										JOptionPane.showMessageDialog(null, "Fix the email.");
									}
									else {
										if (metodo.UpdateEmployee(dni, name, last_names, address, email, username, password)) {
											JOptionPane.showMessageDialog(null,"Data successfully changed.");
										}
									}
								}
							}
							else if (txtUsername.isEnabled() == true) {
								
								name = "0";
								last_names = "0";
								address = "0";
								email = "0";
								password = "0";
								if (txtUsername.getText().isEmpty()) {
									JOptionPane.showMessageDialog(null, "if you don't introduce anything, you don't change anything.");
									
								}
								else {
									if (metodo.UpdateEmployee(dni, name, last_names, address, email, username, password)) {
										JOptionPane.showMessageDialog(null,"Data successfully changed.");
									}
								}
							}
							else if (txtPassword.isEnabled() == true) {
								
								name = "0";
								last_names = "0";
								address = "0";
								email = "0";
								username = "0";
								if (password.isEmpty()) {
									JOptionPane.showMessageDialog(null, "if you don't introduce anything, you don't change anything.");
									
								}else {
									if (password.length() >= 6) {
										JOptionPane.showMessageDialog(null, "The password must be more than 6 characters.");
									}else {
										if (metodo.UpdateEmployee(dni, name, last_names, address, email, username, password)) {
											JOptionPane.showMessageDialog(null,"Data successfully changed.");
										}
									}
								}
							}
						}
						else {
							JOptionPane.showMessageDialog(null,"that person is not an employee.");
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "If you don't enter your DNI you can't change anything.");
				}
			}  catch (Exception e2) {
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
