package main;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import dataObjects.Dao;
import model.Atleta;
import model.AtletaHistorico;
import model.Modalidade;
import model.Prova;
import model.ProvaModalidade;
import model.Serie;
import model.Torneio;

public class Main {

	public static void createTorneio() {
		String line;
		String nome;
		int grauDificuldade = 0;
		String status = "EM EXECUCAO";
		
		System.out.println("Criacao de Novo Torneio");
		
		do{
			line = utils.Util.readConsole("Digite o Nome do Torneio (maximo 50 caracteres):"); 
		}while(line.length()>50);
		nome = line;
		
		do{
			line = utils.Util.readConsole("Digite o grau de dificuldade do Torneio");
			grauDificuldade = (line.matches("^[1-9]0*$")?Integer.parseInt(line):0);
		}while(grauDificuldade < 1 || grauDificuldade > 10);
		grauDificuldade = Integer.parseInt(line);
		Torneio torneio = new Torneio(nome, grauDificuldade, status);
		Dao.createTorneio(torneio);
	}

	public static void createRelevantTorneio() {
		String line;
		String nome;
		int grauDificuldade = 0;
		String status = "REALIZADO";
		System.out.println("Criacao de Novo Torneio Relevante");
		
		do{
			line = utils.Util.readConsole("Digite o Nome do Torneio (maximo 50 caracteres):"); 
		}while(line.length()>50);
		nome = line;
		
		do{
			line = utils.Util.readConsole("Digite o grau de dificuldade do Torneio");
			grauDificuldade = (line.matches("^[1-9]0*$")?Integer.parseInt(line):0);
		}while(grauDificuldade < 1 || grauDificuldade > 10);
		grauDificuldade = Integer.parseInt(line);
		
		Torneio torneio = new Torneio(nome, grauDificuldade, status);
		Dao.createTorneio(torneio);
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
		Dao.createModalidade(modalidade);
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
				line = utils.Util.readConsole("Digite a data de nascimento(dd/MM/yyyy): ");
				dtnsc = utils.Util.stringParserDate(line);	
			} catch (ParseException e) {
				utils.Util.printError("Formato irregular da data (dd/MM/yyyy)", e);
			}
		}while(dtnsc == null);
		dataNascimento = utils.Util.dateParserString(dtnsc);
		
		do{
			line = utils.Util.readConsole("Digite '1' para MASCULINO e '2' para FEMININO");
		}while( !(line.equals("1") || line.equals("2")) );
		sexo = (line.equals("1")?"MASCULINO":"FEMININO");
		
		ArrayList<AtletaHistorico> ahs = new ArrayList<AtletaHistorico>();
		String opt;
		do{
			do{
				line = utils.Util.readConsole("Deseja cadastrar uma marca? (S/N)");
			}while(!(line.equalsIgnoreCase("S") || line.equalsIgnoreCase("N")));
			opt = line;
			
			if(opt.equals("S")){
				AtletaHistorico ah = insertMarcaAtletaHistorico(sexo);
				ahs.add(ah);
			}
			
		}while(!opt.equalsIgnoreCase("N"));
		
		
		Atleta atleta = new Atleta(cpf, nome, sexo, dataNascimento, nacionalidade);
		Dao.createAtleta(atleta,ahs);		
	}
	
	public static void createProva(){
		String line;
		int codTorneio = 0;
		int codModalidade = 0;
		String sexo = "";
		System.out.println("CRIAR PROVA");
		
		System.out.println("Torneios 'EM EXECUCAO'");
		ArrayList<Torneio> torneios = Dao.getAllRunningTorneio();
		System.out.println("CODTORNEIO - NOME TORNEIO");
		for(Torneio t : torneios){
			System.out.println(t.getCodTorneio()+" - "+t.getNome());
		}
		do{
			line = utils.Util.readConsole("Digite o Codigo do Torneio em execucao que a prova pertence:");
		}while(!line.matches("^[1-9][0-9]*$"));
		codTorneio = Integer.parseInt(line);
		
		do{
			line = utils.Util.readConsole("Digite '1' para MASCULINO e '2' para FEMININO para definir o sexo da prova");
		}while( !(line.equals("1") || line.equals("2")) );
		sexo = (line.equals("1")?"MASCULINO":"FEMININO");
		
		System.out.println("Modalidades Disponiveis");
		ArrayList<Modalidade> modalidades;
		if(sexo.equals("MASCULINO"))
			modalidades = Dao.getAllModalidadesMasculinas();
		else modalidades = Dao.getAllModalidadesFemininas();
		for(Modalidade m : modalidades){
			System.out.println(m.getCodModalidade()+" - "+m.getNome());
		}
		do{
			line = utils.Util.readConsole("Digite o Codigo da Modalidade em execucao que a prova pertence:");
		}while(!line.matches("^[1-9][0-9]*$"));
		codModalidade = Integer.parseInt(line);
		
		Prova prova = new Prova(codTorneio, codModalidade, sexo);
		Dao.createProva(prova);
	}
	
	public static void createSerie(){
		String line;
		int codProva = 0;
		int codTorneio = 0;
		String etapa = "";
		String data = "";
		String hora = "";
		String status = "PREVISTA";
		
		System.out.println("Criar Serie");
		
		System.out.println("Torneios 'EM EXECUCAO'");
		ArrayList<Torneio> torneios = Dao.getAllRunningTorneio();
		System.out.println("CODTORNEIO - NOME TORNEIO");
		for(Torneio t : torneios){
			System.out.println(t.getCodTorneio()+" - "+t.getNome());
		}
		do{
			line = utils.Util.readConsole("Digite o Codigo do Torneio em execucao que a prova pertence:");
		}while(!line.matches("^[1-9][0-9]*$"));
		codTorneio = Integer.parseInt(line);
		
		System.out.println("Provas cadastradas para o torneio");
		ArrayList<ProvaModalidade> provas = Dao.getAllProvaTorneio(codTorneio);
		System.out.println("CODPROVA - CODMODALIDADE - DESCRICAO - SEXO");
		for(ProvaModalidade p : provas){
			System.out.println(p.getCodProva()+" - "+p.getCodModalidade()+" - "+p.getNome()+" - "+p.getSexo());
		}
		do{
			line = utils.Util.readConsole("Digite o Codigo da prova cuja serie será criada:");
		}while(!line.matches("^[1-9][0-9]*$"));
		codProva = Integer.parseInt(line);
		
		do{
			line = utils.Util.readConsole("Digite '1' para Etapa Eliminatoria, '2' para Etapa Semi-Final e '3' para Etapa Final:");
		}while(!(line.equals("1") || line.equals("2") || line.equals("3")));
		etapa = (line.equals("1")?"ELIMINATORIA":(line.equals("2")?"SEMIFINAL":"FINAL"));
		
		Date dt = null;
		do{
			try {
				line = utils.Util.readConsole("Digite a data da serie (dd/MM/yyyy)");
				dt = utils.Util.stringParserDate(line);
			} catch (ParseException e) {
				utils.Util.printError("Formato irregular da data (dd/MM/yyyy)", e);
			}
		}while(dt==null);
		data = utils.Util.dateParserString(dt);
		
		dt = null;
		do{
			try {
				line = utils.Util.readConsole("Digite o horario da serie (HH:mm) (0 as 23 horas):");
				dt = utils.Util.stringParserHour(line);
			} catch (ParseException e) {
				utils.Util.printError("Formato irregular da data (HH:mm)", e);
			}
		}while(dt==null);
		hora = utils.Util.hourParserString(dt);
		Serie serie = new Serie(codProva, etapa, data,hora, status);
		Dao.createSerie(serie);
		
	}
	
	public static AtletaHistorico insertMarcaAtletaHistorico(String sexo){
		String line;
		
		System.out.println("Torneios 'EM EXECUCAO'");
		ArrayList<Torneio> torneios = Dao.getAllRunningTorneio();
		System.out.println("CODTORNEIO - NOME TORNEIO");
		for(Torneio t : torneios){
			System.out.println(t.getCodTorneio()+" - "+t.getNome());
		}
		do{
			line = utils.Util.readConsole("Digite o Codigo do Torneio em execucao que ira competir:");
		}while(!line.matches("^[1-9][0-9]*$"));
		int codTorneio = Integer.parseInt(line);
		
		System.out.println("Torneios Relevantes");
		torneios.clear();
		torneios = Dao.getAllRelevantsTorneio();
		System.out.println("CODTORNEIO - NOME TORNEIO");
		for(Torneio t : torneios){
			System.out.println(t.getCodTorneio()+" - "+t.getNome());
		}
		do{
			line = utils.Util.readConsole("Digite o Codigo do Torneio relevante que voce participou:");
		}while(!line.matches("^[1-9][0-9]*$"));
		int codTorneioRelevante = Integer.parseInt(line);
		
		
		System.out.println("Provas cadastradas para o torneio");
		ArrayList<ProvaModalidade> provas = Dao.getAllProvaTorneio(codTorneio,sexo);
		System.out.println("CODMODALIDADE - DESCRICAO - SEXO");
		for(ProvaModalidade p : provas){
			System.out.println(p.getCodModalidade()+" - "+p.getNome()+" - "+p.getSexo());
		}
		do{
			line = utils.Util.readConsole("Digite o Codigo da modalidade cuja marca passada foi atingida:");
		}while(!line.matches("^[1-9][0-9]*$"));
		int codModalidade = Integer.parseInt(line);
		
		do{
			line = utils.Util.readConsole("Digite a colocacao atingida no torneio passado :");
		}while(!line.matches("^[1-9][0-9]*$"));
		int colocacao = Integer.parseInt(line);
		
		do{
			line = utils.Util.readConsole("Digite a marca atingida no torneio passado :");
		}while(!line.matches("^(?:\\d{1,3}.)?\\d{0,5}$"));
		float marca = Float.parseFloat(line);
		
		AtletaHistorico ah = new AtletaHistorico(codTorneioRelevante, codModalidade, marca, colocacao);
		
		return ah;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	}

}
