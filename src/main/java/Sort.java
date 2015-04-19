import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		int[] i = new int[]{3,1,2};
		sort1(i, 0, i.length);
		System.out.println(Arrays.toString(i));
	}

	public static void sort1(int[] arr, int left, int right) {
		if (left == right) return;
		int i = left, j = right - 1, k = arr[left];
		while (i < j) {
			while (k <= arr[j] && i < j)
				j--;
			arr[i] = arr[j];
			while (k >= arr[i] && i < j)
				i++;
			arr[j] = arr[i];
		}
		arr[i] = k;
		sort1(arr, left, i);
		sort1(arr, i + 1, right);
	}
}
