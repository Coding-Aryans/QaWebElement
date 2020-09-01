package testcases;

import java.sql.SQLException;

public class TestDatabaseConnection {

	public static void main(String[] args) {
		try {
			DbManager.setMysqlDbConnection();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}

}
