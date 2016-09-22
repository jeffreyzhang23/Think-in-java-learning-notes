package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {
	static String file = "C:\\Users\\Jeffrey\\Desktop\\BasicFileOutput.out";
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(
				new StringReader(
						BufferedInputFile.read("H:\\git\\Thinking in java learning notes\\Thinking in java\\src\\io\\BasicFileOutput.java")));
		PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter(file)));
		int lineNumber = 1;
		String s;
		while((s = in.readLine()) != null) {
			out.println(lineNumber++ + ": " + s);
		}
		out.close();
		System.out.println(BufferedInputFile.read(file));
	}
			
}
