package net.mindview.util;

public class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;
	public BasicGenerator(Class<T> type) {this.type = type;}
	@Override
	public T next() {
		// assume type is a public class
		try {
			return type.newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	//Produce a Default generator given a type token;
	public static <T> Generator<T> create(Class<T> type) {
		return new BasicGenerator<T>(type);
	}
}
