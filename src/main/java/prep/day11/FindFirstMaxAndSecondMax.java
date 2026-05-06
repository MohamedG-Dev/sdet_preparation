package prep.day11;

public class FindFirstMaxAndSecondMax {

	public static void main(String[] args) {
		int[] arr = { 10, 2, 5, 6, 1, 8 };
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int thirdMax = Integer.MIN_VALUE;
		for (int num : arr) {
			if (num > max) {
				thirdMax = secondMax;
				secondMax = max;
				max = num;
			} else if (num <= max && num > secondMax) {
				thirdMax = secondMax;
				secondMax = num;
			} else if (num <= secondMax && num > thirdMax) {
				thirdMax = num;
			}

		}

		System.out.println("Max Number: " + max);
		System.out.println("Second Max Number: " + secondMax);
		System.out.println("Third Max Number: " + thirdMax);

	}

}
