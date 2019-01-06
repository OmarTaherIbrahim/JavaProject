package utils;

import java.sql.Connection;

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
