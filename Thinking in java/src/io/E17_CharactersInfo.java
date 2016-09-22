package io;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.mindview.util.TextFile;

public class E17_CharactersInfo {
	public static void main(String[] args) {
		Map<Character, Integer> map = new HashMap<>();
		for(String word : new TextFile(
			"H:\\git\\Thinking in java learning notes\\Thinking in java\\src\\io\\E17_CharactersInfo.java", "\\W+")) {
			for(int i = 0; i < word.length(); i++) {
				Character ch = word.charAt(i);
				Integer freq = map.get(ch);
				map.put(ch, freq == null ? 1 : freq + 1); // 此处不能为freq++，把freq作为值存入map再++和直接把freq+1当作值存入不是一个概念
			}
		}
		List<Character> list = Arrays.asList(map.keySet().toArray(new Character[0]));
		Collections.sort(list);
		for(Character ch : list) {
			System.out.println(ch + "===>" + map.get(ch));
		}
	}
}
