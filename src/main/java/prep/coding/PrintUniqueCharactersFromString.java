package prep.coding;

import java.util.LinkedHashSet;

public class PrintUniqueCharactersFromString {

	public static void main(String[] args) {
		String str = "abbacdaab";
		LinkedHashSet<Character> set = new LinkedHashSet<>();
		StringBuilder sb = new StringBuilder();
		for (char ch : str.toCharArray()) {
			if (set.add(ch))
				sb.append(ch);
		}
		System.out.println(sb.toString());
	}

}
