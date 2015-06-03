import java.util.Scanner;
public class Huiwen {
	public static void main(String[] args) {
		String str = new Scanner(System.in).nextLine();
		for (int i = str.length(); i >= 0; i--) {
			String s = str.substring(0, i);
			if (s.equals(new StringBuilder(s).reverse().toString())) {
				String s1 = new StringBuilder(str.substring(i)).reverse().toString();
				System.out.println(s1 + str);
				break;
			}
		}
	}
}