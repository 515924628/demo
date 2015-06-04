import java.util.Arrays;

public class HasSameNum {
	public static void main(String[] args) {
		int[] ints = new int[]{1, 2, 3, 4, 5, 6, 3, 1};
		Arrays.sort(ints);
		boolean flag = false;
		for (int i = 0; i < ints.length; i++) {
			if (ints[i] == ints[i + 1]) {
				flag = true;
				break;
			}
		}
		System.out.println(flag);
	}
}
