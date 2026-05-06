package prep.day18;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ListManipulationUsingStream {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 22, 32, null, 123, 100);
		// print only the number starts with 1
		list.stream().filter(n -> Objects.nonNull(n)).filter(n -> n.toString().startsWith("1"))
				.forEach(System.out::println);

	}

}
