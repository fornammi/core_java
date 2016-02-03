package daniel.java.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateHelper {

	public static void main(String[] args) {
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//毫秒数转为java.util.Date类型
		java.util.Date dt = new Date(1440640144000L);  
		String sDateTime = sdf.format(dt);  //得到精确到秒的表示：08/31/2006 21:08:00
		System.out.println(sDateTime);
	}
}
