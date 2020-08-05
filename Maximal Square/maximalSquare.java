class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int max=0;
        
        if(matrix.length <=0)
            return max;
        
        int memo[][] = new int[matrix.length+1][matrix[0].length+1];
        for(int i=1; i <= matrix.length;i++)
            for(int j=1; j <= matrix[0].length;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    int current=1;
                    current += Math.min(memo[i-1][j], Math.min(memo[i-1][j-1], memo[i][j-1]));
                    memo[i][j] = current;
                    max = Math.max(max, current);
                }
            }
        
        return max*max;
    }
}