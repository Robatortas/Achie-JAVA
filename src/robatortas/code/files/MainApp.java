package robatortas.code.files;

import robatortas.code.files.achie.AchieKey;
import robatortas.code.files.utils.ErrorManager;
import robatortas.code.files.utils.ErrorManager.ErrorType;

public class MainApp {
	
	// I shouldn't put this here!
	public static String path = "test.achie";
	
	public static void main(String[] args) {
		System.out.println("Hello Achie!");
		
<<<<<<< HEAD
		//new ErrorManager(new Throwable(), "ERROR!", ErrorType.HANDLED);
=======
//		new ErrorManager(new Throwable(), "ERROR!", ErrorType.HANDLED);
>>>>>>> 608e11da72d3c59478427e397fd64e2a07528d0a
//		new ErrorManager();
		tester();
	}
	
	public static void tester() {
//		System.out.println(aReader.getKeyName("bed"));
//		int a = aReader.getKeyValue("grass");
//		System.out.println(aReader.<String>getKeyValue("bed"));
		new AchieKey().getKeyValue("Robatortas");
	}
}