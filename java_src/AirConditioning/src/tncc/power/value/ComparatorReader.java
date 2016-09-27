package tncc.power.value;

import java.util.*;

public class ComparatorReader implements Comparator{

	public int compare(Object arg0, Object arg1) {
		  Reader reader0=(Reader)arg0;
		  Reader reader1=(Reader)arg1;
		  
		  String a=reader0.getName()+"-"+reader0.getReaderId();
		  String b=reader1.getName()+"-"+reader1.getReaderId();
		  
		  int flag=a.compareTo(b);
		  //int flag=reader0.getName().compareTo(reader1.getName());
		  if(flag==0){
		   return reader0.getName().compareTo(reader1.getName());
		  }else{
		   return flag;
		  }  
		 }
	


}
