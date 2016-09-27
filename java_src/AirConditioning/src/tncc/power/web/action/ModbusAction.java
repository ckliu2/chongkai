package tncc.power.web.action;

import service.HoneyWellTest.CMobus;

import com.base.util.Tools;
import com.common.web.action.CommonActionSupport;

public class ModbusAction  extends CommonActionSupport{
	
	String code;
	int id;
	int returnCode;
	
    String host = "140.118.18.229";
    short port = 4660;
    short type = 1;
    short uid = 30;
    short sid = 1;
	
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}
	
	public String list()
    { 
		return SUCCESS;
    }
	
	public String modbusfunctest()
    {
		 System.out.println(id);		
		 switch(id){
         case 1:
        	 returnCode=HoneyWell.DT200.DT200Mobus.instance.dt200_register_get(host, port, type, uid, sid, (short)1);
         break;
         
         case 2:
        	 returnCode=HoneyWell.DT200.DT200Mobus.instance.dt200_register_get(host, port, type, uid, sid, (short)4);
         break;
         
         case 3:
        	 returnCode=HoneyWell.DT200.DT200Mobus.instance.dt200_register_set(host, port, type, uid, sid, (short)4 , (short)1);
         break;
         
         case 4:
        	 returnCode=HoneyWell.DT200.DT200Mobus.instance.dt200_register_set(host, port, type, uid, sid, (short)4 , (short)0);
         break;
         
         case 5:
        	 returnCode=HoneyWell.DT200.DT200Mobus.instance.dt200_drive_lock(host, port, type, uid, sid);
         break;
         
         case 6:
        	 returnCode=HoneyWell.DT200.DT200Mobus.instance.dt200_drive_unlock(host, port, type, uid, sid);
         break;
         
        }
		return String.valueOf(returnCode);
    }
	
	
}
