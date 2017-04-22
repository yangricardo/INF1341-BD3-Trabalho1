package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static void printError(String msg,Exception e) {
		System.err.println(msg);
		System.err.println(" Message: "+e.getMessage());
		System.err.println(" CAUSE: "+e.getCause());
	}
	
	public static String dateParserString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(date);
	}
	
	public static Date stringParserDate(String date){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			printError("Erro ao gerar Date",e);
			return null;
		}
	}
	
}
