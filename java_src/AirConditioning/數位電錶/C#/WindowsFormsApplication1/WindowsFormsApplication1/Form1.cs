using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Net.Sockets;




namespace WindowsFormsApplication1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
             TcpClient clientSocket = new TcpClient();
             clientSocket.Connect("140.129.140.19", 4660);

             NetworkStream serverStream = clientSocket.GetStream();
            //byte[] outStream = System.Text.Encoding.ASCII.GetBytes("Message from Client$");
             //xx  03  00  00  00  02
             byte[] outStream1 = new byte[8];
           
              outStream1[0] = 0;
              outStream1[1] = 3;
              outStream1[2] = 0;
              outStream1[3] = 0;
              outStream1[4] = 0;
              outStream1[5] = 2;

              
             

             byte[] CRC=new byte[2];
            
             GetCRC(outStream1, CRC);

             outStream1[6] = CRC[0];
             outStream1[7] = CRC[1];
             serverStream.Write(outStream1, 0, outStream1.Length);
             serverStream.Flush();

             Console.WriteLine("socket outStream1內容..");    
             Console.WriteLine("outStream1[0]=" + Convert.ToString(outStream1[0]));
             Console.WriteLine("outStream1[1]=" + Convert.ToString(outStream1[1]));
             Console.WriteLine("outStream1[2]=" + Convert.ToString(outStream1[2]));
             Console.WriteLine("outStream1[3]=" + Convert.ToString(outStream1[3]));
             Console.WriteLine("outStream1[4]=" + Convert.ToString(outStream1[4]));
             Console.WriteLine("outStream1[5]=" + Convert.ToString(outStream1[5]));
             Console.WriteLine("outStream1[6]=" + Convert.ToString(outStream1[6]));
             Console.WriteLine("outStream1[7]=" + Convert.ToString(outStream1[7]));
             
            
             
           
             byte[] inStream = new byte[10025];
             serverStream.Read(inStream, 0, (int)clientSocket.ReceiveBufferSize);
             //string returndata = System.Text.Encoding.ASCII.GetString(inStream);
            
             Console.WriteLine("(int)clientSocket.ReceiveBufferSize=" + (int)clientSocket.ReceiveBufferSize);
             Console.WriteLine("inStream[0]=" + Convert.ToString(inStream[0]));
             Console.WriteLine("inStream[1]=" + Convert.ToString(inStream[1]));
             Console.WriteLine("inStream[2]=" + Convert.ToString(inStream[2]));
             Console.WriteLine("inStream[3]=" + Convert.ToString(inStream[3]));
             Console.WriteLine("inStream[4]=" + Convert.ToString(inStream[4]));
             Console.WriteLine("inStream[5]=" + Convert.ToString(inStream[5]));
             Console.WriteLine("inStream[6]=" + Convert.ToString(inStream[6]));
             Console.WriteLine("inStream[7]=" + Convert.ToString(inStream[7]));
             Console.WriteLine("inStream[8]=" + Convert.ToString(inStream[8]));


             double a1 = Convert.ToDouble(inStream[4]);
             double a2 = Convert.ToDouble(inStream[3]);
             double a3 = Convert.ToDouble(inStream[6]);
             double a4 = Convert.ToDouble(inStream[5]);

             double sum =  (a1 * 1) + (a2 * 256) + (a3 * 65536) + (a3 * 16777216);

             Console.WriteLine("sum=" + Convert.ToString(sum));

             string s=Convert.ToString(inStream[0]) +'-'+ Convert.ToString(inStream[1])+'-'+ Convert.ToString(inStream[2])+'-'+ Convert.ToString(inStream[3])+'-'+ Convert.ToString(inStream[4])+'-'+ Convert.ToString(inStream[5])+'-'+ Convert.ToString(inStream[6])+'-'+ Convert.ToString(inStream[7])+'-'+ Convert.ToString(inStream[8]);
             textBox1.Text = s;

             status.Text = Convert.ToString(sum/100)+" [KWH]";

             serverStream.Close();            
             clientSocket.Close();
            


        }

       



        private void GetCRC(byte[] message,  byte[] CRC) // message : Modbus指令 ； CRC : 2 Byte Checksum
        {
            ushort CRCFull = 0xFFFF; // CRC 的初值設成 0xFFFF
            byte CRCHigh = 0xFF, CRCLow = 0xFF; // CRC 的 High byte 和 Low byte
            char CRCLSB; // CRC Least signficant bit


            for (int i = 0; i < (message.Length) - 2; i++)
            {
                CRCFull = (ushort)(CRCFull ^ message[i]); // exclusive or 


                for (int j = 0; j < 8; j++)
                {
                    CRCLSB = (char)(CRCFull & 0x0001); // 取得 Least signficant bit
                    CRCFull = (ushort)((CRCFull >> 1) & 0x7FFF); // 移去 Least signficant bit，前補0


                    if (CRCLSB == 1) // 如果 Least signficant bit 為 1
                        CRCFull = (ushort)(CRCFull ^ 0xA001);
                }
            }
            CRC[1] = CRCHigh = (byte)((CRCFull >> 8) & 0xFF); // CRC high byte 在 後
            CRC[0] = CRCLow = (byte)(CRCFull & 0xFF); // CRC low byte 在前
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {
            Console.WriteLine("button2_Click...");
        }

        private void button2_Click_1(object sender, EventArgs e)
        {
            TcpClient clientSocket = new TcpClient();
            clientSocket.Connect("140.129.140.19", 4660);

            NetworkStream serverStream = clientSocket.GetStream();

            byte[] outStream1 = new byte[8];
            outStream1[0] = 0x00;
            outStream1[1] = 0x05;
            outStream1[2] = 0x00;
            outStream1[3] = 0x02;
            outStream1[4] = 0xFF;
            outStream1[5] = 0x00;
            byte[] CRC = new byte[2];
            GetCRC(outStream1, CRC);
            outStream1[6] = CRC[0];
            outStream1[7] = CRC[1];
            serverStream.Write(outStream1, 0, outStream1.Length);
            serverStream.Flush();

            Console.WriteLine("socket outStream1內容..");
            Console.WriteLine("outStream1[0]=" + Convert.ToString(outStream1[0]));
            Console.WriteLine("outStream1[1]=" + Convert.ToString(outStream1[1]));
            Console.WriteLine("outStream1[2]=" + Convert.ToString(outStream1[2]));
            Console.WriteLine("outStream1[3]=" + Convert.ToString(outStream1[3]));
            Console.WriteLine("outStream1[4]=" + Convert.ToString(outStream1[4]));
            Console.WriteLine("outStream1[5]=" + Convert.ToString(outStream1[5]));
            Console.WriteLine("outStream1[6]=" + Convert.ToString(outStream1[6]));
            Console.WriteLine("outStream1[7]=" + Convert.ToString(outStream1[7]));




            byte[] inStream = new byte[10025];
            serverStream.Read(inStream, 0, (int)clientSocket.ReceiveBufferSize);
            //string returndata = System.Text.Encoding.ASCII.GetString(inStream);

            Console.WriteLine("(int)clientSocket.ReceiveBufferSize=" + (int)clientSocket.ReceiveBufferSize);
            Console.WriteLine("inStream[0]=" + Convert.ToString(inStream[0]));
            Console.WriteLine("inStream[1]=" + Convert.ToString(inStream[1]));
            Console.WriteLine("inStream[2]=" + Convert.ToString(inStream[2]));
            Console.WriteLine("inStream[3]=" + Convert.ToString(inStream[3]));
            Console.WriteLine("inStream[4]=" + Convert.ToString(inStream[4]));
            Console.WriteLine("inStream[5]=" + Convert.ToString(inStream[5]));
            Console.WriteLine("inStream[6]=" + Convert.ToString(inStream[6]));
            Console.WriteLine("inStream[7]=" + Convert.ToString(inStream[7]));
            Console.WriteLine("inStream[8]=" + Convert.ToString(inStream[8]));

            string s = Convert.ToString(inStream[0]) + '-' + Convert.ToString(inStream[1]) + '-' + Convert.ToString(inStream[2]) + '-' + Convert.ToString(inStream[3]) + '-' + Convert.ToString(inStream[4]) + '-' + Convert.ToString(inStream[5]) + '-' + Convert.ToString(inStream[6]) + '-' + Convert.ToString(inStream[7]) + '-' + Convert.ToString(inStream[8]);
            textBox1.Text = s;

            serverStream.Close();
            clientSocket.Close();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            TcpClient clientSocket = new TcpClient();
            clientSocket.Connect("140.129.140.19", 4660);

            NetworkStream serverStream = clientSocket.GetStream();

            byte[] outStream1 = new byte[8];
            outStream1[0] = 0x00;
            outStream1[1] = 0x05;
            outStream1[2] = 0x00;
            outStream1[3] = 0x02;
            outStream1[4] = 0x00;
            outStream1[5] = 0x00;
            byte[] CRC = new byte[2];
            GetCRC(outStream1, CRC);
            outStream1[6] = CRC[0];
            outStream1[7] = CRC[1];
            serverStream.Write(outStream1, 0, outStream1.Length);
            serverStream.Flush();

            Console.WriteLine("socket outStream1內容..");
            Console.WriteLine("outStream1[0]=" + Convert.ToString(outStream1[0]));
            Console.WriteLine("outStream1[1]=" + Convert.ToString(outStream1[1]));
            Console.WriteLine("outStream1[2]=" + Convert.ToString(outStream1[2]));
            Console.WriteLine("outStream1[3]=" + Convert.ToString(outStream1[3]));
            Console.WriteLine("outStream1[4]=" + Convert.ToString(outStream1[4]));
            Console.WriteLine("outStream1[5]=" + Convert.ToString(outStream1[5]));
            Console.WriteLine("outStream1[6]=" + Convert.ToString(outStream1[6]));
            Console.WriteLine("outStream1[7]=" + Convert.ToString(outStream1[7]));




            byte[] inStream = new byte[10025];
            serverStream.Read(inStream, 0, (int)clientSocket.ReceiveBufferSize);
            //string returndata = System.Text.Encoding.ASCII.GetString(inStream);

            Console.WriteLine("(int)clientSocket.ReceiveBufferSize=" + (int)clientSocket.ReceiveBufferSize);
            Console.WriteLine("inStream[0]=" + Convert.ToString(inStream[0]));
            Console.WriteLine("inStream[1]=" + Convert.ToString(inStream[1]));
            Console.WriteLine("inStream[2]=" + Convert.ToString(inStream[2]));
            Console.WriteLine("inStream[3]=" + Convert.ToString(inStream[3]));
            Console.WriteLine("inStream[4]=" + Convert.ToString(inStream[4]));
            Console.WriteLine("inStream[5]=" + Convert.ToString(inStream[5]));
            Console.WriteLine("inStream[6]=" + Convert.ToString(inStream[6]));
            Console.WriteLine("inStream[7]=" + Convert.ToString(inStream[7]));
            Console.WriteLine("inStream[8]=" + Convert.ToString(inStream[8]));

            string s = Convert.ToString(inStream[0]) + '-' + Convert.ToString(inStream[1]) + '-' + Convert.ToString(inStream[2]) + '-' + Convert.ToString(inStream[3]) + '-' + Convert.ToString(inStream[4]) + '-' + Convert.ToString(inStream[5]) + '-' + Convert.ToString(inStream[6]) + '-' + Convert.ToString(inStream[7]) + '-' + Convert.ToString(inStream[8]);
            textBox1.Text = s;

            serverStream.Close();
            clientSocket.Close();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            //xx  05  00  40  FF  00
            TcpClient clientSocket = new TcpClient();
            clientSocket.Connect("140.129.140.19", 4660);

            NetworkStream serverStream = clientSocket.GetStream();

            byte[] outStream1 = new byte[8];
            outStream1[0] = 0x00;
            outStream1[1] = 0x05;
            outStream1[2] = 0x00;
            outStream1[3] = 0x40;
            outStream1[4] = 0xFF;
            outStream1[5] = 0x00;
            byte[] CRC = new byte[2];
            GetCRC(outStream1, CRC);
            outStream1[6] = CRC[0];
            outStream1[7] = CRC[1];
            serverStream.Write(outStream1, 0, outStream1.Length);
            serverStream.Flush();

            Console.WriteLine("socket outStream1內容..");
            Console.WriteLine("outStream1[0]=" + Convert.ToString(outStream1[0]));
            Console.WriteLine("outStream1[1]=" + Convert.ToString(outStream1[1]));
            Console.WriteLine("outStream1[2]=" + Convert.ToString(outStream1[2]));
            Console.WriteLine("outStream1[3]=" + Convert.ToString(outStream1[3]));
            Console.WriteLine("outStream1[4]=" + Convert.ToString(outStream1[4]));
            Console.WriteLine("outStream1[5]=" + Convert.ToString(outStream1[5]));
            Console.WriteLine("outStream1[6]=" + Convert.ToString(outStream1[6]));
            Console.WriteLine("outStream1[7]=" + Convert.ToString(outStream1[7]));




            byte[] inStream = new byte[10025];
            serverStream.Read(inStream, 0, (int)clientSocket.ReceiveBufferSize);
            //string returndata = System.Text.Encoding.ASCII.GetString(inStream);

            Console.WriteLine("(int)clientSocket.ReceiveBufferSize=" + (int)clientSocket.ReceiveBufferSize);
            Console.WriteLine("inStream[0]=" + Convert.ToString(inStream[0]));
            Console.WriteLine("inStream[1]=" + Convert.ToString(inStream[1]));
            Console.WriteLine("inStream[2]=" + Convert.ToString(inStream[2]));
            Console.WriteLine("inStream[3]=" + Convert.ToString(inStream[3]));
            Console.WriteLine("inStream[4]=" + Convert.ToString(inStream[4]));
            Console.WriteLine("inStream[5]=" + Convert.ToString(inStream[5]));
            Console.WriteLine("inStream[6]=" + Convert.ToString(inStream[6]));
            Console.WriteLine("inStream[7]=" + Convert.ToString(inStream[7]));
            Console.WriteLine("inStream[8]=" + Convert.ToString(inStream[8]));

            string s = Convert.ToString(inStream[0]) + '-' + Convert.ToString(inStream[1]) + '-' + Convert.ToString(inStream[2]) + '-' + Convert.ToString(inStream[3]) + '-' + Convert.ToString(inStream[4]) + '-' + Convert.ToString(inStream[5]) + '-' + Convert.ToString(inStream[6]) + '-' + Convert.ToString(inStream[7]) + '-' + Convert.ToString(inStream[8]);
            textBox1.Text = s;

            serverStream.Close();
            clientSocket.Close();
        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void button4_Click_1(object sender, EventArgs e)
        {
            status.Text = "重新偵測..";
        }

        private void button5_Click(object sender, EventArgs e)
        {
            byte b = (byte)0x83;
            status.Text = Convert.ToString(b);
  
        }






    }







}
