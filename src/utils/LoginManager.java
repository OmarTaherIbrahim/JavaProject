package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import data.UserInfo;

public class LoginManager {
	static Connection conection;
	PreparedStatement predState=null;
	public LoginManager() {
		conection = SqliteConnection.Connector();
		if(conection == null) System.exit(1);
	}
	
	public boolean isConnected() {
		try {
			return !conection.isClosed();
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public  void endit() {

		try {
			if (predState!=null)
			predState.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	public boolean isLogin(String usr, String pswrd) throws SQLException {
		usr=usr.toLowerCase();
		ResultSet result=null;
		String query="select username from users where ? = username and password = ? ";
		predState = conection.prepareStatement(query);
		predState.setString(1, usr);
		predState.setString(2, pswrd);
		
		result = predState.executeQuery();
		if(result.next()) {
			return true;
		}
		if(predState!=null) {
			predState.close();	
		}
		if(result != null) {
			result.close();
		}
		
		return false;
	}
	
	//----check if the account that  is sent is valid for creation if so sends it to createAccount function
	public int isSignup(String usr, String email,String pswrd) throws SQLException{
		usr=usr.toLowerCase();
		email=email.toLowerCase();
		ResultSet result =null;
		String query="Select * from users where username = ? or email = ?";
		
		predState = conection.prepareStatement(query);
		predState.setString(1, usr);
		predState.setString(2, email);
		result = predState.executeQuery();
		if(result.next()) {
			//if an account exists with same username or email
			//check if it's both the email and username and if so return -2
			query="Select * from users where username = ? and email = ?";
			predState = conection.prepareStatement(query);
			predState.setString(1, usr);
			predState.setString(2, email);
			result = predState.executeQuery();
			if(result.next()) {
				if(predState!=null) predState.close();	
				if(result != null) result.close();
				return -2;
			}else {
				//else if not both of them check if it's the user name and if so return -1
				query="Select * from users where username = ?";
				
				predState = conection.prepareStatement(query);
				predState.setString(1, usr);
				result = predState.executeQuery();
				if(result.next()) {
					if(predState!=null) predState.close();	
					if(result != null) result.close();
					return -1;
				}
			}
			//else it's the email so return 0
			if(predState!=null) predState.close();	
			if(result != null) result.close();
			return 0;
		}else {
			createAccount(usr, email, pswrd);
			if(predState!=null) predState.close();	
			if(result != null) result.close();
			return 1;
			//returns 1 to prove creating the account was successful
		}
		
	}
	//---create account execute the update statement in to sqlite database
	private void createAccount(String usr, String email, String pswrd) throws SQLException {
		String sql = "Insert into users(username,email,password) values(?,?,?)";
		
		predState=conection.prepareStatement(sql);
		predState.setString(1, usr);
		predState.setString(2, email);
		predState.setString(3, pswrd);
		predState.executeUpdate();
	}
	public static void UpdateAll() {
		try {
			String sql = "Update  users set abcLevel=?,abcXP=?,colorsLevel=?,colorsXP=?, shapesLevel=?, shapesXP=?, multiLevel=?, multiXP=?, addLevel=?, addXp=?,subLevel=?,subXP=? where username=?";
			PreparedStatement predState=null;
			predState=conection.prepareStatement(sql);
			predState.setInt(1, UserInfo.AlphabetsLevel);
			predState.setInt(2, UserInfo.AlphabetsXp);
			predState.setInt(3, UserInfo.ColorsLevel);
			predState.setInt(4, UserInfo.ColorsXp);
			predState.setInt(5, UserInfo.ShapesLevel);
			predState.setInt(6, UserInfo.ShapesXp);
			predState.setInt(7, UserInfo.MultiplicationLevel);
			predState.setInt(8, UserInfo.MultiplicationXp);
			predState.setInt(9, UserInfo.AdditionLevel);
			predState.setInt(10, UserInfo.AdditionXp);
			predState.setInt(11, UserInfo.SubtractionLevel);
			predState.setInt(12, UserInfo.SubtractionXp);
	
			predState.setString(13, UserInfo.UserName.toLowerCase());
			predState.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void getAll() {
		try {
			String sql = "select abcLevel,abcXP,colorsLevel,colorsXP , shapesLevel, shapesXP, multiLevel, multiXP, addLevel, addXp,subLevel,subXP from users where username=?";
			PreparedStatement predState=null;
			predState=conection.prepareStatement(sql);
			
	
			predState.setString(1, UserInfo.UserName.toLowerCase());
			ResultSet result = predState.executeQuery();
			if(result.next()) {
				UserInfo.AlphabetsLevel=result.getInt(1);
				UserInfo.AlphabetsXp=result.getInt(2);
				UserInfo.ColorsLevel=result.getInt(3);
				UserInfo.ColorsXp=result.getInt(4);
				UserInfo.ShapesLevel=result.getInt(5);
				UserInfo.ShapesXp=result.getInt(6);
				UserInfo.AdditionLevel=result.getInt(7);
				UserInfo.AdditionXp=result.getInt(8);
				UserInfo.SubtractionLevel=result.getInt(9);
				UserInfo.SubtractionXp=result.getInt(10);
				UserInfo.MultiplicationLevel=result.getInt(11);
				UserInfo.MultiplicationXp=result.getInt(12);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
