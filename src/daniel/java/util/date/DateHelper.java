package daniel.java.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateHelper {

	public static void main(String[] args) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//毫秒数转为java.util.Date类型
		java.util.Date dt = new Date(1440640144000L);  
		String sDateTime = sdf.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00
		System.out.println(sDateTime);
		
		Date d = new Date();
		System.out.println("当前时间："+d);
		Date o = DateHelper.skipWorkDate(d, 5);
		System.out.println("5个工作日后："+o);
	}
	
	public static Date skipWorkDate(Date date, int skipDay) {
		GregorianCalendar after = new GregorianCalendar();
		after.setTime(date);
		int i = 1;
		while(i <= skipDay){//i表示执行循环的总次数
			after.add(Calendar.DAY_OF_WEEK, 1); //增加一天
			int dayOfWeek = after.get(Calendar.DAY_OF_WEEK);//下一天
			//继续下一次循环之前
			if (dayOfWeek == 1 || dayOfWeek == 7) {
				//下一天是周末(=1,周日;=7，周六)：总次数不变
			} else {
				//下一天是工作日：总次数减少一次
				i++;
			}
		}
		return after.getTime();
	}
}
