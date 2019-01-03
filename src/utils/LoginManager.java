package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginManager {
	Connection conection;
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
	
	public boolean isLogin(String usr, String pswrd) throws SQLException {
		usr=usr.toLowerCase();
		PreparedStatement preparedStatement=null;
		ResultSet result=null;
		String query="select username from users where ? = username and password = ? ";
		preparedStatement = conection.prepareStatement(query);
		preparedStatement.setString(1, usr);
		preparedStatement.setString(2, pswrd);
		
		result = preparedStatement.executeQuery();
		if(result.next()) {
			return true;
		}
		if(preparedStatement!=null) {
			preparedStatement.close();	
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
		PreparedStatement predState=null;
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
		PreparedStatement predState=null;
		predState=conection.prepareStatement(sql);
		predState.setString(1, usr);
		predState.setString(2, email);
		predState.setString(3, pswrd);
		predState.executeUpdate();
	}
}
