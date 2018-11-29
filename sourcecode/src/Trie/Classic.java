package Trie;

import java.util.Calendar;
import java.util.Date;

public class Classic {
	public static void main(String[] args) {
		Date d1 = new Date();
		Calendar cal = Calendar.getInstance();
		
		Date d2 = new Date("2/2/2017");
		if (d1.before(d2))
			System.out.println("This is true");
		System.out.println(cal.getTime());
	}

}
