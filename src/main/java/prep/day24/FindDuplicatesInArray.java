package prep.day24;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicatesInArray {

	public static void main(String[] args) {
		int[] arr = {10,20,30,40,40,10};
		Set<Integer> set = new HashSet<>();
		for(int num : arr) {
			if(!set.add(num)) {
				System.out.println(num);
			}
		}

	}

}
