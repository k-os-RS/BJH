package ventanas;

import gestion_db.metodos_db;
import java.sql.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class fire extends JFrame implements ActionListener {

	public static boolean fired = false;
	private JLabel lblBjh, lblDNI, lblIncorrect, lblFooter, lblFondo;
	private JTextField txtDNI;
	private ResultSet data;
	private JButton btnSaved, btnCancel;
	metodos_db metodo = new metodos_db();
	String dni;
	
	public fire() {
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
		lblBjh.setBounds(100, 35, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);
		
		lblDNI = new JLabel("Employee's DNI :");
		lblDNI.setFont(fields);
		lblDNI.setBounds(20, 180, 150, 30);
		lblDNI.setForeground(new Color(54, 54, 54));
		add(lblDNI);

		txtDNI = new JTextField();
		txtDNI.setBorder(null);
		txtDNI.setBounds(220, 180, 100, 25);
		txtDNI.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtDNI);
		
		lblIncorrect = new JLabel("This DNI doesn't exist.");
		lblIncorrect.setVisible(false);
		lblIncorrect.setFont(text_message);
		lblIncorrect.setBounds(80, 300, 255, 30);
		lblIncorrect.setForeground(new Color(255, 0, 0));
		add(lblIncorrect);
		
		btnSaved = new JButton("Save employee");
		btnSaved.setBorder(null);
		btnSaved.setFocusable(false);
		btnSaved.addActionListener(this);
		btnSaved.setBounds(40, 330, 115, 30);
		btnSaved.setForeground(new Color(54, 54, 54));
		btnSaved.setBackground(new Color(246, 190, 82));
		add(btnSaved);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(200, 330, 115, 30);
		btnCancel.setForeground(new Color(54, 54, 54));
		btnCancel.setBackground(new Color(246, 190, 82));
		add(btnCancel);
		
		lblFooter = new JLabel("© 2020 BJH Anime Store");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(250, 480, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		add(lblFooter);
		
		ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_panel.png"));
		lblFondo = new JLabel(fondo);
		lblFondo.setBounds(0, 0, 350, 450);
		add(lblFondo);

	}

	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		if (event.equals(btnSaved)) {
			try {
				
				dni = txtDNI.getText().trim();
				
				if (metodo.EmployeeExist(dni)) {
					data = metodo.ShowEmployee(dni);
					data.next();
					String id = data.getString(1);
					System.out.println(id);
					metodo.EmployeesFireConnect(id);
					fired = true;
					management FrameManagement = new management();
					FrameManagement.setVisible(true);
					this.setVisible(false);
					metodo.FireEmployee(dni);
				} else {
					lblIncorrect.setVisible(true);
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
