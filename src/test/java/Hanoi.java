import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 最慢的是System.out.println()!
 * f1最快，f2最慢。
 * n太大时f1会出错。。。
 */
public class Hanoi {
	public static Map<String, StringBuilder> map = new HashMap<>();

	public static String f1(int n, char a, char b, char c) {
		String str = "" + n + a + b + c;
		StringBuilder sb;
		if (map.get(str) == null) {
			sb = new StringBuilder();
			map.put(str, sb);
		} else {
			return map.get(str).toString();
		}
		if (n == 1) {
			sb.append(String.format("移动%c到%c\n", a, c));
			return sb.toString();
		} else {
			sb.append(f1(n - 1, a, c, b));
			sb.append(String.format("移动%c到%c\n", a, c));
			sb.append(f1(n - 1, b, a, c));
			return sb.toString();
		}
	}

	public static String f2(int n, char a, char b, char c) {
		if (n == 1) {
			return String.format("移动%c到%c\n", a, c);
		} else {
			return f2(n - 1, a, c, b) + String.format("移动%c到%c\n", a, c) + f2(n - 1, b, a, c);
		}
	}

	static List<String> list = new ArrayList<>();
	public static void f3(int n, char a, char b, char c) {
		if (n == 1) {
//			System.out.printf("移动%c到%c\n", a, c);
			list.add(String.format("移动%c到%c\n", a, c));
		} else {
			f3(n - 1, a, c, b);
//			System.out.printf("移动%c到%c\n", a, c);
			list.add(String.format("移动%c到%c\n", a, c));
			f3(n - 1, b, a, c);
		}
	}

	public static void main(String[] args) {

		long t1 = System.currentTimeMillis();
		f1(16, 'a', 'b', 'c');
		long t2 = System.currentTimeMillis();
		f2(16, 'a', 'b', 'c');
		long t3 = System.currentTimeMillis();
		f3(16, 'a', 'b', 'c');
		long t4 = System.currentTimeMillis();

		System.out.println(t2 - t1);
		System.out.println(t3 - t2);
		System.out.println(t4 - t3);
	}
}
