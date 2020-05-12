package ventanas;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

import gestion_db.conexion_db;
import gestion_db.metodos_db;

public class cambiarpass extends JDialog implements ActionListener {
	
	private conexion_db conexion;
	private Connection connect;
	private metodos_db mtd;
	private ResultSet data;

	private JPanel contentPane;
	private JLabel lblBjh;
	private JLabel lblFondo;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblNPassword;
	private JLabel lblRNPassword;
	private JLabel lblIncorrect;
	private JButton btnChange;
	private JButton btnCancel;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JPasswordField txtNPass;
	private JPasswordField txtRNPass;

	public cambiarpass() {
		//Ventana principal	
		setUndecorated(true);
		setSize(350, 450);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//Fuentes
		Font titulo = new Font("Frank Ruehl CLM", Font.BOLD, 72);
		Font campos = new Font("Comic Sans MS", Font.BOLD, 18);
		Font text_message = new Font("Comic Sans MS", Font.BOLD, 14);
		
		//Componentes
		lblBjh = new JLabel("BJH");
		lblBjh.setForeground(new Color(246, 190, 82));
		lblBjh.setFont(titulo);
		lblBjh.setBounds(100, 50, 150, 70);
		contentPane.add(lblBjh);
		
		lblUsername = new JLabel(" Username:");
		lblUsername.setBorder(null);
		lblUsername.setFont(campos);
		lblUsername.setForeground(new Color(228, 228, 228));
		lblUsername.setBounds(10, 130, 115, 30);
		contentPane.add(lblUsername);

		txtUser = new JTextField();
		txtUser.setBorder(null);
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setBounds(230, 130, 100, 25);
		contentPane.add(txtUser);
		
		lblPassword = new JLabel(" Password:");
		lblPassword.setBorder(null);
		lblPassword.setFont(campos);
		lblPassword.setForeground(new Color(228, 228, 228));
		lblPassword.setBounds(10, 170, 115, 30);
		contentPane.add(lblPassword);
		
		txtPass = new JPasswordField();
		txtPass.setBorder(null);
		txtPass.setEchoChar('⬛');
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		txtPass.setBounds(230, 170, 100, 25);
		contentPane.add(txtPass);
		
		lblNPassword = new JLabel(" New password:");
		lblNPassword.setBorder(null);
		lblNPassword.setFont(campos);
		lblNPassword.setForeground(new Color(228, 228, 228));
		lblNPassword.setBounds(10, 210, 150, 30);
		contentPane.add(lblNPassword);
		
		txtNPass = new JPasswordField();
		txtNPass.setBorder(null);
		txtNPass.setEchoChar('⬛');
		txtNPass.setHorizontalAlignment(SwingConstants.CENTER);
		txtNPass.setBounds(230, 210, 100, 25);
		contentPane.add(txtNPass);
		
		lblRNPassword = new JLabel(" Repeat new password:");
		lblRNPassword.setBorder(null);
		lblRNPassword.setFont(campos);
		lblRNPassword.setForeground(new Color(228, 228, 228));
		lblRNPassword.setBounds(10, 250, 210, 30);
		contentPane.add(lblRNPassword);
		
		txtRNPass = new JPasswordField();
		txtRNPass.setBorder(null);
		txtRNPass.setEchoChar('⬛');
		txtRNPass.setHorizontalAlignment(SwingConstants.CENTER);
		txtRNPass.setBounds(230, 250, 100, 25);
		contentPane.add(txtRNPass);
		
		lblIncorrect = new JLabel("Incorrect username or password");
		lblIncorrect.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncorrect.setForeground(new Color(255, 40, 16));
		lblIncorrect.setBounds(50, 280, 245, 25);
		lblIncorrect.setFont(text_message);
		lblIncorrect.setVisible(false);
		contentPane.add(lblIncorrect);
		
		btnChange = new JButton("Change Password");
		btnChange.setBackground(new Color(246, 190, 82));
		btnChange.setForeground(new Color(54, 54, 54));
		btnChange.setBorder(null);
		btnChange.setFocusable(false);
		btnChange.addActionListener(this);
		btnChange.setBounds(50, 310, 115, 30);
		contentPane.add(btnChange);
		
		btnCancel = new JButton("Close");
		btnCancel.setBackground(new Color(246, 190, 82));
		btnCancel.setForeground(new Color(54, 54, 54));
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(195, 310, 100, 30);
		try {
			metodos_db metodo = new metodos_db();
			if (!(metodo.LogInCorrect("admin", "admin"))) {
				contentPane.add(btnCancel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/fondo_login.png")));
		lblFondo.setBounds(0, 0, 350, 450);
		contentPane.add(lblFondo);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		conexion = new conexion_db();
		mtd = new metodos_db();
		
		if (evento.equals(btnChange)) {
			System.exit(0);
		}
		
		if (evento.equals(btnCancel)) {
			System.exit(0);
		}
		
	}
}
