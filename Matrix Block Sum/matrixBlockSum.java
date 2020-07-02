class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        
        int n = mat[0].length; //Number of columns
        int m = mat.length; //Number of rows
        
        int total = 0;
        
        int answer[][] = new int[m][n];
        
        for(int i =0; i < m; i++)
        {
            for(int j=0; j < n; j++)
            {
                answer[i][j]=getSum(i,j, K, mat, n, m);
            }
        }
        
        return answer;
    }
    
    public int getSum(int row, int col, int k, int[][]mat, int n, int m)
    {
        int sum = 0;
        
        for(int i = Math.max(row-k, 0); i <= Math.min(row+k, m-1);i++)
        {
                      
            for( int j = Math.max(col-k, 0); j <= Math.min(col+k, n-1); j++ )
            {
               sum+=mat[i][j]; 
            }
            
        }
        
        return sum;
    }
}