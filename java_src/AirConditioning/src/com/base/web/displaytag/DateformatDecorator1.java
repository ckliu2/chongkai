package com.base.web.displaytag;

import javax.servlet.jsp.PageContext;

import java.text.*;
import java.util.*;

import org.displaytag.properties.MediaTypeEnum;

public class DateformatDecorator1 extends CommonColumnDecorator
{
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    public DateformatDecorator1()
    {
        super();
    }
    
    public Object decorate(Object columnValue, PageContext context, MediaTypeEnum md) 
    {   
        if (columnValue == null)
            return "";
        
        if (columnValue instanceof Date) {
        	Date b = (Date) columnValue;
        	return sdf.format(b);
        } else {
            return "";
        }
    }
}
