class Solution {
    public int minFallingPathSum(int[][] A) {
        //Bottom-Up approach, starting from last element, calculate all possiblities and store the minimum in their array index.
        int left, right, same, current;
        for(int i=A.length-2; i >=0;i--)
        {
            for(int j=0; j < A[i].length;j++)
            {
                left = 0;
                right = 0;
                current = A[i+1][j]; //Same column as A[i][j]
                if(j >0)
                {
                    left = A[i+1][j-1];
                    current = Math.min(left, current);
                }
                if(j+1 < A[i].length)
                {
                    right = A[i+1][j+1];
                    current= Math.min(current, right);
                }
                
               A[i][j] +=current;
            }
        }
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i < A[0].length;i++)
        {
            min = Math.min(min, A[0][i]);
        }
        
        return min;
        
        
    }
}