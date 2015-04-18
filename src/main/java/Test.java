import zpy.util.Arrangement;

import java.util.ArrayList;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		Arrangement a = new Arrangement();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		a.permutation(list, System.out::println);
		a.permutation(list, 3, System.out::println);
	}
}
