package leetcode.binarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
	

	public static void main(String[] args) {
		Integer[] nums = {56,2,40,37,18,29,98,10,0,90,39,105,280,454,1302,536,23,84,15,61};
		List<Integer> list = new ArrayList<Integer>();
		for (Integer in : nums) {
			list.add(in);
		}
		Collections.sort(list);
		System.out.println("=======sorted List======"+list);
		
		Integer[] sortedNums = list.toArray(nums);
		int result = getBinarySearch(sortedNums, 29);
		System.out.println("====return nums's index===="+result);
		

	}

	private static int getBinarySearch(Integer[] nums, int key) {
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = ((low+high) / 2);
			if(nums[mid] == key) {
				return mid;				
			}
			if (nums[mid] < key) {
				low = mid+1;
			} else {
				high = mid-1;
			}
		}
		return -1;
	}

}
