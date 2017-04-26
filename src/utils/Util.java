package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Util {

	public static void printError(String msg,Exception e) {
		System.err.println("==>"+msg+"\n"+e);
		e.printStackTrace();
	}
	
	public static String dateParserString(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		return sdf.format(date);
	}
	
	public static Date stringParserDate(String date) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("DD/MM/YYYY");
		return sdf.parse(date);
	}
	
	public static String readConsole(String message){
		System.out.println(message);
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		return s.nextLine();
	}
	
}
