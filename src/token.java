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
		
		for(int x=0; x<al.size(); x++){
			String stemTerm = al.get(x);
			stemmer(stemTerm);
			
		}
	}
		
		//below code will work as stemmer 
		
		
//		 for (int a=0; a<al.size(); a++ ) {
//		      System.out.println("token "+ a +" = " + al.get(a));
//		      String queryterm = al.get(a);
////		      System.out.println(queryterm);
////		      String test =  "This is a sentence";
////		      String lastWord = test.substring(test.lastIndexOf(" ")+1);
////		      System.out.println(lastWord);
////		      String str2 = "ence";
////		      if(lastWord.toLowerCase().contains(str2.toLowerCase())){
////		    	  System.out.println("yes sub string present");
////		      }
//		      
//		 } 
//		
		
	

	private void stemmer(String stemTerm) {
		// TODO Auto-generated method stub
		String tmp = stemTerm.toLowerCase();
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
	                	   System.out.println("got your term " + tmp1);
	                	   break;
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
	
	}

//		Map<String, Integer> wordMap = new HashMap<String, Integer>();
//	       try {
//	           fis = new FileInputStream("suffix.txt");
//	           dis = new DataInputStream(fis);
//	           br = new BufferedReader(new InputStreamReader(dis));
////	           String line = null;
////	           while((line = br.readLine()) != null){
////	               StringTokenizer st = new StringTokenizer(line, " ");
////	               while(st.hasMoreTokens()){
////	                   String tmp1 = st.nextToken().toLowerCase();
////	                   if(wordMap.containsKey(tmp1)){
////	                       wordMap.put(tmp1, wordMap.get(tmp1)+1);
////	                   } else {
////	                       wordMap.put(tmp1, 1);
////	                   }
////	               }
//	           }
//	       } catch (FileNotFoundException e) {
//	           e.printStackTrace();
//	       } catch (IOException e) {
//	           e.printStackTrace();
//	       } finally{
//	           try{if(br != null) br.close();}catch(Exception ex){}
//	       }
//	       
	       

	

