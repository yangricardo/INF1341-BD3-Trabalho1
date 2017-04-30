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
	
	public static void createModalidade(Modalidade modalidade){
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO MODALIDADE (CODMODALIDADE,NOME, SEXO)"
					+"VALUES(CODMODALIDADE.NEXTVAL,?,?)");
			pstmt.setString(1, modalidade.getNome());
			pstmt.setString(2, modalidade.getSexo());
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("Modalidade Cadastrada");
		} catch (SQLException e) {
			utils.Util.printError("Erro ao criar Modalidade", e);
		}
		closeConnection();
	}
	
	public static Modalidade getModalidade(int codModalidade){
		Modalidade modalidade = null;
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM MODALIDADE WHERE CODMODALIDADE = ?");
			pstmt.setInt(1, codModalidade);
			ResultSet rs = pstmt.executeQuery();
			modalidade = new Modalidade(rs.getInt("codModalidade"), rs.getString("nome"), rs.getString("sexo"));
			pstmt.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			modalidade = null;
		}		
		closeConnection();		
		return modalidade;
	}
	
	public static ArrayList<Modalidade> getAllModalidades(){
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
	
	public static ArrayList<Modalidade> getAllModalidadesFemininas(){
		ArrayList<Modalidade> modalidades = new ArrayList<Modalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM MODALIDADE"
					+ " WHERE SEXO = 'FEMININO' "
					+ " OR SEXO = 'AMBOS'");
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
		ArrayList<Modalidade> modalidades = new ArrayList<Modalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM MODALIDADE"
					+ " WHERE SEXO = 'MASCULINO' "
					+ " OR SEXO = 'AMBOS'");
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
