package cn.mycar.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.javafx.binding.StringFormatter;

public class Dateandtime {
//获取时间
public static String Datetime() {
	Date currentTime = new Date();
	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	  String dateString = formatter.format(currentTime);
	return dateString;
}
}
