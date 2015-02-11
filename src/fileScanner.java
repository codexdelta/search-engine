import java.io.File;
import java.io.FilenameFilter;


public class fileScanner {
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
}