class Solution {
    public boolean canReach(int[] arr, int start) {
        
        Queue<Integer> q = new LinkedList<Integer>();
        if(start < arr.length)
            q.add(start);
        
        int current;
        int forward;
        int backward;
        while(!q.isEmpty())
        {
            current = q.remove(); //View the next index to be tried.
            
            if(arr[current]==0)
                return true;
            
            forward = current+arr[current];
            backward = current - arr[current];
            
            if(forward < arr.length && arr[forward] != -1)
                q.add(forward);
            if(backward >= 0 && arr[backward] != -1)
                q.add(backward);
            
            arr[current] = -1;                
        }
        
        return false;
        
    }
}