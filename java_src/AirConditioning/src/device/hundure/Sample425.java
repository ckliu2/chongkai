package device.hundure;

public class Sample425
{
	public static void main(String[] args)
	{
		// Ū��DLL
		System.loadLibrary("SampleDLL");

		// �ϥ�DLL�����禡
		int ret = prtExcel( "Nack of JAVA", "2300" );

		// ��X���G
		System.out.println( "ret = " + ret );
	}

	// �ŧi��ͤ�k
	static public native int prtExcel(
		String lpNameOfItem,
		String lpValue);

}
