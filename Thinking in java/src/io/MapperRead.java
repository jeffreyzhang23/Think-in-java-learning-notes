package io;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

public class MapperRead {
	public static void main(String[] args) throws Exception{
		FileChannel fc = new RandomAccessFile(
				new File("D:\\Package\\SW_DVD5_Visio_Pro_2016_64Bit_ChnSimp_MLF_X20-42759.ISO"), "rw").getChannel();
		IntBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size()).asIntBuffer();
		while(bb.hasRemaining()) {
			System.out.print(bb.get());
		}
		fc.close();
		
	
	}
}
