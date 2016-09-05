package generics.coffee;

public class BasketballPlayers {
	private static long count = 0;
	private final long id = count++;
	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
}
