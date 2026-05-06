package prep.day2;

public class Runner {

	public static void main(String[] args) {
		Employee e1 = new Employee.Builder().setEmpName("John Doe").setEmpID("E102").setProject("Test Project")
				.setSalary(1001).setCompanyName("Test Company").build();
		System.out.println(e1);
		

	}

}
