package main;

import java.sql.Connection;
import java.sql.SQLException;
import dataObjects.ConnectionFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection c = ConnectionFactory.getConnection();
		try {
			System.out.println(c.getMetaData().getDriverName());
			System.out.println(c.getMetaData().getUserName());
		} catch (SQLException e) {
			utils.Util.printError("Erro ao acessar banco", e);
		}
		
	}

}
