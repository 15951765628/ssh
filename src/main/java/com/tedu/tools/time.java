package com.tedu.tools;

import java.text.SimpleDateFormat;
import java.util.Date;

public class time {

	//获取时间
		public static Date getDate(){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			java.util.Date time=null;
			try {
			   time= sdf.parse(sdf.format(new Date()));

			} catch (Exception e) {

			   e.printStackTrace();
			}
			return time;
		}
}
