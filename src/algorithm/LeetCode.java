package algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode {
	/**
	 * O(N) time, hash table, dynamically add key-value pairs, submitted
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		int[] result = null;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (map.containsKey(target - nums[i])) {
				result = new int[2];
				result[0] = map.get(target - nums[i]);
				result[1] = i;
				break;
			}
			map.put(nums[i], i);
		}
		return result;
	}

	public static final long inv_divisor = 0x1999999A;
	public static final int max = (int) (Integer.MAX_VALUE * inv_divisor >> 32);

	/**
	 * modulus; bitwise shift is faster than division
	 * 
	 * @param x
	 * @return
	 */
	public static int reverseInteger(int x) {
		int result = 0;
		int tmp_x = Math.abs(x);
		for (; tmp_x != 0; tmp_x = (int) (tmp_x * inv_divisor >>> 32)) {
			// for (; tmp_x != 0;tmp_x /=10) {
			if (result > max)
				return 0;
			result = result * 10 + tmp_x % 10;
		}
		return x < 0 ? -result : result;
	}

	/**
	 * best solution
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0))
			return false;
		int rev = 0;
		while (x > rev) {
			rev = rev * 10 + x % 10;
			x /= 10;
		}
		return (x == rev || x == rev / 10);
	}

	/**
	 * trick
	 * 
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome_2(int x) {
		if (x < 0)
			return false;
		long x_1 = x;
		long x_2 = 0;
		while (x != 0) {
			x_2 = x_2 * 10 + x % 10;
			x /= 10;
		}
		return x_2 == x_1;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		public String toString() {
			if (next == null)
				return "" + val;
			else
				return next.toString() + "_" + val;
		}
	}

	/**
	 * traversal linked lists
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode res = new ListNode(0);
		ListNode tmp = res;
		int n = l1.val + l2.val;
		tmp.val = n % 10;
		tmp.next = new ListNode(n / 10);
		while (l1.next != null && l2.next != null) {
			tmp = tmp.next;
			l1 = l1.next;
			l2 = l2.next;
			n = tmp.val + l1.val + l2.val;
			tmp.next = new ListNode(n / 10);
			tmp.val = n % 10;
		}
		while (l1.next != null) {
			l1 = l1.next;
			tmp = tmp.next;
			n = tmp.val + l1.val;
			tmp.next = new ListNode(n / 10);
			tmp.val = n % 10;
		}
		while (l2.next != null) {
			l2 = l2.next;
			tmp = tmp.next;
			n = tmp.val + l2.val;
			tmp.next = new ListNode(n / 10);
			tmp.val = n % 10;
		}
		if (tmp.next.val == 0)
			tmp.next = null;
		return res;
	}

	/**
	 * TODO hard
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		// int l = nums1.length + nums2.length;
		// if (l == 0)
		// return 0.0;
		// boolean even = (l & 1) == 0;
		// int i, p1, p2, tmp = 0;
		// for (i = 0, p1 = 0, p2 = 0; i < (l >>> 1); ++i) {
		// if (nums1[p1] < nums2[p2]) {
		// tmp = nums1[p1];
		// ++p1;
		//
		// } else {
		// tmp = nums2[p2];
		// ++p2;
		// }
		// }
		// if (even) {
		// if (nums1[p1] < nums2[p2]) {
		// tmp += nums1[p1];
		// } else {
		// tmp += nums2[p2];
		// }
		// }
		return 0.0;
	}

	public static void main(String[] args) {
		System.out.println("Two sum:");
		System.out.println(Arrays.toString(twoSum(new int[] { 1, 3, 6, 8, 9 }, 12)));
		System.out.println(Arrays.toString(twoSum(new int[] { 10, 4, 4, 4, 4 }, 8)));
		System.out.println(Arrays.toString(twoSum(new int[] { 10, 3, 6, 8, 9 }, 19)));
		System.out.println(Arrays.toString(twoSum(new int[] { 10, 10, 10, 10, 7 }, 12)));
		System.out.println("Reverse integer");
		System.out.println(reverseInteger(65493813));
		System.out.println(reverseInteger(100000009));
		System.out.println(reverseInteger(-123456789));
		System.out.println("Is palindrome:");
		System.out.println(isPalindrome_2(123321));
		System.out.println(isPalindrome_2(12321));
		System.out.println(isPalindrome_2(123322));
		System.out.println("Add two numbers:");
		ListNode l1 = new ListNode(8);
		ListNode l2 = new ListNode(6);
		l1.next = new ListNode(6);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(8);
		System.out.println(l1 + " + " + l2 + " = " + addTwoNumbers(l1, l2));
	}

}
