package dataObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		//OK
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO TORNEIO (CODTORNEIO,NOME, GRAUDIFICULDADE,STATUS)"
					+"VALUES(CODTORNEIO.NEXTVAL,?,?,?)");
			pstmt.setString(1,torneio.getNome());
			pstmt.setInt(2, torneio.getGrauDificuldade());
			pstmt.setString(3, torneio.getStatus());
			pstmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			pstmt.close();
			System.out.println("Torneio Cadastrado");
		} catch (SQLException e) {
			utils.Util.printError("Erro ao criar Torneio", e);
		}
		closeConnection();
	}
	
	public static void updateTorneio(Torneio torneio){
		//não testado
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(
					"UPDATE TORNEIO SET NOME = ?, GRAUDIFICULDADE = ?, STATUS = ? "
					+ "WHERE CODTORNEIO = ?");
			pstmt.setString(1, torneio.getNome());
			pstmt.setInt(2, torneio.getGrauDificuldade());
			pstmt.setString(3, torneio.getStatus());
			pstmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
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
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(
					"DELETE FROM TORNEIO WHERE CODTORNEIO = ?");
			pstmt.setInt(1, codTorneio);
			pstmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao remover torneio", e);
		}
		closeConnection();
	}
	
	public static ArrayList<Torneio> getAllRelevantsTorneio(){
		ArrayList<Torneio> torneios = new ArrayList<Torneio>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM TORNEIO WHERE STATUS = 'REALIZADO'");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Torneio torneio = new Torneio(rs.getInt("codTorneio"),
						rs.getString("nome"), rs.getInt("grauDificuldade"),
						rs.getString("status"));
				torneios.add(torneio);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar torneios relevantes", e);
		}
		closeConnection();
		return torneios;
	}
	
	public static ArrayList<Torneio> getAllRunningTorneio(){
		ArrayList<Torneio> torneios = new ArrayList<Torneio>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM TORNEIO WHERE STATUS = 'EM EXECUCAO'");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Torneio torneio = new Torneio(rs.getInt("codTorneio"),
						rs.getString("nome"), rs.getInt("grauDificuldade"),
						rs.getString("status"));
				torneios.add(torneio);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar torneios relevantes", e);
		}
		closeConnection();
		return torneios;
	}
	
}
