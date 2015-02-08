import java.util.*;
import java.io.*;
/**
 * @author root
 *
 */
public class first {
/**
 * @param args
 */
public static void main(String[] args)
	{
	Scanner input = new Scanner(System.in);
	token tokenObject = new token();
	System.out.print("Enter your query: ");
	String query = input.nextLine();
	tokenObject.QuerytoToken(query);
	fileScanner fileScannerObject = new fileScanner();
	String[] a = null;
	fileScannerObject.FilteredFileList(a);
	}
}
