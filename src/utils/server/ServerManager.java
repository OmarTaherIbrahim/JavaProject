package utils.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerManager {
	String serverName= "localhost";
	int port = 15000;
	private Socket socket = null;
	private DataInputStream objectInputStream = null;
	private DataOutputStream objectOutputStream = null;
	public ServerManager(){
		try {
			socket = new Socket(InetAddress.getLocalHost(), port);
			objectInputStream = new DataInputStream(socket.getInputStream());
			objectOutputStream = new DataOutputStream(socket.getOutputStream());
		}catch(UnknownHostException une) {
			
		}catch(IOException e) {
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void close() {
		try {
			socket.close();
			objectInputStream.close();
			objectOutputStream.close();
		}catch(IOException e) {
			
		}catch(Exception e) {
			
		}
	}
	
	public void sendString() {
		try {
			objectOutputStream.writeUTF("this is a message");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean sendLoginInfo() {
		try {
//			ObjectOutputStream
		}catch(Exception e){
			
		}
		return false;
	}
	///destructor
	protected void finalize() {
		close();
	}
}
