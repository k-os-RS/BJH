package ventanas;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

public class empleado extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblEmpleado;
	private JLabel lblNombre;

	public empleado() {
		//Ventana administración
		setTitle("Empleado BJH");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		//Fuentes
		Font empleado = new Font("Frank Ruehl CLM", Font.BOLD, 20);
		Font nombre = new Font("Frank Ruehl CLM", Font.PLAIN, 16);
		
		//Componentes
		lblEmpleado = new JLabel("Empleado: ");
		lblEmpleado.setFont(empleado);
		lblEmpleado.setBounds(10, 10, 114, 20);
		contentPane.add(lblEmpleado);
		
		lblNombre = new JLabel("Brandon Medina Rodriguez");
		lblNombre.setFont(nombre);
		lblNombre.setBounds(110, 10, 190, 20);
		contentPane.add(lblNombre);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		
		
	}
	
}
