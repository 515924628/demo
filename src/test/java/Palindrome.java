public class Palindrome {
	public String fun1(String str) {
		String t = "";
		for (int i = 1; i < str.length() - 1; i++) {
			int j = i + 1, k = i - 1;
			while (k >= 0 && j < str.length() && str.charAt(k) == str.charAt(j)) {
				j++;
				k--;
			}
			if (j - k > t.length() + 2) {
				t = str.substring(k + 1, j);
			}
			if (str.charAt(i) == str.charAt(i + 1)) {
				j = i + 2;
				k = i - 1;
				while (k >= 0 && j < str.length() && str.charAt(k) == str.charAt(j)) {
					j++;
					k--;
				}
				if (j - k > t.length()) {
					t = str.substring(k + 1, j);
				}
			}
		}
		return t;
	}

	public static void main(String[] args) {
		System.out.println(new Palindrome().fun1("1234321"));
	}
}
