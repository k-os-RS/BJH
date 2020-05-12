package ventanas;

import gestion_db.metodos_db;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class inicio extends JFrame implements ActionListener {
	
	//private conexion_db conexion;
	//private Connection connect;
	private metodos_db mtd;
	//private ResultSet data;

	private JPanel contentPane;
	private JLabel lblBjh;
	private JLabel lblFondo;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblIncorrect;
	private JButton btnIniciarSesion;
	private JButton btnCerrar;
	private JTextField txtUser;
	private JPasswordField txtPass;

	public void iniciar() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inicio frame = new inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Add limit password 6 char (open english)
	//Ready player one
	//Factura con objetos tipo toString

	public inicio() {
		//Ventana principal	
		//setUndecorated(true);
		setBounds(0, 0, 350, 450);
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
		lblUsername.setBounds(50, 175, 115, 30);
		contentPane.add(lblUsername);

		txtUser = new JTextField();
		txtUser.setBorder(null);
		txtUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtUser.setBounds(195, 175, 100, 25);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		lblPassword = new JLabel(" Password:");
		lblPassword.setBorder(null);
		lblPassword.setFont(campos);
		lblPassword.setForeground(new Color(228, 228, 228));
		lblPassword.setBounds(50, 220, 115, 30);
		contentPane.add(lblPassword);
		
		txtPass = new JPasswordField();
		txtPass.setBorder(null);
		txtPass.setEchoChar('⬛');
		txtPass.setHorizontalAlignment(SwingConstants.CENTER);
		txtPass.setBounds(195, 220, 100, 25);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		btnIniciarSesion = new JButton("Log In");
		btnIniciarSesion.setBackground(new Color(246, 190, 82));
		btnIniciarSesion.setForeground(new Color(54, 54, 54));
		btnIniciarSesion.setBorder(null);
		btnIniciarSesion.setFocusable(false);
		btnIniciarSesion.addActionListener(this);
		btnIniciarSesion.setBounds(50, 310, 115, 30);
		contentPane.add(btnIniciarSesion);
		
		btnCerrar = new JButton("Close");
		btnCerrar.setBackground(new Color(246, 190, 82));
		btnCerrar.setForeground(new Color(54, 54, 54));
		btnCerrar.setBorder(null);
		btnCerrar.setFocusable(false);
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(195, 310, 100, 30);
		contentPane.add(btnCerrar);
		
		lblIncorrect = new JLabel("Incorrect username or password");
		lblIncorrect.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncorrect.setForeground(new Color(255, 40, 16));
		lblIncorrect.setBounds(50, 280, 245, 25);
		lblIncorrect.setFont(text_message);
		lblIncorrect.setVisible(false);
		contentPane.add(lblIncorrect);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(inicio.class.getResource("/imagenes/fondo_login.png")));
		lblFondo.setBounds(0, 0, 335, 415);
		contentPane.add(lblFondo);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		//conexion = new conexion_db();
		mtd = new metodos_db();
		
		if (event.equals(btnIniciarSesion)) {
			try {
				
				char[] ArrayPass = txtPass.getPassword();
				String user = txtUser.getText().toString();
				String pass = new String(ArrayPass);
						
				if (txtUser.getText().isEmpty() || pass.isEmpty()) {
					lblIncorrect.setVisible(true);
					contentPane.revalidate();
					contentPane.repaint();
				} else if (mtd.LogInCorrect(user, pass)) {
					cambiarpass changepass = new cambiarpass();
					
					contentPane.setVisible(false);
					changepass.setVisible(true);
				} else {
					lblIncorrect.setVisible(true);
					contentPane.revalidate();
					contentPane.repaint();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		//Acción de cerrar ventana principal
		if (event.equals(btnCerrar)) {
			System.exit(0);
		}
	}
}
