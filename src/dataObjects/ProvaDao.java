package dataObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Prova;
import model.ProvaModalidade;

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
					"INSERT INTO PROVA (codTorneio,codModalidade,sexo)"
					+ "VALUES(?,?,?)");
			pstmt.setInt(1, prova.getCodTorneio());
			pstmt.setInt(2, prova.getCodModalidade());
			pstmt.setString(3, prova.getSexo());
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("Prova Cadastrada");
		} catch (SQLException e) {
			utils.Util.printError("Erro ao criar Prova", e);
		}		
		closeConnection();
	}
	
	public static void deleteProva(Prova prova){
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"DELETE FROM PROVA WHERE CODTORNEIO = ? AND CODMODALIDADE = ? ");
			pstmt.setInt(1, prova.getCodTorneio());
			pstmt.setInt(2, prova.getCodModalidade());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao criar Prova", e);
		}		
		closeConnection();
	}
	
	
	public static ArrayList<ProvaModalidade> getAllProvaTorneio(int codTorneio){
		//não testado
		ArrayList<ProvaModalidade> provas = new ArrayList<ProvaModalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM PROVAMODALIDADE WHERE CODTORNEIO = ?");
			pstmt.setInt(1, codTorneio);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				ProvaModalidade prova = new ProvaModalidade(rs.getInt("codProva"),
						rs.getInt("codTorneio"), rs.getInt("codModalidade"), 
						rs.getString("nome"), rs.getString("sexo"));
				provas.add(prova);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar Prova", e);
		}		
		closeConnection();
		return provas;
	}
	
	
}
