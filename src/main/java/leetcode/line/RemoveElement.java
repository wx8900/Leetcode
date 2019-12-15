package leetcode.line;

import java.util.LinkedList;
import java.util.List;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		List<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (val != nums[i]) {
				list.add(nums[i]);
			}
		}
		return list.size();
	}

	public static void main(String[] args) {
		int nums[] = { 3, 2, 2, 3 };
		RemoveElement re = new RemoveElement();
		System.out.println(re.removeElement(nums, 3));
	}

}
