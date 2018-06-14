package domain.parking;

public class ValetTicket extends ParkingTicket {
	
	boolean hasFreeDayRule = true;
	int hrRate = 5;
	int freeTime = 0;
	int maxDaily = 50;
	int freeDayEvery = 7;
	
	public ValetTicket(int days, int hours, int minutes) {
		super(days, hours, minutes);
	}
	
}
