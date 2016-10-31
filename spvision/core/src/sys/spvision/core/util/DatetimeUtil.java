package sys.spvision.core.util;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DatetimeUtil {

	public static String date2StringDate(Date date) {
		if (date == null) {
			return "";
		}

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}

	public static String date2StringDatetime(Date date) {
		if (date == null) {
			return "";
		}

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}

	public static String date2StringTime(Date date) {
		if (date == null) {
			return "";
		}

		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(date);
	}

	public static String timestamp2StringDate(Timestamp t) {
		if (t == null) {
			return "";
		}

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(t);
	}

	public static String timestamp2StringTime(Timestamp t) {
		if (t == null) {
			return "";
		}

		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(t);
	}

	public static String timestamp2StringDatetime(Timestamp t) {
		if (t == null) {
			return "";
		}

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(t);
	}

	public static Date string2Date(String str) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return new Date(df.parse(str).getTime());
	}

	public static Date string2Datetime(String str) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return new Date(df.parse(str).getTime());
	}

	public static Date string2Time(String str) throws ParseException {
		DateFormat df = new SimpleDateFormat("HH:mm:ss");
		return new Date(df.parse(str).getTime());
	}

	public static Timestamp string2Timestamp(String str) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = df.parse(str);
		String time = df.format(date);
		return Timestamp.valueOf(time);
	}

	// T+1 非工作日
	public static Date periodStartTime(Integer period) {
		Calendar time = Calendar.getInstance();
		int day = time.get(Calendar.DAY_OF_YEAR);
		time.set(Calendar.DAY_OF_YEAR, day + 1);
		time.set(Calendar.MONTH, time.get(Calendar.MONTH) + period - 1);
		return new Date(time.getTime().getTime());
	}

	public static Date periodEndTime(Integer period) {
		Calendar time = Calendar.getInstance();
		int day = time.get(Calendar.DAY_OF_YEAR);
		time.set(Calendar.DAY_OF_YEAR, day + 1);
		time.set(Calendar.MONTH, time.get(Calendar.MONTH) + period);
		return new Date(time.getTime().getTime());
	}

	public static String getCurrentDateTime(String formatType) {
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		return sdf.format(date);
	}

	/**
	 * 返回两个日期之间的天数，每月为30天，每年为360天
	 * @param start 开始日期
	 * @param end   结束日期
	 * @return  间隔的天数
	 */
	public static int getDateInterval(java.sql.Date start, java.sql.Date end) {
		GregorianCalendar startCal = new GregorianCalendar();
		GregorianCalendar endCal = new GregorianCalendar();
		startCal.setTime(start);
		endCal.setTime(end);
		int startYear=startCal.get(Calendar.YEAR);
		int endYear=endCal.get(Calendar.YEAR);
		int startMonth=startCal.get(Calendar.MONTH);
		int endMonth=endCal.get(Calendar.MONTH);
		int months = 0;
	    if(startYear==endYear){
	    	months=endMonth - startMonth;
	    }else{
	    	months=12*(endYear-startYear)+ endMonth-startMonth;//两个日期相差几个月，即月份差
	    }
	   // months = months == 0 ? 0 : months - 1;
	    int startDay = startCal.get(Calendar.DATE)==31?30:startCal.get(Calendar.DATE);
		int endDay = endCal.get(Calendar.DATE)==31?30:endCal.get(Calendar.DATE);
		int gap=months * 30 + endDay -startDay;
		return gap;
	}

	
	public static int dateDiff(String start, String end) {
		 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", new Locale("zh", "cn"));
		try{
			long t1 = simpleDateFormat.parse(start).getTime();
            long t2=simpleDateFormat.parse(end).getTime();
            int diff=(int)((t2-t1)/1000);
            return diff;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
	}
	
	public static String dateStringMinner(String date1, String date2){
		if(date1.compareTo(date2) > 0){
			return date2;
		}
		return date1;
	}
	
	/*public static void main(String[] args) throws Exception {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println(DatetimeUtil.dateDiff("2014-07-31 18:59:00","2014-08-03 00:00:00"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date1 = sdf.parse("2014-2-1");

		java.util.Date date2 = sdf.parse("2015-3-14");
		long gap = DatetimeUtil.getDateInterval(date1, date2);
		System.out.println("\n相差" + gap + "天");
	}
*/
}
