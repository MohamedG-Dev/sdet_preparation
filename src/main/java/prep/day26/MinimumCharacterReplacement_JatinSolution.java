package prep.day26;

import java.util.Arrays;

public class MinimumCharacterReplacement_JatinSolution {

	public static void main(String[] args) {
		String[] arr = { "ab", "aab", "abb", "abab", "abaaaba"};
		int[] countArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			int index = 1;
			String word = arr[i];
			while (index < word.length()) {
				if (word.charAt(index) == word.charAt(index - 1)) {
					count += 1;
					index += 2;
				} else
					index += 1;
			}
			countArr[i] = count;
		}
		System.out.println(Arrays.toString(countArr));
	}

}
