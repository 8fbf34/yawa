package test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import domain.parking.ParkingTicket;
import domain.parking.ValetTicket;

class TestWhateverHeIsDoing {
	
	
	/*
	 * Parking ticket
	 * 	Entry time
	 * 	Exit time
	 * 
	 * Time is three integers (days:hours:minutes)
	 * 
	 * Rules:
	 * $2/hour
	 * $15 daily max
	 * 7th day free
	 * 1st day only, first half hour free
	 * 
	 * Cases:
	 * Days	Hrs	Min	Fee
	 * 0	0	0	0
	 * 0	0	29	0
	 * 0	0	30	0
	 * 0	0	31	2
	 * 0	0	45	2
	 * 0	1	29	2
	 * 0	1	30	2
	 * 0	1	31	4
	 * 0	7	30	14
	 * 0	7	31	15
	 * 1	0	30	15
	 * 1	0	31	17
	 * 2	0	30	30
	 * 2	0	31	32
	 * 6	0	30	90
	 * 6	0	31	90
	 * 7	0	30	90
	 * 7	0	31	92
	 */
	
	@Test
	void testTicketCosts() {
		buildParkingCases().forEach(c -> {
			int should = c.getCost();
			int is = c.getParkingTicket().ProcessTicket();
			System.out.printf("Processing ticket with %s\n", c.getParkingTicket().toString());
			assertEquals(should, is);
		});
	}
	
	@Test
	void testValetCosts() {
		buildValetCases().forEach(c -> {
			int should = c.getCost();
			int is = c.getParkingTicket().ProcessTicket();
			System.out.printf("Processing ticket with %s\n", c.getParkingTicket().toString());
			assertEquals(should, is);
		});
		
	}
	
	ArrayList<TicketCostCase> buildParkingCases() {
		ArrayList<TicketCostCase> cases = new ArrayList<>();
		cases.add(new TicketCostCase(new ParkingTicket(2, 13, 0),	60));
		return cases;
	}
	
	ArrayList<TicketCostCase> buildValetCases() {
		ArrayList<TicketCostCase> valetCases = new ArrayList<>();
		valetCases.add(new TicketCostCase(new ValetTicket(2, 5, 25),	58));
		return valetCases;
	}

	
	private class TicketCostCase {
		private ParkingTicket t;
		private int c;
		
		public TicketCostCase(ParkingTicket ticket, int cost) {
			t = ticket;
			c = cost;
		}
		
		public ParkingTicket getParkingTicket() {
			return t;
		}
		
		public int getCost() {
			return c;
		}
		
		public boolean equals() {
			return t.ProcessTicket() == c;
		}
	}
}
