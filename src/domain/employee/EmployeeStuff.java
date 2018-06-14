package domain.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class EmployeeStuff {

	public static void main(String[] args) {
		ArrayList<Employee> employeeList = buildEmployeeList();

		System.out.printf(
				"The total of all yearly salaries is:\t%s\n", 
				employeeList.parallelStream().mapToDouble(Employee::getYearly).sum());
		
		employeeList.stream().forEach(e -> {
			System.out.println("---Employee Information---");
			Arrays.asList(e.describe()).stream().forEach(info -> System.out.println(info));
			System.out.println("--------------------------\n");
		});
		
	}
	
	private static ArrayList<Employee> buildEmployeeList() { 
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee("Adam", "Wheelock", 4000.0));
		employeeList.add(new Employee("Mark", "Sobdodo", 3500.0));
		employeeList.add(new Employee("Alex", "Mueller", 2400.20));
		employeeList.add(new Employee("Chris", "Stephens", 2500.0));
		employeeList.add(new Employee("Doug", "Welder", 3000.50));
		employeeList.add(new Employee("Clark", "Kent", 25.0));
		employeeList.add(new Employee("Bruce", "Wayen", 15000.13));
		employeeList.add(new Employee("Gordon", "Ramsey", 12000.0));
		employeeList.add(new Employee("Garth", "Brooks", 3500.0));
		employeeList.add(new Employee("Wayne", "Broski", 2350.0));
		employeeList.add(new Employee("Timmy", "from Southpark", 120.0));
		employeeList.add(new Employee("Dr.", "House", 20000.0));
		employeeList.add(new Employee("James", "Bond", 0.0));
		return employeeList;
	}
}
