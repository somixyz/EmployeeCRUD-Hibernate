package starter;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {

	public static void main(String[] args) {

		try {
			String jdbcURL = "jdbc:mysql://localhost:3306/hb_employee_crud?useSSL=false&serverTimezone=UTC";
			String user = "root";
			String pass = "Milos.1993";
			System.out.println("Connceting to database: " + jdbcURL);
			
			Connection con = DriverManager.getConnection(jdbcURL, user, pass);

			System.out.println("Connection succesful ");
			
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
