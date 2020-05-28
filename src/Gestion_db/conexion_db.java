package gestion_db;

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
			
			System.out.println(" ERROR > El controlador no has sido encontrado.");
			e.getStackTrace();
			
		} catch (SQLException e) {
			
			System.out.println(" ERROR > La conexi\u00f3n no ha sido establecida");
			e.getStackTrace();
			
		}
		return connect;
	}
}
