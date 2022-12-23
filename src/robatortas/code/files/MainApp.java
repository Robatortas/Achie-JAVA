package robatortas.code.files;

import robatortas.code.files.achie.AchieReader;

public class MainApp {
	
	public static void main(String[] args) {
		System.out.println("Hello Achie!");
		new AchieReader("test.achie").read();
	}
}