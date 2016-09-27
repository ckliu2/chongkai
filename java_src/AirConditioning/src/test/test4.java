package test;

import com.base.util.Tools;
import java.text.*;

public class test4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	   DecimalFormat df = new DecimalFormat("00");
       String stime="1634";
       String now=df.format(Tools.getCurrentTimestamp().getHours())+df.format(Tools.getCurrentTimestamp().getMinutes());
	   //System.out.println(now);
	   if(Integer.parseInt(now) >=Integer.parseInt(stime)  ){
		   System.out.println("shutdown");
		   
	   }
	}

}
