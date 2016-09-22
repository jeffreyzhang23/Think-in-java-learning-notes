package io;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.mindview.util.BinaryFile;

public class E19_BytesInfo {
	public static void main(String[] args) throws IOException {
		Map<Byte, Integer> map = new HashMap<>();
		for(Byte b : BinaryFile.read(
			"H:\\git\\Thinking in java learning notes\\Thinking in java\\src\\io\\E19_BytesInfo.java")) {
			Integer freq = map.get(b);
			map.put(b, freq == null ? 1 : freq + 1);
		}
		List<Byte> list = Arrays.asList(map.keySet().toArray(new Byte[0]));
		for(Byte b : list) {
			System.out.println(b + "===>" + map.get(b));
		}
	}
}
