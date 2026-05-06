package prep.coding;

import java.util.HashMap;
import java.util.Map;

public class FindSecondMostFrequentCharacter {

	public static void main(String[] args) {
		String input = "aabbb";
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : input.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		int firstMax = 0;
		int secondMax = 0;

		for (Map.Entry<Character, Integer> entrySet : map.entrySet()) {
			int value = entrySet.getValue();
			if (value > firstMax) {
				secondMax = firstMax;
				firstMax = entrySet.getValue();
			} else if (value > secondMax && value < firstMax) {
				secondMax = value;
			}
		}

		for (Map.Entry<Character, Integer> entrySet : map.entrySet()) {
			if (entrySet.getValue() == secondMax) {
				System.out.println("Second Most Frequent Character: " + entrySet.getKey() + " and frequency: "
						+ entrySet.getValue());
			}
		}

	}

}
