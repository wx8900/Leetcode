package mock.xcode.google;

/**
 *  09/30/2018 10:00 AM 第3期第3场 头姐
 *  given a array of int, not guarantee sorted. Please find all numbers which can be searched by binary search necessarily

 [2,1,4,2,|4] => [2 1] [4 2] [4]
 2  1|  4  2 | 4
 |
 <4, 2>
 1  2|  2  4 | 4 sorted
 |
 <2, 4>

 2 1 3 4 5 6
 5 => able to find

 2 1 3 4 6 5
 5 => unable

 [2 1 3 5 4 6] => 6, 3
 [1 2 3] =>
 [3 2 1] =>

 Number right > it
 And left < it

 2 1 3 4 5 6
 2, 2, 3,4,5,6
 113456

 思路： 发现格式为：当前值比左边所有值都大，当前值比右边所有值都小，所以要定义2个变量：左边最大值，右边最小值
       O(n)
 */
public class GuaranteedBinarySearchNumbers {
     // C++
    /*int guaranteed(int[] nums) {
        vector<int> left_max;
        vector<int> right_min;

        left_max.push_back(nums[0]);
        int tmp_left_max = nums[0];
        for(int i =0 ;i<nums.size(); i++) {
            left.push_back(tmp_left_max, nums[i]);
        }
        right_min.push_back(nums.back());
        int tmp_right_min = nums.back();
        for(int i =nums.size()-2 ;i>=0; i--) {
            left.push_back(tmp_right_min, nums[i]);
        }

        int ans =0;
        for(int i =0; i <nums.size(); i++) {
            if( i ==0) {
                if(right_min[0] >= nums[i]
                ans++;
            }else if(i ==nums.size()-1) {
                if(left_max.back() <= nums[i])
                    ans++;
            }else {
                if(right_min[i] >= nums[i] && left_max[i] <= nums[i] )
                    ans++;
            }
        }
        return ans;
    }*/
}
