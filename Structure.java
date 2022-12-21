package Park;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public abstract class Structure {
	Connection c;
	Statement s;
	Scanner scan;
	int id;
	
	Structure() throws SQLException {
		c = DriverManager.getConnection("jdbc:mysql://localhost:3306/parkinglot", "root", "33");
		s = c.createStatement();
		scan = new Scanner(System.in);
	}
	
	public abstract void insert() throws SQLException;
	public abstract void update() throws SQLException;
	public abstract void delete() throws SQLException;
	public abstract void showByID() throws SQLException;
}
