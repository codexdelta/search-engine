import java.util.*;
import java.util.Map.Entry;
import java.io.*;
/**
 * @author Aswin Devarajan
 * 
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
	fileScanner fileScannerObject = new fileScanner();
	System.out.print("Enter your query: ");
	String query = input.nextLine();
	tokenObject.QuerytoToken(query);
	
	String[] a = null;
	fileScannerObject.FilteredFileList(a);
    WordCount mdc = new WordCount();
    Map<String, Integer> wordMap = mdc.getWordCount("ashwin.txt");
    List<Entry<String, Integer>> list = mdc.sortByValue(wordMap);
    for(Map.Entry<String, Integer> entry:list){
        System.out.println(entry.getKey()+" ==== "+entry.getValue());
    }

	}
}
