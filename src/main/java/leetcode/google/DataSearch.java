package leetcode.google;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//4/5/2017
public class DataSearch {

	public static void main(String[] args) {
		Integer[] nums = {-3,89,2,56,31,0,80,129,23,6,75,38,205,1003};
		int target = 80;
		List<Integer> list = Arrays.asList(nums);
		Collections.sort(list);
		System.out.println("sorted list : "+ list);
		Integer[] sortedArray = (Integer[])list.toArray();
		Integer index = getIndex(sortedArray, target);
		System.out.println("index : "+index);
	}

	private static Integer getIndex(Integer[] nums, int target) {
		// check input parameters
		if (nums == null) return -1;
		if (nums != null && nums.length <= 0) return -1;
		
		// initial variables
		int low = 0;
		int high = nums.length -1;
		while (low <= high) {
			int mid = (low + high) >>> 1;
			if (target == nums[mid]) {
				return mid;
			} else if (target < nums[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		
		// return value process 
		return -1;
	}

}
