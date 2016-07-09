package server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
    
public class FileServer {

 private static ServerSocket serverSocket;

 public static void main(String args[])
 {
	 String htmlfile="<body><h1>Hello,This is Ambica</h1></body>";
     try {
		serverSocket = new ServerSocket(80);
        System.out.println("Waiting for clients...");

        Socket client = serverSocket.accept();
        
       
     //print the request from client
       /*char[] buf = new char[8196];
       BufferedReader from_proxy= new BufferedReader(new InputStreamReader(client.getInputStream()));
       int bytesRead =from_proxy.read(buf);   //BytesRead need to be calculated if the char buffer contains too many values
       String requestClinet = new String(buf, 0, bytesRead);
       System.out.println(requestClinet);
       
       */
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        writer.write(htmlfile);
        writer.flush();
        writer.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

 }
}
