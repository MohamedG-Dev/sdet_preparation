package prep.day23;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
		Employee e1 = new Employee(101, "Jatin", "QA", 10000);
		// System.out.println(e1);
		List<Employee> empList = new ArrayList<>();
		empList.add(e1);
		empList.add(new Employee(102, "Rohit", "Developer", 30000));
		empList.add(new Employee(103, "Rahul", "DevOps", 35000));
		empList.add(new Employee(104, "Leach", "Developer", 40000));
		empList.stream().filter(e -> e.getSalary() > 10000).forEach(System.out::println);

		// sort the list on the basis of salary
		System.out.println("*************Sorting the list basis of salary********************");
		List<Employee> sortedBySalaryList = empList.stream()
				.sorted((emp1, emp2) -> Double.compare(emp1.getSalary(), emp2.getSalary()))
				.collect(Collectors.toList());
		sortedBySalaryList.forEach(System.out::println);

	}

}
