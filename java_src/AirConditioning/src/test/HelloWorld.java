package test;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.*;
import com.sun.jna.ptr.*;

public class HelloWorld {
	
	public interface CLibrary extends Library{
		CLibrary INSTANCE = (CLibrary)Native.loadLibrary("D:\\tmp\\c\\Project2.dll",CLibrary.class);

		    public int example1(int i);
   }
	
    public static void main(String[] args) {
        
    	//CLibrary clib = (CLibrary)Native.loadLibrary("Project2", CLibrary.class);
    	
    	CLibrary.INSTANCE.example1(1);
    	/*System.out.println("example 1: " + newVal);
    	*/
    }
    



}
