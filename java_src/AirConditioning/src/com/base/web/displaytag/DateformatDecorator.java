package com.base.web.displaytag;

import javax.servlet.jsp.PageContext;

import java.text.*;
import java.util.*;

import org.displaytag.properties.MediaTypeEnum;

public class DateformatDecorator extends CommonColumnDecorator
{
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
    public DateformatDecorator()
    {
        super();
    }
    
    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {   
        if (columnValue == null)
            return "";
        
        if (columnValue instanceof Date) {
        	Date b = (Date) columnValue;
        	
        	System.out.println("year="+b.getYear()+"__date="+b.getDate()+"___Day="+b.getDay());
            String week="";
        	switch(b.getDay()){
              case 1:
              	week="(�@)";
              break;	
              case 2:
                	week="(�G)";
                break;
              case 3:
                	week="(�T)";
                break;
              case 4:
                	week="(�|)";
                break;
              case 5:
                	week="(��)";
                break;
              case 6:
                	week="(��)";
                break;
              case 0:
                	week="(��)";
                break;
            }
        	/*if (b.intValue() == 1) {
                return getText("common.male");
            } else {
                return getText("common.female");
            }*/
        	String s=sdf.format(b)+week;
        	return s;
        } else {
            return "";
        }
    }
}
