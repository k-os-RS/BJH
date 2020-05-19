package ventanas;

import gestion_db.metodos_db;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class request_product extends JFrame implements ActionListener {

	private JLabel lblBjh, lblEmpty, lblNoQuantity, lblIDProduct, lblQuantity, lblIncorrect, lblFooter, lblFondo;
	private JTextField txtIDProduct, txtQuantity;
	private JButton btnSaved, btnCancel;
	metodos_db metodo = new metodos_db();
	String id_product, id = stock.id_pro;
	int quantity;
	
	public request_product() {
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
		
		lblIDProduct = new JLabel("ID Product:");
		lblIDProduct.setFont(fields);
		lblIDProduct.setBounds(20, 180, 150, 30);
		lblIDProduct.setForeground(new Color(54, 54, 54));
		add(lblIDProduct);

		txtIDProduct = new JTextField();
		txtIDProduct.setText(id);
		txtIDProduct.setBorder(null);
		txtIDProduct.setEditable(false);
		txtIDProduct.setBounds(220, 180, 100, 25);
		txtIDProduct.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtIDProduct);
		
		lblQuantity = new JLabel("Quantity:");
		lblQuantity.setFont(fields);
		lblQuantity.setBounds(20, 230, 150, 30);
		lblQuantity.setForeground(new Color(54, 54, 54));
		add(lblQuantity);

		txtQuantity = new JTextField();
		txtQuantity.setText("0");
		txtQuantity.setBorder(null);
		txtQuantity.setBounds(220, 230, 100, 25);
		txtQuantity.setHorizontalAlignment(SwingConstants.CENTER);
		add(txtQuantity);
		
		lblEmpty = new JLabel("Please fill all fields.");
		lblEmpty.setVisible(false);
		lblEmpty.setFont(text_message);
		lblEmpty.setBounds(100, 300, 255, 30);
		lblEmpty.setForeground(new Color(255, 0, 0));
		add(lblEmpty);
		
		lblNoQuantity = new JLabel("Quantity must be greater than zero.");
		lblNoQuantity.setVisible(false);
		lblNoQuantity.setFont(text_message);
		lblNoQuantity.setBounds(30, 300, 300, 30);
		lblNoQuantity.setForeground(new Color(255, 0, 0));
		add(lblNoQuantity);
		
		lblIncorrect = new JLabel("This product doesn't exist.");
		lblIncorrect.setVisible(false);
		lblIncorrect.setFont(text_message);
		lblIncorrect.setBounds(80, 300, 255, 30);
		lblIncorrect.setForeground(new Color(255, 0, 0));
		add(lblIncorrect);
		
		btnSaved = new JButton("Request");
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
				
				id_product = txtIDProduct.getText().trim();
				quantity = Integer.parseInt(txtQuantity.getText().trim());
				
				if (!id_product.isEmpty() || quantity != 0) {
					if (metodo.IDProductExist(id_product)) {
						if (quantity > 0) {
							metodo.addQuantity(id_product, quantity);
						} else {
							lblEmpty.setVisible(false);
							lblIncorrect.setVisible(false);
							lblNoQuantity.setVisible(true);
						}
					} else {
						lblEmpty.setVisible(false);
						lblIncorrect.setVisible(true);
						lblNoQuantity.setVisible(false);
					}
				} else {
					lblEmpty.setVisible(true);
					lblIncorrect.setVisible(false);
					lblNoQuantity.setVisible(false);
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
