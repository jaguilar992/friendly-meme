package proceso;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

public class ProcessFile {
	private FileInputStream fis;
	private boolean ready = false;
	private File file;
	public ProcessFile(String filename) {
		try {
			 this.file= new File(filename);
			fis = new FileInputStream(file);
			this.ready=true;
		}catch (Exception e) {
			this.ready = false;
		}
	}
	
	
	public String readBuffer(){
		String buffer="";
		if(this.ready){
			try{
				byte[] data = new byte[(int) this.file.length()];
				fis.read(data);
				fis.close();
				buffer = new String(data, "UTF-8");
			}catch(Exception e){}
		}
		return buffer;
	}
	
	public ArrayList<String> readlines(){
		ArrayList<String> lista = new ArrayList<>();
		if(this.ready){
			String buffer = this.readBuffer();
			buffer= buffer.replace(" ", "");
			buffer= buffer.replace("\n", "");
			
			for (String l : buffer.split(";")) {
				lista.add(l+";");
			}
		}
		return lista;
	}
	
	
}
