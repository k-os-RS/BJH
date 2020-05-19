package ventanas;

import gestion_db.metodos_db;
import java.sql.*;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class workers extends JFrame implements ActionListener {

	private JLabel lblBjh, lblDNI, lblDNIEmpty, lblDNIExist, lblFooter, lblFondo;
	private JButton btnShowEmployee, btnShowAllEmployee, btnCancel;
	private JTextField txtDNI;
	private ResultSet result;
	private JTable table;
	private JScrollPane scrollpane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] data = new String [8];
	metodos_db metodo = new metodos_db();
	String dni;

	public workers() {
		//Frame
		setLayout(null);
		setResizable(false);
		setTitle("Workers panel");
		setBounds(0, 0, 640, 540);
		setLocationRelativeTo(null);
		setBackground(new Color(54, 54, 54));
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());

		//Fonts
		Font title = new Font("Frank Ruehl CLM", 1, 62);
		Font scroll = new Font("Andale Mono", 0, 18);
		Font tabled = new Font("Andale Mono", 2, 12);
		Font text_message = new Font("Comic Sans MS", 3, 16);
		
		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(236, 20, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);
		
		lblDNI = new JLabel("DNI: ");
		lblDNI.setFont(scroll);
		lblDNI.setBounds(50, 130, 100, 30);
		lblDNI.setForeground(new Color(54, 54, 54));
		add(lblDNI);
		
		txtDNI = new JTextField();
		txtDNI.setBorder(null);
		txtDNI.setBounds(100, 180, 130, 30);
		txtDNI.setForeground(new Color(54, 54, 54));
		txtDNI.setBackground(new Color (224, 224, 224));
		txtDNI.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtDNI);
		
		btnShowEmployee = new JButton("Show employee");
		btnShowEmployee.setBorder(null);
		btnShowEmployee.setFocusable(false);
		btnShowEmployee.addActionListener(this);
		btnShowEmployee.setBounds(50, 230, 180, 30);
		btnShowEmployee.setForeground(new Color(54, 54, 54));
		btnShowEmployee.setBackground(new Color(246, 190, 82));
		add(btnShowEmployee);

		btnShowAllEmployee = new JButton("Show all employees");
		btnShowAllEmployee.setBorder(null);
		btnShowAllEmployee.setFocusable(false);
		btnShowAllEmployee.addActionListener(this);
		btnShowAllEmployee.setBounds(50, 280, 180, 30);
		btnShowAllEmployee.setForeground(new Color(54, 54, 54));
		btnShowAllEmployee.setBackground(new Color(246, 190, 82));
		add(btnShowAllEmployee);
		
		table = new JTable();
		modelo.addColumn("DNI");
		modelo.addColumn("Name");
		modelo.addColumn("Last names");
		modelo.addColumn("Address");
		modelo.addColumn("Email");
		modelo.addColumn("Username");
		modelo.addColumn("Password");
		table.setFont(tabled);
		table.setModel(modelo);
		
		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(250, 110, 350, 250);
		add(scrollpane);
		
		lblDNIEmpty = new JLabel("Please fill in the DNI field.");
		lblDNIEmpty.setFont(scroll);
		lblDNIEmpty.setVisible(false);
		lblDNIEmpty.setBounds(200, 380, 210, 30);
		lblDNIEmpty.setForeground(new Color(255, 0, 0));
		add(lblDNIEmpty);
		
		lblDNIExist = new JLabel("This DNI don't exists.");
		lblDNIExist.setFont(scroll);
		lblDNIExist.setVisible(false);
		lblDNIExist.setBounds(220, 380, 210, 30);
		lblDNIExist.setForeground(new Color(255, 0, 0));
		add(lblDNIExist);
		
		btnCancel = new JButton("Close");
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(230, 420, 130, 30);
		btnCancel.setForeground(new Color(54, 54, 54));
		btnCancel.setBackground(new Color(246, 190, 82));
		add(btnCancel);

		lblFooter = new JLabel("© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(250, 480, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		add(lblFooter);
		
		ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_panel.png"));
		lblFondo = new JLabel(fondo);
		lblFondo.setBounds(0, 0, 640, 540);
		add(lblFondo);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		if (event.equals(btnShowEmployee) ) {
			try {
				
				dni = txtDNI.getText().trim();
				
				if (!dni.isEmpty()) {
					if (metodo.EmployeeExist(dni)) {
						result = metodo.ShowEmployee(dni);
						modelo.setRowCount(0);
						while (result.next()) {
							data[0] = result.getString(2);
							data[1] = result.getString(3);
							data[2] = result.getString(4);
							data[3] = result.getString(5);
							data[4] = result.getString(6);
							data[5] = result.getString(7);
							data[6] = result.getString(8);
							modelo.addRow(data);
						}
					} else {
						lblDNIEmpty.setVisible(false);
						lblDNIExist.setVisible(true);
					}
					
				} else {
					lblDNIEmpty.setVisible(true);
					lblDNIExist.setVisible(false);
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}

		if (event.equals(btnShowAllEmployee) ) {
			try {
				
				dni = txtDNI.getText().trim();
				result = metodo.ShowAllEmployees();
				modelo.setRowCount(0);
				while (result.next()) {
					data[0] = result.getString(2);
					data[1] = result.getString(3);
					data[2] = result.getString(4);
					data[3] = result.getString(5);
					data[4] = result.getString(6);
					data[5] = result.getString(7);
					data[6] = result.getString(8);
					modelo.addRow(data);
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
//	public void EmptyTable(){
//        DefaultTableModel tb = (DefaultTableModel) table.getModel();
//        int a = table.getRowCount() - 1;
//        for (int i = a; i >= 0; i--) {          
//        tb.removeRow(tb.getRowCount() - 1);
//        }
//    }

}
