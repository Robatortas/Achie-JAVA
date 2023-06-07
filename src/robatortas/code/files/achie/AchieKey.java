package robatortas.code.files.achie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import robatortas.code.files.MainApp;

public class AchieKey {

	// The KEY!
	String key;
	
	// FIRST STRING STORES THE KEY NAME, SECOND STRING STORES THE KEY VALUE
	HashMap<String, String> achieData = new HashMap<String, String>();
	
	List<String> fileContents = new LinkedList<String>();
	
	// The character index that is being iterated.
	long currentChara;
	// Character index before the current one.
	long previousChara;
	// Character index after the current one.
	long postChara;
	// The character index which indicates the ending character of a key.
	long endingChara;
	// Checks to see if key has been found.
	boolean found;
	// Data type queried.
	String dataType;
	
	public AchieKey() {
		this.currentChara = 0;
		this.previousChara = 0;
		this.postChara = 0;
		this.found = false;
		
//		this.fileContents = StringUtils.stringListToString(new AchieReader(MainApp.path).read());
		this.fileContents = new AchieReader(MainApp.path).read();
		
		//System.out.println(fileContents);
	}
	
	/** <NEWLINE>
	 * <b>getKeyValue function in AchieKey class</b>
	 * <br><br>
	 * Gets the value of a Key.
	 * <br><br>
	 * <b><i>Note that if key doesn't exist in the achie file, or is inside a KeyChain, it will return null!</i></b>
	 * @param key The key you desire to get.
	 */
	public void getKeyValue(String key) {
		this.key = key;
		findKeyValue(key);
	}
	
	private void findKeyValue(String key) {
		String line = "";
		String potentialKey;
		
		for(int i = 0; i < fileContents.size(); i++) {
			line = fileContents.get(i).trim();
			this.currentChara = i;
			
			findKeyData(key, "value");
			
			System.out.println(line);
			
//			if(i > 1 && i < fileContents.size()) System.out.println(line.charAt(0));
//			System.out.println(line.charAt(0));
//			if(line.charAt(0) == SyntaxCharacters.START_VARIABLE && line.charAt(0+key.length()) == SyntaxCharacters.END_VARIABLE) {
//				potentialKey = line.substring(line.indexOf(SyntaxCharacters.START_VARIABLE + key), line.indexOf(key + SyntaxCharacters.END_VARIABLE));
//				
//				System.out.println(potentialKey);
//			}
		}
		
		System.out.println("Your selected datatype is: " + this.dataType);
	}
	
	/** <NEWLINE>
	 * <b>findKey function in AchieKey class</b>
	 * <br><br>
	 * Finds the give key.
	 * <br>
	 * <i>Basically, finds the location of the key.<i>
	 * 
	 * @param key The key that is being queried.
	*/
	private String findKey(String key) {
		
		return null;
	}
	
	/** <NEWLINE>
	 * <b>findKeyData function in AchieKey class</b>
	 * <br><br>
	 * Finds the give key data.
	 * 
	 * @param key The key that is being queried.
	 * @param queriedData The data you want to query.
	*/
	private String findKeyData(String key, String queriedData) {
		String data = queriedData.trim().toLowerCase();
		
		String[] types = {
				"name", /* name is basically the key! */
				"value"
		};
		
		for(int i = 0; i < types.length; i++) {
			String type = types[i].toLowerCase();
			if(data == type) {
				this.dataType = data;
			}
		}
		
		return this.dataType;
	}
	
	/** <NEWLINE>
	 * <b>getKeyName function in AchieKey class</b>
	 * <br><br>
	 * Gets the name of a Key.
	 * <br><br>
	 * <b><i>Note that if key doesn't exist in the achie file, or is inside a KeyChain, it will return null!</i></b>
	 */
	public String getKeyName() {
		return key;
	}
	
	public long getPostChara() {
		return this.currentChara += 1;
	}
	
	public long getPreviousChara() {
		return this.currentChara -= 1;
	}
	
	public long getCurrentChara() {
		return this.currentChara;
	}
	
	// WILL RETURN TRUE ONCE THE END OF THE KEY VARIABLE IS REACHED
	public boolean keyEnded() {
		return false;
	}
	
	// Returns the data type queried.
	public String getDataType() {
		return this.dataType;
	}
	
	public long endOfKeyIndex() {
		return this.endingChara;
	}
}