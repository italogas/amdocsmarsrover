package br.com.italogas.marsrovers.util;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
	
	public static void log(String msg) {
		FileWriter writer;
		try {
			writer = new FileWriter("output.txt", true);
			writer.write(msg);
			writer.write("\n");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
