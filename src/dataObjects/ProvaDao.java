package dataObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Prova;

public class ProvaDao {
	
	private static Connection connection;
	private static void openConnection() {
		connection = ConnectionFactory.getConnection();
	}
	
	private static void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao fechar conexão", e);
		}
	}

	public static void createProva(Prova prova){
		//não testado
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO PROVA (codTorneio,codModalidade)"
					+ "VALUES(?,?)");
			pstmt.setInt(1, prova.getCodTorneio());
			pstmt.setInt(2, prova.getCodModalidade());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao criar Prova", e);
		}		
		closeConnection();
	}
	
	public static void getAllProvaTorneio(int codTorneio){
		//não testado
		ArrayList<Prova> provas = new ArrayList<Prova>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM PROVA WHERE CODTORNEIO = ?");
			pstmt.setInt(1, codTorneio);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Prova prova = new Prova(rs.getInt("codProva"), 
						rs.getInt("codTorneio"), 
						rs.getInt("codModalidade"));
				provas.add(prova);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar Prova", e);
		}		
		closeConnection();
	}
	
	
}
