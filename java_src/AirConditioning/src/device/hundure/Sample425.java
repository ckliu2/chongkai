package device.hundure;

public class Sample425
{
	public static void main(String[] args)
	{
		// 讀取DLL
		System.loadLibrary("SampleDLL");

		// 使用DLL內的函式
		int ret = prtExcel( "Nack of JAVA", "2300" );

		// 輸出結果
		System.out.println( "ret = " + ret );
	}

	// 宣告原生方法
	static public native int prtExcel(
		String lpNameOfItem,
		String lpValue);

}
