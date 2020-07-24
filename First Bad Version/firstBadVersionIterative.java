/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int beg = 1;
        int end = n;
        int mid;
        
        while(beg<end)
        {
            
            mid = beg + (end-beg)/2;
            
            if(isBadVersion(mid))
            {
                end = mid;
            }
            else
            {
                beg = mid+1;
            }
        }
        
        return beg;
     
    }
}