package Trie;

import java.util.Calendar;

class Mine {
	private ThreadLocal<Calendar> cal = new ThreadLocal<Calendar>(){
		protected Calendar initialValue() {
			return Calendar.getInstance();
			
		}
		
	};
	public Calendar getCalendar(){
		return cal.get();
		
	}
}

public class TestLocal {

}
