package dataObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.sql.Date;

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
			utils.Util.printError("Erro ao fechar conexão", e);
		}
	}
	
	public static ArrayList<Atleta> getAllAtletas(){
		//Não testado ainda
		openConnection();
		ArrayList<Atleta> atletas = new ArrayList<Atleta>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM ATLETA");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()){
				Atleta atleta = new Atleta(rs.getInt("codAtleta"), 
						rs.getString("cpf"), 
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
		//não testado
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO ATLETA (CODATLETA,CPF,NOME,SEXO,DATANASCIMENTO,NACIONALIDADE)"
					+ "VALUES(CODATLETA.NEXTVAL,?,?,?,?,?)");
			pstmt.setString(1, atleta.getCpf());
			pstmt.setString(2, atleta.getNome());
			pstmt.setString(3, atleta.getSexo());
			Date sqlDTNSC = null;
			try {
				sqlDTNSC = new Date(utils.Util.stringParserDate(atleta.getDataNascimento()).getTime());
			} catch (ParseException e) {
				utils.Util.printError("Erro de conversao de datas", e);
			}
			pstmt.setDate(4, sqlDTNSC);
			pstmt.setString(5, atleta.getNacionalidade());
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("Atleta Cadastrado: "+atleta.getNome()+" "+atleta.getDataNascimento());
		} catch (SQLException e) {
			utils.Util.printError("Erro ao adicionar Atleta", e);
		}		
		closeConnection();
	}
}
