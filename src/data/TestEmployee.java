package data;

public class TestEmployee {

	public static void main(String[] args) {
		EmployeDao dao = new EmployeeDBDao();
		Employee emp = dao.getEmpById(1123);
		System.out.println(emp);

	}

}
