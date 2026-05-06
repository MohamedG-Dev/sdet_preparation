package prep.day2;

public class Employee {
	private String empName;
	private String empID;
	private String project;
	private double salary;
	private String companyName;

	private Employee(String empName, String empID, String project, double salary, String companyName) {
		super();
		this.empName = empName;
		this.empID = empID;
		this.project = project;
		this.salary = salary;
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empID=" + empID + ", project=" + project + ", salary=" + salary
				+ ", companyName=" + companyName + "]";
	}

	// Inner class - it can be static
	public static class Builder {
		private String empName;
		private String empID;
		private String project;
		private double salary;
		private String companyName;

		public Builder setEmpName(String empName) {
			this.empName = empName;
			return this;// current Builder Object instance
		}

		public Builder setEmpID(String empID) {
			this.empID = empID;
			return this;
		}

		public Builder setProject(String project) {
			this.project = project;
			return this;
		}

		public Builder setSalary(double salary) {
			this.salary = salary;
			return this;
		}

		public Builder setCompanyName(String companyName) {
			this.companyName = companyName;
			return this;
		}

		public Employee build() {
			return new Employee(empName, empID, project, salary, companyName);
		}
	}

}
