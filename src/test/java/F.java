import java.util.*;
import java.math.BigInteger;
public class F {
	static Map<Integer,BigInteger> map = new HashMap<>();
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		System.out.println(fun1(45));
		long t2 = System.currentTimeMillis();
		System.out.println(fun2(45));
		long t3 = System.currentTimeMillis();
		System.out.println(t2 - t1);
		System.out.println(t3 - t2);
	}

	static BigInteger fun1(int n) {
		if (map.get(n) == null) {
			map.put(n, n <= 2 ? BigInteger.valueOf(n) : fun1(n - 2).add(fun1(n - 1)));
		}
		return map.get(n);
	}
	static BigInteger fun2(int n) {
		return n <= 2 ? BigInteger.valueOf(n) : fun2(n - 2).add(fun2(n - 1));
	}
}
