package testController;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 测试用
 * Created by dahoufang the one on 2017/8/29.
 */
public class TestController {
	public static void main (String args[])
	{

		/*int a  = 2 << 3;
		System.out.println(a);
		try
		{
			String ts = "2017-09-20T18:00:00.000";
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
												       //yyyy-mm-dd'T'HH:mm:ss.SSS
			Date dt = sdf.parse(ts);
			long time = dt.getTime();
			String s = String.valueOf(time);

			Date date = new Date(time);
			SimpleDateFormat sdfSSS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String format = sdfSSS.format(date);
			System.out.println(format);
			*//*TimeZone tz = sdf.getTimeZone();
			Calendar c = sdf.getCalendar();
			System.out.println("Display name: " +tz.getDisplayName());
			System.out.println(getString(c));*//*
		}
		catch(ParseException pe)
		{
			System.out.println("Error offset: " + pe.getErrorOffset());
			pe.printStackTrace();
		}*/

		testPattern();
	}

	public static void testPattern(){
		// 要验证的字符串
		String str = "a2b$";
		String regEx = "^[a-zA-Z]\\w{3,15}$";
		// 编译正则表达式
		Pattern pattern = Pattern.compile(regEx);
		// 忽略大小写的写法
		// Pattern pat = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		// 字符串是否与正则表达式相匹配
		boolean rs = matcher.matches();
		System.out.println(rs);
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
