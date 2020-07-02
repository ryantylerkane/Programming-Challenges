class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        if(nums.length==0) //Check for case where any empty list is passed.
            return answer;
        
        answer.add(Arrays.stream(nums).boxed().collect( Collectors.toList()));
        answer = subPermutations(nums,answer);
        
        if(nums.length>1)
            drillDown(nums, answer);
        
        return answer;
    }
    
    
    private List<List<Integer>> drillDown(int[] nums, List<List<Integer>> answer)
    {
        int shiftedNums[] = new int[nums.length];
        shiftedNums = shiftRight(Arrays.copyOf(nums, nums.length),0);
        
        
            while(!Arrays.equals(nums,shiftedNums))
            {
                List<Integer> temp = Arrays.stream(shiftedNums).boxed().collect(Collectors.toList());
                answer.add(temp);
                answer = subPermutations(shiftedNums,answer);
                shiftedNums = shiftRight(shiftedNums,0);
            }
        
        return answer;
    }
    
 private List<List<Integer>> subPermutations(int[] shiftedNums,List<List<Integer>> answer)
 {
            int[] subPerm = Arrays.copyOf(shiftedNums,shiftedNums.length);
                for(int i=1; i <shiftedNums.length-1;i++)
                {
                    answer.add(Arrays.stream(shiftRight(subPerm,i)).boxed().collect( Collectors.toList()));
                }
     return answer;
 }
    private int[] shiftRight(int[] nums, int start) //Function moves the value at each index one spot to the right.
    {
        int last= nums[nums.length-1]; //Store the last element so it can be placed at index 0.
        int current=nums[start+1];
        int prev = nums[start];
        for(int i = start; i < nums.length-1;i++)
        {
            current = nums[i+1];
            nums[i+1] = prev;
            prev=current;
        }
        
        nums[start] = last; //Overwrite the first num with the last value.
        return nums;
    } 
}