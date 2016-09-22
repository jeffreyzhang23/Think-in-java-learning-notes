package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class E07_FileInToList {
	public static List<String> readAndAdd (String filename) throws IOException{
		List<String> list = new LinkedList<>();
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		while((s = in.readLine()) != null) {
			list.add(s);
		}
		in.close();
		return list;
	}
	public static void main(String[] args) throws IOException{
		List<String> list = readAndAdd("H:\\git\\Thinking in java learning notes\\Thinking in java\\src\\io\\BufferedInputFile.java");
//		for(int i = list.size() - 1; i >= 0; i--) {
//			System.out.println(list.get(i));
//		}
		for(ListIterator<String> it = list.listIterator(list.size()); it.hasPrevious();) {
			System.out.println(it.previous());
		}
	}
}
