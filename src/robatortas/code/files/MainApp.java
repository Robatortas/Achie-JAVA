package robatortas.code.files;

import robatortas.code.files.achie.AchieKey;

public class MainApp {
	
	// I shouldn't put this here!
	public static String path = "test.achie";
	
	public static void main(String[] args) {
		System.out.println("Hello Achie!");
		
		tester();
	}
	
	public static void tester() {
//		System.out.println(aReader.getKeyName("bed"));
//		int a = aReader.getKeyValue("grass");
//		System.out.println(aReader.<String>getKeyValue("bed"));
		new AchieKey().getKeyValue("Robatortas");
	}
}