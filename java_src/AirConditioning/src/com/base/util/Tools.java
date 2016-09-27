package com.base.util;

import java.io.*;
import java.net.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.security.*;

public class Tools {

    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public static Properties getAppProperties() {
	String propertiesFile = System.getProperty("catalina.base")
		+ "/webapps/AirConditioning/WEB-INF/classes/app_zh_TW.properties";
	Properties prop = new Properties();
	try {
	    prop.load(new FileInputStream(propertiesFile));
	} catch (Exception e) {
	    System.out.println("getAppProperties error=" + e.toString());
	}
	return prop;
    }

    private static HashMap hm = new HashMap();

    public Tools() {
	super();
	// TODO Auto-generated constructor stub
    }

    public static String uuid() {
	UUID uuid = UUID.randomUUID();
	return uuid.toString();
    }

    public static boolean isEmptyString(String s) {
	if (s == null || s.trim().length() == 0)
	    return true;
	return false;
    }

    public static Date getTodaydate1() {
	Date d = Tools.getCurrentTimestamp();
	String date = String.valueOf(d.getYear() + 1900) + "-"
		+ String.valueOf(d.getMonth() + 1) + "-" + d.getDate()
		+ " 00:00";
	return convertToDateTime(date);
    }

    public static Date getTodaydate2() {
	Date d = Tools.getCurrentTimestamp();
	String date = String.valueOf(d.getYear() + 1900) + "-"
		+ String.valueOf(d.getMonth() + 1) + "-" + d.getDate()
		+ " 23:59";
	return convertToDateTime(date);
    }

    public static java.util.Date convertToDateTime(String date) {
	if (date != null && date.length() > 0) { // 2013-10-04 00:00
	    java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat(
		    "yyyy-MM-dd HH:mm");
	    try {
		return dmj.parse(date);
	    } catch (java.text.ParseException e) {
		e.printStackTrace();
	    }
	}

	return null;
    }

    public static java.util.Date convertToDateTime1(String date) {
	if (date != null && date.length() > 0) { // 2014-04-18 15:39:51
						 // yyyy-MM-dd hh:mm:ss
	    java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat(
		    "yyyy-MM-dd hh:mm:ss.SSS");
	    try {
		return dmj.parse(date);
	    } catch (java.text.ParseException e) {
		System.out.println(e.toString());
	    }
	}

	return null;
    }

    public static java.util.Date convertToDate(String date) {
	if (date != null && date.length() > 0) {
	    java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat(
		    "yyyy/MM/dd");

	    try {
		return dmj.parse(date);
	    } catch (java.text.ParseException e) {
		e.printStackTrace();
	    }
	}

	return null;
    }

    public static java.util.Date convertToDate1(String date) {
	if (date != null && date.length() > 0) {
	    java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat(
		    "yyyy-MM-dd");

	    try {
		return dmj.parse(date);
	    } catch (java.text.ParseException e) {
		e.printStackTrace();
	    }
	}

	return null;
    }

    public static String dateToString(java.util.Date date) {
	if (date != null) {
	    java.text.SimpleDateFormat dmj = new java.text.SimpleDateFormat(
		    "yyyy/MM/dd");
	    String s = dmj.format(date);
	    return s;
	}

	return null;
    }

    public static Timestamp getCurrentTimestamp() {
	return new Timestamp(System.currentTimeMillis());
    }

    public static String formatSimpleDate2(int days, int s) {
	Calendar cal = Calendar.getInstance();
	cal.add(Calendar.DATE, days);
	if (s == 0) {
	    cal.set(Calendar.HOUR_OF_DAY, 0);
	    cal.set(Calendar.MINUTE, 0);
	} else {
	    cal.set(Calendar.HOUR_OF_DAY, 23);
	    cal.set(Calendar.MINUTE, 59);
	}
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
		"yyyy-MM-dd HH:mm");
	return sdf.format(cal.getTime());

    }

    public static String formatSimpleDate1(java.util.Date d) {
	String s = "";
	if (d != null) {
	    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
		    "yyyy-MM-dd HH:mm");

	    return sdf.format(d);
	}

	return null;
    }

    public static String formatSimpleDate2(java.util.Date d) {
	String s = "";
	if (d != null) {
	    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
		    "yyyy-MM-dd HH:mm:ss");

	    return sdf.format(d);
	}

	return null;
    }

    public static String formatSimpleDate(java.util.Date d) {
	String s = "";
	if (d != null) {
	    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(
		    "yyyy/MM/dd");

	    return sdf.format(d);
	}

	return null;
    }

    public static String firstCharToLowerCase(String pString_) {
	String sRetVal = new String();
	if (pString_ == null || pString_.length() == 0) {
	    return (sRetVal);
	}
	sRetVal = pString_.substring(0, 1).toLowerCase()
		+ pString_.substring(1, pString_.length());

	return (sRetVal);
    }

    public static String firstCharToUpperCase(String pString_) {
	String sRetVal = new String();
	if (pString_ == null || pString_.length() == 0) {
	    return (sRetVal);
	}
	sRetVal = pString_.substring(0, 1).toUpperCase()
		+ pString_.substring(1, pString_.length());

	return (sRetVal);
    }

    public static String getUniqueId() {
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


    public static Long convertEncryptStringToId(String str) {
	String a = campus.tool.util.security.Util.decrypt(str);
	long aid;
	try {
	    aid = Long.parseLong(a);
	} catch (NumberFormatException ex) {
	    throw null;
	}
	return new Long(aid);
    }

    public static String md5(String m) {
	String pass = "";
	try {
	    byte[] LaborBytes = m.getBytes();
	    MessageDigest algorithm = MessageDigest.getInstance("MD5");
	    algorithm.reset();
	    algorithm.update(LaborBytes);
	    byte messageDigest[] = algorithm.digest();
	    StringBuffer hexString = new StringBuffer();
	    for (int i = 0; i < messageDigest.length; i++) {
		String hex = Integer.toHexString(0xFF & messageDigest[i]);
		if (hex.length() == 1)
		    hexString.append('0');
		hexString.append(hex);
	    }
	    pass = hexString + "";
	} catch (Exception e) {
	    System.out.println("MDF FAIL()");
	}
	return pass;
    }

    public static Date getToday() {
	Date t = new Date();
	return t;
    }

    public static String getTodaytoString() {
	Date b = new Date();
	String week = "";
	switch (b.getDay()) {
	case 1:
	    week = "(一)";
	    break;
	case 2:
	    week = "(二)";
	    break;
	case 3:
	    week = "(三)";
	    break;
	case 4:
	    week = "(四)";
	    break;
	case 5:
	    week = "(五)";
	    break;
	case 6:
	    week = "(六)";
	    break;
	case 0:
	    week = "(日)";
	    break;
	}
	String s = sdf.format(b);
	return s;
    }

    public static void writeFile(String filename, String value) {
	try {
	    BufferedWriter out = new BufferedWriter(new FileWriter(filename));
	    out.write(value);
	    out.close();
	} catch (Exception e) {
	    System.out.println("writeFile error=" + e.toString());
	}
    }

    public static boolean socketTest(String hostName, int portNumber) {
	try {
	    Socket echoSocket = new Socket(hostName, portNumber);	   
	    return true;
	} catch (Exception e) {
	    System.out.println("socket to=" + hostName +" : "+portNumber +" error!");
	    return false;
	}

    }
    
    public static void main(String[] arg) {
	System.out.println(socketTest("140.118.23.250",502));
    }

}
