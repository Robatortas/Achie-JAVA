package robatortas.code.files.achie;

/** <NEWLINE>
 * <b>AchieKeyChain class</b>
 * <br><br>
 * Get all information regarding Achie's KeyChains!
 * 
 */
public class AchieKeyChain {

	// The key that is wanted to be used inside the KeyChain
	String key;
	// The KeyChain that will be used
	String keyChain;
	
	public AchieKeyChain(String keyChain) {
		this.keyChain = keyChain;
	}
	
	/** <NEWLINE>
	 * <b>getKeyValue function in AchieKeyChain class</b>
	 * <br><br>
	 * Gets the value of the Key that is inside current KeyChain.
	 * <br><br>
	 * <b><i>Note that if key doesn't exist in the achie file, it will return null!</i></b>
	 */
	// THIS WILL PROBABLY RETURN A GENERIC! (I FEEL LAZY TO IDENTIFY NUMBERS AND STRINGS AND STUFF, AND PARSE THEM!)
	public void getKeyValue(String key) {
		this.key = key;
	}
	
	/** <NEWLINE>
	 * <b>getKeyName function in AchieKeyChain class</b>
	 * <br><br>
	 * Gets the name of the Key that is inside the specified KeyChain.
	 * <br><br>
	 * <b><i>Note that if Key doesn't exist in the achie file, it will return null!</i></b>
	 */
	public String getKeyName() {
		return key;
	}
	
	/** <NEWLINE>
	 * <b>getKeyChainName function in AchieKeyChain class</b>
	 * <br><br>
	 * Gets the name of the parent KeyChain.
	 * <br><br>
	 * <b><i>Note that if KeyChain doesn't exist in the achie file, it will return null!</i></b>
	 */
	public String getKeyChainName() {
		return this.keyChain;
	}
	
	// WILL RETURN A STRING WITH THE CONTENTS THAT ARE INSIDE THE KEYCHAIN!
	public String getKeyChainContents() {
		return null;
	}
}