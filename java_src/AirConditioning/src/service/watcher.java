package service;

import java.applet.*;
import java.awt.*;
import java.net.*; 

public class watcher extends Applet {
	Thread t;
    int i=0;
    URL url;
    Image img;
    Font f=new Font("TimesRoman",Font.BOLD,20);
    
	public void init(){
		try{
		System.out.println("watcher init()..1");
		url=new URL("http://www.tnu.edu.tw/images/");
		img = getImage(url,"tnitMap.JPG");
		}catch(Exception e){
			System.out.println("init() fail");
		}
	}	
	
	
	public void paint (Graphics g) {
		try{   
		   System.out.println("watcher paint()..");
	       g.drawImage(img,0,0,this);
		   setBackground(Color.yellow);	   
		   g.setFont(f);
		   
		   update(g);
		   
		  /* for(int j=0;j<5;j++){
          
		      //g.drawString("測試SOCKET="+j, 30, 50);  
			   System.out.println("j="+j); 
		       Thread.sleep(1000);
		   
		   }*/
		
		}catch(Exception e){
			System.out.println("paint() fail..");
		}
	}

	
	public void update (Graphics g) {
	    try{   
		   System.out.println("watcher update()..");
		   g.drawImage(img,0,0,this);
		   setBackground(Color.yellow);	   
		  /* for(int j=0;j<20;j++){
             
		      g.drawString("測試SOCKET="+j, 30, 50);  
		      Thread.sleep(1000);
		   
		   }*/
		   
	    }catch(Exception e){
	    	System.out.println(e.toString());
	    }
		   
	    }
	
	
	/*public void start(){
		System.out.println("watcher start()..1");
		t=new Thread();
		t.run();
	}*/
	
    /*public void paint(Graphics g){
       System.out.println("watcher paint().."+i);
       g.drawImage(img,0,0,this);
	   setBackground(Color.yellow);	   
	   g.setFont(f);

	   g.drawString("測試SOCKET="+i, 30, 50);  
	   
    }*/
    
    

    
	/* public void run(){
    	System.out.println("watcher run()");
    	
    	while(true){
    		try{
    			t.sleep(500); //0.5秒更新  Thread.sleep(500);
    			System.out.println("i="+i);
    		}catch(Exception e){
    			System.out.println("watcher run() fail!");
    		}
    		
    		repaint();
    		//i++;
    	}
    	
    }*/
    
}
