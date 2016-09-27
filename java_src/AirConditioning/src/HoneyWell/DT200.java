package HoneyWell;

import java.util.ArrayList;
import java.util.List;

import service.HoneyWellTest.CMobus;
import tncc.power.value.*;

import com.base.util.Tools;
import com.sun.jna.Library;
import com.sun.jna.Native;

public class DT200 {
	public interface DT200Mobus extends Library{
		DT200Mobus instance = (DT200Mobus)Native.loadLibrary("modbusfunc", DT200Mobus.class);
		 public short dt200_register_get(String host,short port,short type, short uid, short sid, short addr);
	     public short dt200_register_set(String host,short port,short type, short uid, short sid, short addr, short value);
	     public short dt200_drive_lock(String host,short port,short type, short uid, short sid);
	     public short dt200_drive_unlock(String host,short port,short type, short uid, short sid);
	     public short dt200_global_status_get(String host,short port,short type, short uid, short[] ret);
	}
	
	public static void main(String[] args) {
		
	}
	
	public static void setLock(String serverIP,int port,int serverId,int readerId,boolean status)
	{
		try{
			short s;
			if(status==true){
				CMobus.instance.dt200_drive_lock(serverIP, port, 0 , serverId, readerId);
			}else{
				CMobus.instance.dt200_drive_unlock(serverIP, port, 0 , serverId, readerId);
			}

		}catch(Exception e){
		  System.out.println("setDevicePowerStatus error");	
		}
	}
	
	public static void setDevice(PowerController powerController,Reader reader,String drive,String mode,String temp,String fanspeed,String lock,int templimit,int user_temp)
	{
		try{
			String serverIP=powerController.getIp();
			int port=powerController.getPort();
			int serverId=powerController.getDeviceId();
			int readerId=reader.getReaderId();
			
			//System.out.println("powerController ip="+powerController.getIp());
			//System.out.println("powerController port ="+powerController.getPort());
			//System.out.println("Reader.getId="+reader.getReaderId());
			//System.out.println("drive="+drive+"-mode="+mode+"-temp="+temp+"-fanspeed="+fanspeed+"-lock="+lock);
			
			
			//drive
			  short driveCode;
			
			if(!drive.equals("NOSETTING")){
			  if(drive.equals("ON")){
				driveCode=1;
			  }else{
				driveCode=0;
			  }			 
			  //System.out.println("driveCode="+driveCode);
			  CMobus.instance.dt200_register_set(serverIP, port, 0 , serverId, readerId, (short)4,(short)driveCode);
			}
			
			
			//mode
			short modeCode=Short.parseShort(mode);			
			CMobus.instance.dt200_register_set(serverIP, port, 0 , serverId, readerId, (short)5,(short)modeCode);			
			
			//temp
			short tempCode=Short.parseShort(temp.replace(".", ""));	
			
			if(user_temp < templimit){			
			  CMobus.instance.dt200_register_set(serverIP, port, 0 , serverId, readerId, (short)2,(short)tempCode);
			  System.out.println("tempCode="+tempCode+"---templimit="+templimit);
			}
			
			//fanspeed
			short fanspeedCode=Short.parseShort(fanspeed);			
			CMobus.instance.dt200_register_set(serverIP, port, 0 , serverId, readerId, (short)3,(short)fanspeedCode);
			//System.out.println("fanspeedCode="+fanspeedCode);
			
			//lock			
			//System.out.println("lock="+lock);			
			if(lock.equals("lock")){
				//System.out.println("exe lock");	
				CMobus.instance.dt200_drive_lock(serverIP, port, 0 , serverId, readerId);
			}else{
				//System.out.println("exe unlock");	
				CMobus.instance.dt200_drive_unlock(serverIP, port, 0 , serverId, readerId);
			}
	               
	
		}catch(Exception e){
		  System.out.println("setDevicePowerStatus error="+e.toString()+"/");	
		}
	}
	
	public static void setDevicePowerStatus(String serverIP,int port,int serverId,int readerId,boolean status)
	{
		try{
			short s;
			if(status==true){
				s=1;
			}else{
				s=0;
			}
			//System.out.println("s="+s);
			System.out.println("serverIP="+serverIP+"--port="+port+"--serverId="+serverId+"--readerId="+readerId+"--s="+s);
			System.out.println(CMobus.instance.dt200_register_set(serverIP, port, 0 , serverId, readerId, (short)4,(short)s));
		}catch(Exception e){
		  System.out.println("setDevicePowerStatus error="+e.toString());	
		}
	}
	
	public static List<Device> getDeviceStatus(short[] status_array,PowerController powerController)
	{
		ArrayList<Device> al = new ArrayList<Device>();
		try{
			short[][] status_array_2d = new short[32][11];	
			 for (int i=0; i<32; i++) {
				    
				    Device device=new Device(powerController);
				    device.setTimestamp(Tools.getCurrentTimestamp());
				    
		            for (int j=0; j<11; j++) {
		            	
		                status_array_2d[i][j] = status_array[i * 11 + j];
		                if(status_array_2d[i][0]!=-1 && i!=0 ){
		                	
		                	device.setGroup(String.valueOf(i));
		                	//System.out.println(String.format("status_array_2d[%d][%d] = %d", i, j, status_array[i * 11 + j]));
		                    switch(j){
		                       case 0: //稰代竟放
		                    	  float f=Float.parseFloat(String.valueOf(status_array[i * 11 + j]))/10; 		                    	 
		                    	  device.setInletTemp(String.valueOf(f)) ;
		                    	  //System.out.println("稰代竟放="+device.getInletTemp());
		                       break;		                       
		                       case 1: //放砞﹚
		                    	      float f1=Float.parseFloat(String.valueOf(status_array[i * 11 + j]))/10; 
			                    	  device.setSetTemp(String.valueOf(f1)) ;
			                    	  //System.out.println("放砞﹚="+device.getSetTemp());
			                   break;
		                       case 2: //硉篈 
		                         	  device.setFanSpeed(String.valueOf(status_array[i * 11 + j])) ;
			                   break;
		                       case 3: //秨币篈 
		                    	      if(status_array[i * 11 + j]==1){
		                    	    	  device.setDrive("ON");
		                    	      }else{
		                    	    	  device.setDrive("OFF");
		                    	      }	
		                    	      //System.out.println("秨币篈 ="+status_array[i * 11 + j]);
			                   break;
		                       case 4: //Mode 
		                         	  device.setMode(String.valueOf(status_array[i * 11 + j])) ;
			                   break;			                   
		                       case 10: //lock 
		                         	  device.setLock(String.valueOf(status_array[i * 11 + j])) ;
			                   break;			                   
		                      
		                    }
		                    
		                }
		                
		                
		            }   
		            
		            if(status_array_2d[i][0]!=-1 && i!=0){
		            	//System.out.println("add device="+i);
		            	al.add(device);
		            }
		            
		            
		        }
			
			
		}catch(Exception e){
		  System.out.println(e.toString());	
		}
		return al;
	 }
}
