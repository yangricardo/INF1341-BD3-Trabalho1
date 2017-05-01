package dataObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Serie;

public class SerieDao {

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
	
	public static void createSerie(Serie serie){
		//não testado
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO SERIE(CODPROVA,ETAPA,DATA,HORA,STATUS)"
					+ "VALUES (?,?,?,?,?)");
			pstmt.setInt(1, serie.getCodProva());
			pstmt.setString(2, serie.getEtapa());
			pstmt.setString(3, serie.getData());
			pstmt.setString(4, serie.getHora());
			pstmt.setString(5, serie.getStatus());
			pstmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			pstmt.close();			
		} catch (SQLException e) {
			utils.Util.printError("Erro ao adicionar Serie", e);
		}		
		closeConnection();
	}
	
	public static void getAllSeries(){
		//não testado
		ArrayList<Serie> series = new ArrayList<Serie>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM SERIE");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				Serie serie = new Serie(rs.getInt("codSerie"), 
						rs.getInt("codProva"), rs.getString("etapa"),
						rs.getString("data"), rs.getString("hora"), 
						rs.getString("status"));
				series.add(serie);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar Series", e);
		}
		closeConnection();		
	}
	
	
}
