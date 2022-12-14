public class CardDeck {
	private Card[] deck = new Card[56]; // ���� ���� ���� ī�� ��
	private int idx;// �ڵ����� 0���� �ʱ�ȭ
	private int card_count = 56;
	private int m;

	public CardDeck() { 
		createDeck();
	}

	// ������ ���� 56���� ī�嵦 �ϼ�
	private void createDeck() { 
		createFruit(Card.STRAWBERRY);
		createFruit(Card.BANANA);
		createFruit(Card.PLUM);
		createFruit(Card.LIME);
	}

	private void createFruit(String s) {
		for(int i = 1; i <= Card.SIZE_OF_ONE_FRUIT; i++) { // 5��
			deck[idx] = new Card(s, 1);
			idx++;
		}
		for(int i = 1; i <= Card.SIZE_OF_TWO_FRUIT; i++) { // 3��
			deck[idx] = new Card(s, 2);
			idx++;
		}
		for(int i = 1; i <= Card.SIZE_OF_THREE_FRUIT; i++) { // 3��
			deck[idx] = new Card(s, 3);
			idx++;
		}
		for(int i = 1; i <= Card.SIZE_OF_FOUR_FRUIT; i++) { // 2��
			deck[idx] = new Card(s, 4);
			idx++;
		}
		for(int i = 1; i <= Card.SIZE_OF_FIVE_FRUIT; i++) { // 1��
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

	// 56���� ī�带 ���� ī�嵦(���� ���� �� �ҷ��;� ��)
	public Card[] randomDeck() {
		Card[] d = new Card[56];
		for(int i = 0; i < 56; i++) {
			d[i] = newCard();
		}
		return d;
	}

	// �������� ī�带 1�� �̴� �޼ҵ�
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