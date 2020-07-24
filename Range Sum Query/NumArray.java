class NumArray {

    HashMap<Pair<Integer, Integer>, Integer> table;
    int numbers[];
    public NumArray(int[] nums) {
        
        numbers = nums;
        table = new HashMap<>();
    }
    
    public int sumRange(int i, int j) {
        
        Pair current = new Pair(i,j);
        
        if(!table.containsKey(current))
        {
            int sum = 0;
            
            for(int start = i; start <= j; start++)
            {
                sum+=numbers[start];
            }
            table.put(current,sum);
        }
        
        return table.get(current);
        
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */