package gestion_db;

import java.sql.*;
import com.mysql.jdbc.Statement;

public class metodos_db {
	
	private conexion_db connecting = new conexion_db();
	private Connection connect;
	private Statement command;
	private ResultSet data;
	
	public boolean LogInCorrect (String username, String password) throws SQLException {
		
		boolean verify = false;
		connect = connecting.getConexion();
		String sql = "SELECT * FROM persona WHERE username='"+username+"' and password='"+password+"'";
		
		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			
			while (data.next()) {
				verify = true;
			}
			command.close();
			connect.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return verify;
		
	}
	public boolean HireEmployee (String dni, String name, String last_names, String address, String email, String username, String password, String empleado) throws SQLException {
		
		boolean verify = false;
		int confirm = 0;
		connect = connecting.getConexion();
		String sql = "INSERT INTO persona (DNI,name,last_names,address,email,username,password,empleado) values ('"+dni+"','"+name+"','"+last_names+"','"+address+"','"+email+"','"+username+"','"+password+"','"+empleado+"')";
		
		try {
			command = (Statement) connect.createStatement();
			confirm = command.executeUpdate(sql);
			
			if (confirm == 1) {
				verify = true;
			}
			command.close();
			connect.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return verify;
		
	}
	public void FireEmployee (String dni) throws SQLException {
		
		String empleado = "si";
		connect = connecting.getConexion();
		String sql = "DELETE FROM persona WHERE dni='"+dni+"' and empleado='"+empleado+"'";
		
		try {
			command = (Statement) connect.createStatement();
			command.executeUpdate(sql);

			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public boolean EmployeeExist (String dni) throws SQLException {
		
		boolean verify = false;
		String empleado = "si";
		connect = connecting.getConexion();
		String sql = "SELECT * FROM persona WHERE dni='"+dni+"' and empleado='"+empleado+"'";
		
		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			
			while (data.next()) {
				verify = true;
			}
			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return verify;
		
	}
	public boolean ChangePassword (String username, String newpassword) throws SQLException {
		
		boolean verify = false;
		int confirm = 0;
		connect = connecting.getConexion();
		String sql = "UPDATE persona SET password='"+newpassword+"' WHERE persona.username='"+username+"'";
		
		try {
			command = (Statement) connect.createStatement();
			confirm = command.executeUpdate(sql);
			
			if (confirm == 1) {
				verify = true;
			}
			command.close();
			connect.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return verify;
		
	}
	
}
