package test;

import java.util.Date;

import com.base.util.Tools;

public class test5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       String s="2014-01-13 23:59";
       Date d=Tools.convertToDateTime(s);
       System.out.println(d.toLocaleString());
	}

}
