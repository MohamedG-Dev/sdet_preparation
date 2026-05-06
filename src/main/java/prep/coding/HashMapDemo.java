package prep.coding;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<String, String> countryCapital = new HashMap<>();
		countryCapital.put("India", "New Delhi");
		countryCapital.put("USA", "Washington D C");
		countryCapital.put("UK", "London");
		System.out.println(countryCapital.get("india"));// returns null
		System.out.println("India".hashCode()%16);//output: 7
		System.out.println("USA".hashCode()%16);//output: 3
		System.out.println("UK".hashCode()%16);//output: 6
		Set<String> set = countryCapital.keySet();
		System.out.println(set);//[USA, UK, India]
		// traversing a map
		for (Map.Entry<String, String> entry : countryCapital.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}

}
