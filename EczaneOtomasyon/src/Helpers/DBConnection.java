package Helpers;
import java.sql.*;
import com.mysql.*;
public class DBConnection {
Connection c =null;
public DBConnection() {}
public Connection connDb() {
	try {
		this.c=DriverManager.getConnection("jdbc:mysql://localhost:3306/eczaneotomasyon","root","1234");
		return c;
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block3
		e.printStackTrace();
	}
	return c;

	
}
}
