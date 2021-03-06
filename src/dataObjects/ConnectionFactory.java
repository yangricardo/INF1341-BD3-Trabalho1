package dataObjects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection connection = null;
	private final static String[] url = {"jdbc:oracle:thin:@139.82.3.27:1521:orcl","jdbc:oracle:thin:@localhost:1521:xe","jdbc:oracle:thin:@ 172.20.10.8:1521:xe"};
	private final static String[] username = {"BD32017_1212206","inf1341"};
	private final static String[] password = {"BD32017_1212206","inf1341"};
	
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			try {
				connection = DriverManager.getConnection(url[1], username[1], password[1]);
			} catch (SQLException e) {
				utils.Util.printError("Erro ao obter conex�o", e);
			}
		} catch(java.lang.ClassNotFoundException e) {
			utils.Util.printError("Erro ao encontrar a classe", e);
		}
		return connection;
	}
	
}
