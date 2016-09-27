package device.hundure;

class JavaRD800Demo
{
	
	public static void main(String[] args)
	{
		short status;
		int lDevice = 0;
		
		long[] pSnr = new long[1];  //���ŧi�� new int[2]
		long plsnr= 0;
		char[] pSBuffer = new char[16];
		char[] pRBuffer = new char[16];
		JavaRD800 rd = new JavaRD800();
		int[] pValue = new int[1];
		
		
		lDevice = rd.dc_init(100,115200);
		if(lDevice <= 0)
		{
			System.out.print("�s��Ū�d�� error!\n");
			return;
		}
		System.out.print(lDevice+"   �s��Ū�d�� ok!\n");
		
		//�ߥd�A�P�_�d���O�_�s�A�w�N�Ǹ�TYPE�אּ long int
		
		rd.dc_beep(lDevice, (short)100);
		
		status = rd.dc_card(lDevice,(short)0,pSnr);
		if(status != 0)
		{
			System.out.print("dc_card error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		
		System.out.print("dc_card ok!\n");
		System.out.println(pSnr[0]); //�W�[�C�L�Ǹ����O�A�H long ��^�קK���ͭt�ƪ��p
			
		//���J��X�@�~				
		
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
		
		//����sector 0 
		status = rd.dc_authentication(lDevice,(short)0,(short)0);
		if(status != 0)
		{
			System.out.print("dc_authentication error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("dc_authentication ok!\n");
		
		//�g�Jsector 0, block 2����Ƭ�16�� M ���r��
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
		
		//Ū�� sector 0, block 2�����
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
		//�w�r��覡�g�J sector0, block 2
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
		
		//�g�Jsector 0, block 2����Ƭ�16�� FF ���r���A�O�g�J16�i��
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
		
				
		//�Nblock 1 ��l�ƼƭȬ� 100
		status=rd.dc_initval(lDevice,(short)1,(int) 100);
		if(status != 0)
		{
			System.out.print("dc_initval error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.print("dc_initval ok!\n");
		
		//Ū���Nblock 1 �ƭȬ� 100
		status = rd.dc_readval(lDevice,(short)1,pValue);
		
	  if(status != 0)
		{
			System.out.print("dc_readval error!\n");
			rd.dc_exit(lDevice);
			return;
		}
		System.out.println(pValue[0]); 
		
		
		//�󴫰�Xsector 0��X�AKEYA�����Ӧr��FFFFFFFFFFF�AAC�|�Ӧr��FF078069, KEYB�����Ӧr��FFFFFFFFFFF
		//�g�J��Block 3�����
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
		 
		//����Ū�d��
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
