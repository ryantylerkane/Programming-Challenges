/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
     
       return binSearch(1, n); 
        
    }
    
    private int binSearch(int beg, int end)
    {
        if(beg==end)
            return beg;
        
        int mid = beg+(end-beg)/2;
        if(isBadVersion(mid))
        {
           return 0 + binSearch(beg, mid);
        }
        else
        {
            return 0+ binSearch(mid+1, end);
        }
    }
}