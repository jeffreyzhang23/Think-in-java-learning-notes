package net.mindview.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
	// read a file as a single string:
	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(new File(fileName).getAbsoluteFile()));
			try {
				String s;
				while((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
			 	}
			} finally {
				in.close();
			}
			
		} catch (IOException e) {
			throw new RuntimeException();
		}
		return sb.toString();
	}
	// write a single file in one method call:
	public static void write(String fileName, String text) {
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
	}
	// read a file, split by any regular expression（正则表达式）:
	public TextFile(String fileName, String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));
		// regular exception split() often leaves an empty 
		// string at the first position:
		if(get(0).equals(" ")) remove(0);
	}
	// normally read by lines:
	public TextFile(String fileName) {
		this(fileName, "\n");
	}
	public void write(String fileName) {
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			try {
				for(String item : this) {
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		} 
	}
	// simple test:
	public static void main(String[] args) {
		String file = read(
				"H:\\git\\Thinking in java learning notes\\Thinking in java\\src\\net\\mindview\\util\\TextFile.java");
		write("test.txt", file);
		TextFile text = new TextFile("test.txt");
		text.write("test2.txt");
		// break into unique sorted list of words:
		TreeSet<String> words = new TreeSet<String>(new TextFile("H:\\git\\Thinking in java learning notes\\Thinking in java\\src\\net\\mindview\\util\\TextFile.java", "\\W+"));
		System.out.println(words.headSet("a"));
		System.out.println(words);
	}
	
}
