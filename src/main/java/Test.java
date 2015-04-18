import java.util.ArrayList;
import java.util.List;

/**
 * Created by zpy on 2015/3/17.
 *
 */
public class Test {
	public static void main(String[] args) {
		Arrangement a = new Arrangement();
		List<Integer> d = new ArrayList<>();
		d.add(1);
		d.add(2);
		d.add(3);
		d.add(4);
		d.add(5);
		List<List<Integer>> lists = new ArrayList<>();
		a.permutation(d, 3, lists::add);
		lists.stream().forEach(System.out::println);
	}
}
