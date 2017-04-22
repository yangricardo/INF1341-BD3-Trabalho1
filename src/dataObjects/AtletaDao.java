package dataObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Atleta;

public class AtletaDao {
	private static Connection connection;
	private static void openConnection() {
		connection = ConnectionFactory.getConnection();
	}
	
	private static void closeConnection(){
		try {
			connection.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao fechar conex�o", e);
		}
	}
	
	public static ArrayList<Atleta> getAllAtletas(){
		//N�o testado ainda
		openConnection();
		ArrayList<Atleta> atletas = new ArrayList<Atleta>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM ATLETA");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				Atleta atleta = new Atleta(rs.getInt("codAtleta"), 
						rs.getInt("cpf"), 
						rs.getString("nome"), 
						rs.getString("sexo"),
						rs.getString("dataNascimento"),
						rs.getString("nacionalidade"));
				atletas.add(atleta);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao obter atletas", e);
			return null;
		}		
		closeConnection();
		return atletas;
	}
	
	public static void createAtleta(Atleta atleta){
		//n�o testado
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO ATLETA (CPF,NOME,SEXO,DATANASCIMENTO,NACIONALIDE)"
					+ "VALUES(?,?,?,?,?,)");
			pstmt.setInt(1, atleta.getCpf());
			pstmt.setString(2, atleta.getNome());
			pstmt.setString(3, atleta.getSexo());
			pstmt.setString(4, atleta.getDataNascimento());
			pstmt.setString(5, atleta.getNacionalidade());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao adicionar Atleta", e);
		}		
		closeConnection();
	}
}
