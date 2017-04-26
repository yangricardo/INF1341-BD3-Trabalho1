package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import dataObjects.AtletaDao;
import dataObjects.ModalidadeDao;
import dataObjects.TorneioDao;
import model.Atleta;
import model.Modalidade;
import model.Torneio;

public class Main {

	public static void createTorneio() {
		String line;
		String nome;
		int grauDificuldade = 0;
		String status = "EM EXECUCAO";
		
		System.out.println("Criacao de Novo Torneio");
		
		do{
			line = utils.Util.readConsole("Digite o Nome do Torneio:"); 
		}while(line.length()>25);
		nome = line;
		
		do{
			line = utils.Util.readConsole("Digite o grau de dificuldade do Torneio");
			grauDificuldade = (line.matches("^[1-9]0*$")?Integer.parseInt(line):0);
		}while(grauDificuldade < 1 || grauDificuldade > 10);
		grauDificuldade = Integer.parseInt(line);
		Torneio torneio = new Torneio(nome, grauDificuldade, status);
		TorneioDao.createTorneio(torneio);
	}

	public static void createRelevantTorneio() {
		String line;
		String nome;
		int grauDificuldade = 0;
		String status = "REALIZADO";
		System.out.println("Criacao de Novo Torneio Relevante");
		
		do{
			line = utils.Util.readConsole("Digite o Nome do Torneio:"); 
		}while(line.length()>25);
		nome = line;
		
		do{
			line = utils.Util.readConsole("Digite o grau de dificuldade do Torneio");
			grauDificuldade = (line.matches("^[1-9]0*$")?Integer.parseInt(line):0);
		}while(grauDificuldade < 1 || grauDificuldade > 10);
		grauDificuldade = Integer.parseInt(line);
		
		Torneio torneio = new Torneio(nome, grauDificuldade, status);
		TorneioDao.createTorneio(torneio);
	}

	public static void createModalidade() {
		String line;
		String nome;
		String sexo = "REPETIR";
		System.out.println("Criacao de Nova Modalidade");
		
		do{
			line = utils.Util.readConsole("Digite a Descricao da Modalidade: ");
		}while(line.length()>50);
		nome = line;
		
		do{
		line = utils.Util.readConsole("Digite '1' para AMBOS, '2' para MASCULINO e '3' para FEMININO - SOMENTE O NUMERO");
		}while(!(line.equals("1") || line.equals("2") || line.equals("3")));
		sexo = (line.equals("1")?"AMBOS":(line.equals("2")?"MASCULINO":"FEMININO"));
		
		Modalidade modalidade = new Modalidade(nome, sexo);
		ModalidadeDao.createModalidade(modalidade);
	}

	public static void createAtleta(){
		String line;
		String nome;
		String cpf;
		String nacionalidade;
		String dataNascimento;
		String sexo;
		System.out.println("Cadastro de Atleta");
		
		do{
			line = utils.Util.readConsole("Digite o Nome do Atleta:");
		}while(line.length()>50);
		nome = line;
		
		do{
			line = utils.Util.readConsole("Digite o cpf:");
		}while(!line.matches("^[0-9]{3}[\\.]?[0-9]{3}[\\.]?[0-9]{3}[-]?[0-9]{2}$"));
		cpf = line;
		
		do{
			line = utils.Util.readConsole("Digite a nacionalidade:");
		}while(line.length()>10);
		nacionalidade = line;
		
		//Verifica se a data digitada e valida
		Date dtnsc = null;
		do{
			try {
				line = utils.Util.readConsole("Digite a data de nascimento(DD/MM/YYYY): ");
				dtnsc = utils.Util.stringParserDate(line);	
			} catch (ParseException e) {
				utils.Util.printError("Formato irregular da data (DD/MM/YYYY)", e);
			}
		}while(dtnsc == null);
		dataNascimento = utils.Util.dateParserString(dtnsc);
		
		do{
			line = utils.Util.readConsole("Digite '1' para MASCULINO e '2' para FEMININO");
		}while( !(line.equals("1") || line.equals("2")) );
		sexo = (line.equals("1")?"MASCULINO":"FEMININO");
		
		Atleta atleta = new Atleta(cpf, nome, sexo, dataNascimento, nacionalidade);
		AtletaDao.createAtleta(atleta);		
	}
	
	public static void exemplo() {
		String line = "";
		while (!line.equals("sair")) {
			line = utils.Util.readConsole("Digite a data de nascimento(DD/MM/YYYY): ");
			if (line.equals("sair"))
				break;
			Date date = null;
			try {
				date = utils.Util.stringParserDate(line);
				System.out.println(utils.Util.dateParserString(date));
			} catch (ParseException e) {
				utils.Util.printError("Formato irregular da data (DD/MM/YYYY)", e);
				continue;
			}
		}
	}

	public static void createProva(){
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("teste");
		ArrayList<Modalidade> modalidades = ModalidadeDao.getAllModalidadesMasculinas();
		System.out.println("teste");
		modalidades.forEach(modalidade -> System.out.println(modalidade.getCodModalidade()+" "+modalidade.getNome()+" "+modalidade.getSexo()));
	}

}
