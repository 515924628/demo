public class A {
	public static void main(String[] args) {
		int count = 2008, sum = 0;
		for (int n = 1; ; n++) {
			if (count >= 1 << n) {
				count -= 1 << n;
				sum += 1 << n;
			} else {
				sum += count;
				break;
			}
			if (count >= n) {
				count -= n;
				sum -= n;
			} else {
				sum -= count;
				break;
			}
		}
		System.out.println(sum + 2008);
	}
}
