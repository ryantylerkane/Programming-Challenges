class Solution {
    public int numIslands(char[][] grid) {
        
        int ans=0;
        
        for(int i =0; i < grid.length;i++)
        {
            for(int j=0; j < grid[i].length;j++)
            {
                if(grid[i][j] == '1')
                {
                    destroyIsland(grid, i,j); //Locate and remove all adjacent lands that comprise island.
                    ans++;
                }
                  
            }
        }
        
        return ans;
    }
    
    public void destroyIsland(char[][] grid, int rows, int cols)
    {
        if(rows >=0 && rows < grid.length && cols >=0 && cols < grid[0].length && grid[rows][cols]=='1')
        {
            grid[rows][cols] = '0'; //Remove the land and check all adjacent lands and destroy those as well.
            destroyIsland(grid, rows+1, cols); //Check for 1 directly on the right.
            destroyIsland(grid, rows-1, cols); //Check for 1 directly on the left.
            destroyIsland(grid, rows, cols+1); //Check for 1 directly above.
            destroyIsland(grid, rows, cols-1); //Check for 1 directly underneath.
        }
    }
}