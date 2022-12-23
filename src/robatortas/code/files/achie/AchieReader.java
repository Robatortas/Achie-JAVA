package robatortas.code.files.achie;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/** <NEWLINE>
 * <b><i>AchieReader class</i></b>
 * <br><br>
 * 
 * Class which provides the necessary functions to read an Achie file.
 * <br><br>
 * 
 * -Robatortas
 */
public class AchieReader {
	
	final String PATH;
	final File FILE;
	
	public AchieReader(String path) {
		this.PATH = path;
		this.FILE = new File(path);
		if(!FILE.exists()) {
			System.err.println("Specified path does not exists.");
			System.exit(0);
		} else System.out.println("File by the name of " + "\"" + FILE.getName() + "\"" + " found");
	}
	
	public List<String> read() {
		Path path = Paths.get(this.PATH);
		try {
			List<String> contents = Files.readAllLines(path);
			return contents;
//			System.out.println(contents);
		} catch (IOException e) {
			System.err.println("Unable to read file!");
			e.printStackTrace();
		}
		return null;
	}
	
	/** <NEWLINE>
	 * getKeyName function
	 * <br><br>
	 * 
	 * Gets the name of the indicated key.
	 * <br><br>
	 * Uses the key parameter to identify and get the key's name.
	 * 
	 * @param key The name of the key.
	 */
	public void getKeyName(String key) {
		
	}
	
	/** <NEWLINE>
	 * getKeyValue function
	 * <br><br>
	 * 
	 * Gets the value of the indicated key.
	 * <br><br>
	 * Uses the key parameter to identify the key.
	 * 
	 * @param key The name of the key.
	 */
	public void getKeyValue(String key) {
		
	}
}