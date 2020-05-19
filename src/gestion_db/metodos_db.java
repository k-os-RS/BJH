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
		String sql = "INSERT INTO persona (DNI,name,last_names,address,email,username,password,employee) values ('"+dni+"','"+name+"','"+last_names+"','"+address+"','"+email+"','"+username+"','"+password+"','"+empleado+"')";
		
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
	public void EmployeesConnect (String id_persona) throws SQLException {
		
		connect = connecting.getConexion();
		String sql = "INSERT INTO empleado (id_persona_aux) values ('"+id_persona+"')";
		
		try {
			command = (Statement) connect.createStatement();
			command.executeUpdate(sql);
			
			command.close();
			connect.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void FireEmployee (String dni) throws SQLException {
		
		String empleado = "si";
		connect = connecting.getConexion();
		String sql = "DELETE FROM persona WHERE dni='"+dni+"' and employee='"+empleado+"'";
		
		try {
			command = (Statement) connect.createStatement();
			command.executeUpdate(sql);
			
			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void EmployeesFireConnect (String id_persona) throws SQLException {

		connect = connecting.getConexion();
		String sql = "DELETE FROM empleado WHERE id_persona_aux='"+id_persona+"'";
		
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
		String sql = "SELECT * FROM persona WHERE dni='"+dni+"' and employee='"+empleado+"'";
		
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
	public boolean isEmployee (String user, String pass) throws SQLException {
		
		boolean verify = false;
		String empleado = "si";
		connect = connecting.getConexion();
		String sql = "SELECT * FROM persona WHERE username='"+user+"' and password='"+pass+"' and employee='"+empleado+"'";
		
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
	public boolean isEmployeeUser (String user) throws SQLException {
		
		boolean verify = false;
		String empleado = "si";
		connect = connecting.getConexion();
		String sql = "SELECT * FROM persona WHERE username='"+user+"' and employee='"+empleado+"'";
		
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
	public ResultSet ShowEmployee (String dni) throws SQLException {
		
		String empleado = "si";
		String sql = "SELECT * FROM persona WHERE dni='"+dni+"' and employee='"+empleado+"'";
		connect = connecting.getConexion();
		
		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
		
	}
	
	public ResultSet ShowAllEmployees () throws SQLException {
		
		String empleado = "si";
		String sql = "SELECT * FROM persona WHERE employee='"+empleado+"'";
		connect  = connecting.getConexion();
		
		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
		
	}
	public boolean addProduct (String name, String type, String price, String quantity) throws SQLException {
		
		boolean verify = false;
		int confirm = 0;
		int id_type = ProductType(type);
		connect = connecting.getConexion();
		String sql = "INSERT INTO producto (id_tipo_aux,name,quantity,price) values ('"+id_type+"','"+name+"','"+quantity+"','"+price+"')";
		
		try {
			command = (Statement) connect.createStatement();
			confirm = command.executeUpdate(sql);
			
			while (confirm == 1) {
				verify = true;
			}
			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return verify;
		
	}
	public boolean addQuantity (String id_product, int quantity) throws SQLException {
		
		boolean verify = false;
		int confirm = 0;
		connect = connecting.getConexion();
		String sql = "UPDATE producto SET quantity='"+quantity+"' WHERE producto.id_producto='"+id_product+"'";
		
		try {
			command = (Statement) connect.createStatement();
			confirm = command.executeUpdate(sql);
			
			while (confirm == 1) {
				verify = true;
			}
			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return verify;
		
	}
	public boolean ProductExist (String name, String type) throws SQLException {
		
		boolean verify = false;
		int id_type = ProductType(type);
		connect = connecting.getConexion();
		String sql = "SELECT * FROM producto WHERE id_tipo_aux='"+id_type+"' and name='"+name+"'";
		
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
	public int ProductType (String type) throws SQLException {
		
		int id = 0;
		boolean verify = false;
		connect = connecting.getConexion();
		String sql = "SELECT * FROM tipo WHERE type_name='"+type+"'";
		String sql2 = "INSERT INTO tipo (type_name) values ('"+type+"')";

		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			
			while (data.next()) {
				id = data.getInt(1);
				verify = true;
			}

			if (!verify) {
				command.executeUpdate(sql2);
				data = command.executeQuery(sql);
				data.next();
				id = data.getInt(1);
			}
			
			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
		
	}
	public boolean IDProductExist (String id_product) throws SQLException {
		
		boolean verify = false;
		connect = connecting.getConexion();
		String sql = "SELECT * FROM producto WHERE id_producto='"+id_product+"'";
		
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
	public int ShowQuantityProduct (String id_product) throws SQLException {
		
		int quantity = 0;
		String sql = "SELECT quantity FROM producto WHERE id_producto='"+id_product+"'";
		connect = connecting.getConexion();
		
		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			data.next();
			quantity = data.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return quantity;
		
	}
	public ResultSet ShowProducts () throws SQLException {
		
		String sql = "SELECT * FROM producto";
		connect = connecting.getConexion();
		
		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
		
	}
	public ResultSet ShowTypes (int id_tipo) throws SQLException {
		
		String sql = "SELECT * FROM tipo WHERE id_tipo='"+id_tipo+"'";
		connect = connecting.getConexion();
		
		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
		
	}
//	public boolean addPurchase (String username, String id_product, String quant_pro) throws SQLException {
//		
//		boolean verify = false;
//		int confirm = 0;
//		int id_type = ProductType(type);
//		connect = connecting.getConexion();
//		String sql = "INSERT INTO producto (id_tipo_aux,name,quantity,price) values ('"+id_type+"','"+name+"','"+quantity+"','"+price+"')";
//		
//		try {
//			command = (Statement) connect.createStatement();
//			confirm = command.executeUpdate(sql);
//			
//			while (confirm == 1) {
//				verify = true;
//			}
//			command.close();
//			connect.close();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return verify;
//		
//	}
	
}
