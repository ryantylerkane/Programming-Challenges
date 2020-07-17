class Solution {
    public void rotate(int[][] matrix) {
     
        matrix=reverseCols(matrix);
        matrix=symmetry(matrix);
    }
    
    private int[][] reverseCols(int[][] matrix)
    {
        
        for(int i=0; i < matrix.length; i++)
        {
            int start = 0;
            int end = matrix.length-1;
            int temp = 0;
            while(start < end)
            {
                temp = matrix[start][i];
                matrix[start][i]=matrix[end][i];
                matrix[end][i] = temp;
                start++;
                end--;
            }
        }
        
        return matrix;
    }
    
    private int[][] symmetry(int[][] matrix)
    {
        int temp = 0;
        for(int i=0; i < matrix.length; i++)
            for(int j=i+1; j < matrix[i].length;j++)
            {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        
        return matrix;
    }
}