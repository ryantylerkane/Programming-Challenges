class Solution {
    public int maxSubArray(int[] nums) {
        
        int currentLargest = nums[0];
        int largestFromPos = nums[0];
        
        for(int i=1; i < nums.length; i++)
        {
            largestFromPos = Math.max(nums[i], largestFromPos + nums[i]);
            if(currentLargest<largestFromPos)
                currentLargest = largestFromPos;
        }
        
        return currentLargest;
    }
}