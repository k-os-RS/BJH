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
import javax.swing.JButton;

public class administracion extends JFrame implements ActionListener {

	private JPanel contentPane;

	public administracion() {
		//Ventana administración
		setTitle("Administraci\u00F3n BJH");
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnContratarEmpleado = new JButton("Contratar empleado");
		btnContratarEmpleado.setBounds(10, 111, 150, 23);
		contentPane.add(btnContratarEmpleado);
		
		JButton button = new JButton("Contratar empleado");
		button.setBounds(10, 145, 150, 23);
		contentPane.add(button);
		
		JLabel lblGestionEmpleado = new JLabel("Gestion Empleado");
		lblGestionEmpleado.setBounds(10, 74, 46, 14);
		contentPane.add(lblGestionEmpleado);
		
		//Fuentes
		
		//Componentes
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object evento = e.getSource();
		
		
		
	}
}
