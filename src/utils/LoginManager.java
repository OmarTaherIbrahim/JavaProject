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
		try {
			preparedStatement = conection.prepareStatement(query);
			System.out.println("1ß");
			preparedStatement.setString(1, usr);
			System.out.println("1ß");
			preparedStatement.setString(2, pswrd);
			System.out.println("1ß");
			
			result = preparedStatement.executeQuery();
			System.out.println("1ß");
			if(result.next()) {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(preparedStatement!=null) {
			preparedStatement.close();
			System.out.println("not null");
			}
			if(result != null) {

			result.close();

			System.out.println("not null result");
			}
			
		}
		return false;
	}
}
