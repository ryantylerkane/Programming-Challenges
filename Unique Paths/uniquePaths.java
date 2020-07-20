class Solution {
    
    private int memo[][];
    public int uniquePaths(int m, int n) {
        memo=new int[m][n];
        return moveRobot(0,0,m,n);
    }
    
    public int moveRobot(int row, int col, int m, int n)
    {
        if(row>=m || col>=n)
            return 0;
        else if(row==m-1 && col==n-1)
            return 1;
        else
        {
            if(memo[row][col]==0)
            {
                memo[row][col]= moveRobot(row+1, col,m,n) + moveRobot(row,col+1,m,n);
            }
            
            return memo[row][col];
        }
        
    }
}