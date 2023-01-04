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
	
	public AchieKey() {
		this.currentChara = 0;
		this.previousChara = 0;
		this.postChara = 0;
		this.found = false;
		
//		this.fileContents = StringUtils.stringListToString(new AchieReader(MainApp.path).read());
		this.fileContents = new AchieReader(MainApp.path).read();
		
		this.fileContents = ignoreComments(fileContents);
	}
	
	/** <NEWLINE>
	 * <b>ignoreComments function in AchieKey class</b>
	 * <br><br>
	 * Ignores and returns the contents of the file without comments.
	 * @param fileContents The contents of the file in a string form.
	 */
	public List<String> ignoreComments(List<String>fileContents) {
		List<String> result = new LinkedList<String>();
		
		String line = null;
		boolean isComment = false;
		for(int i = 0; i < fileContents.size(); i++) {
			line = fileContents.get(i).trim();
			
			if(line.startsWith("#")) { 
				isComment = true;
			} else isComment = false;
			
			if(!isComment) result.add(line+"\n");
		}
		return result;
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
	
	public void findKey(String key) {
		
	}
	private void findKeyValue(String key) {
		String line = "";
		String potentialKey;
		
		for(int i = 0; i < fileContents.size(); i++) {
			
		}
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
	
	public long postChara() {
		return this.currentChara += 1;
	}
	
	public long previousChara() {
		return this.currentChara -= 1;
	}
	
	// WILL RETURN TRUE ONCE THE END OF THE KEY VARIABLE IS REACHED
	public boolean keyEnded() {
		return false;
	}
	
	public long endOfKeyIndex() {
		return this.endingChara;
	}
}