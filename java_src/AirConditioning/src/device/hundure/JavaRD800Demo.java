package device.hundure;

class JavaRD800Demo
{
	
	public static void main(String[] args)
	{
		short status;
		int lDevice = 0;
		
		long[] pSnr = new long[1];  //更改宣告為 new int[2]
		long plsnr= 0;
		char[] pSBuffer = new char[16];
		char[] pRBuffer = new char[16];
		JavaRD800 rd = new JavaRD800();
		int[] pValue = new int[1];
		
		
		lDevice = rd.dc_init(100,115200);
		if(lDevice <= 0)
		{
			System.out.print("連接讀卡機 error!\n");
			return;
		}
		System.out.print(lDevice+"   連接讀卡機 ok!\n");
		
		//詢卡，判斷卡片是否存，已將序號TYPE改為 long int
		
		rd.dc_beep(lDevice, (short)100);
		
		status = rd.dc_card(lDevice,(short)0,pSnr);
		if(status != 0)
		{
			System.out.print("dc_card error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		
		System.out.print("dc_card ok!\n");
		System.out.println(pSnr[0]); //增加列印序號指令，以 long 返回避免產生負數狀況
			
		//載入基碼作業				
		
		//keyA
		pSBuffer[0] = 0xFF;
		pSBuffer[1] = 0xFF;
		pSBuffer[2] = 0xFF;
		pSBuffer[3] = 0xFF;
		pSBuffer[4] = 0xFF;
		pSBuffer[5] = 0xFF;
		
       //AC
		pSBuffer[6] = 0xFF;		
		pSBuffer[7] = 0x07;
		pSBuffer[8] = 0x80;
		pSBuffer[9] = 0x69;
		
        //keyB
		pSBuffer[10] = 0xFF;
		pSBuffer[11] = 0xFF;
		pSBuffer[12] = 0xFF;
		pSBuffer[13] = 0xFF;
		pSBuffer[14] = 0xFF;
		pSBuffer[15] = 0xFF;


		status = rd.dc_load_key(lDevice,(short)0,(short)0,pSBuffer);
		if(status != 0)
		{
			System.out.print("dc_load_key error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("dc_load_key ok!\n");
		
		//驗證sector 0 
		status = rd.dc_authentication(lDevice,(short)0,(short)0);
		if(status != 0)
		{
			System.out.print("dc_authentication error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("dc_authentication ok!\n");
		
		//寫入sector 0, block 2的資料為16個 M 的字元
		/*for(int i=0;i<16;i++)
		{
			pSBuffer[i] = 'M';
		}
		status = rd.dc_write(lDevice,(short)2,pSBuffer);
		if(status != 0)
		{
			System.out.print("dc_write error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("dc_write ok!\n");
		*/
		
		//讀取 sector 0, block 2的資料
		status = rd.dc_read(lDevice,(short)0,pRBuffer);
		if(status != 0)
		{
			System.out.print("dc_read error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("dc_read ok!\n");
		
		/*for(int j=0;j<16;j++){
			System.out.println("pRBuffer[j]="+pRBuffer[j]);
		}*/
		
		
		/*
		//已字串方式寫入 sector0, block 2
	    char[] str =new char[24];
		char[] str1 =new char[24];
		
		String Verstr=new String(str);
		
		String sChinese = "jesus love u";
		status=rd.dc_write(lDevice,(short)2,sChinese);
		if(status != 0)
		{
			System.out.print("dc_write error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		
		Verstr=rd.dc_read(lDevice,(short)2,Verstr);
		if(status != 0)
		{
			System.out.print("dc_read error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.println("getInfo="+Verstr);
		
		//寫入sector 0, block 2的資料為16個 FF 的字元，是寫入16進位
		for(int i=0;i<16;i++)
		{
			pRBuffer[i] = 0xFF;
		}
		status = rd.dc_write(lDevice,(short)2,pRBuffer);
		if(status != 0)
		{
			System.out.print("dc_write error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("dc_write ok!\n");
		System.out.println(pRBuffer);
		
				
		//將block 1 初始化數值為 100
		status=rd.dc_initval(lDevice,(short)1,(int) 100);
		if(status != 0)
		{
			System.out.print("dc_initval error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("dc_initval ok!\n");
		
		//讀取將block 1 數值為 100
		status = rd.dc_readval(lDevice,(short)1,pValue);
		
	  if(status != 0)
		{
			System.out.print("dc_readval error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.println(pValue[0]); 
		
		
		//更換基碼sector 0基碼，KEYA為六個字為FFFFFFFFFFF，AC四個字為FF078069, KEYB為六個字為FFFFFFFFFFF
		//寫入到Block 3的資料
		for(int i=0;i<16;i++)
		{
			pRBuffer[i] = 0xFF;
		}
		pRBuffer[6] = 0xFF;
		pRBuffer[7] = 0x07;
		pRBuffer[8] = 0x80;
		pRBuffer[9] = 0x69;
		
		status = rd.dc_write(lDevice,(short)3,pRBuffer);
		if(status != 0)
		{
			System.out.print("dc_write error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("dc_write ok!\n");
		System.out.println(pRBuffer);
		*/
		 
		//關閉讀卡機
		status = rd.dc_exit(lDevice);
		if(status != 0)
		{
			System.out.print("dc_exit error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		
		
		System.out.print("dc_exit ok!\n");
	}
}
