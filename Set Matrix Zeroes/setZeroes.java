class Solution {
    public void setZeroes(int[][] matrix) {
        
       /* Use -1 as an indicator to represent which columns and rows need to be set to zero.
       The first row will be used to indicate which columns need to be set to zero.
       The first column will be used to indicate which rows must be set to zero.
       */
        Boolean column0 = markZeroes(matrix);
        updateMatrix(matrix, column0);
        
    }
    
    public Boolean markZeroes(int[][] matrix)
    {
        Boolean column0 = false;
        
        for(int i=0; i < matrix.length; i++)
        {
            for(int j=0; j < matrix[i].length; j++)
            {
                if(matrix[i][j] ==0) //Mark the columns and rows that need to be set to zero.
                {  
                    matrix[i][0] = 0;
                    if(j==0)
                        column0=true;
                    else
                        matrix[0][j]=0;
                } 
                
            }
        }
        
        return column0;
    }
    
    public void updateMatrix(int[][]matrix, Boolean column0)
    {
        //Update rows
        for(int i=1; i < matrix.length; i++) //Traverse first column to find all rows to be set to zero.
        {
            if(matrix[i][0] == 0)
            {
                for(int j=0; j < matrix[i].length;j++)
                {
                    matrix[i][j] = 0;
                }
            }
        }
        
        
        //Update columns
        for(int i=1; i < matrix[0].length;i++)//Traverse top row to find all columns to be set to zero.
        {
            if(matrix[0][i] == 0)
            {
                for(int j=0; j < matrix.length;j++)
                {
                        matrix[j][i] = 0;
                }
            }
        }
        
        if(matrix[0][0]==0) //Update first row after 1 to n have been updated.
            for(int j=0; j < matrix[0].length;j++)
                matrix[0][j] = 0;
        
         if(column0==true)//Check if the first column needs to be filled with zeroes.
            for(int k = 0; k < matrix.length;k++)
            {
                matrix[k][0] = 0;
            }
    }
}