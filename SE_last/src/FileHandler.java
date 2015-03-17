import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class FileHandler {
	
	private ArrayList<String> stemWordsFinal;
	private static Map<String,Integer> wordMap = new TreeMap<String,Integer>();
	public static Map<String, Integer> getWordMap() {
		return wordMap;
	}
	public static void setWordMap(Map<String, Integer> wordMap) {
		FileHandler.wordMap = wordMap;
	}
	public static File[] files= null;
	public String FileLister(){
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

	public void StemCounterInFile(){
		 TokenHandler tokenHandler = new TokenHandler();
		 HashSet<String> set = new HashSet<>(tokenHandler.getStemWordsAfterCheck());
		 stemWordsFinal = new ArrayList<String>(set);
		for(int a= 0; a<stemWordsFinal.size(); a++){
			System.out.println(stemWordsFinal.get(a)+" Stemwords after getting inside the stemcounterinfile");
		}
		for(File f: files){
			//String file= f.getName();
				
				System.out.println(f.getName() + " printing the name of the file");
				FileInputStream fis =null;
				 DataInputStream dis= null;
				 BufferedReader br= null;
				 try{
						fis = new FileInputStream(f);
						dis = new DataInputStream(fis);
						br= new BufferedReader(new InputStreamReader(dis));
						String line = null;
						while((line =br.readLine()) !=null){
							StringTokenizer st= new StringTokenizer(line, " ");
							 while(st.hasMoreTokens()){
								 String fileWord = st.nextToken().toLowerCase();
								 for(int a=0; a<stemWordsFinal.size();a++){
									 
									 if(fileWord.equals(stemWordsFinal.get(a))){
										 if(wordMap.containsKey(f.getName())){
						                     wordMap.put(f.getName(), wordMap.get(f.getName())+1);
						                 } else {
						                     wordMap.put(f.getName(), 1);
						                 }
									 }else{}
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
	
	

public void PrintResult(){
	for (Entry<String, Integer> entry : wordMap.entrySet()) {
	    String key = entry.getKey();
	    Integer value = entry.getValue();

	    System.out.println(key + " : " + value);
	}
}
	}
	
