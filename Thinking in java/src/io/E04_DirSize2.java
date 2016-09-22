package io;

import java.io.File;

import net.mindview.util.Directory;

public class E04_DirSize2 {
	public static void main(String[] args) {
		Directory.TreeInfo ti ;
		if(args.length == 0) {
			ti = Directory.walk(".");
		}else {
			ti = Directory.walk(".", args[0]);
		}
		long total = 0;
		for(File file : ti) {
			total += file.length();
		}
		System.out.println(ti.files.size() + " file(s), " + total + " bytes");
	}
}
