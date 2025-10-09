package DSA;

public class NumberOfConsectiveOnes {
    public static void main(String args[])
    {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int res = maxConsectiveOnes(nums, 2);
        System.out.println(res);
    }

    private static int maxConsectiveOnes(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeros = 0;
        while(r < nums.length)
        {
            if (nums[r] == 0) zeros++;
            while(zeros > k)
            {
                if (nums[l] == 0)
                {
                    zeros--;
                }
                l++;
            }
            if (zeros <= k) {
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
                r++;
            }
        }
        return maxLen;
    }

}
