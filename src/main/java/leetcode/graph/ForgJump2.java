package leetcode.graph;

class ForgJump2 {

    public static void main(String[] args) {
        ForgJump2 fg = new ForgJump2();
        int[] a = new int[]{0, 1, 3, 5, 6, 8, 12, 17};
        long startTime1 =System.currentTimeMillis();
        System.out.println(fg.canCross(a));
        long endTime1 =System.currentTimeMillis();
        System.out.println("运行时间："+(endTime1-startTime1)+" ms !");
    }

    public boolean canCross(int[] stones) {
        boolean[] jumped = new boolean[stones.length];
        for(int i = 3; i < jumped.length; i++) {
            if (stones[i] > stones[i-1] * 2)
                return false;

            jumped[i] = false;
        }

        return cross(stones, jumped, stones[0], 0);
    }

    private boolean cross(int[] stones, boolean[] jumped, int stone, int jump) {

        if(stone == stones[stones.length - 1]) return true;

        int pos = findPos(stones, stone);

        if (pos == -1) return false;

        jumped[pos] = true;
        for (int i = 1; i >= -1; i--) {
            int next = findPos(stones, stone + jump + i);
            if (next != -1) {
                if (!jumped[next]) {
                    if (cross(stones, jumped, stone + jump + i, jump + i)) {
                        return true;
                    }

                    jumped[next] = false;

                }
            }
        }

        return false;
    }

    private int findPos(int[] stones, int target) {
        int low = 0;
        int high = stones.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (stones[mid] == target)
                return mid;

            if (target < stones[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }

        return -1;
    }
}
