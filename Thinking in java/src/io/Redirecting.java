package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Redirecting {
	public static void main(String[] args) throws IOException {
		PrintStream console = System.out;
		BufferedInputStream in = new BufferedInputStream(
				new FileInputStream("H:\\git\\Thinking in java learning notes\\Thinking in java\\src\\io\\Redirecting.java"));
		PrintStream out = new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream("test.out")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int lineNum = 1;
		String s; 
		while((s = br.readLine()) != null) {
//			System.out.println(lineNum++ + ": " + s);
			System.out.println(lineNum++ + ": " + s);
		}
		out.close();
		System.setOut(console);
	}
}
