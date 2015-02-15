package test;
import java.util.*;
import java.io.*;
public class fileScanner {
	public ArrayList<String> StemForTree = new ArrayList<String>();
	public ArrayList<String> FileList = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create a file.txt scanner 
		//create a class which will search for the tokens from other class create a index of the files 
		// with freq rate 
		String a[]=null;
		FilteredFileList(a[]);
	}
		public String FilteredFileList(String a[]) {
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
		
		public ArrayList StemSearchInFile(ArrayList StemForTree){
			 
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
					FileList.add(rfile);
					
					}	
				/*for(int z=0; z<FileList.size(); z++){
					getWordCount(FileList.get(z));
				}*/
				return FileList;
				}
}


