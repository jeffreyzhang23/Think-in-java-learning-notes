package io;

import java.io.File;
import java.io.IOException;

import net.mindview.util.BinaryFile;
import net.mindview.util.Directory;

public class E20_ClassSignatureChecker {
	final static byte[] signature = {(byte)202, (byte)254, (byte)186, (byte)190};
	public static void main(String[] args) throws IOException {
		String dir = ".";
		if(args.length == 1) 
			dir = args[0];
		for(File file : Directory.walk(dir, ".*\\.class")) {
			byte[] b = BinaryFile.read(file);
			for(int i = 0; i < signature.length; i++) {
				if(b[i] != signature[i]) {
					System.err.println(file + " is corrupt!");
					break;
				}
			}
			
		}
		
	}
}
