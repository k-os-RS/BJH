package errors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class noconexion extends JFrame implements ActionListener {

	private JLabel lblBjh, lblError, lblFondo;
	private JButton btnClose;

	public noconexion() {
		//Frame
		setLayout(null);
		setResizable(false);
		setUndecorated(true);
		setBounds(0, 0, 350, 150);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/imagenes/logo_bjh.png")).getImage());
		
		//Fonts
		Font title = new Font("Frank Ruehl CLM", 3, 32);
		Font text_message = new Font("Comic Sans MS", 3, 16);
		
		//Components
		lblBjh = new JLabel("BJH Anime Store");
		lblBjh.setFont(title);
		lblBjh.setBounds(60, 10, 260, 48);
		lblBjh.setForeground(new Color(230, 180, 90));
		add(lblBjh);
		
		lblError = new JLabel("» Fallo al conectar con la base de datos «");
		lblError.setFont(text_message);
		lblError.setBounds(10, 50, 340, 30);
		lblError.setForeground(new Color(255, 0, 0));
		add(lblError);
		
		btnClose = new JButton("Accept");
		btnClose.setBorder(null);
		btnClose.setFocusable(false);
		btnClose.addActionListener(this);
		btnClose.setBounds(115, 90, 115, 30);
		btnClose.setForeground(new Color(54, 54, 54));
		btnClose.setBackground(new Color(246, 190, 82));
		add(btnClose);
		
		ImageIcon fondo = new ImageIcon(getClass().getResource("/imagenes/fondo_error.png"));
		lblFondo = new JLabel(fondo);
		lblFondo.setBounds(0, 0, 350, 150);
		add(lblFondo);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();
		
		if (event.equals(btnClose)) {
			dispose();
		}
		
	}

}
