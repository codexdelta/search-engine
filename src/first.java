import java.util.*;
import java.io.*;
import java.lang.*;
/**
 * @author 
 * 
 *
 */
public class first {
/** 
 * @param args
 */
	public static ArrayList<String> passingStemToFileScanner = new ArrayList<String>();
public static void main(String args[])
	{	
	Scanner input = new Scanner(System.in);
	token tokenObject = new token();
	fileScanner fileScannerObject = new fileScanner();
	fileScannerObject.fileLister();
	System.out.print("Enter your query: ");
	String query = input.nextLine();
	tokenObject.QuerytoToken(query);
	ArrayList<String> passingStemToFileScanner = tokenObject.TokentoStem();
	fileScannerObject.StemCounter(passingStemToFileScanner);
	}
// public ArrayList al= new ArrayList<String>();
/*public static void TokenSenderToFileScanner(ArrayList al){
	fileScanner fileObject1 = new fileScanner();
	fileObject1.check(al);
}*/
}
