package device.hundure;

public class GCU {
	static
	{
		System.loadLibrary("CH29_001.dll");
	}
	//public native int hsGCUOpenChannel(String gip,String ip,int port);
	
	public native int BCBType_Count(int a,int b);
}
