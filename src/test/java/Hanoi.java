public class Hanoi {
	public static void f(int n, char a, char b, char c) {
		if (n == 1) {
			System.out.printf("移动%c到%c\n", a, c);
		} else {
			f(n - 1, a, c, b);
			System.out.printf("移动%c到%c\n", a, c);
			f(n - 1, b, a, c);
		}
	}

	public static void main(String[] args) {
		f(64,'a','b','c');
	}
}
