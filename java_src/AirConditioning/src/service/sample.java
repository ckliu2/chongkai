package service;

import java.applet.Applet;
import java.awt.*;
import java.net.URL;


public class sample extends Applet implements Runnable{	
	Thread t;
	Font f=new Font("TimesRoman",Font.BOLD,20);
	int n=0;
    URL url;
    Image img;
    Graphics myGra;
    
	public void init(){
		try{
		  System.out.println("sample init()..");		
		  url=new URL("http://www.tnu.edu.tw/images/");
		  img = getImage(url,"tnitMap.JPG");
	
		  myGra=getGraphics(); 
		  myGra.drawImage(img,0,0,this);
	  	  
	     }catch(Exception e){
    	
         }
	}
    
    

	
     public void start(){ 
		t=new Thread(this);
		t.start();
	}
     

     
     
     
	
	
    public void paint(Graphics g){
       System.out.println("sample paint()..");	   
       //g.drawImage(img,0,0,this);
       setBackground(Color.yellow);
       g.setFont(f);
       if( (n++)%2==1 ){
    	   g.setColor(Color.blue);
       }else{
    	   g.setColor(Color.red);
       }
 	   //g.drawString("SOCKET´ú¸Õ=...."+n+"..."+wpcServer.getReceice(), 30, 50);
 	  g.drawString("SOCKET´ú¸Õ=...."+n+"..."+wpcServer.getReceice(), 30, 50);
 	   
     }
    
    public void run(){
      while(true){
    	    try{
    	    	t.sleep(500);
    	    }catch(Exception e){
    	    	
    	    }
    	    repaint();
      }
    }
}
