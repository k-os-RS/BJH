package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class changepass extends JFrame implements ActionListener {

	public static boolean changed = false;
	private JLabel lblFondo, lblBjh, lblUser, lblPass, lblNPass, lblRNPass, lblMinChar, lblNoEquals,lblIncorrect, lblFooter;
	private JButton btnChange, btnCancel;
	private JTextField txtUser;
	private JPasswordField txtPass, txtNPass, txtRNPass;
	metodos_db metodo = new metodos_db();
	String username = login.user;
	String password = login.pass;
	String NPassword = "";
	String RNPassword = "";

	public changepass() {
		//Frame
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setBounds(0, 0, 350, 450);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());
		
		//Fonts
		Font title = new Font("Frank Ruehl CLM", 1, 62);
		Font fields = new Font("Comic Sans MS", 1, 16);
		Font text_message = new Font("Comic Sans MS", 3, 16);
		
		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(95, 35, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);
		
		lblUser = new JLabel(" Username:");
		lblUser.setFont(fields);
		lblUser.setBounds(20, 130, 115, 30);
		lblUser.setForeground(new Color(228, 228, 228));
		add(lblUser);

		txtUser = new JTextField(username);
		txtUser.setBorder(null);
		txtUser.setEditable(false);
		txtUser.setBounds(220, 130, 100, 25);
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtUser);
		
		lblPass = new JLabel(" Password:");
		lblPass.setFont(fields);
		lblPass.setBounds(20, 180, 115, 30);
		lblPass.setForeground(new Color(228, 228, 228));
		add(lblPass);
		
		txtPass = new JPasswordField();
		txtPass.setBorder(null);
		txtPass.setEchoChar('⬛');
		txtPass.setBounds(220, 180, 100, 25);
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtPass);
		
		lblNPass = new JLabel(" New Password:");
		lblNPass.setFont(fields);
		lblNPass.setBounds(20, 230, 135, 30);
		lblNPass.setForeground(new Color(228, 228, 228));
		add(lblNPass);
		
		txtNPass = new JPasswordField();
		txtNPass.setBorder(null);
		txtNPass.setEchoChar('⬛');
		txtNPass.setBounds(220, 230, 100, 25);
		txtNPass.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtNPass);
		
		lblRNPass = new JLabel(" Repeat New Password:");
		lblRNPass.setFont(fields);
		lblRNPass.setBounds(20, 280, 190, 30);
		lblRNPass.setForeground(new Color(228, 228, 228));
		add(lblRNPass);
		
		txtRNPass = new JPasswordField();
		txtRNPass.setBorder(null);
		txtRNPass.setEchoChar('⬛');
		txtRNPass.setBounds(220, 280, 100, 25);
		txtRNPass.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtRNPass);
		
		lblMinChar = new JLabel("New password must be at least 6 chars");
		lblMinChar.setVisible(false);
		lblMinChar.setFont(text_message);
		lblMinChar.setBounds(20, 300, 320, 30);
		lblMinChar.setForeground(new Color(255, 0, 0));
		add(lblMinChar);
		
		lblNoEquals = new JLabel("Passwords don't match");
		lblNoEquals.setVisible(false);
		lblNoEquals.setFont(text_message);
		lblNoEquals.setBounds(80, 300, 255, 30);
		lblNoEquals.setForeground(new Color(255, 0, 0));
		add(lblNoEquals);
		
		lblIncorrect = new JLabel("Incorrect username or password");
		lblIncorrect.setVisible(false);
		lblIncorrect.setFont(text_message);
		lblIncorrect.setBounds(50, 300, 255, 30);
		lblIncorrect.setForeground(new Color(255, 0, 0));
		add(lblIncorrect);
		
		btnChange = new JButton("Change");
		btnChange.setBorder(null);
		btnChange.setFocusable(false);
		btnChange.addActionListener(this);
		btnChange.setBounds(40, 330, 115, 30);
		btnChange.setForeground(new Color(54, 54, 54));
		btnChange.setBackground(new Color(246, 190, 82));
		add(btnChange);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(200, 330, 115, 30);
		btnCancel.setForeground(new Color(54, 54, 54));
		btnCancel.setBackground(new Color(246, 190, 82));
		if (password.equals("admin")) {
			btnCancel.setEnabled(false);
		} else {
			btnCancel.setEnabled(true);
		}
		add(btnCancel);
		
		lblFooter = new JLabel("© 2020 BJH Anime Store");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(120, 400, 210, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		add(lblFooter);
		
		ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_login.png"));
		lblFondo = new JLabel(fondo);
		lblFondo.setBounds(0, 0, 350, 450);
		add(lblFondo);
		
	}

	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		//Accion cuando se pulsa el boton Change
		if (event.equals(btnChange)) {
			try {
				
				char[] ArrayPass = txtPass.getPassword();
				char[] ArrayNPass = txtNPass.getPassword();
				char[] ArrayRNPass = txtRNPass.getPassword();
				username = txtUser.getText().trim();
				password = new String(ArrayPass);
				NPassword = new String(ArrayNPass);
				RNPassword = new String(ArrayRNPass);
				
				
				if (password.isEmpty() || NPassword.isEmpty() || RNPassword.isEmpty()) {
					lblMinChar.setVisible(false);
					lblNoEquals.setVisible(false);
					lblIncorrect.setVisible(true);
					txtPass.requestFocusInWindow();
					txtPass.setText("");
					txtNPass.setText("");
					txtRNPass.setText("");
				} else if (metodo.LogInCorrect(username, password)) {
					if (NPassword.equals(RNPassword)) {
						if (NPassword.length() >= 6) {
							if (metodo.ChangePassword(username, NPassword)) {
								changed = true;
								login FrameLogin = new login();
								FrameLogin.setVisible(true);
								this.setVisible(false);
							} else {
								lblMinChar.setVisible(false);
								lblNoEquals.setVisible(false);
								lblIncorrect.setVisible(true);
								txtPass.requestFocusInWindow();
								txtPass.setText("");
								txtNPass.setText("");
								txtRNPass.setText("");
							}
						} else {
							lblMinChar.setVisible(true);
							lblNoEquals.setVisible(false);
							lblIncorrect.setVisible(false);
							txtPass.requestFocusInWindow();
							txtPass.setText("");
							txtNPass.setText("");
							txtRNPass.setText("");
						}
					} else {
						lblMinChar.setVisible(false);
						lblNoEquals.setVisible(true);
						lblIncorrect.setVisible(false);
						txtPass.requestFocusInWindow();
						txtPass.setText("");
						txtNPass.setText("");
						txtRNPass.setText("");
					}//Fin del if 
				} else {
					lblMinChar.setVisible(false);
					lblNoEquals.setVisible(false);
					lblIncorrect.setVisible(true);
					txtPass.requestFocusInWindow();
					txtPass.setText("");
					txtNPass.setText("");
					txtRNPass.setText("");
				}//Fin del if
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		//Accion cuando se pulsa el boton Cancel
		if (event.equals(btnCancel)) {
			if (username.equals("admin")) {
				management FrameManagement = new management();
				FrameManagement.setVisible(true);
				this.setVisible(false);
			} else {
				employee FrameEmployee = new employee();
				FrameEmployee.setVisible(true);
				this.setVisible(false);
			}
		}
		
	}
	
}
