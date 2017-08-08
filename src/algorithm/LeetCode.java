package algorithm;
import java.util.Arrays;
import java.util.HashMap;

public class LeetCode {
	/**
	 * O(N) time, hash table, dynamically add key-value pairs
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target){
		int[] result = null;
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length;++i){
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
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{1,3,6,8,9},12)));
		System.out.println(Arrays.toString(twoSum(new int[]{10,4,4,4,4},8)));
		System.out.println(Arrays.toString(twoSum(new int[]{10,3,6,8,9},19)));
		System.out.println(Arrays.toString(twoSum(new int[]{10,10,10,10,7},12)));
	}

}
