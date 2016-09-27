package service;

import java.net.*;
import java.io.*;
public class java_server
{
public static void main(String h[])
{
try
{
ServerSocket ss=new ServerSocket(4660);
Socket s=ss.accept();
System.out.println("Client Accepted");
BufferedReader br=new BufferedReader(new
InputStreamReader(s.getInputStream()));
System.out.println(br.readLine());
PrintWriter wr=new PrintWriter(new
OutputStreamWriter(s.getOutputStream()),true);
wr.println("Welcome to Socket Programming");
}catch(Exception e){System.out.println(e);}
}
}



