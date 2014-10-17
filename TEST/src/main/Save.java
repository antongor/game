package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Save {
	public static void save(String playerData) {
		String dataFolder = System.getenv("APPDATA").replace('\\', '/');
		String destinationFolder = (dataFolder + "/GameSave/");
		new File(destinationFolder).mkdirs();
		File file = new File(destinationFolder + "position.sav");
		try {
			file.createNewFile();
			FileOutputStream oStream = new FileOutputStream(file);
			PrintWriter writer = new PrintWriter(oStream);
			writer.print(playerData);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static String load() {
		String dataFolder = System.getenv("APPDATA").replace('\\', '/');
		String destinationFolder = (dataFolder + "/GameSave/");
		File file = new File(destinationFolder + "position.sav");
		String contents = "";
		try {
			FileInputStream oStream = new FileInputStream(file);
			InputStreamReader reader = new InputStreamReader(oStream);
			BufferedReader buffer = new BufferedReader(reader);
			contents = buffer.readLine();
			buffer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contents;
	}
}
