package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class modify extends JFrame implements ActionListener {
	
	private JLabel lblBjh, lblSelect, lblDNI, lblName, lblLastnames, lblAddress, lblEmail, lblUsername, lblPassword, lblFooter;
	private JTextField txtDNI, txtName, txtLastnames, txtAddress, txtEmail, txtUsername;
	private JButton btnChangeData, btnCancel;
	private JPasswordField txtPassword;
	metodos_db metodo = new metodos_db();
	private JComboBox<String> cbbEdit;
	
	public modify() {
		//Frame
		setLayout(null);
		setResizable(false);
		setTitle("Administration Panel | Admin");
		setBounds(0, 0, 640, 540);
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
		lblBjh.setBounds(230, 20, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);
		
		lblSelect = new JLabel("Select to be modified");
		lblSelect.setFont(scroll);
		lblSelect.setBounds(230, 60, 170, 70);
		lblSelect.setForeground(new Color(54, 54, 54));
		add(lblSelect);
		
		cbbEdit = new JComboBox<String>();
		cbbEdit.setBounds(200, 120, 220, 25);
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
		add(cbbEdit);
		
		lblDNI = new JLabel("DNI: ");
		lblDNI.setFont(scroll);
		lblDNI.setBounds(50, 160, 110, 30);
		lblDNI.setForeground(new Color(54, 54, 54));
		add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBounds(170, 160, 110, 30);
		txtDNI.setForeground(new Color(54, 54, 54));
		txtDNI.setBackground(new Color (224, 224, 224));
		txtDNI.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtDNI);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(scroll);
		lblName.setBounds(50, 210, 110, 30);
		lblName.setEnabled(false);
		lblName.setForeground(new Color(54, 54, 54));
		add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(170, 210, 110, 30);
		txtName.setEnabled(false);
		txtName.setForeground(new Color(54, 54, 54));
		txtName.setBackground(new Color (224, 224, 224));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtName);
		
		lblLastnames = new JLabel("Last names: ");
		lblLastnames.setFont(scroll);
		lblLastnames.setBounds(50, 260, 110, 30);
		lblLastnames.setEnabled(false);
		lblLastnames.setForeground(new Color(54, 54, 54));
		add(lblLastnames);
		
		txtLastnames = new JTextField();
		txtLastnames.setBounds(170, 260, 110, 30);
		txtLastnames.setEnabled(false);
		txtLastnames.setForeground(new Color(54, 54, 54));
		txtLastnames.setBackground(new Color (224, 224, 224));
		txtLastnames.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtLastnames);
		
		lblAddress = new JLabel("Address: ");
		lblAddress.setFont(scroll);
		lblAddress.setBounds(50, 310, 110, 30);
		lblAddress.setEnabled(false);
		lblAddress.setForeground(new Color(54, 54, 54));
		add(lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBounds(170, 310, 110, 30);
		txtAddress.setEnabled(false);
		txtAddress.setForeground(new Color(54, 54, 54));
		txtAddress.setBackground(new Color (224, 224, 224));
		txtAddress.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtAddress);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setFont(scroll);
		lblEmail.setBounds(310, 160, 110, 30);
		lblEmail.setEnabled(false);
		lblEmail.setForeground(new Color(54, 54, 54));
		add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(410, 160, 110, 30);
		txtEmail.setEnabled(false);
		txtEmail.setForeground(new Color(54, 54, 54));
		txtEmail.setBackground(new Color (224, 224, 224));
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtEmail);
		
		lblUsername = new JLabel("Username: ");
		lblUsername.setFont(scroll);
		lblUsername.setBounds(310, 210, 110, 30);
		lblUsername.setEnabled(false);
		lblUsername.setForeground(new Color(54, 54, 54));
		add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(410, 210, 110, 30);
		txtUsername.setEnabled(false);
		txtUsername.setForeground(new Color(54, 54, 54));
		txtUsername.setBackground(new Color (224, 224, 224));
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtUsername);
		
		lblPassword = new JLabel("Password: ");
		lblPassword.setFont(scroll);
		lblPassword.setBounds(310, 260, 110, 30);
		lblPassword.setEnabled(false);
		lblPassword.setForeground(new Color(54, 54, 54));
		add(lblPassword);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(410, 260, 110, 30);
		txtPassword.setEnabled(false);
		txtPassword.setEchoChar('⬛');
		txtPassword.setForeground(new Color(54, 54, 54));
		txtPassword.setBackground(new Color (224, 224, 224));
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtPassword);
		
		btnChangeData = new JButton("Change Data");
		btnChangeData.setBorder(null);
		btnChangeData.setFocusable(false);
		btnChangeData.addActionListener(this);
		btnChangeData.setBounds(180, 420, 130, 30);
		btnChangeData.setForeground(new Color(54, 54, 54));
		btnChangeData.setBackground(new Color(246, 190, 82));
		add(btnChangeData);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(320, 420, 130, 30);
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
		
		if (event.equals(btnChangeData) ) {
			changepass FrameChangePass = new changepass();
			FrameChangePass.setVisible(true);
			this.setVisible(false);
			
		}
		
		if (event.equals(btnCancel) ) {
			management FrameManagement = new management();
			FrameManagement.setVisible(true);
			this.setVisible(false);
			
		}
		
	}

}
