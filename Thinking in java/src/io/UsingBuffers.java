package io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class UsingBuffers {
	//相邻两个字符互换位置
	private static void symmetricScramble(CharBuffer buffer) {
		while(buffer.hasRemaining()) {
			buffer.mark();
			char c1 = buffer.get();
			char c2 = buffer.get();
			buffer.reset();
			buffer.put(c2).put(c1);
		}
	}
	public static void main(String[] args) {
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer buff = ByteBuffer.allocate(data.length * 2);
		CharBuffer cb = buff.asCharBuffer();
		cb.put(data);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
	}
}
