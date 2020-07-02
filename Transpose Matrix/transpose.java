class Solution {
    public int[][] transpose(int[][] A) {
        
        int ans[][] = new int[A[0].length][A.length]; //Invert the row and column values for the transposed matrix.
        
        for(int i=0; i < A.length; i++) //Traverse rows of A.
        {
            for(int j=0; j < A[0].length; j++) //Traverse column of A.
            {
                ans[i][j] = A[j][i];
            }
        }
        
        return ans;
    }
}