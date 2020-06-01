package gestion_db;

import java.sql.*;

//import com.mysql.jdbc.Statement;

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
	public boolean ClientExist (String id_client) throws SQLException {
		
		boolean verify = false;
		connect = connecting.getConexion();
		String sql = "SELECT * FROM cliente WHERE id_cliente='"+id_client+"'";
		
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
	public boolean PurchaseExist (String id_client, String id_producto) throws SQLException {

		boolean verify = false;
		String state = "Waiting";
		connect = connecting.getConexion();
		String sql = "SELECT * FROM compra WHERE id_cliente_aux='"+id_client+"' and id_producto_aux='"+id_producto+"' and state='"+state+"'";
		
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
	public void PurchaseAcept (String id_client, String id_product, int quantity) throws SQLException {

		connect = connecting.getConexion();
		String state = "Completed";
		String sql = "UPDATE producto SET quantity='"+quantity+"' WHERE producto.id_producto='"+id_product+"'";
		String sql2 = "UPDATE compra SET state='"+state+"' WHERE compra.id_cliente_aux='"+id_client+"' and compra.id_producto_aux='"+id_product+"'";
		
		try {
			command = (Statement) connect.createStatement();
			command.executeUpdate(sql);
			command.executeUpdate(sql2);
			
			command.close();
			connect.close();
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
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
	public void addProduct (String name, String type, String price, String quantity) throws SQLException {
		
		int id_type = ProductType(type);
		connect = connecting.getConexion();
		String sql = "INSERT INTO producto (id_tipo_aux,name,quantity,price) values ('"+id_type+"','"+name+"','"+quantity+"','"+price+"')";
		
		try {
			command = (Statement) connect.createStatement();
			command.executeUpdate(sql);

			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
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
			while (data.next()) {
				quantity = data.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return quantity;
		
	}
	public int ShowQuantityPurchase (String id_cliente, String id_product) throws SQLException {
		
		int quantity = 0;
		String sql = "SELECT quantity_sold FROM compra WHERE id_cliente_aux='"+id_cliente+"' and id_producto_aux='"+id_product+"'";
		connect = connecting.getConexion();
		
		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			while (data.next()) {
				quantity = data.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return quantity;
		
	}
	public ResultSet ShowQuanProduct (String id_product) throws SQLException {
		
		String sql = "SELECT quantity FROM producto WHERE id_producto='"+id_product+"'";
		connect = connecting.getConexion();
		
		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
		
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
	public ResultSet ShowPurchases () throws SQLException {
		
		String sql = "SELECT * FROM compra";
		connect = connecting.getConexion();
		
		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return data;
		
	}
	public int PersonID (String username) throws SQLException {
		
		int id = 0;
		connect = connecting.getConexion();
		String sql = "SELECT id_persona FROM persona WHERE username='"+username+"'";

		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			
			while (data.next()) {
				id = data.getInt(1);
			}
			
			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
		
	}
	public int ClienteID (String username) throws SQLException {
		
		int id = 0;
		int id_persona_aux = PersonID(username);
		connect = connecting.getConexion();
		String sql = "SELECT id_cliente FROM cliente WHERE id_persona_aux='"+id_persona_aux+"'";

		try {
			command = (Statement) connect.createStatement();
			data = command.executeQuery(sql);
			
			while (data.next()) {
				id = data.getInt(1);
			}
			
			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return id;
		
	}
	
	public void addPurchase (String username, String id_product, int quant_pro) throws SQLException {
		
		String date = "NOW()", state = "Waiting";
		int id_cliente = ClienteID(username);
		connect = connecting.getConexion();
		String sql = "INSERT INTO compra (id_cliente_aux,id_producto_aux,quantity_sold,date,state) values ('"+id_cliente+"','"+id_product+"','"+quant_pro+"',"+date+",'"+state+"')";
		
		try {
			command = (Statement) connect.createStatement();
			command.executeUpdate(sql);
			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public boolean UpdateEmployee (String dni, String name, String last_names, String address, String email, String username, String password) throws SQLException {
		
		boolean verify = false;
		int confirm = 0;
		connect = connecting.getConexion();
		String sql = "UPDATE persona SET name = '"+name+"' ,last_names = '"+last_names+"' ,address = '"+address+"',email = '"+email+"',username = '"+username+"',password = '"+password+"' WHERE DNI = '"+dni+"'";
		
		if (address == "0" && last_names == "0" && email == "0" && username == "0" && password == "0") {
			sql = "UPDATE persona SET name = '"+name+"' WHERE DNI = '"+dni+"'";
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

		}
		else if (name == "0" && address == "0" && email == "0" && username == "0" && password == "0") {
			sql = "UPDATE persona SET last_names = '"+last_names+"' WHERE DNI = '"+dni+"'";
			try {
				connect = connecting.getConexion();
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
		}
		else if (name == "0" && last_names == "0" && email == "0" && username == "0" && password == "0") {
			sql = "UPDATE persona SET address = '"+address+"' WHERE DNI = '"+dni+"'";
			try {
				connect = connecting.getConexion();
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
		}
		else if (name == "0" && last_names == "0" &&  address == "0" && username == "0" && password == "0") {
			sql = "UPDATE persona SET email = '"+email+"' WHERE DNI = '"+dni+"'";
			try {
				connect = connecting.getConexion();
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
		}
		else if (name == "0" && last_names == "0" && address == "0" && password == "0" && email == "0") {
			sql = "UPDATE persona SET username = '"+username+"' WHERE DNI = '"+dni+"'";
			try {
				connect = connecting.getConexion();
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
		}
		else if (name == "0" && last_names == "0" && address == "0" && username == "0" && email == "0" ) {
			sql = "UPDATE persona SET password = '"+password+"' WHERE DNI = '"+dni+"'";
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
		}
		else {
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
		}
		return verify;
		
	}
	public void UpdateProductAll (String id, String name, String type, String price) throws SQLException {
		int id_tipo_aux = ProductType(type);
		connect = connecting.getConexion();
		String sql = "UPDATE producto SET id_tipo_aux='"+id_tipo_aux+"', name='"+name+"', price='"+price+"' WHERE id_producto='"+id+"'";
		
		try {
			command = (Statement) connect.createStatement();
			command.executeUpdate(sql);

			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void UpdateProductType (String id, String type) throws SQLException {
		int id_tipo_aux = ProductType(type);
		connect = connecting.getConexion();
		String sql = "UPDATE producto SET id_tipo_aux='"+id_tipo_aux+"' WHERE id_producto='"+id+"'";
		
		try {
			command = (Statement) connect.createStatement();
			command.executeUpdate(sql);

			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void UpdateProductName (String id, String name) throws SQLException {
		connect = connecting.getConexion();
		String sql = "UPDATE producto SET name='"+name+"' WHERE id_producto='"+id+"'";
		
		try {
			command = (Statement) connect.createStatement();
			command.executeUpdate(sql);

			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void UpdateProductPrice (String id, String price) throws SQLException {
		connect = connecting.getConexion();
		String sql = "UPDATE producto SET price='"+price+"' WHERE id_producto='"+id+"'";
		
		try {
			command = (Statement) connect.createStatement();
			command.executeUpdate(sql);

			command.close();
			connect.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
