package vn.edu.hust.ooad.subjectmanagersys.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeHandler {
	
	public static String datetimeToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		return sdf.format(date);
	}
}
