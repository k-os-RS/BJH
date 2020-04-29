package gestion_db;

import java.sql.*;
import com.mysql.jdbc.Statement;

public class metodos_db {
	
	private conexion_db conecting = new conexion_db();
	private Connection connect;
	private Statement command;
	private ResultSet data;
}
