package dataObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

import model.Atleta;
import model.AtletaHistorico;
import model.Modalidade;
import model.Prova;
import model.ProvaInscritosModalidade;
import model.ProvaModalidade;
import model.Serie;
import model.Torneio;

public class Dao {

	/* Operacoes de conex�o com o banco */
	private static Connection connection;

	private static void openConnection() {
		connection = ConnectionFactory.getConnection();
	}

	private static void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao fechar conex�o", e);
		}
	}

	/* Table Modalidade */

	public static void createModalidade(Modalidade modalidade) {
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO MODALIDADE (CODMODALIDADE,NOME, SEXO)" + "VALUES(CODMODALIDADE.NEXTVAL,?,?)");
			pstmt.setString(1, modalidade.getNome());
			pstmt.setString(2, modalidade.getSexo());
			pstmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			pstmt.close();
			System.out.println("Modalidade Cadastrada");
		} catch (SQLException e) {
			utils.Util.printError("Erro ao criar Modalidade", e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				utils.Util.printError("Erro ao Rollback", e);
			}
		}
		closeConnection();
	}

	public static Modalidade getModalidade(int codModalidade) {
		Modalidade modalidade = null;
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM MODALIDADE WHERE CODMODALIDADE = ?");
			pstmt.setInt(1, codModalidade);
			ResultSet rs = pstmt.executeQuery();
			modalidade = new Modalidade(rs.getInt("codModalidade"), rs.getString("nome"), rs.getString("sexo"));
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar modalidade", e);
			modalidade = null;
		}
		closeConnection();
		return modalidade;
	}

	public static ArrayList<Modalidade> getAllModalidades() {
		ArrayList<Modalidade> modalidades = new ArrayList<Modalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM MODALIDADE");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Modalidade mod = new Modalidade(rs.getInt("CODMODALIDADE"), rs.getString("nome"), rs.getString("sexo"));
				modalidades.add(mod);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar modalidades", e);
		}
		closeConnection();
		return modalidades;
	}

	public static ArrayList<Modalidade> getAllModalidadesFemininas() {
		ArrayList<Modalidade> modalidades = new ArrayList<Modalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT * FROM MODALIDADE" + " WHERE SEXO = 'FEMININO' " + " OR SEXO = 'AMBOS'");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Modalidade mod = new Modalidade(rs.getInt("CODMODALIDADE"), rs.getString("nome"), rs.getString("sexo"));
				modalidades.add(mod);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar modalidade femininas", e);
		}
		closeConnection();
		return modalidades;
	}

	public static ArrayList<Modalidade> getAllModalidadesMasculinas() {
		ArrayList<Modalidade> modalidades = new ArrayList<Modalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT * FROM MODALIDADE" + " WHERE SEXO = 'MASCULINO' " + " OR SEXO = 'AMBOS'");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Modalidade mod = new Modalidade(rs.getInt("CODMODALIDADE"), rs.getString("nome"), rs.getString("sexo"));
				modalidades.add(mod);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar modalidades masculinas", e);
		}
		closeConnection();
		return modalidades;
	}

	/* Table Torneio */

	public static void createTorneio(Torneio torneio) {
		// OK
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO TORNEIO (CODTORNEIO,NOME, GRAUDIFICULDADE,STATUS)"
							+ "VALUES(CODTORNEIO.NEXTVAL,?,?,?)");
			pstmt.setString(1, torneio.getNome());
			pstmt.setInt(2, torneio.getGrauDificuldade());
			pstmt.setString(3, torneio.getStatus());
			pstmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			pstmt.close();
			System.out.println("Torneio Cadastrado");
		} catch (SQLException e) {
			utils.Util.printError("Erro ao criar Torneio", e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				utils.Util.printError("Erro ao Rollback", e);
			}
		}
		closeConnection();
	}

	public static void updateTorneio(Torneio torneio) {
		// n�o testado
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(
					"UPDATE TORNEIO SET NOME = ?, GRAUDIFICULDADE = ?, STATUS = ? " + "WHERE CODTORNEIO = ?");
			pstmt.setString(1, torneio.getNome());
			pstmt.setInt(2, torneio.getGrauDificuldade());
			pstmt.setString(3, torneio.getStatus());
			pstmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao atualizar torneio", e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				utils.Util.printError("Erro ao Rollback", e);
			}
		}
		closeConnection();
	}

	public static void deleteTorneio(int codTorneio) {
		// n�o testado
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement("DELETE FROM TORNEIO WHERE CODTORNEIO = ?");
			pstmt.setInt(1, codTorneio);
			pstmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao remover torneio", e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				utils.Util.printError("Erro ao Rollback", e);
			}
		}
		closeConnection();
	}

	public static ArrayList<Torneio> getAllRelevantsTorneio() {
		ArrayList<Torneio> torneios = new ArrayList<Torneio>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM TORNEIO WHERE STATUS = 'REALIZADO'");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Torneio torneio = new Torneio(rs.getInt("codTorneio"), rs.getString("nome"),
						rs.getInt("grauDificuldade"), rs.getString("status"));
				torneios.add(torneio);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar torneios relevantes", e);
		}
		closeConnection();
		return torneios;
	}

	public static ArrayList<Torneio> getAllRunningTorneio() {
		ArrayList<Torneio> torneios = new ArrayList<Torneio>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM TORNEIO WHERE STATUS = 'EM EXECUCAO'");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Torneio torneio = new Torneio(rs.getInt("codTorneio"), rs.getString("nome"),
						rs.getInt("grauDificuldade"), rs.getString("status"));
				torneios.add(torneio);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar torneios relevantes", e);
		}
		closeConnection();
		return torneios;
	}

	/* Table Prova */

	public static void createProva(Prova prova, Serie serie) {
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(
					"INSERT INTO PROVA (codProva,codTorneio,codModalidade,sexo)" + "VALUES(CODPROVA.NEXTVAL,?,?,?)");
			pstmt.setInt(1, prova.getCodTorneio());
			pstmt.setInt(2, prova.getCodModalidade());
			pstmt.setString(3, prova.getSexo());
			pstmt.executeUpdate();
			pstmt = connection.prepareStatement("INSERT INTO SERIE(CODSERIE,CODPROVA,ETAPA,DATA,HORA,STATUS)"
					+ "VALUES (CODSERIE.NEXTVAL,CODPROVA.CURRVAL,?,?,?,?)");
			pstmt.setString(1, serie.getEtapa());
			pstmt.setString(2, serie.getData());
			System.out.println(serie.getHora()+" "+serie.getHora().length());
			pstmt.setString(3, serie.getHora());
			pstmt.setString(4, serie.getStatus());
			pstmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			pstmt.close();
			System.out.println("Prova Cadastrada");
		} catch (SQLException e) {
			utils.Util.printError("Erro ao criar Prova", e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				utils.Util.printError("Erro ao Rollback", e);
			}
		}
		closeConnection();
	}

	public static void deleteProva(Prova prova) {
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection
					.prepareStatement("DELETE FROM PROVA WHERE CODTORNEIO = ? AND CODMODALIDADE = ? ");
			pstmt.setInt(1, prova.getCodTorneio());
			pstmt.setInt(2, prova.getCodModalidade());
			pstmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao criar Prova", e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				utils.Util.printError("Erro ao Rollback", e);
			}
		}
		closeConnection();
	}

	public static ArrayList<ProvaModalidade> getAllProvaTorneio(int codTorneio, String sexo) {
		ArrayList<ProvaModalidade> provas = new ArrayList<ProvaModalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection
					.prepareStatement("SELECT * FROM PROVAMODALIDADE WHERE CODTORNEIO = ? AND SEXO = ?");
			pstmt.setInt(1, codTorneio);
			pstmt.setString(2, sexo);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ProvaModalidade prova = new ProvaModalidade(rs.getInt("codProva"), rs.getInt("codTorneio"),
						rs.getInt("codModalidade"), rs.getString("nome"), rs.getString("sexo"));
				provas.add(prova);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar Prova", e);
		}
		closeConnection();
		return provas;
	}

	public static ArrayList<ProvaModalidade> getAllProvaTorneio(int codTorneio) {
		ArrayList<ProvaModalidade> provas = new ArrayList<ProvaModalidade>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM PROVAMODALIDADE WHERE CODTORNEIO = ?");
			pstmt.setInt(1, codTorneio);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				ProvaModalidade prova = new ProvaModalidade(rs.getInt("codProva"), rs.getInt("codTorneio"),
						rs.getInt("codModalidade"), rs.getString("nome"), rs.getString("sexo"));
				provas.add(prova);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar Prova", e);
		}
		closeConnection();
		return provas;
	}
	
	/*public static void testSQL(){
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT COUNT(*) FROM SERIECLASSIFICACAO WHERE CODSERIE = ?");
			pstmt.setInt(1, 3);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int contAtletasSerie = rs.getInt(1);
			System.out.println(8%8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		closeConnection();		
	}*/
	

	public static void distributeRegiteredOnProva(int codProva) {
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM PROVAINSCRITOSMODALIDADE " + " WHERE CODPROVA = ? " + " ORDER BY NOTAGERAL DESC");
			pstmt.setInt(1, codProva);
			ResultSet rs = pstmt.executeQuery();
			ArrayList<ProvaInscritosModalidade> vPim = new ArrayList<ProvaInscritosModalidade>();
			int i = 0;
			while(rs.next()) {
				ProvaInscritosModalidade pim = new ProvaInscritosModalidade(rs.getInt("codProva"),
						rs.getInt("codProva"), rs.getInt("codModalidade"), rs.getString("nome_Modalidade"),
						rs.getInt("codAtleta"), rs.getString("nome_Atleta"), rs.getString("sexo"),
						rs.getFloat("notaGeral"));
				System.out.println(pim.getNomeAtleta()+" "+pim.getNomeModalidade());
				vPim.add(pim);
				if(i==63)
					break;
				i++;
			}
			Collections.shuffle(vPim);

			/* pega os dados da serie ja criada */
			pstmt = connection.prepareStatement("SELECT * FROM SERIE WHERE CODPROVA = ? AND ETAPA = 'ELIMINATORIA'");
			pstmt.clearParameters();
			pstmt.setInt(1, codProva);
			rs = pstmt.executeQuery();
			rs.next();
			Serie serieaux = new Serie(rs.getInt("codSerie"), rs.getInt("codProva"), rs.getString("etapa"),
					rs.getString("data"), rs.getString("hora"), rs.getString("status"));

			i = 0;
			int raiaparticipacao = 1;
			while (!vPim.isEmpty()) {
				pstmt = connection.prepareStatement("SELECT COUNT(*) FROM SERIECLASSIFICACAO WHERE CODSERIE = ?");
				pstmt.setInt(1, serieaux.getCodSerie());
				rs = pstmt.executeQuery();
				rs.next();
				int contAtletasSerie = rs.getInt(1);
				if (contAtletasSerie % 8 == 0) {
					/* insere nova serie */
					pstmt = connection.prepareStatement("INSERT INTO SERIE(CODSERIE,CODPROVA,ETAPA,DATA,HORA,STATUS)"
							+ "VALUES (CODSERIE.NEXTVAL,?,?,?,?,?)");
					pstmt.clearParameters();
					pstmt.setInt(1, codProva);
					pstmt.setString(2, serieaux.getEtapa());
					pstmt.setString(3, serieaux.getData());
					try {
						// adiciona 30 minutos a hora da serie anterior
						Date dateAux = utils.Util.stringParserHour(serieaux.getHora());
						GregorianCalendar gc = new GregorianCalendar();
						SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
						gc.setTime(dateAux);
						gc.add(Calendar.MINUTE, 30);
						serieaux.setHora(sdf.format(gc.getTime()));
					} catch (ParseException e) {
						utils.Util.printError("erro ao parser hora", e);
					}
					pstmt.setString(4, serieaux.getHora());
					pstmt.setString(5, serieaux.getStatus());
					pstmt.executeUpdate();
					
					ProvaInscritosModalidade pim = vPim.remove(0);
					raiaparticipacao = 1;
					pstmt = connection.prepareStatement(
							"INSERT INTO SERIECLASSIFICACAO(CODSERIE,CODATLETA,RAIAPARTICIPACAO,STATUSCLASSIFICACAOATLETA)"
									+ "VALUES(?,?,?,?)");
					pstmt.clearParameters();
					pstmt.setInt(1, serieaux.getCodSerie());
					pstmt.setInt(2, pim.getCodAtleta());
					pstmt.setInt(3, raiaparticipacao);
					pstmt.setString(4, "NAO COMPARECEU");
					pstmt.executeUpdate();
				}

				if (contAtletasSerie % 8 != 0) {
					ProvaInscritosModalidade pim = vPim.remove(0);

					pstmt = connection.prepareStatement(
							"INSERT INTO SERIECLASSIFICACAO(CODSERIE,CODATLETA,RAIAPARTICIPACAO,STATUSCLASSIFICACAOATLETA)"
									+ "VALUES(?,?,?,?)");
					pstmt.clearParameters();
					pstmt.setInt(1, serieaux.getCodSerie());
					pstmt.setInt(2, pim.getCodAtleta());
					pstmt.setInt(3, raiaparticipacao);
					pstmt.setString(4, "NAO COMPARECEU");
					pstmt.executeUpdate();
					raiaparticipacao++;
				}
			}

			pstmt.executeUpdate();
			connection.commit();
			connection.setAutoCommit(true);
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao criar Series", e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				utils.Util.printError("Erro ao Rollback", e);
			}
		}

		closeConnection();
	}

	/* Table Serie */

	public static void createSerie(Serie serie) {
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO SERIE(CODSERIE,CODPROVA,ETAPA,DATA,HORA,STATUS)"
							+ "VALUES (CODSERIE.NEXTVAL,?,?,?,?,?)");
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
			try {
				connection.rollback();
			} catch (SQLException e1) {
				utils.Util.printError("Erro ao Rollback", e);
			}
		}
		closeConnection();
	}

	public static void getAllSeries() {
		ArrayList<Serie> series = new ArrayList<Serie>();
		openConnection();
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM SERIE");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Serie serie = new Serie(rs.getInt("codSerie"), rs.getInt("codProva"), rs.getString("etapa"),
						rs.getString("data"), rs.getString("hora"), rs.getString("status"));
				series.add(serie);
			}
			pstmt.close();
		} catch (SQLException e) {
			utils.Util.printError("Erro ao recuperar Series", e);
		}
		closeConnection();
	}

	/* Table Atleta */

	public static ArrayList<Atleta> getAllAtletas() {
		openConnection();
		ArrayList<Atleta> atletas = new ArrayList<Atleta>();
		try {
			PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM ATLETA");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Atleta atleta = new Atleta(rs.getInt("codAtleta"), rs.getString("cpf"), rs.getString("nome"),
						rs.getString("sexo"), rs.getString("dataNascimento"), rs.getString("nacionalidade"));
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

	public static void createAtleta(Atleta atleta, ArrayList<AtletaHistorico> ahs, ArrayList<Integer> codProvas) {
		openConnection();
		try {
			connection.setAutoCommit(false);
			PreparedStatement pstmt = connection
					.prepareStatement("INSERT INTO ATLETA (CODATLETA,CPF,NOME,SEXO,DATANASCIMENTO,NACIONALIDADE)"
							+ "VALUES(CODATLETA.NEXTVAL,?,?,?,?,?)");
			pstmt.setString(1, atleta.getCpf());
			pstmt.setString(2, atleta.getNome());
			pstmt.setString(3, atleta.getSexo());
			pstmt.setString(4, atleta.getDataNascimento());
			pstmt.setString(5, atleta.getNacionalidade());
			pstmt.executeUpdate();
			pstmt.clearParameters();
			for (AtletaHistorico ah : ahs) {
				pstmt = connection.prepareStatement(
						"INSERT INTO ATLETAHISTORICO (CODATLETA,CODMODALIDADE,CODTORNEIO,COLOCACAO,MARCA)"
								+ "VALUES(CODATLETA.CURRVAL,?,?,?,?)");
				pstmt.setInt(1, ah.getCodModalidade());
				pstmt.setInt(2, ah.getCodTorneio());
				pstmt.setInt(3, ah.getColocacao());
				pstmt.setFloat(4, ah.getMarca());
				pstmt.executeUpdate();
				pstmt.clearParameters();
			}

			for (int codProva : codProvas) {
				pstmt = connection.prepareStatement(
						"INSERT INTO PROVAINSCRITOS (CODATLETA,CODPROVA)" + "VALUES(CODATLETA.CURRVAL,?)");
				pstmt.setInt(1, codProva);
				pstmt.executeUpdate();
				pstmt.clearParameters();
			}

			pstmt.close();
			connection.commit();
			connection.setAutoCommit(true);
			System.out.println("Atleta Cadastrado: " + atleta.getNome() + " " + atleta.getDataNascimento());
		} catch (SQLException e) {
			utils.Util.printError("Erro ao adicionar Atleta", e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				utils.Util.printError("Erro ao Rollback", e);
			}
		}
		closeConnection();
	}

}
