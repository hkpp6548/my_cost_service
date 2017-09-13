package testController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/** 测试用
 * Created by dahoufang the one on 2017/8/29.
 */
public class TestController {
	public static void main (String args[])
	{
		try
		{
			String ts = "2007-10-23T17:15:44.000";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
			Date dt = sdf.parse(ts);
			long time = dt.getTime();
			String s = String.valueOf(time);

			Date date = new Date(time);
			SimpleDateFormat sdfSSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format = sdfSSS.format(date);
			System.out.println(format);
			/*TimeZone tz = sdf.getTimeZone();
			Calendar c = sdf.getCalendar();
			System.out.println("Display name: " +tz.getDisplayName());
			System.out.println(getString(c));*/
		}
		catch(ParseException pe)
		{
			System.out.println("Error offset: " + pe.getErrorOffset());
			pe.printStackTrace();
		}
	}


	private static String getString(Calendar c)
	{
		StringBuffer result = new StringBuffer();
		result.append(c.get(Calendar.YEAR));
		result.append("-");
		result.append((c.get(Calendar.MONTH) + 1));
		result.append("-");
		result.append(c.get(Calendar.DAY_OF_MONTH));
		result.append(" ");
		result.append(c.get(Calendar.HOUR_OF_DAY));
		result.append(":");
		result.append(c.get(Calendar.MINUTE));
		result.append(":");
		result.append(c.get(Calendar.SECOND));
		return result.toString();
	}

	/*
   * 将时间戳转换为时间
   */
	public static String stampToDate(String s, String format) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		long lt = new Long(s);
		Date date = new Date(lt);
		res = simpleDateFormat.format(date);
		return res;
	}

	/*
	 * 将时间转换为时间戳
	 */
	public static String dateToStamp(String s, String format) {
		String res;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		try {
			date = simpleDateFormat.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return s;
		}
		long ts = date.getTime();
		res = String.valueOf(ts);
		return res;
	}

}
