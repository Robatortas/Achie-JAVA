package robatortas.code.files.achie;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import robatortas.code.files.utils.StringUtils;

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
	
	// KEEPING THESE ARRAYS TEMPORARILY (WILL DELETE THEM SOON!)
	final String[] initialCharacters = {
			"<",
			"[",
			"{",
			":",
			"#"
	};
	
	final String[] endingCharacters = {
			">",
			"]",
			"}",
			";",
			",",
	};
	
	public AchieReader(String path) {
		this.PATH = path;
		this.FILE = new File(path);
		
		if(!FILE.exists()) {
			System.err.println("Specified path does not exists.");
			System.exit(0);
		} else System.out.println("File by the name of " + "\"" + FILE.getName() + "\"" + " found");
	}
	
	/** <NEWLINE>
	 * <b>read function in AchieReader class</b>
	 * <br><br>
	 * Reads the achie file specified.
	 * <br><br>
	 * <b><i>Note that if path equals null, it will throw an error!</i></b>
	 */
	public List<String> read() {
		Path path = Paths.get(PATH);
		try {
			List<String> contents = Files.readAllLines(path);
			return contents;
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
	@Deprecated
	private String getKeyName(String key) {
		List<String> contents = read();
		
		String line = "";
		
		String result = "";
		
		for(int i = 0; i < contents.size(); i++) {
			line = contents.get(i).trim();

			if(line.startsWith("#")) line = "";
			
			// TRUE IF IT'S A KEY.
			if(line.startsWith(this.initialCharacters[0])) {
				line = line.substring(line.lastIndexOf(initialCharacters[0])+1, line.lastIndexOf(endingCharacters[0]));
				if(line.equals(key)) {
					result = line;
					return result;
				}
			}
		}
		if(key != result) System.out.println("No such key with the name of " + "\"" + key +"\"");
		return result;
	}
	
	/** <NEWLINE>
	 * getKeyValue function
	 * <br><br>
	 * 
	 * Gets the value of the indicated key.
	 * <br>
	 * Use the key parameter to identify the key.
	 * <br><br>
	 * 
	 * <b>USES GENERICS</b>
	 * 
	 * @param key The name of the key.
	 */
	@SuppressWarnings("unchecked")
	@Deprecated
	public <T> T getKeyValue(String key) {
		List<String> contents = read();
		
		String line = "";
		String keyName = "";
		String result = "";
		
		for(int i = 0; i < contents.size(); i++) {
			line = contents.get(i).trim();

			// IGNORES COMMENTS
			if(line.startsWith("#")) line = "";
			
			if(line.startsWith(this.initialCharacters[0])) {
				keyName = line.substring(line.lastIndexOf(initialCharacters[0])+1, line.lastIndexOf(endingCharacters[0]));
				line = line.substring(line.lastIndexOf(this.initialCharacters[3])+1, line.lastIndexOf(";")).trim();
				
				if(keyName.equals(key)) {
					result = line;
					return (T) result;
				}
			}
		}
		if(key != result) System.out.println("Unable to find value of " + "\"" + key +"\"" + " key");
		return (T) result;
	}
	
	private String getInitialCharacters(String line) {
		for(int i = 0; i < this.initialCharacters.length; i++) {
			if(line.startsWith(this.initialCharacters[i].toString())) {
				return initialCharacters[i].toString();
			}
		}
		return "";
	}
	
	private String getEndingCharacters(String line) {
		for(int i = 0; i < this.endingCharacters.length; i++) {
			if(Character.toString(line.charAt(line.lastIndexOf(this.endingCharacters[i].toString()))).equals(this.endingCharacters[i].toString())) {
				System.out.println("ENDING" + endingCharacters[i].toString());
				return endingCharacters[i].toString();
			}
		}
		return "";
	}
}