package service;

import java.net.*;
import java.io.*;

public class testServer {
	private static ServerSocket serverSocket;
	private static listenClient listen ;
	
    public static void main(String[] args) throws Exception {  
    	System.out.println("******** wpcServer **********");
		int port=8081;  
		startServer(port) ;
	}

	public static void startServer(int port) throws Exception {
	    try {
	        serverSocket = new ServerSocket(port);
			Thread thread = new Thread(new listenClient(serverSocket));
			thread.start();
			System.out.println("******** wpcServer listen 8081 **********");
	    }
	    catch (IOException ex) {
			ex.printStackTrace();
	    }
	}
}

/*
class listenClient implements Runnable {
	private ServerSocket serverSocket;
	private Socket clientSocket;

	DataInputStream  in;
	DataOutputStream out;

	public listenClient(ServerSocket serverSocket) throws Exception {
		this.serverSocket = serverSocket;
	}
	
	public void run() {
		try {
			while(true) {
				clientSocket = serverSocket.accept();
				System.out.println("Connection from " + clientSocket.getInetAddress().getHostAddress());	
				in  = new DataInputStream (clientSocket.getInputStream());				
				String inData=in.readLine();
				System.out.println("receive Data="+inData);
			}
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}*/
