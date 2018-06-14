package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import domain.string.shit.ZStripper;

class TestZStripper {

	@Test
	void testZsRemoved() {
		ArrayList<StringPair> testStringPairs = new ArrayList<>();
		testStringPairs.add(new StringPair("", ""));
		testStringPairs.add(new StringPair("Z", ""));
		testStringPairs.add(new StringPair("ZZ", ""));
		testStringPairs.add(new StringPair("ZABC", "ABC"));
		testStringPairs.add(new StringPair("AZBC", "ABC"));		
		//testStringPairs.add(new StringPair("ZAZBC", "AZBC"));
		
		for(StringPair p : testStringPairs) {
			String stripped = ZStripper.strip(p.getFirst());
			System.out.printf("Before: '%s'\tStripped: '%s'\t Should Be: '%s'\n", 
					p.getFirst(),
					stripped, 
					p.getSecond());
			assertEquals(stripped, p.getSecond());
		}
	}

	
	@Test
	void testNoZsInFirstTwo() {
		ArrayList<StringPair> testStringPairs = new ArrayList<>();
		testStringPairs.add(new StringPair("ZZZ", ""));
		testStringPairs.add(new StringPair("ZAZAZ", "AAZ"));
		testStringPairs.add(new StringPair("AZZAZ", "AAZ"));
		testStringPairs.add(new StringPair("ZZZZ", ""));
		testStringPairs.add(new StringPair("ZZZZZZZZZ", ""));
		
		for(StringPair p : testStringPairs) {
			String stripped = ZStripper.strip(p.getFirst());
			System.out.printf("Before: '%s'\tStripped: '%s'\t Should Be: '%s'\n", 
					p.getFirst(),
					stripped, 
					p.getSecond());
			assertEquals(stripped, p.getSecond());
		}
	}
	
	private class StringPair {
		String a;
		String b;
		public StringPair(String a, String b) {
			this.a = a;
			this.b = b;
		}
		
		public String getFirst() {
			return a;
		}
		
		public String getSecond() {
			return b;
		}
	}
}
