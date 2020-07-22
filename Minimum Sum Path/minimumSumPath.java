class Solution {
    public int minPathSum(int[][] grid) {
        if(grid.length==0)
            return 0;
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        for(int i =1; i < cols; i++) //Take sum for each element in first row.
        {
            grid[0][i] += grid[0][i-1];
        }
        
        for(int j=1; j < rows;j++) //Take sum for each element in first column.
        {
            grid[j][0] +=grid[j-1][0];
        }
        
        for(int i=1; i < rows;i++)
            for(int j=1; j < cols; j++)
            {
                grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]); //Any given cell's path to the finish is its own value + its smallest left/upper neighbor.
            }
        
        return grid[rows-1][cols-1];
        
    }
}