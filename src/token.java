import java.util.*;
import java.io.*;


public class token {
	public ArrayList<String> stemWordsAfterCheck = new ArrayList<String>();

	public ArrayList<String> QuerytoToken(String query){
		StringTokenizer st = new StringTokenizer(query, " ");
		ArrayList<String> al = new ArrayList<String>();
		while(st.hasMoreTokens()){
			al.add(st.nextToken());
		}
		return al;
	}
	public void ListtoStem(ArrayList<String> al){
		
		for(int c=0; c<al.size();c++){
			
			String tmp = al.get(c);
			Stemmer(tmp);	
		}
	}
	public void Stemmer(String tmp){
		
		String stem = tmp.toLowerCase();
		int stemLength = stem.length();
		FileInputStream fis = null;
		DataInputStream dis = null;
		BufferedReader br= null;
		
		ArrayList<String> suffixList = new ArrayList<String>();
		try {
			fis = new FileInputStream("suffix.txt");
			dis = new DataInputStream(fis);
			br = new BufferedReader(new InputStreamReader(dis));
			String line = null;
		while((line = br.readLine()) != null){
			StringTokenizer st= new StringTokenizer(line, " ");
			while(st.hasMoreTokens()){
				String suffixTerm = st.nextToken().toLowerCase();
				if(stem.endsWith(suffixTerm)){
					//removing the suffix from the tokens
					String StemforDictionary = stem.substring(0, stem.length()-suffixTerm.length());
					System.out.print("job 2");
					DictionaryCheck(StemforDictionary);
				}
			}
		}
		}catch (Exception e) {}
	}
	public void DictionaryCheck(String StemforDictionary){
		System.out.print("job 3");
		FileInputStream fis= null;
		DataInputStream dis = null;
		BufferedReader br = null;
		
		
		try{
			System.out.print("job 4");
			fis = new FileInputStream("wordlist.txt");
			dis = new DataInputStream(fis);
			br= new BufferedReader(new InputStreamReader(dis));
			String line = null;
			while((line = br.readLine()) != null){
				StringTokenizer st = new StringTokenizer(line, " ");
				while(st.hasMoreTokens()){
					String Dictionarywords= st.nextToken().toLowerCase();
					if(Dictionarywords.equalsIgnoreCase(StemforDictionary)){
						stemWordsAfterCheck.add(Dictionarywords);
					}
				}
			}
		}catch (Exception e){}
		System.out.println("job 5");
		System.out.println(stemWordsAfterCheck.get(0));
		for(int x=0; x<stemWordsAfterCheck.size();x++){
			System.out.print("job 6");
			System.out.println(stemWordsAfterCheck.get(x));
		}
	}
	}


	       

	
<<<<<<< HEAD

=======
>>>>>>> 6675a792c881ecd77005d1708c52683e2ac1dc86
