package prep.day27;

import java.util.HashMap;
import java.util.Map;

public class HackathonIBM_ScoreCalculator {

	public static void main(String[] args) {
		String erica="EMH";
		String bob ="HME";
		System.out.println(scoreCard(erica,bob));
		erica = "HHH";
		bob = "MMM";
		System.out.println(scoreCard(erica,bob));
	}

	static String scoreCard(String erica, String bob) {
		
		if(erica.length()!=bob.length())
			return "Length of Erica and Bob should be same";
		Map<Character, Integer> map = new HashMap<>();
		map.put('E', 1);
		map.put('M', 3);
		map.put('H', 5);

		int erica_score = 0;
		int bob_score = 0;
		for (int i = 0; i < erica.length(); i++) {
			erica_score += map.get(erica.charAt(i));
			bob_score += map.get(bob.charAt(i));
		}

		if (erica_score > bob_score) {
			return "Erica";
		} else if (bob_score > erica_score) {
			return "Bob";
		} else {
			return "Tie";
		}
	}

}
