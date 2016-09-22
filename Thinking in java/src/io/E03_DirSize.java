package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class E03_DirSize {
	public static void main(final String[] args) {
		File path = new File(".");
		String[] list;
		if(args.length == 0) 
			list = path.list();
		else
			list = path.list(new FilenameFilter() {
				private Pattern pattern = Pattern.compile(args[0]);
				@Override
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
			});
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		long fs;
		long total = 0;
		for(String s : list) {
			fs = new File(path, s).length();
			System.out.println(s + ", " + fs + " byte(s)");
			total += fs;
		}
		System.out.println("=========================");
		System.out.println(list.length + " file(s), " + total + " byte(s)");
		
	}
}
