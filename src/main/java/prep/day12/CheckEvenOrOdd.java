package prep.day12;

public class CheckEvenOrOdd {

	public static void main(String[] args) {
		int num = 10;
		while (num > 1) {
			num -= 2;
		}

		if (num == 0)
			System.out.println("even");
		else
			System.out.println("odd");

	}

}
