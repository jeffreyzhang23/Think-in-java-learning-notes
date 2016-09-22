package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferToText {
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws Exception {
		FileChannel fc = new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		fc = new FileInputStream("data2.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		fc.read(buff);
		buff.flip();
		// doesn't work
		System.out.println(buff.asCharBuffer());
		//decode using this system's default charset:
		buff.rewind(); 
		String encoding = System.getProperty("file.encoding");
		System.out.println("Decode using " + encoding + ": " + Charset.forName(encoding).decode(buff));
		// or, we could encode with something that will print:
		fc = new FileOutputStream("data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		fc = new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		//use a CharBuffer to write through:
		fc = new FileOutputStream("data2.txt").getChannel();
		buff = ByteBuffer.allocate(24); //more than needed
		buff.asCharBuffer().put("some text");
		fc.write(buff);
		fc.close();
		// read and display
		fc = new FileInputStream("data2.txt").getChannel();
		buff.clear();
		fc.read(buff);
		buff.flip();
		System.out.println(buff.asCharBuffer());
		
		
		
		
	}
}
