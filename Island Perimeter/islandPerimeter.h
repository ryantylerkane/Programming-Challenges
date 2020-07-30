class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int answer = 0;
        for(int i=0; i < grid.size(); i++)
            for(int j=0; j < grid[i].size();j++)
                if(grid[i][j]==1)
                {
                    answer= countBorders(grid, i,j);
                    break;
                }
        return answer;
    }

private:
    int countBorders(vector<vector<int>>& grid, int row, int col)
    {
        if(row <0 || row >= grid.size() || col <0 || col >= grid[row].size() || grid[row][col]==0)
            return 1;
        if(grid[row][col]==2) //Already encountered this piece of the island.
            return 0;
        
        grid[row][col]=2;
        int borders=0;
        
        borders+=countBorders(grid, row+1, col);
        borders+=countBorders(grid, row-1, col);
        borders+=countBorders(grid, row,col+1);
        borders+=countBorders(grid, row, col-1);
        
        
        return borders;
    }
};