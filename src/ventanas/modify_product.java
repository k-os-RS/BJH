package ventanas;

import gestion_db.metodos_db;
import clases.comprobaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class modify_product extends JFrame implements ActionListener {

	private JLabel lblBjh, lblSelect, lblId, lblName, lblType, lblPrice, lblFooter, lblFondo;
	private JTextField txtID, txtName, txtType, txtPrice;
	private JButton btnChangeData, btnCancel;
	private String name,type,price,ID;
	metodos_db metodo = new metodos_db();
	private JComboBox<String> cbbEdit;
	comprobaciones comprob = new comprobaciones();


	public modify_product() {
		//Frame
		getContentPane().setLayout(null);
		setResizable(false);
		setTitle("Modidy product panel");
		setBounds(0, 0, 840, 640);
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
		lblBjh.setBounds(359, 72, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		getContentPane().add(lblBjh);

		lblSelect = new JLabel("Select to be modified");
		lblSelect.setFont(scroll);
		lblSelect.setBounds(353, 132, 170, 30);
		lblSelect.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblSelect);

		cbbEdit = new JComboBox<String>();
		cbbEdit.setBounds(323, 172, 220, 25);
		cbbEdit.setBackground(new Color(246, 190, 82));
		cbbEdit.setFont(scroll);
		cbbEdit.setForeground(new Color(54, 54, 54));
		cbbEdit.addItem("");
		cbbEdit.addItem(" Name");
		cbbEdit.addItem(" Type");
		cbbEdit.addItem(" Price");
		cbbEdit.addItem(" All");
		getContentPane().add(cbbEdit);
		cbbEdit.addActionListener(this);

		lblId = new JLabel("Product code: ");
		lblId.setFont(scroll);
		lblId.setBounds(160, 210, 120, 30);
		lblId.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblId);

		txtID = new JTextField();
		txtID.setBorder(null);
		txtID.setBounds(293, 212, 110, 30);
		txtID.setForeground(new Color(54, 54, 54));
		txtID.setBackground(new Color (224, 224, 224));
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtID);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(scroll);
		lblName.setBounds(433, 212, 110, 30);
		lblName.setEnabled(false);
		lblName.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblName);
		
		txtName = new JTextField();
		txtName.setBorder(null);
		txtName.setBounds(533, 212, 110, 30);
		txtName.setEnabled(false);
		txtName.setForeground(new Color(54, 54, 54));
		txtName.setBackground(new Color (224, 224, 224));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtName);
		
		lblType = new JLabel("Type: ");
		lblType.setFont(scroll);
		lblType.setBounds(433, 262, 110, 30);
		lblType.setEnabled(false);
		lblType.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblType);

		txtType = new JTextField();
		txtType.setBorder(null);
		txtType.setBounds(533, 262, 110, 30);
		txtType.setEnabled(false);
		txtType.setForeground(new Color(54, 54, 54));
		txtType.setBackground(new Color (224, 224, 224));
		txtType.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtType);

		lblPrice = new JLabel("Price: ");
		lblPrice.setFont(scroll);
		lblPrice.setBounds(433, 312, 110, 30);
		lblPrice.setEnabled(false);
		lblPrice.setForeground(new Color(54, 54, 54));
		getContentPane().add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setBorder(null);
		txtPrice.setBounds(533, 312, 110, 30);
		txtPrice.setEnabled(false);
		txtPrice.setForeground(new Color(54, 54, 54));
		txtPrice.setBackground(new Color (224, 224, 224));
		txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(txtPrice);
		
		btnChangeData = new JButton("Change Data");
		btnChangeData.setBorder(null);
		btnChangeData.setFocusable(false);
		btnChangeData.addActionListener(this);
		btnChangeData.setBounds(236, 517, 130, 30);
		btnChangeData.setForeground(new Color(54, 54, 54));
		btnChangeData.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnChangeData);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(500, 517, 130, 30);
		btnCancel.setForeground(new Color(54, 54, 54));
		btnCancel.setBackground(new Color(246, 190, 82));
		getContentPane().add(btnCancel);
		
		lblFooter = new JLabel("Â© 2020 BJH Anime Store | All rights reserved");
		lblFooter.setFont(text_message);
		lblFooter.setBounds(445, 599, 385, 30);
		lblFooter.setForeground(new Color(246, 190, 82));
		getContentPane().add(lblFooter);
		
		ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_panel.png"));
		lblFondo = new JLabel(fondo);
		lblFondo.setBounds(0, 0, 840, 640);
		getContentPane().add(lblFondo);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		if (event.equals(cbbEdit) ) {

			
			String text = cbbEdit.getSelectedItem().toString();
			
			if (text == " Name") {
				
				lblName.setEnabled(true);
				lblPrice.setEnabled(false);
				lblType.setEnabled(false);
				txtName.setEnabled(true);
				txtPrice.setEnabled(false);
				txtType.setEnabled(false);

			}
			else if (text == " Price") {
				
				lblName.setEnabled(false);
				lblPrice.setEnabled(true);
				lblType.setEnabled(false);
				txtName.setEnabled(false);
				txtPrice.setEnabled(true);
				txtType.setEnabled(false);
			}
			else if (text == " Type") {
				
				lblName.setEnabled(false);
				lblPrice.setEnabled(false);
				lblType.setEnabled(true);
				txtName.setEnabled(false);
				txtPrice.setEnabled(false);
				txtType.setEnabled(true);
			}
			else if (text == " All") {
				
				lblName.setEnabled(true);
				lblPrice.setEnabled(true);
				lblType.setEnabled(true);
				txtName.setEnabled(true);
				txtPrice.setEnabled(true);
				txtType.setEnabled(true);
			}
			
		}
		if (event.equals(btnChangeData)) {
			try {
				
				price = txtPrice.getText().trim();
				name = txtName.getText().trim();
				type = txtType.getText().trim();
				ID = txtID.getText().trim();
				
					if (txtName.isEnabled() == true) {
						txtName.setEnabled(true);
						if (!ID.isEmpty() || !name.isEmpty()) {
							metodo.UpdateProductName(ID, name);
							JOptionPane.showMessageDialog(null, "Data successfully changed.");
						} else {
							JOptionPane.showMessageDialog(null, "Please fill all fields.");
						}
					} else if (txtType.isEnabled() == true) {
						txtType.setEnabled(true);
						if (!ID.isEmpty() || !type.isEmpty()) {
							metodo.UpdateProductType(ID, type);
							JOptionPane.showMessageDialog(null, "Data successfully changed.");
						} else {
							JOptionPane.showMessageDialog(null, "Please fill all fields.");
						}
					} else if (txtPrice.isEnabled() == true) {
						txtPrice.setEnabled(true);
						if (!ID.isEmpty() || !price.isEmpty()) {
							metodo.UpdateProductPrice(ID, price);
							JOptionPane.showMessageDialog(null, "Data successfully changed.");
						} else {
							JOptionPane.showMessageDialog(null, "Please fill all fields.");
						}
					} else if (cbbEdit.equals(" All")) {
						txtName.setEnabled(true);
						txtType.setEnabled(true);
						txtPrice.setEnabled(true);
						if (!ID.isEmpty() || !name.isEmpty() || !type.isEmpty() || !price.isEmpty()) {
							metodo.UpdateProductAll(ID, name, type, price);
							JOptionPane.showMessageDialog(null, "Data successfully changed.");
						} else {
							JOptionPane.showMessageDialog(null, "Please fill all fields.");
						}
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
