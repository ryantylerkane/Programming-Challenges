class Solution {
    public int[] twoSum(int[] nums, int target) {
        int answer[] = new int[2];
        HashMap<Integer,Integer> operands = new HashMap<Integer,Integer>();
        
        int secondNum = 0;
        for(int i=0; i < nums.length;i++)
        {
            secondNum = target-nums[i];
            if(operands.containsKey(secondNum))
            {
                answer[0] = i;
                answer[1] = operands.get(secondNum);
                return answer;
            }
            
            operands.put(nums[i],i);
        }
        
        return answer;
    }
}