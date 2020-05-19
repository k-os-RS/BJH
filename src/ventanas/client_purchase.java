package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

@SuppressWarnings("serial")
public class client_purchase extends JPanel implements ActionListener {

	private JLabel lblBjh, lblFooter, lblFondo;
	private JButton btnUpdateList;
	private ResultSet result, result2;
	private JTable table;
	private JScrollPane scrollpane;
	private DefaultTableModel modelo = new DefaultTableModel();
	private String [] data = new String [4];
	metodos_db metodo = new metodos_db(); 
	
	public client_purchase() {
		//Frame
		setLayout(null);
		setBounds(0, 0, 640, 540);
		
		//Fonts
		Font title = new Font("Frank Ruehl CLM", 1, 62);
		Font tabled = new Font("Andale Mono", 2, 12);
		Font text_message = new Font("Comic Sans MS", 3, 16);
		
		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(236, 20, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);

		table = new JTable();
		modelo.addColumn("Id_cliente");
		modelo.addColumn("Product");
		modelo.addColumn("Quantity sold");
		modelo.addColumn("Date");
		modelo.addColumn("State");
		table.setFont(tabled);
		table.setModel(modelo);
		try {

			result = metodo.ShowProducts();
			modelo.setRowCount(0);
			while (result.next()) {
				result2 = metodo.ShowTypes(result.getInt(2));
				data[0] = result.getString(1);
				while (result2.next()) {
					data[1] = result2.getString(2);
				}
				data[2] = result.getString(3);
				data[3] = result.getString(4);
				data[4] = result.getString(5);
				modelo.addRow(data);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		scrollpane = new JScrollPane(table);
		scrollpane.setBounds(40, 110, 560, 250);
		add(scrollpane);
		
		btnUpdateList = new JButton("Update list");
		btnUpdateList.setBorder(null);
		btnUpdateList.setFocusable(false);
		btnUpdateList.addActionListener(this);
		btnUpdateList.setBounds(265, 400, 120, 30);
		btnUpdateList.setForeground(new Color(54, 54, 54));
		btnUpdateList.setBackground(new Color(246, 190, 82));
		add(btnUpdateList);
		
		lblFooter = new JLabel("© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(250, 450, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		add(lblFooter);
		
		ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_panel.png"));
		lblFondo = new JLabel(fondo);
		lblFondo.setBounds(0, 0, 640, 540);
		add(lblFondo);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		if (event.equals(btnUpdateList) ) {
			try {
				
				result = metodo.ShowProducts();
				modelo.setRowCount(0);
				while (result.next()) {
					result2 = metodo.ShowTypes(result.getInt(2));
					data[0] = result.getString(1);
					while (result2.next()) {
						data[1] = result2.getString(2);
					}
					data[2] = result.getString(3);
					data[3] = result.getString(4);
					data[4] = result.getString(5);
					modelo.addRow(data);
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
	}

}
