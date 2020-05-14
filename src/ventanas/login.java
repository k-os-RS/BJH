package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class login extends JFrame implements ActionListener {

	public static String user = "";
	public static String pass= "";
	private JLabel lblFondo, lblBjh, lblLogin, lblUser, lblPass, lblIncorrect, lblFooter;
	private JButton btnLogin, btnClose;
	private JTextField txtUser;
	private JPasswordField txtPass;
	metodos_db metodo = new metodos_db();

	public void excute() {
		login FrameLogin = new login();
		FrameLogin.setVisible(true);
	}

	public login() {
		//Frame
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setBounds(0, 0, 350, 450);
		setLocationRelativeTo(null);
		//setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());
		
		//Fonts
		Font title = new Font("Frank Ruehl CLM", 1, 62);
		Font fields = new Font("Comic Sans MS", 1, 16);
		Font text_message = new Font("Comic Sans MS", 3, 16);
		
		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(100, 35, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);
		
		lblLogin = new JLabel("Password Changed. Please Log In again");
		lblLogin.setFont(text_message);
		lblLogin.setBounds(20, 120, 320, 30);
		lblLogin.setForeground(new Color(0, 255, 0));
		if (changepass.changed) {
			lblLogin.setVisible(true);
		} else {
			lblLogin.setVisible(false);
		}
		add(lblLogin);
		
		lblUser = new JLabel(" Username:");
		lblUser.setFont(fields);
		lblUser.setBounds(20, 180, 115, 30);
		lblUser.setForeground(new Color(228, 228, 228));
		add(lblUser);

		txtUser = new JTextField();
		txtUser.setBorder(null);
		txtUser.setBounds(220, 180, 100, 25);
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtUser);
		
		lblPass = new JLabel(" Password:");
		lblPass.setFont(fields);
		lblPass.setBounds(20, 230, 115, 30);
		lblPass.setForeground(new Color(228, 228, 228));
		add(lblPass);
		
		txtPass = new JPasswordField();
		txtPass.setBorder(null);
		txtPass.setEchoChar('⬛');
		txtPass.setBounds(220, 230, 100, 25);
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtPass);
		
		lblIncorrect = new JLabel("Incorrect username or password");
		lblIncorrect.setVisible(false);
		lblIncorrect.setFont(text_message);
		lblIncorrect.setBounds(50, 300, 255, 30);
		lblIncorrect.setForeground(new Color(255, 0, 0));
		add(lblIncorrect);
		
		btnLogin = new JButton("Log In");
		btnLogin.setBorder(null);
		btnLogin.setFocusable(false);
		btnLogin.addActionListener(this);
		btnLogin.setBounds(40, 330, 115, 30);
		btnLogin.setForeground(new Color(54, 54, 54));
		btnLogin.setBackground(new Color(246, 190, 82));
		add(btnLogin);
		
		btnClose = new JButton("Close");
		btnClose.setBorder(null);
		btnClose.setFocusable(false);
		btnClose.addActionListener(this);
		btnClose.setBounds(200, 330, 115, 30);
		btnClose.setForeground(new Color(54, 54, 54));
		btnClose.setBackground(new Color(246, 190, 82));
		add(btnClose);
		
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
		
		//Acción cuando se pulsa el boton Log In
		if (event.equals(btnLogin)) {
			try {
				
				char[] ArrayPass = txtPass.getPassword();
				user = txtUser.getText().trim();
				pass = new String(ArrayPass);

				if (user.isEmpty() || pass.isEmpty()) {
					lblIncorrect.setVisible(true);
					txtUser.requestFocusInWindow();
					txtUser.setText("");
					txtPass.setText("");
				} else if (metodo.LogInCorrect(user, pass)) {
					if (user.equals("admin") && pass.equals("admin")) {
						changepass FrameChange = new changepass();
						FrameChange.setVisible(true);
						this.setVisible(false);
					} else if (user.equals("admin")){
						management FrameManagement = new management();
						FrameManagement.setVisible(true);
						this.setVisible(false);
					} else {
						employee FrameEmployee = new employee();
						FrameEmployee.setVisible(true);
						this.setVisible(false);
					}
				} else {
					lblIncorrect.setVisible(true);
					txtUser.requestFocusInWindow();
					txtUser.setText("");
					txtPass.setText("");
				}//Fin del if
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}//Fin del try
		}
		
		//Acción cuando se pulsa el boton Close
		if (event.equals(btnClose)) {
			System.exit(0);
		}
		
	}

}
