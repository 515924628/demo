import zpy.calc.Calc;

import java.util.function.Consumer;

/**
 * 4个数字，3、4、7、8
 * 3个符号，×、÷、－
 * 要求各用一次（括号随意），结果 = 10
 */
public class Demo {

	public static void main(String[] args) throws Exception {
		String num = "3478";
		String opt = "*/-";
		Calc calc = new Calc();
		fun(num, str1 -> fun(opt, str2 -> {
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < 3; i++) {
				s.append(str1.charAt(i));
				s.append(str2.charAt(i));
			}
			s.append(str1.charAt(3));
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					s.insert(i, '(');
					for (int j = i + 1; j <= s.length(); j++) {
						if (s.charAt(j - 1) >= '0' && s.charAt(j - 1) <= '9') {
							s.insert(j, ')');
							try {
								double d = Double.valueOf(calc.calculator(s.toString()));
								if (d == 10d) {
								System.out.println(s);
								}
							} catch (Exception e) {
							}
							s.deleteCharAt(j);
						}
					}
					s.deleteCharAt(i);
				}
			}
		}));
	}

	public static void fun(String string, Consumer<String> consumer) {
		fun(string, "", consumer);
	}

	public static void fun(String str, String string, Consumer<String> consumer) {
		if (string.length() == str.length()) {
			consumer.accept(string);
			return;
		}
		for (int i = 0; i <= string.length(); i++) {
			fun(str, string.substring(0, i) + str.charAt(string.length()) + string.substring(i), consumer);
		}
	}
}
