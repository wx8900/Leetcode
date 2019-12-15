package oaphone.microsoft;

/**
 * Demo class
 *
 * @author Jeff
 * @date 03/10/2019
 */
public class FrogJumpII {

    public static void main(String[] args) {
        FrogJumpII frogJumpII = new FrogJumpII();
        int[] ints = new int[]{2,3,1,1,4};
        System.out.println(frogJumpII.canJump(ints));
    }

    public boolean canJump(int[] nums) {
        int maxIndex=0;
        for(int i = 0; i < nums.length; ++i)
        {
            if(i <= maxIndex)
            {
                maxIndex = Math.max(maxIndex,i+nums[i]);
            }
        }
        return maxIndex >= nums.length-1;
    }
}
