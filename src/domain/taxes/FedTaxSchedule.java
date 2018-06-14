package domain.taxes;

import domain.employee.Employee;

public class FedTaxSchedule extends SSTaxSchedule {
	public static Double calcTax(Employee e) {
		
		return SSTaxSchedule.calcTax(e) + getFedFor(e);
	}
	
	private static Double getFedFor(Employee e) {
		Double fedRate = 0.0;
		Double flatExtra = 0.0;
		Double hourly = e.getBiWeekly();
		if(hourly > 0 && hourly < 200) {
			// fedRate = 0.0
		} else if (hourly > 0 && hourly < 200) {
			fedRate = 0.10;
		} else if (hourly < 0){
			// this shouldn't happen but we're not using exceptions in this example
		} else {
			flatExtra = 20.0;
			fedRate = 0.15;
		}
		
		return flatExtra + fedRate * hourly;
	}
}
