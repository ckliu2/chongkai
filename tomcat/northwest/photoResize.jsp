<%@ page import="java.io.*,java.awt.Graphics,java.awt.Image,java.awt.image.BufferedImage,javax.imageio.ImageIO" %>
<%@page contentType="image/jpeg" %>
<%
  try{
      String id=request.getParameter("id");
      String sn=request.getParameter("sn"); 
      String filename=""; 
      

    if(sn.indexOf("-")!=-1){    
      String filePath="D://IIS//bill//photo//"+id+"//"; 
      File f = new File(filePath);       
      String[] paths = f.list();
      for(String path:paths)
      {     
          if(path.indexOf(sn)!=-1){
            filename=path;           
          }         
      }           
    }else{
    	filename=sn+".jpg";
    }
    
	    
	   
	    String srcImageFile="D://IIS//bill//photo//"+id+"//"+filename;
	        
	    BufferedImage src = ImageIO.read(new File(srcImageFile)); 
      int width = src.getWidth(); 
      int height = src.getHeight();
      System.out.println("id="+id+"--sn="+sn+"--width="+width+"--height="+height);      
      
      java.text.DecimalFormat df = new java.text.DecimalFormat("#0.####");
      int reWidth,reHeight;  
      double scaleRate;    
      int limitWidth=400;
      int limitHeight=400;
      
      
      
     
       
      //¾î¦¡
      if(width >= height){
         scaleRate=Double.parseDouble(String.valueOf(limitWidth))/Double.parseDouble(String.valueOf(width));      
       }else{
       	//ª½¦¡
     	   scaleRate=Double.parseDouble(String.valueOf(limitHeight))/Double.parseDouble(String.valueOf(height));      
       }
    	
    	  reWidth=(int)Math.round(Double.parseDouble(String.valueOf(width)) * scaleRate);
	      reHeight=(int)Math.round(Double.parseDouble(String.valueOf(height)) * scaleRate);
           
        
           
      Image image = src.getScaledInstance(reWidth, reHeight, Image.SCALE_DEFAULT);  
      BufferedImage tag = new BufferedImage(reWidth, reHeight, BufferedImage.TYPE_INT_RGB);  
      Graphics g = tag.getGraphics();  
      g.drawImage(image, 0, 0, null); 
      g.dispose();  
            
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ImageIO.write(tag, "JPEG", baos);
      byte[] bytes = baos.toByteArray();
            
      OutputStream o = response.getOutputStream();
	    o.write(bytes);
      o.flush();
      o.close();

            
	}catch(Exception e){
	    System.out.println(e.toString());
	}
	
%>
