package robatortas.code.files;

import robatortas.code.files.achie.AchieReader;

public class MainApp {
	
	static AchieReader aReader;
	
	public static void main(String[] args) {
		System.out.println("Hello Achie!");
		aReader = new AchieReader("test.achie");
		
		tester();
	}
	
	public static void tester() {
//		System.out.println(aReader.getKeyName("bed"));
//		int a = aReader.getKeyValue("grass");
		System.out.println(aReader.<String>getKeyValue("bed"));
		
		
	}
}