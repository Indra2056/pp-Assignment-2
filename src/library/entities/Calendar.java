package library.entities;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Calendar {
	
	private static Calendar self; //changed sElF to self
	private static java.util.Calendar calendar; //changed cAlEnDaR to calendar
	
	
	private Calendar() {
		calendar = java.util.Calendar.getInstance(); //changed cAlEnDaR to calendar
	}
	
	public static Calendar getInstance() //changed gEtInStAnCe to getInstance
	{
		if (self == null) //changed sElF to self
		{
			self = new Calendar(); //changed sElF to self
		}
		return self; //changed sElF to self
	}
	
	public void incrementDate(int days) {
		calendar.add(java.util.Calendar.DATE, days);	//changed cAlEnDaR to calendar	
	}
	
	public synchronized void setDate(Date DaTe) //changed SeT_DaTe to setDate
	{
		try {
			calendar.setTime(date); //changed DaTe to date
	        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);  //changed cAlEnDaR to calendar
	        calendar.set(java.util.Calendar.MINUTE, 0);   //changed cAlEnDaR to calendar
	        calendar.set(java.util.Calendar.SECOND, 0);  //changed cAlEnDaR to calendar
	        calendar.set(java.util.Calendar.MILLISECOND, 0); //changed cAlEnDaR to calendar
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	public synchronized Date getDate() // changed gEt_DaTe to getDate
	{
		try {
	        calendar.set(java.util.Calendar.HOUR_OF_DAY, 0);  //changed cAlEnDaR to calendar
	        calendar.set(java.util.Calendar.MINUTE, 0);  //changed cAlEnDaR to calendar
	        calendar.set(java.util.Calendar.SECOND, 0);  //changed cAlEnDaR to calendar
	        calendar.set(java.util.Calendar.MILLISECOND, 0); //changed cAlEnDaR to calendar
			return calendar.getTime();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}

	public synchronized Date getDueDate(int loanPeriod) //changed gEt_DuE_DaTe to getDueDate
	{
		Date now = getDate(); // changed gEt_DaTe to getDate
		calendar.add(java.util.Calendar.DATE, loanPeriod); //changed cAlEnDaR to calendar
		Date dueDate = calendar.getTime(); //changed cAlEnDaR to calendar and dUeDaTe to dueDate
		calendar.setTime(now); //changed cAlEnDaR to calendar
		return dueDate; // changed dUeDaTe to dueDate
	}
	
	public synchronized long getDaysDifference(Date targetDate) //changed GeT_DaYs_DiFfErEnCe to getDaysDifference
	{
		
		long diffMillis = getDate().getTime() - targetDate.getTime(); // changed gEt_DaTe to getDate
	    long diffDays = TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS); //changed Diff_Days to diffDays
	    return diffDays; //changed Diff_Days to diffDays
	}

}

