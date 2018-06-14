package domain.taxes;

import domain.employee.Employee;

public class TaxSchedule {
	
	private final static double RATE = 0.0;
	
	public static Double calcTax(Employee e) {
		return RATE * e.getYearly();
	};
}
