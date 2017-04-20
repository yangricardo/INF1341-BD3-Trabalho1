package utils;

public class Util {

	public static void printError(String msg,Exception e) {
		System.err.println(msg);
		System.err.println(" Message: "+e.getMessage());
		System.err.println(" CAUSE: "+e.getCause());
	}
	
}
