package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class modify_product extends JFrame implements ActionListener {

	private JLabel lblBjh, lblSelect, lblDNI, lblName, lblType, lblPrice, lblFooter, lblFondo;
	private JTextField txtDNI, txtName, txtType, txtPrice;
	private JButton btnChangeData, btnCancel;
	metodos_db metodo = new metodos_db();
	private JComboBox<String> cbbEdit;

	public modify_product() {
		//Frame
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setTitle("Modidy product panel");
		setBounds(0, 0, 640, 540);
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
		lblBjh.setBounds(236, 20, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);

		lblSelect = new JLabel("Select to be modified");
		lblSelect.setFont(scroll);
		lblSelect.setBounds(230, 80, 170, 30);
		lblSelect.setForeground(new Color(54, 54, 54));
		add(lblSelect);

		cbbEdit = new JComboBox<String>();
		cbbEdit.setBounds(200, 120, 220, 25);
		cbbEdit.setBackground(new Color(246, 190, 82));
		cbbEdit.setFont(scroll);
		cbbEdit.setForeground(new Color(54, 54, 54));
		cbbEdit.addItem("");
		cbbEdit.addItem(" Name");
		cbbEdit.addItem(" Type");
		cbbEdit.addItem(" Price");
		cbbEdit.addItem(" All");
		add(cbbEdit);
		
		lblDNI = new JLabel("ID Product: ");
		lblDNI.setFont(scroll);
		lblDNI.setBounds(50, 160, 110, 30);
		lblDNI.setForeground(new Color(54, 54, 54));
		add(lblDNI);

		txtDNI = new JTextField();
		txtDNI.setBorder(null);
		txtDNI.setBounds(170, 160, 110, 30);
		txtDNI.setForeground(new Color(54, 54, 54));
		txtDNI.setBackground(new Color (224, 224, 224));
		txtDNI.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtDNI);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(scroll);
		lblName.setBounds(310, 160, 110, 30);
		lblName.setEnabled(false);
		lblName.setForeground(new Color(54, 54, 54));
		add(lblName);
		
		txtName = new JTextField();
		txtName.setBorder(null);
		txtName.setBounds(410, 160, 110, 30);
		txtName.setEnabled(false);
		txtName.setForeground(new Color(54, 54, 54));
		txtName.setBackground(new Color (224, 224, 224));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtName);
		
		lblType = new JLabel("Type: ");
		lblType.setFont(scroll);
		lblType.setBounds(310, 210, 110, 30);
		lblType.setEnabled(false);
		lblType.setForeground(new Color(54, 54, 54));
		add(lblType);

		txtType = new JTextField();
		txtType.setBorder(null);
		txtType.setBounds(410, 210, 110, 30);
		txtType.setEnabled(false);
		txtType.setForeground(new Color(54, 54, 54));
		txtType.setBackground(new Color (224, 224, 224));
		txtType.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtType);

		lblPrice = new JLabel("Price: ");
		lblPrice.setFont(scroll);
		lblPrice.setBounds(310, 260, 110, 30);
		lblPrice.setEnabled(false);
		lblPrice.setForeground(new Color(54, 54, 54));
		add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setBorder(null);
		txtPrice.setBounds(410, 260, 110, 30);
		txtPrice.setEnabled(false);
		txtPrice.setForeground(new Color(54, 54, 54));
		txtPrice.setBackground(new Color (224, 224, 224));
		txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtPrice);
		
		btnChangeData = new JButton("Change Data");
		btnChangeData.setBorder(null);
		btnChangeData.setFocusable(false);
		btnChangeData.addActionListener(this);
		btnChangeData.setBounds(180, 420, 130, 30);
		btnChangeData.setForeground(new Color(54, 54, 54));
		btnChangeData.setBackground(new Color(246, 190, 82));
		add(btnChangeData);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(320, 420, 130, 30);
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
		
		if (event.equals(btnChangeData) ) {
			changepass FrameChangePass = new changepass();
			FrameChangePass.setVisible(true);
			this.setVisible(false);
			
		}
		
		if (event.equals(btnCancel) ) {
			management FrameManagement = new management();
			FrameManagement.setVisible(true);
			this.setVisible(false);
			
		}
		
	}

}
