package test;

import java.util.Date;

import com.base.util.Tools;

public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.Calendar Cal=java.util.Calendar.getInstance();   
		Cal.add(java.util.Calendar.MINUTE,3);  
		Date d=Cal.getTime();
		System.out.println("date:"+d);   
	}

}
