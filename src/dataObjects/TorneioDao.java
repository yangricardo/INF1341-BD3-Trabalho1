package dataObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Torneio;

public class TorneioDao {

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
	
	public static void createTorneio(Torneio torneio){
		//não testado
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO TORNEIO (NOME, GRAUDIFICULDADE,STATUS)"
					+"VALUES(?,?,?)");
			pstmt.setString(1,torneio.getNome());
			pstmt.setInt(2, torneio.getGrauDificuldade());
			pstmt.setString(3, torneio.getStatus());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao criar Torneio", e);
		}
		closeConnection();
	}
	
	public static void updateTorneio(Torneio torneio){
		//não testado
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"UPDATE TORNEIO SET NOME = ?, GRAUDIFICULDADE = ?, STATUS = ? "
					+ "WHERE CODTORNEIO = ?");
			pstmt.setString(1, torneio.getNome());
			pstmt.setInt(2, torneio.getGrauDificuldade());
			pstmt.setString(3, torneio.getStatus());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao atualizar torneio", e);
		}
		closeConnection();
	}
	
	public static void deleteTorneio(int codTorneio){
		//não testado
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"DELETE FROM TORNEIO WHERE CODTORNEIO = ?");
			pstmt.setInt(1, codTorneio);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao remover torneio", e);
		}
		closeConnection();
	}
	
}
