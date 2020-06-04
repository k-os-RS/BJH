package gestion_db;

import errors.noconexion;
import java.sql.*;

public class conexion_db {
	
	private Connection connect;
	
	public Connection getConexion() throws SQLException {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/prueba";
			String user = "root";
			String password = "";
			
			connect = (Connection) DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			
			noconexion FrameNoConexion = new noconexion();
			FrameNoConexion.setVisible(true);
			e.getStackTrace();
			
		} catch (SQLException e) {
			
			noconexion FrameNoConexion = new noconexion();
			FrameNoConexion.setVisible(true);
			e.getStackTrace();

		}
		return connect;
	}
}
