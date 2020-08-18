class Solution {
    
    public int orangesRotting(int[][] grid) { 
        Queue<int[]> rotted = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length;i++)
            for(int j=0; j < grid[i].length;j++)
                if(grid[i][j] ==2)
                    rotted.add(new int[]{i,j});
                else if(grid[i][j]==1)
                    fresh++;
        
        if(fresh==0)
            return 0;
        
        int search[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int minutes = 0;
        while(!rotted.isEmpty())
        {
            minutes++;
            int curr[];
            int size = rotted.size();
            for(int i=0; i<size;i++)
            {
                curr = rotted.remove();
                for(int j[] : search)
                {
                    int row = curr[0] + j[0];
                    int col = curr[1] + j[1];
                    if(row >=0 && row < grid.length && col >=0 && col < grid[0].length && grid[row][col]==1)
                    {
                        fresh--;
                        grid[row][col]=2;
                        rotted.add(new int[]{row,col});
                    }
                }
            }
            if(fresh==0)
                return minutes;   
        }
        
            return -1;
    }
}