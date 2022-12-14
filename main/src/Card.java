public class Card {
	private String fruit;
	private int face;
	
	public static final int SIZE_OF_FIVE_FRUIT = 1;
	public static final int SIZE_OF_FOUR_FRUIT = 2;
	public static final int SIZE_OF_THREE_FRUIT = 3;
	public static final int SIZE_OF_TWO_FRUIT = 3;
	public static final int SIZE_OF_ONE_FRUIT = 5;
	
	public static final String BANANA = "banana";
	public static final String STRAWBERRY = "strawberry";
	public static final String LIME = "lime";
	public static final String PLUM = "plum";
	
	public Card(String s, int r) {
		fruit = s; face = r;
	}
	
	public int face() { return face; }
	
	public String fruit() { return fruit; }
	
}