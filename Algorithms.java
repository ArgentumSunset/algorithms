	import java.util.Arrays;

	public class Algorithms {

	public static void main(String[] args) {
		int[] cards = {9,10,12,10,11,7,8,2};
		// System.out.println(findMax(cards));
		sortCards(cards);
		for(int i = 0; i < cards.length; i++){
			System.out.println(cards[i]);
		}
		System.out.println("Find1: ");  // unsorted
		System.out.println(find1(3, cards));
		System.out.println(find1(5, cards));
		System.out.println(find1(10, cards));
		System.out.println(find1(9, cards));
		System.out.println("Find2: ");  // sorted
		System.out.println(find2(3, cards));
		System.out.println(find2(5, cards));
		System.out.println(find2(10, cards));
		System.out.println(find2(9, cards));

	}

	public static int findMax(int[] args) {
		int max = args[0];
		for(int x : args) {
			if (x > max) {
				max = x;
			}
		}
		return max;
	}

	public static void sortCards(int[] args) {
		int min = 100;
		int last = 0;
		for(int i = 0; i < args.length; i++) {
			for(int j = i; j < args.length; j++) {
				if (args[j] < min){
					min = args[j];
					last = j; 
				}
			}
			args[last] = args[i];
			args[i] = min;
			min = 100;
		}
	}

	public static boolean find1(int a, int[] cards) { // Naive version
		boolean found = false;
		for(int x : cards) {
			if(x == a) {
				found = true;
			}
		}
		return found;
	}

	public static boolean find2(int a, int[] cards) {
		sortCards(cards);
		int[] lossyCards = Arrays.copyOf(cards, cards.length);
		while (lossyCards.length > 1) {
			lossyCards = cutDown(a, lossyCards);
		}
		return (lossyCards[0] == a);
	}

	public static int[] cutDown(int a, int[] arr) {
		return (a >= arr[arr.length / 2]) ? Arrays.copyOfRange(arr, arr.length / 2, arr.length) : Arrays.copyOfRange(arr, 0, arr.length / 2);
	}
}