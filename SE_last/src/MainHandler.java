import java.io.*;
import java.util.*;


public class MainHandler {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		FileHandler fileHandler = new FileHandler();
		fileHandler.FileLister();

		FirstEvent();
		// rest of the code goes over here
		
		SearchAgain();		
	}
	public static void FirstEvent(){
		Scanner input = new Scanner(System.in);
		TokenHandler tokenHandler = new TokenHandler();
		FileHandler fileHandler = new FileHandler();
		fileHandler.EmptyTreeMap();
		System.out.println("Enter your Query : ");
		String query = input.nextLine();
		// if check condition for empty query 
		if(query.isEmpty()){
			System.out.println("Please enter query");
			SearchAgain();
		}
		tokenHandler.setQuery(query);
		tokenHandler.QueryToToken();
		tokenHandler.TokenToStem();
		fileHandler.StemCounterInFile();
		fileHandler.PrintResult();
		
	}
	
	public static void SearchAgain(){
		Scanner input = new Scanner(System.in);
		System.out.println("Do you want to search again? 1 or 0");
		int searchAgain = input.nextInt();
		if (searchAgain == 1) {
		main(null);
		}else if(searchAgain == 0){
			System.out.println("Thank you for using the Search Engine");
		}else{}
	}
	
	

}
