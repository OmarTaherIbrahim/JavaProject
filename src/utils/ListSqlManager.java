package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListSqlManager {
	Connection conn;
	public ListSqlManager() {
		conn = SqliteConnection.Connector();
		if(conn == null) {
			System.out.println("No connection");
			System.exit(-1);
		}
	}
	public void fillArray(String [] ary, String tableName,String column) throws SQLException ,ArrayIndexOutOfBoundsException{
		int size=1;
		String sql = "select Count(*) from "+tableName+";";
		Statement statement = conn.createStatement() ;
		ResultSet result = statement.executeQuery(sql);
		if(result.next()) {
			size = result.getInt("Count(*)");
			System.out.println(size);
		}
		ary=new String[size];
		sql = "Select "+column+"  from "+tableName+";";
		statement = conn.createStatement();
		result = statement.executeQuery(sql);
		int i=0;
		while(result.next()&&i<size) {
			ary[i]=result.getString(column);
			//System.out.println(ary[i]);
			i++;
		}
		
		if(result!=null)result.close();
	}
	public String[] getArray(String tableName,String column) throws SQLException ,ArrayIndexOutOfBoundsException{
		String [] ary;
		int size=1;
		String sql = "select Count(*) from "+tableName+";";
		Statement statement = conn.createStatement() ;
		ResultSet result = statement.executeQuery(sql);
		if(result.next()) {
			size = result.getInt("Count(*)");
			System.out.println(size);
		}
		ary=new String[size];
		sql = "Select "+column+"  from "+tableName+";";
		statement = conn.createStatement();
		result = statement.executeQuery(sql);
		int i=0;
		while(result.next()&&i<size) {
			ary[i]=result.getString(column);
			System.out.println(ary[i]);
			i++;
		}
		
		if(result!=null)result.close();
		return ary;
	}
	public void insertArray(String [] ary, String tableName,String column) throws SQLException {
		String sql = "Insert into "+tableName+"("+column +") values(?);";
		PreparedStatement prepStatement =conn.prepareStatement(sql);
		for (String string : ary) {
			prepStatement.setString(1, string);
			prepStatement.executeUpdate();
		}
		if(prepStatement!=null)
		prepStatement.close();
	}
}
