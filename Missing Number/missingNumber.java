class Solution {
    public int missingNumber(int[] nums) {
        
        int total=0;
        for(int i=0; i <= nums.length;i++)
            total+=i;
        
        for(int n: nums)
            total-=n;
        
        return total;
        
    }
}