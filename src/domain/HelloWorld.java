package domain;

import java.util.Arrays;
import domain.StringHolderClass;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String intro = "Hi it's Tom and this is ";
		String outro = "awesome";
		if(args.length > 0) {
			outro = args[0];
		}
		System.out.println(intro + outro);
		
		String[] exampleStrs = {"ab", "cd", "12", "34"};
		
		Arrays.asList(exampleStrs)
			.stream()
			.forEach(System.out::println);
		

		StringHolder sh = new StringHolder();
		StringHolderClass shc = new StringHolderClass();
		String s = new String("ab");
		String t = "ab";
		System.out.printf("s == t:\t%b\n", s==t);
		System.out.printf("s == getAb():\t%b\n", s==getAb());
		System.out.printf("s == sh.getS():\t%b\n", s==sh.getS());
		System.out.printf("s == shc.getS():\t%b\n", s==shc.getS());
		
	}
	
	private static String getAb() {
		return "ab";
	}
	
	
	private static class StringHolder {
		private String s;
		
		public StringHolder() {
			this.s = "ab";
		}
		
		public String getS() {
			return this.s;
		}
	}
}
