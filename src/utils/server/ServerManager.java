package utils.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.SQLException;

import utils.SqliteConnection;

public class ServerManager {
	String serverName= "localhost";
	int port = 15000;
	private Socket socket = null;
	private DataInputStream dataInputStream = null;
	private DataOutputStream  dataOutputStream = null;
	private Connection conection;
	public ServerManager(){
		try {
			socket = new Socket(InetAddress.getLocalHost(), port);
			 dataInputStream = new DataInputStream(socket.getInputStream());
			 dataOutputStream = new DataOutputStream(socket.getOutputStream());
		}catch(UnknownHostException une) {
			
		}catch(IOException e) {
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void close() {
		try {
			socket.close();
			 dataInputStream.close();
			 dataOutputStream.close();
		}catch(IOException e) {
			
		}catch(Exception e) {
			
		}
	}
	
	public boolean isLogin(String usr, String pswrd) throws SQLException {
		boolean state=false;
		try {
			 dataOutputStream.writeUTF("isLogin");
			 dataOutputStream.writeUTF(usr);
			 dataOutputStream.writeUTF(pswrd);
			 state=(boolean) dataInputStream.readBoolean();
			 System.out.println(state+"X");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return state;
	}
	
	public void sendString() {
		try {
			 dataOutputStream.writeUTF("this is a message");
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean sendLoginInfo() {
		try {
//			 dataOutputStream
		}catch(Exception e){
			
		}
		return false;
	}
	///destructor
	protected void finalize() {
		close();
	}
}
