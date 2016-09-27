package test;

import java.util.Date;

import com.base.util.Tools;

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		String beginDate="2013-11-22";
		String s="0915";
		String start=beginDate+" "+s.substring(0,2)+":"+s.substring(2,4);
		Date d=Tools.convertToDateTime(start);
        System.out.println(d);
        */
		
		//yyyy-MM-dd HH:mm
        Date d=Tools.getCurrentTimestamp();
        String date=String.valueOf(d.getYear()+1900)+"-"+String.valueOf(d.getMonth()+1)+"-"+d.getDate()+" 00:00";
        String date1=String.valueOf(d.getYear()+1900)+"-"+String.valueOf(d.getMonth()+1)+"-"+d.getDate()+" 23:59";
        
        System.out.println(date);
        System.out.println(date1);
        
        System.out.println(Tools.convertToDateTime(date));
        System.out.println(Tools.convertToDateTime(date1));
	}

}
