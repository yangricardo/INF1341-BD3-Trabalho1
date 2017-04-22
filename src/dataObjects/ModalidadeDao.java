package dataObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Modalidade;

public class ModalidadeDao {
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
	
	public static ArrayList<Modalidade> getAllModalidades(){
		//Não testado ainda
		ArrayList<Modalidade> modalidades = new ArrayList<Modalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM MODALIDADE");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Modalidade mod = new Modalidade(rs.getInt("CODMODALIDADE"),
						rs.getString("nome"), rs.getString("sexo"));
				modalidades.add(mod);
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return modalidades;		
	}
	
	public static ArrayList<Modalidade> getAllModalidadesMasculinas(){
		//Não testado ainda
		ArrayList<Modalidade> modalidades = new ArrayList<Modalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM MODALIDADE"
					+ "WHERE SEXO = 'MASCULINO'"
					+ "AND SEXO = 'AMBOS'");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Modalidade mod = new Modalidade(rs.getInt("CODMODALIDADE"),
						rs.getString("nome"), rs.getString("sexo"));
				modalidades.add(mod);
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return modalidades;		
	}
	
	public static ArrayList<Modalidade> getAllModalidadesFemininas(){
		//Não testado ainda
		ArrayList<Modalidade> modalidades = new ArrayList<Modalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM MODALIDADE"
					+ "WHERE SEXO = 'FEMININO'"
					+ "OR SEXO = 'AMBOS'");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Modalidade mod = new Modalidade(rs.getInt("CODMODALIDADE"),
						rs.getString("nome"), rs.getString("sexo"));
				modalidades.add(mod);
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return modalidades;		
	}
	
	public static ArrayList<Modalidade> getAllModalidadesMasculino(){
		//Não testado ainda
		ArrayList<Modalidade> modalidades = new ArrayList<Modalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM MODALIDADE"
					+ "WHERE SEXO = 'MASCULINO'"
					+ "OR SEXO = 'AMBOS'");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Modalidade mod = new Modalidade(rs.getInt("CODMODALIDADE"),
						rs.getString("nome"), rs.getString("sexo"));
				modalidades.add(mod);
			}
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeConnection();
		return modalidades;		
	}
	
}
