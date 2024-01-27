import java.util.Arrays;
import java.util.stream.IntStream;

class Card implements Comparable<Card> {

	int num;

	public Card(int num) {
		this.num = num;
	}

	public int compareTo(Card o) {
		return num - o.num;
	}

}

class HeartCard extends Card {

	public HeartCard(int num) {
		super(num);
	}

}

class SpadeCard extends Card {

	public SpadeCard(int num) {
		super(num);
	}

}

class CloverCard extends Card {

	public CloverCard(int num) {
		super(num);
	}

}

class DiamondCard extends Card {

	public DiamondCard(int num) {
		super(num);
	}

}

class Problem {

	Card[] cards;

	public Problem() {
		this.cards = new Card[52];
		IntStream.rangeClosed(1, 13)
				.forEach(n -> {
					cards[n - 1] = new HeartCard(n);
					cards[n + 12] = new SpadeCard(n);
					cards[n + 25] = new CloverCard(n);
					cards[n + 38] = new DiamondCard(n);
				});
	}

	public String solve() {
		int total = 0;
		int[] pedigree = new int[12];
		Card[] card = new Card[6];

		for (int i = 0; i < 52; ++i) {
			for (int j = i + 1; j < 52; ++j) {
				for (int k = j + 1; k < 52; ++k) {
					for (int l = k + 1; l < 52; ++l) {
						for (int m = l + 1; m < 52; ++m) {
							for (int n = m + 1; n < 52; ++n) {
								card[0] = cards[i];
								card[1] = cards[j];
								card[2] = cards[k];
								card[3] = cards[l];
								card[4] = cards[m];
								card[5] = cards[n];
								++pedigree[getPedigree(card)];
								++total;
							}
						}
					}
				}
			}
		}
		return toString(pedigree, total);
	}

	private int getPedigree(Card[] card) {
		int p = 0;

		Arrays.sort(card);
		p = Math.max(p, isOnePair(card));
		p = Math.max(p, isTwoPair(card));
		p = Math.max(p, isTriple(card));
		p = Math.max(p, isStraight(card));
		p = Math.max(p, isBackStraight(card));
		p = Math.max(p, isMaution(card));
		p = Math.max(p, isFlush(card));
		p = Math.max(p, isFullHouse(card));
		p = Math.max(p, isFourCard(card));
		p = Math.max(p, isStraightFlush(card));
		p = Math.max(p, isRoyalStraightFlush(card));
		return p;
	}

	private int isOnePair(Card[] card) {
		for (int i = 0; i < 5; ++i) {
			if (card[i].num == card[i + 1].num) {
				return 1;
			}
		}
		return -1;
	}

	private int isTwoPair(Card[] card) {
		int cnt = 0;
		for (int i = 0; i < 5; ++i) {
			if (cnt == 0 && card[i].num == card[i + 1].num) {
				++cnt;
			} else if (cnt > 0 && card[i].num == card[i + 1].num && card[i - 1].num != card[i].num) {
				++cnt;
			}
		}
		return cnt > 1 ? 2 : -1;
	}

	private int isTriple(Card[] card) {
		for (int i = 0; i < 4; ++i) {
			if (card[i].num == card[i + 1].num && card[i].num == card[i + 2].num) {
				return 3;
			}
		}
		return -1;
	}

	private int isStraight(Card[] card) {
		boolean[] check = new boolean[14];
		for (int i = 0; i < 6; ++i) {
			check[card[i].num] = true;
		}
		for (int i = 1; i <= 9; ++i) {
			if (check[i] && check[i + 1] && check[i + 2]
					&& check[i + 3] && check[i + 4]) {
				return 4;
			}
		}
		return -1;
	}

	private int isBackStraight(Card[] card) {
		boolean[] check = new boolean[14];
		for (int i = 0; i < 6; ++i) {
			check[card[i].num] = true;
		}
		for (int i = 1; i < 6; ++i) {
			if (!check[i]) {
				return -1;
			}
		}
		return 5;
	}

	private int isMaution(Card[] card) {
		boolean[] check = new boolean[14];
		for (int i = 0; i < 6; ++i) {
			check[card[i].num] = true;
		}
		for (int i = 13; i > 9; --i) {
			if (!check[i]) {
				return -1;
			}
		}
		return check[1] ? 6 : -1;
	}

	private int isFlush(Card[] card) {
		for (int i = 0; i < 2; ++i) {
			int count = 0;
			for (int j = i + 1; j < 6; ++j) {
				if (card[i].getClass().isInstance(card[j])) {
					++count;
				}
			}
			if (count >= 5) {
				return 7;
			}
		}
		return -1;
	}

	private int isFullHouse(Card[] card) {
		boolean two = false;
		boolean three = false;
		int[] count = new int[14];

		for (int i = 0; i < 6; ++i) {
			++count[card[i].num];
		}
		for (int i = 1; i <= 13; ++i) {
			if (count[i] == 2) {
				two = true;
			} else if (count[i] == 3) {
				three = true;
			}
		}
		return two && three ? 8 : -1;
	}

	private int isFourCard(Card[] card) {
		int[] count = new int[14];

		for (int i = 0; i < 6; ++i) {
			++count[card[i].num];
		}
		for (int i = 1; i <= 13; ++i) {
			if (count[i] >= 4) {
				return 9;
			}
		}
		return -1;
	}

	private int isStraightFlush(Card[] card) {
		boolean[][] check = new boolean[4][14];

		for (int i = 0; i < 6; ++i) {
			check[matchPattern(card[i])][card[i].num] = true;
		}
		for (int j = 0; j < 4; ++j) {
			for (int i = 1; i <= 9; ++i) {
				if (check[j][i] && check[j][i + 1] && check[j][i + 2]
						&& check[j][i + 3] && check[j][i + 4]) {
					return 10;
				}
			}
		}
		return -1;
	}

	private int isRoyalStraightFlush(Card[] card) {
		boolean[][] check = new boolean[4][14];

		for (int i = 0; i < 6; ++i) {
			check[matchPattern(card[i])][card[i].num] = true;
		}
		for (int j = 0; j < 4; ++j) {
			if (check[j][1] && check[j][2] && check[j][3]
					&& check[j][4] && check[j][5]) {
				return 11;
			}
		}
		return -1;
	}

	private int matchPattern(Card c) {
		if (HeartCard.class.isInstance(c)) {
			return 0;
		} else if (DiamondCard.class.isInstance(c)) {
			return 1;
		} else if (SpadeCard.class.isInstance(c)) {
			return 2;
		}
		return 3;
	}

	private String toString(int[] pedigree, int total) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 12; ++i) {
			double persent = (double)pedigree[i] / total;
			sb.append(pedigree[i]).append("\n");
		}
		System.out.println(total);
		return sb.toString();
	}

}

public class Baekjoon1318 {

	public static void main(String[] args) {
		System.out.println(new Problem().solve());
	}

}

