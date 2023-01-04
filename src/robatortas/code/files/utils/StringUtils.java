package robatortas.code.files.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class StringUtils {

	public static String stringListToString(List<String> list) {
		String result = "";
		for(int i = 0; i < list.size(); i++) {
			result += list.get(i) + "\n";
		}
		return result;
	}
	
	public static String stringListToSingleLinedString(List<String> list) {
		String result = "";
		for(int i = 0; i < list.size(); i++) {
			result += list.get(i);
		}
		return result;
	}
	
	public static List<String> stringToLineList(String fileContents) {
		List<String> list = new LinkedList<String>();
		String line = "";
		for(int i = 0; i < fileContents.split("\n").length; i++) {
			line = fileContents.split("\n")[i].toString();
			list.add(line);
		}
		return list;
	}
	
	private static String readFile(String path, Charset encoding) throws IOException{
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded, encoding);
	}
}