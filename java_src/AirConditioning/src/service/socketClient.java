package service;
 
import java.net.InetSocketAddress;
import java.net.Socket;
import java.io.BufferedOutputStream;
 
public class socketClient {
    private String address = "140.129.140.53";// �s�u��ip
    private int port = 8081;// �s�u��port
 
    public socketClient() {
 
        Socket client = new Socket();
        InetSocketAddress isa = new InetSocketAddress(this.address, this.port);
        try {
            client.connect(isa, 10000);
            BufferedOutputStream out = new BufferedOutputStream(client
                    .getOutputStream());
            // �e�X�r��
            String cmd="140.129.121.245*9600*1*2*0";
            out.write(cmd.getBytes());
            out.flush();
            out.close();
            out = null;
            client.close();
            client = null;
 
        } catch (java.io.IOException e) {
            System.out.println("Socket�s�u�����D !");
            System.out.println("IOException :" + e.toString());
        }
    }
 
    public static void main(String args[]) {
        new socketClient();
    }
}