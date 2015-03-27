package learn.java.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _dbConnect {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	_dbConnect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/DB_home","root","root@123");
			st = con.createStatement();
			System.out.println(st);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getData(){
		try {
			String query = "Select * from departments";
			rs = st.executeQuery(query);
			while(rs.next()){
				String d_id = rs.getString("department_id");
				String d_name = rs.getString("Department_name");
				System.out.println("Dept Id: "+d_id+" Dept Name: "+d_name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
}
