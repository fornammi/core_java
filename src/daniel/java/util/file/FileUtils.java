package daniel.java.util.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileUtils {
	
	public static void genFile(File file, String str){
		try {
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			raf.write(new String(str.getBytes(), "UTF-8").getBytes());
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
