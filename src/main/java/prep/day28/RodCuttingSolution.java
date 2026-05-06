package prep.day28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCuttingSolution {

	public static void main(String[] args) {
		int[] rods = {1,1,3,4};
		//sort the array to find the shortest rod
		Arrays.sort(rods);
		//add the rods into a list
		List<Integer> list = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		for(int rod : rods)
			list.add(rod);
		while(!list.isEmpty()) {
			result.add(list.size());
			int shortest = list.get(0);
			ArrayList<Integer> next = new ArrayList<>();
			for(int rod : list) {
				if(rod == shortest) {
					continue;
				}else {
					next.add(rod-shortest);
				}
			}
			list = next;
		}
		System.out.println(result);

	}

}
