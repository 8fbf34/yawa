package domain.employee;

import java.util.Date;

import domain.taxes.FedTaxSchedule;

public class Employee {
	private String firstName;
	private String lastName;
	private Date dob;
	private Double biWeekly;
	
	public Employee(String f, String l, Double b) {
		firstName = f;
		lastName = l;
		biWeekly = b;
	}
	
	public String[] describe() {
		return new String[]{
				String.format("First name:  \t%s", firstName), 
				String.format("Last name:   \t%s", lastName), 
				String.format("Biweekly Pay:\t%s", biWeekly.toString()),
				String.format("Taxes:       \t%f", FedTaxSchedule.calcTax(this))
		};
	}
	
	public String getName() {
		return String.join(" ", firstName, lastName);
	}
	
	public Double getBiWeekly() {
		return biWeekly;
	}
	
	public Double getYearly() {
		return 26.0 * biWeekly;
	}
}
