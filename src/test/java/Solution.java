public class Solution {
	public int hammingWeight(int n) {
		String num = Integer.toString(n, 2);
		return num.length() - num.replaceAll("1","").length();
	}

	public static void main(String[] args) {
		System.out.println(new Solution().hammingWeight(233));
	}
}
