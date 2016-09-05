package generics.coffee;

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

public class BasicGeneratorDemo {
	public static void main(String[] args) {
		Generator<CounterObject> gen = BasicGenerator.create(CounterObject.class);
		for(int i = 0; i < 5; i++) {
			System.out.println(gen.next());
		}
	}
}
