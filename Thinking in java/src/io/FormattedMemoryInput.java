package io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput {
	public static void main(String[] args) throws IOException{
		try {
			DataInputStream in = new DataInputStream(
					new ByteArrayInputStream(
						BufferedInputFile.read("H:\\git\\Thinking in java learning notes\\Thinking in java\\src\\io\\FormattedMemoryInput.java").getBytes()));
//			while(true) {
//				System.out.print((char)in.readByte());
			while(in.available() != 0){
				System.out.print((char)in.readByte());
			}
		} catch (EOFException e) {
			System.out.println("End of stream");
		}
	}
}
