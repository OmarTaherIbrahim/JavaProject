package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.UserInfo;

public class LevelManager {
	static Connection conn;
	public LevelManager() {
		conn = SqliteConnection.Connector();
		if(conn == null) {
			System.out.println("No connection");
			System.exit(-1);
		}
	}
	
	
}
