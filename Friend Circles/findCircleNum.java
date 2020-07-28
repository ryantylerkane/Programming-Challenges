class Solution {
    public int findCircleNum(int[][] M) {
        boolean visited[] = new boolean[M.length];
        Stack<Integer> transitive = new Stack<>();
        
        int numCircles =0;
        
        for(int j=0; j < M.length;j++)
        {
            if(!visited[j])
            { 
                transitive.push(j);
                findFriends(visited, M, transitive);
                numCircles++;
            }
        }
        
        return numCircles;
    }
    
    private void findFriends(boolean visited[], int[][] M, Stack<Integer> transitive)
    {
        
        int current;
        
        while(!transitive.isEmpty())
        {
            current = transitive.pop();
            visited[current] = true;
            for(int i=0; i < M[current].length;i++)
            {
                if(M[current][i] == 1 && !visited[i])
                {
                    transitive.push(i);
                }
            }
        }
    }
}