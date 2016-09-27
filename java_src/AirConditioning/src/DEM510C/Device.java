package DEM510C;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.base.util.Tools;

public class Device {
    int id;
    static int timeout = 3000;
    int deviceId;
    boolean powerstatus;
    static int[] CRC = new int[2];

    public static void main(String[] args) {
	try {
	     setPowerStatus("10.36.0.158", 4660, 9, true);

	   //setPowerStatus("10.36.0.158", 4660, 9, false);
	    //System.out.println("start=" + Tools.getCurrentTimestamp());
	    //System.out.println("Status="   + checkPowerStatus("10.36.0.158", 4660, 9));
	    System.out.println("end=" + Tools.getCurrentTimestamp());
	} catch (Exception e) {
	    System.out.println(e.toString());
	}
    }

    public static int checkPowerStatus(String server, int port, int deviceId) {
	int status = 9;
	try {
	    Socket socket = new Socket(server, port);
	    socket.setSoTimeout(timeout);

	    byte[] msg = new byte[8];
	    msg[0] = (byte) deviceId;
	    msg[1] = (byte) 3;
	    msg[2] = (byte) 0;
	    msg[3] = (byte) 3;
	    msg[4] = (byte) 0;
	    msg[5] = (byte) 1;

	    CRC = getCRC(msg);

	    msg[6] = (byte) CRC[1];
	    msg[7] = (byte) CRC[0];

	    InputStream inputStream = socket.getInputStream();
	    OutputStream outputStream = socket.getOutputStream();
	    outputStream.write(msg);
	    outputStream.flush();

	    byte[] arry = new byte[8];
	    int length, c;
	    length = inputStream.read(arry);
	    /*
	    System.out.println("length=" + length);
	    System.out.println("return byte[0]=" + arry[0]);
	    System.out.println("return byte[1]=" + arry[1]);
	    System.out.println("return byte[2]=" + arry[2]);
	    System.out.println("return byte[3]=" + arry[3]);
	    System.out.println("return byte[4]=" + arry[4]);
	    System.out.println("return byte[5]=" + arry[5]);
	    System.out.println("return byte[6]=" + arry[6]);
	    System.out.println("return byte[7]=" + arry[7]);
            */
	    c = (int) arry[4];
	    if (c < 0) {
		c += 256;
	    }

	    String bin = String.valueOf(Integer.toBinaryString(c));
	    char result = bin.charAt(bin.length() - 1);
	    //System.out.println("c=" + c + "---bin=" + bin + "--" + bin.length() + "--" + result);

	    if (result == '1') {
		status = 1;
	    } else {
		status = 0;
	    }
	    inputStream.close();
	    outputStream.close();
	    socket.close();
	} catch (Exception e) {
	    System.out.println("checkPowerStatus=" + e.toString());
	}

	return status;
    }

    public static void setPowerStatus(String server, int port, int deviceId, boolean status) {
	try {
	    Socket socket = new Socket(server, port);
	    socket.setSoTimeout(timeout);
	    byte[] msg = new byte[8];

	    if (status == true) {
		msg[0] = (byte) deviceId;
		msg[1] = (byte) 5;
		msg[2] = (byte) 0;
		msg[3] = (byte) 2;
		msg[4] = (byte) 255;
		msg[5] = (byte) 0;
	    } else {
		msg[0] = (byte) deviceId;
		msg[1] = (byte) 5;
		msg[2] = (byte) 0;
		msg[3] = (byte) 2;
		msg[4] = (byte) 0;
		msg[5] = (byte) 0;

	    }

	    CRC = getCRC(msg);

	    msg[6] = (byte) CRC[1];
	    msg[7] = (byte) CRC[0];

	    OutputStream outputStream = socket.getOutputStream();
	    outputStream.write(msg);
	    outputStream.flush();
	    outputStream.close();
	    socket.close();

	} catch (Exception e) {
	    System.out.println("setPowerStatus=" + e.toString());
	}
    }

    public static int[] getCRC(byte[] data) {
	int[] vcode = new int[2];
	CRC16Modbus crc = new CRC16Modbus();

	int[] array = new int[data.length - 2];
	for (int i = 0; i < data.length - 2; i++) {
	    int j = (int) data[i];
	    if (j < 0) {
		array[i] = j + 256;
	    } else {
		array[i] = j;
	    }
	}
	/*
	 * for(int i=0;i<array.length;i++){
	 * System.out.println("array["+i+"]="+array[i]); }
	 */
	for (int d : array) {
	    crc.update(d);
	}
	// System.out.println(Integer.toHexString((int) crc.getValue()));
	byte[] byteStr = new byte[2];
	byteStr[0] = (byte) ((crc.getValue() & 0x000000ff));
	byteStr[1] = (byte) ((crc.getValue() & 0x0000ff00) >>> 8);

	int high = (int) byteStr[0];
	int low = (int) byteStr[1];

	// System.out.println("high="+high+"--low="+low);

	if (high < 0) {
	    vcode[1] = high + 256;
	} else {
	    vcode[1] = high;
	}

	if (low < 0) {
	    vcode[0] = low + 256;
	} else {
	    vcode[0] = low;
	}

	// System.out.println("vcode[1]="+vcode[1]+"--vcode[0]="+vcode[0]);

	return vcode;

    }

}
