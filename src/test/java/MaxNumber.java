import java.util.stream.Stream;

/**
 * 编写一个能将给定非负整数列表中的数字排列成最大数字的函数。例如，给定[50，2，1,9]，最大数字为95021。
 */
public class MaxNumber {
	public static void main(String[] args) {
		Stream.of(99,9998)
				.map(Object::toString)
				.sorted(MaxNumber::s)
				.forEach(System.out::print);
	}

	public static int s(String o1, String o2) {
		String s = "";
		if (o1.length() < o2.length()) {
			for (int i = 0; i < o2.length() - o1.length(); i++) {
				s += o1.charAt(o1.length() - 1);
			}
			System.out.printf("1:%s %s %s\n", o1, o2, s);
			return (o1 + s).compareTo(o2);
		} else {
			for (int i = 0; i < o1.length() - o2.length(); i++) {
				s += o2.charAt(o2.length() - 1);
			}
			System.out.printf("2:%s %s %s\n", o1, o2, s);
			return o1.compareTo(o2 + s);
		}
	}
}
