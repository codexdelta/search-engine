import java.util.*;
import java.io.*;
/**
 * @author 
 * 
 *
 */
public class first {
/**
 * @param args
 */
	
public static void main(String args[])
	{	
	Scanner input = new Scanner(System.in);
	token tokenObject = new token();
	fileScanner fileScannerObject = new fileScanner();
	System.out.print("Enter your query: ");
	String query = input.nextLine();
	tokenObject.QuerytoToken(query);
	tokenObject.ListtoStem();
	System.out.println("hello ashwin");
	}
// public ArrayList al= new ArrayList<String>();
public static void TokenSenderToFileScanner(ArrayList al){
	fileScanner fileObject1 = new fileScanner();
	
	fileObject1.check(al);
}
}
