package generics.coffee;

import java.util.Iterator;
import java.util.Random;

import net.mindview.util.Generator;

public class PlayerGenerator implements Generator<BasketballPlayers>, Iterable<BasketballPlayers>{
	private Class<?>[] players = {Jordan.class, Kobe.class, James.class, Iverson.class, Wade.class};
	private Random rand = new Random(47);
	private int n;
	public PlayerGenerator() {
		
	}
	public PlayerGenerator(int count) {
		n = count;
	}
	@Override
	public BasketballPlayers next() {
		// TODO Auto-generated method stub
		try {
			return (BasketballPlayers) players[rand.nextInt(players.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public Iterator<BasketballPlayers> iterator() {
		return new Iterator<BasketballPlayers>() {

			@Override
			public boolean hasNext() {
				return n > 0;
			}

			@Override
			public BasketballPlayers next() {
				n--;
				return PlayerGenerator.this.next();
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}
	
	
	public static void main(String[] args) {
		PlayerGenerator gen = new PlayerGenerator();
		for(int i = 0; i < 5; i++) {
			System.out.print(gen.next() + " ");
		}
		for(BasketballPlayers player : new PlayerGenerator(5)) {
			System.out.print(player + " ");
		}
	}
}
