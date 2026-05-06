package prep.coding;

import java.util.ArrayList;
import java.util.List;

public class EYStringManipulation {
	public static void main(String[] args) {
		String str = "a1b2c3";
		System.out.println(str);
		char[] arr = str.toCharArray();
		List<Character> list  = new ArrayList<>();
		for(char ch : arr) {
			if(Character.isDigit(ch))
				list.add(ch);
		}
		int index=list.size()-1;
		StringBuilder sb = new StringBuilder();
		for(char ch: arr) {
			if(Character.isDigit(ch)) {
				sb.append(list.get(index));
				index--;
			}else
				sb.append(ch);
		}
		System.out.println(sb.toString());
	}

}
