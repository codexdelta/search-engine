import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Map.Entry;


public class fileScanner {
	public File[] files= null;
	public ArrayList<String> StemForTree = new ArrayList<String>();
	public Map<String, Integer> wordMap = new HashMap<String, Integer>();
	
	/*public void check(ArrayList<String> al){
		StemForTree = (ArrayList<String>)al.clone();
		System.out.println(StemForTree);
		System.out.println("its working");		
	}*/
	public String fileLister(){
		File file = new File("folder/");
			files= file.listFiles(new FilenameFilter(){
			
			@Override
			public boolean accept(File dir, String name){
				if(name.toLowerCase().endsWith(".txt")){
					return true;
				}else{
					return false;
				}
			}
		});
		return null;
	}
	public void fileName(){
		
	}
	
	public void StemCounter(ArrayList passingStemToFileScanner) {
		for(int n=0; n<passingStemToFileScanner.size();n++){
			StemForTree.add((String) passingStemToFileScanner.get(n));
			}
		for(File f: files){
			String rfile= f.getName();
			example(rfile);
			}
		
	}
	public void example(String rfile){
	// TODO Auto-generated method stub
		FileInputStream fis =null;
		 DataInputStream dis= null;
		 BufferedReader br= null;
		 
		
			try{
				fis = new FileInputStream("folder/"+rfile);
				dis = new DataInputStream(fis);
				br= new BufferedReader(new InputStreamReader(dis));
				String line = null;
				while((line =br.readLine()) !=null){
					StringTokenizer st= new StringTokenizer(line, " ");
					 while(st.hasMoreTokens()){
					 for(int a=0; a<StemForTree.size();a++){
						 String queryStem =(String) StemForTree.get(a);
						 String fileword=st.nextToken().toLowerCase();
						 if(fileword.contains(queryStem)){
							 if(wordMap.containsKey(rfile)){
			                     wordMap.put(rfile, wordMap.get(rfile)+1);
			                 } else {
			                     wordMap.put(rfile, 1);
			                 }
						 }
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
			
	
		printMap(wordMap);

	}
	public static void printMap(Map wordMap) {
	    Iterator it = wordMap.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        System.out.println(pairs.getKey() + " = " + pairs.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
		
	}
	

/*	public String FilteredFileList(String a[]) {
	File file = new File("folder/");
	File[] files = file.listFiles(new FilenameFilter(){
		
		@Override
		public boolean accept(File dir, String name){
			if(name.toLowerCase().endsWith(".txt")){
				return true;
			}else {
				return false;
			}
		}
	});
	for(File f:files){
		
		String rfile = (String) f.getName();
		
		System.out.println(rfile);
		}
	return null;
	
	
	}
*/
/* public void getWordCount(String filename){
	  	FileInputStream fis = null;
	     DataInputStream dis = null;
	     BufferedReader br = null;
	     try{
	    	 fis = new FileInputStream("folder/"+filename);
	    	 dis = new DataInputStream(fis);
	    	 br = new BufferedReader(new InputStreamReader (dis));
	    	 String line = null;
	         while((line = br.readLine()) != null){
	             StringTokenizer st = new StringTokenizer(line, " ");
	             while(st.hasMoreTokens()){
	                 String tmp = st.nextToken().toLowerCase();
	                 if(wordMap.containsKey(tmp)){
	                     wordMap.put(tmp, wordMap.get(tmp)+1);
	                 } else {
	                     wordMap.put(tmp, 1);
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
*/ /*public void getWordCount(String fileName){
	
     FileInputStream fis = null;
     DataInputStream dis = null;
     BufferedReader br = null;
     
     try {
         fis = new FileInputStream("folder/"+fileName);
         dis = new DataInputStream(fis);
         br = new BufferedReader(new InputStreamReader(dis));
         String line = null;
         while((line = br.readLine()) != null){
             StringTokenizer st = new StringTokenizer(line, " ");
             while(st.hasMoreTokens()){
                 String tmp = st.nextToken().toLowerCase();
                 if(wordMap.containsKey(tmp)){
                     wordMap.put(tmp, wordMap.get(tmp)+1);
                 } else {
                     wordMap.put(tmp, 1);
                 }
             }
         }
     } catch (FileNotFoundException e) {
         e.printStackTrace();
     } catch (IOException e) {
         e.printStackTrace();
     } finally{
         try{if(br != null) br.close();}catch(Exception ex){}
     }
     
     for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
    	    System.out.println(entry.getKey()+" : "+entry.getValue());
    	 
    	}
     
     
     
     for(int c=0;c<StemForTree.size();c++){
    	 System.out.println("ashwin");
    	 String stem = StemForTree.get(c);
    	System.out.println(wordMap.get(stem));
     }
//     sortByValue(wordMap);
//     return wordMap;
 }*/
 
 /*public void sortByValue(Map<String, Integer> wordMap){
	 
     Set<Entry<String, Integer>> set = wordMap.entrySet();
     List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
     Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
     {
         public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
         {
             return (o2.getValue()).compareTo( o1.getValue() );
         }
     } );
     System.out.println("ashwin welcome");
     for(int c=0;c<StemForTree.size();c++){
    	 
     
     for(Map.Entry<String, Integer> entry:list){
    	 for(int c=0; c<StemForTree.size();c++){
    		 
    	 }
      // System.out.println(entry.getKey()+" ==== "+entry.getValue());
    	 
    	 if(entry.getKey().equalsIgnoreCase(StemForTree.get(c))){
    		 System.out.println(entry.getKey()+" ==== "+entry.getValue());
    	 }
    	 
     }
     }
//     return list;
 }
*/

