package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeDBDao implements EmployeDao{
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/companydb";
    
	
	@Override
	public Employee getEmpById(int id) {
		String sql = "select firstname, lastname from employees where id = " + id;
		Employee emp = null;
		try {
			Class.forName(DRIVER_CLASS_NAME);
			Connection conn = DriverManager.getConnection(URL, "student", "student");
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if(rs.next()){
				String firstName = rs.getString(1);
				String lastName = rs.getString(2);
				emp = new Employee(firstName, lastName);
			}
			rs.close();
			statement.close();
			conn.close();
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return emp;
		
		
		
	}

}
