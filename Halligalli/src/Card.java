public class CardDeck {
	private Card[] deck = new Card[56]; // 아직 섞지 않은 카드 덱
	private int idx;// 자동으로 0부터 초기화
	private int card_count = 56;
	private int m;

	public CardDeck() { 
		createDeck();
	}

	// 섞이지 않은 56장의 카드덱 완성
	private void createDeck() { 
		createFruit(Card.STRAWBERRY);
		createFruit(Card.BANANA);
		createFruit(Card.PLUM);
		createFruit(Card.LIME);
	}

	private void createFruit(String s) {
		for(int i = 1; i <= Card.SIZE_OF_ONE_FRUIT; i++) { // 5장
			deck[idx] = new Card(s, 1);
			idx++;
		}
		for(int i = 1; i <= Card.SIZE_OF_TWO_FRUIT; i++) { // 3장
			deck[idx] = new Card(s, 2);
			idx++;
		}
		for(int i = 1; i <= Card.SIZE_OF_THREE_FRUIT; i++) { // 3장
			deck[idx] = new Card(s, 3);
			idx++;
		}
		for(int i = 1; i <= Card.SIZE_OF_FOUR_FRUIT; i++) { // 2장
			deck[idx] = new Card(s, 4);
			idx++;
		}
		for(int i = 1; i <= Card.SIZE_OF_FIVE_FRUIT; i++) { // 1장
			deck[idx] = new Card(s, 5);
			idx++;
		}
	}

	public Card[] giveCardDeck1(Card[] shuffledeck) {
		Card[] player_deck = new Card[100];
		for(int i = 0; i < 28; i++) {
			player_deck[i] = shuffledeck[i];
		}
		return player_deck;
	}

	public Card[] giveCardDeck2(Card[] shuffledeck) {
		Card[] computer_deck = new Card[100];
		for(int i = 28; i < 56; i++) {
			computer_deck[m] = shuffledeck[i];
			m+=1;
		}
		return computer_deck;
	}

	// 56장의 카드를 섞은 카드덱(덱을 만든 후 불러와야 함)
	public Card[] randomDeck() {
		Card[] d = new Card[56];
		for(int i = 0; i < 56; i++) {
			d[i] = newCard();
		}
		return d;
	}

	// 무작위로 카드를 1장 뽑는 메소드
	public Card newCard() { 
		if(!(idx > 0)) {
			createDeck();
		}
		int index = (int)(Math.random() * idx);
		Card card_to_deal = deck[index];
		for (int i = index+1; i < idx; i++)
			deck[i-1] = deck[i];
		idx--;
		return card_to_deal;
	}

	public Card drawCard(Card[] deck, int idx) {
		return deck[idx++];
	}
}