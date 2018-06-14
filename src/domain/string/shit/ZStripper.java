package domain.string.shit;

public class ZStripper {
	public static String strip(String s) {
		switch(s.length()) {
		case 0:
			return s;
		case 1:
		case 2:
			if(s.contains("Z"))
				return strip(s.substring(0).replaceAll("Z", ""));
			else
				return s.substring(0).replaceAll("Z", "");
		default:
			if(s.substring(0,2).contains("Z"))
				return strip(s.substring(0, 2).replaceAll("Z", "") + s.substring(2));
			else
				return s.substring(0, 2).replaceAll("Z", "") + s.substring(2);
		}
	}
}
