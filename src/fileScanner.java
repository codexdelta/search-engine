import java.io.*;
import java.util.*;

public class fileScanner {
	public File[] files= null;
	public ArrayList<String> StemForTree = new ArrayList<String>();
	public Map<String, Integer> wordMap = new HashMap<String, Integer>();

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
	
