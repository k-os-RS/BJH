package ventanas;

import gestion_db.metodos_db;
import clases.comprobaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class products extends JFrame implements ActionListener {

	public static boolean hired = false;
	private JLabel lblBjh, lblName, lblType, lblPrice, lblPriceNumer, lblPriceLess, lblEmpty, lblExist, lbladdProduct, lblFooter, lblFondo;
	private JTextField txtName, txtType, txtPrice;
	private JButton btnSave, btnCancel;
	metodos_db metodo = new metodos_db();
	comprobaciones comprob = new comprobaciones();
	String name, type, price, quantity = "0";
	
	public products() {
		//Frame
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setTitle("Add product panel");
		setBounds(0, 0, 640, 540);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());
		
		//Fonts
		Font title = new Font("Frank Ruehl CLM", 1, 62);
		Font fields = new Font("Comic Sans MS", 1, 16);
		Font text_message = new Font("Comic Sans MS", 3, 16);

		//Components
		lblBjh = new JLabel("B J H");
		lblBjh.setFont(title);
		lblBjh.setBounds(236, 20, 170, 70);
		lblBjh.setForeground(new Color(246, 190, 82));
		add(lblBjh);
		
		lblName = new JLabel("Name: ");
		lblName.setFont(fields);
		lblName.setBounds(50, 160, 110, 30);
		lblName.setForeground(new Color(54, 54, 54));
		add(lblName);
		
		txtName = new JTextField();
		txtName.setBorder(null);
		txtName.setBounds(170, 160, 110, 30);
		txtName.setForeground(new Color(54, 54, 54));
		txtName.setBackground(new Color (224, 224, 224));
		txtName.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtName);
		
		lblType = new JLabel("Tipo: ");
		lblType.setFont(fields);
		lblType.setBounds(50, 220, 110, 30);
		lblType.setForeground(new Color(54, 54, 54));
		add(lblType);
		
		txtType = new JTextField();
		txtType.setBorder(null);
		txtType.setBounds(170, 220, 110, 30);
		txtType.setForeground(new Color(54, 54, 54));
		txtType.setBackground(new Color (224, 224, 224));
		txtType.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtType);
		
		lblPrice = new JLabel("Precio: ");
		lblPrice.setFont(fields);
		lblPrice.setBounds(310, 190, 110, 30);
		lblPrice.setForeground(new Color(54, 54, 54));
		add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setBorder(null);
		txtPrice.setBounds(410, 190, 110, 30);
		txtPrice.setForeground(new Color(54, 54, 54));
		txtPrice.setBackground(new Color (224, 224, 224));
		txtPrice.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtPrice);
		
		lblPriceNumer = new JLabel("The price has to be a number.");
		lblPriceNumer.setFont(fields);
		lblPriceNumer.setBounds(180, 350, 350, 30);
		lblPriceNumer.setForeground(new Color(255, 0, 0));
		lblPriceNumer.setVisible(false);
		add(lblPriceNumer);
		
		lblPriceLess = new JLabel("The price cannot be less than 0€.");
		lblPriceLess.setFont(fields);
		lblPriceLess.setBounds(180, 350, 350, 30);
		lblPriceLess.setForeground(new Color(255, 0, 0));
		lblPriceLess.setVisible(false);
		add(lblPriceLess);

		lblEmpty = new JLabel("Please fill in the fields.");
		lblEmpty.setFont(fields);
		lblEmpty.setBounds(210, 350, 200, 30);
		lblEmpty.setForeground(new Color(255, 0, 0));
		lblEmpty.setVisible(false);
		add(lblEmpty);
		
		lblExist = new JLabel("There's already an product with that name and type.");
		lblExist.setFont(fields);
		lblExist.setBounds(100, 350, 425, 30);
		lblExist.setForeground(new Color(255, 0, 0));
		lblExist.setVisible(false);
		add(lblExist);
		
		lbladdProduct = new JLabel("Product successfully added.");
		lbladdProduct.setFont(fields);
		lbladdProduct.setBounds(200, 350, 220, 30);
		lbladdProduct.setForeground(new Color(0, 255, 0));
		lbladdProduct.setVisible(false);
		add(lbladdProduct);
		
		btnSave = new JButton("Save product");
		btnSave.setBorder(null);
		btnSave.setFocusable(false);
		btnSave.addActionListener(this);
		btnSave.setBounds(170, 420, 115, 30);
		btnSave.setForeground(new Color(54, 54, 54));
		btnSave.setBackground(new Color(246, 190, 82));
		add(btnSave);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(null);
		btnCancel.setFocusable(false);
		btnCancel.addActionListener(this);
		btnCancel.setBounds(310, 420, 115, 30);
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

	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		if (event.equals(btnSave)) {
			try {

				name = txtName.getText().trim();
				type = txtType.getText().trim();
				price = txtPrice.getText().trim();
				
				if (!name.isEmpty() && !type.isEmpty() && !price.isEmpty()) {
					if (comprob.isNumberInt(price)) {
						if (!metodo.ProductExist(name, type)) { 
							if (price.length() > 0) {
								if (metodo.addProduct(name, type, price, quantity)) {
									lblPriceNumer.setVisible(false);
									lblPriceLess.setVisible(false);
									lblEmpty.setVisible(false);
									lblExist.setVisible(false);
									lbladdProduct.setVisible(true);
								}
							} else {
								lblPriceNumer.setVisible(false);
								lblPriceLess.setVisible(true);
								lblEmpty.setVisible(false);
								lblExist.setVisible(false);
								lbladdProduct.setVisible(false);
							}
						} else {
							lblPriceNumer.setVisible(false);
							lblPriceLess.setVisible(false);
							lblEmpty.setVisible(false);
							lblExist.setVisible(true);
							lbladdProduct.setVisible(false);
						}
					} else {
						lblPriceNumer.setVisible(true);
						lblPriceLess.setVisible(false);
						lblEmpty.setVisible(false);
						lblExist.setVisible(false);
						lbladdProduct.setVisible(false);
					}
				} else {
					lblPriceNumer.setVisible(false);
					lblPriceLess.setVisible(false);
					lblEmpty.setVisible(true);
					lblExist.setVisible(false);
					lbladdProduct.setVisible(false);
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		
		if (event.equals(btnCancel) ) {
			stock FrameStock = new stock();
			FrameStock.setVisible(true);
			this.setVisible(false);
		}
		
	}
	
}
