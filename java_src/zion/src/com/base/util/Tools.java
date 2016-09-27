package com.base.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.security.*;

public class Tools
{

    private static HashMap  hm = new HashMap();
    public Tools()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public static boolean isEmptyString(String s)
    {
        if (s == null || s.trim().length() == 0)
            return true;
        return false; 
    }
    
    public static java.util.Date convertToDate(String date)
    {
        if (date != null && date.length() > 0) {
            java.text.SimpleDateFormat dmj= new java.text.SimpleDateFormat("yyyy/MM/dd");
            
           try{
                return dmj.parse(date);
           }catch(java.text.ParseException e){
               e.printStackTrace();
           } 
        }
        
        return null;
    }

    public static String dateToString(java.util.Date date)
    {
        if (date != null) {
            java.text.SimpleDateFormat dmj= new java.text.SimpleDateFormat("yyyy/MM/dd");
            String s = dmj.format(date);
            return s;
        }
        
        return null;
    }

    public static Timestamp getCurrentTimestamp()
    {
        return new Timestamp(System.currentTimeMillis());
    }

    public static String formatSimpleDate(java.util.Date d)
    {
        String s = "";
        if (d != null) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");
            
            return sdf.format(d);
        }
            
        return null;
    }

    public static String firstCharToLowerCase(String pString_) 
    {
        String sRetVal = new String();
        if (pString_ == null || pString_.length() == 0) 
        {
            return(sRetVal);
        }
        sRetVal = pString_.substring(0, 1).toLowerCase() +
               pString_.substring(1, pString_.length());
        
        return(sRetVal);
    }

    public static String firstCharToUpperCase(String pString_) 
    {
        String sRetVal = new String();
        if (pString_ == null || pString_.length() == 0) 
        {
            return(sRetVal);
        }
        sRetVal = pString_.substring(0, 1).toUpperCase() +
               pString_.substring(1, pString_.length());
        
        return(sRetVal);
    }
    
    public static String getUniqueId() 
    {
        Date ts = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmssSSS.");
        String txt = fmt.format(ts);

        if (hm.get(txt) != null) {
            int a = ((Integer) hm.get(txt)).intValue() + 1;
            hm.put(txt, new Integer(a));
            return txt + a;
        } else {
            hm.clear();
            hm.put(txt, new Integer(0));
            return txt + "0";
        }
    }
    
    public static void main(String[] arg)
    {
        for (int i=0; i < 1000; i++) {
            System.out.println(getUniqueId() + ",");
        }
    }
    
    public static Long convertEncryptStringToId(String str)
    {
        String a = campus.tool.util.security.Util.decrypt(str);
        long aid;
        try {
            aid = Long.parseLong(a);
        } catch (NumberFormatException ex) {
            throw null;
        }
        return new Long(aid);
    }
    

    public static String md5(String m){
      String pass="";
       try{        
            byte[] defaultBytes = m.getBytes();
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();
              StringBuffer hexString = new StringBuffer();
                for (int i=0;i<messageDigest.length;i++) {
  	       String hex = Integer.toHexString(0xFF & messageDigest[i]); 
  	         if(hex.length()==1)
  	           hexString.append('0');
  	          hexString.append(hex);
                  }
                pass = hexString+"";
        }catch(Exception e){
              System.out.println("MDF FAIL()");	 
        }	
        return pass;
     } 
    
    public static Date getToday(){
    	Date t=new Date();
    	return t;
    }
    
    public static String getLivelyBibleDate() 
    {
        Date ts = new Date();
        SimpleDateFormat fmt = new SimpleDateFormat("MMdd");
        String txt = fmt.format(ts);
        return txt;      
    }


}
