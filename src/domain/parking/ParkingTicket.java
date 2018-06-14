package domain.parking;

public class ParkingTicket {
	
	private int d;
	private int h;
	private int m;
	
	private boolean hasFreeDayRule = true;
	private int hrRate = 3;
	private int freeTime = 15;
	private int maxDaily = 20;
	private int freeDayEvery = 7;
	
	public ParkingTicket(int days, int hours, int minutes) {
		d = days;
		h = hours;
		m = minutes;
	}
	
	public int ProcessTicket() {
		int total = 0;
		int maxHoursADay = maxDaily / hrRate;
		
		boolean freeDay = false;
		// get total from days
		if(hasFreeDayRule) {
			total += (d - d/freeDayEvery) * maxDaily;
			freeDay = ((d+1)%freeDayEvery) == 0;
		} else {
			total += d * maxDaily;
		}
		// get total from remainder
		if(d==0) {
			if((h>=maxHoursADay && m>freeTime) || h>maxHoursADay) {
				// if we're over the max daily charge
				total += maxDaily;
			} else {
				// pay per hour minus complimentary time
				total += (h+(m/(freeTime+1)))*hrRate; 
			}
		} else if(!freeDay){ // not a free day? you're gonna pay for it
			if((h>=maxHoursADay && m>0) || h>maxHoursADay) {
				// if we're over the max daily charge
				total += maxDaily;
			} else {
				// pay per hour minus complimentary time
				total += (h+(m>0?1:0))*hrRate; 
			}
			
		}
		
		return total;
	}
	
	public String toString() {
		return String.format("%2d:%2d:%2d", d, h, m);
	}
}
