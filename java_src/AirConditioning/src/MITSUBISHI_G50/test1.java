package MITSUBISHI_G50;

import com.base.util.Tools;

import java.util.*;
import java.text.*;

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		/*
		Calendar c = Calendar.getInstance();                   
		c = Calendar.getInstance();         
		c.set(Calendar.DAY_OF_WEEK, 1);		               
		System.out.println(sdf.format(c.getTime())); 
		*/
		for(int i=1;i<=7;i++){
			Calendar c = Calendar.getInstance();                   
			c = Calendar.getInstance();         
			c.set(Calendar.DAY_OF_WEEK, i);		               
			System.out.println(sdf.format(c.getTime())+"--week="+c.getTime().getDay()); 	
		}
		
		/*
		c = Calendar.getInstance(); 
        c.set(Calendar.DAY_OF_WEEK, 7);
        System.out.println(sdf.format(c.getTime())); 
		*/
		//System.out.println(d.);
		/*
		Calendar c = new GregorianCalendar();
		
		c.set(Calendar.YEAR, year);
		c.set(Calendar.WEEK_OF_YEAR, week);

		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek());
		System.out.println(c.getTime());

		c.roll(Calendar.DAY_OF_WEEK, 6);
		System.out.println(c.getTime());

	    System.out.println(c.MONTH);
	    */
	}

}
