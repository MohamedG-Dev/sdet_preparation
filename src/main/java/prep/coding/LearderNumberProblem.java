package prep.coding;

public class LearderNumberProblem {

	public static void main(String[] args) {
		int[] arr = { 16, 17, 4, 3, 5, 2 };
		int maxRight = arr[arr.length - 1];
		System.out.println(maxRight);
		for (int index = arr.length - 2; index >= 0; index--) {
			if (arr[index] > maxRight) {
				maxRight = arr[index];
				System.out.println(maxRight);
			}
		}

	}

}
