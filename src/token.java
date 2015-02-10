import java.util.*;
import java.io.*;


public class token {
	public ArrayList<String> StemWords = new ArrayList<String>();
	
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
		
		for(int x=0; x<al.size(); x++){
			String stemTerm = al.get(x);
			Stemmer(stemTerm);
			
		}
	}
		
		//below code will work as stemmer	

	private void Stemmer(String stemTerm) {
		// TODO Auto-generated method stub
		String tmp = stemTerm.toLowerCase();
		int stemtermlength= tmp.length();
		FileInputStream fis = null;
		DataInputStream dis=null;
		BufferedReader br= null;
		
		ArrayList<String> suffixList = new ArrayList<String>();
		try{
			fis = new FileInputStream("suffix.txt");
			dis = new DataInputStream(fis);
			br = new BufferedReader(new InputStreamReader(dis));
			String line =null;
			while((line = br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(line, " ");
				 while(st.hasMoreTokens()){
	                   String tmp1 = st.nextToken().toLowerCase();
	                   if(tmp.endsWith(tmp1)){
	                	  //strip off the suffix and check whether the new word is present in dic
//	                	   System.out.println("length of the suffix:" + tmp1.length());
	                	   String PrimaryStemWords =tmp.substring(0, tmp.length()-tmp1.length());
	                	   DictionaryTokenCheck(PrimaryStemWords);
//	                	   System.out.println(PrimaryStemWords);
	               
//	                	   System.out.println("got your term " + tmp1);
	                	   
	                   }
	                  
	 		      
				 }
		}
			}catch (FileNotFoundException e) {
	           e.printStackTrace();
	       } catch (IOException e) {
	           e.printStackTrace();
	       } finally{
	           try{if(br != null) br.close();}catch(Exception ex){}
	       }
		}
	
	public void DictionaryTokenCheck(String PrimaryStemWords){
		StemWords.add(PrimaryStemWords);
		System.out.println(StemWords.get(0));
		
		
	}
}

	       

	

