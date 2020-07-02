class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        if(nums.length<=2)
            return false;
        
        //Else, array is at least three elements long. 
        int pattern[] = new int[2];
        pattern[0] = nums[0];
        int index=0;
        
        for(int i =1; i < nums.length;i++)
        {
           if(nums[i] > pattern[index])
           {
               System.out.println(i);
               if(index==1)
                   return true;
               else
                pattern[++index] = nums[i];
           }
            else if(nums[i] < pattern[index])
            {
                if(nums[i] <= pattern[0])
                {
                    pattern[0] = nums[i];
                }
                else
                {
                    pattern[1] = nums[i];
                }
            }
        }      
        
        return false;
    }
}