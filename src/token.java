import java.util.*;
import java.io.*;


public class token {
	public void QuerytoToken(String query){
		int tokens = 0;
		System.out.println("Your code is working!");
		StringTokenizer st = new StringTokenizer(query, " ");
		 ArrayList<String> al = new ArrayList<String>();
			while(st.hasMoreTokens()){
				al.add(st.nextToken());	
				
				tokens = tokens + 1;
			}
		System.out.println("Number of token are : " + tokens);
		System.out.println(al);
	}

	
	public void WritetoFile(){
		
	}
}
