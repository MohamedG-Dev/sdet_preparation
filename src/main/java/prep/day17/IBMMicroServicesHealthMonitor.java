package prep.day17;

import java.util.List;

public class IBMMicroServicesHealthMonitor {

	public static void main(String[] args) {
		List<String> list = List.of("YYY", "YNY", "YYY", "YYY", "YYY");
		//expected output: 3

		System.out.println(calculateMaxStreak(list));

	}

	static int calculateMaxStreak(List<String> list) {
		int currentstreak = 0;
		int maxStreak = 0;
		for (String str : list) {
			if (!str.contains("N")) {
				currentstreak += 1;
				maxStreak = Math.max(currentstreak, maxStreak);
			} else {
				currentstreak = 0;
			}
		}
		return maxStreak;
	}

}
