class Solution {
    
  class CompareLog implements Comparator<String>
  {
      @Override
      public int compare(String l1, String l2)
      {
          //Store identifer in l1[0] and l2[0] and the rest of the log in l1[1] and l2[1].
          String[] l1Parts = l1.split(" ",2);
          String[] l2Parts = l2.split(" ",2);
          
          boolean isLetter1 = Character.isLetter(l1Parts[1].charAt(0));
          boolean isLetter2 = Character.isLetter(l2Parts[1].charAt(0));
          
          if(isLetter1 && isLetter2)
          {
              int ret = l1Parts[1].compareTo(l2Parts[1]);
              
              //If the two strings contain the same log content, assess their identifier.
              ret = (ret==0) ? l1Parts[0].compareTo(l2Parts[0]): ret;
              return ret;
          }
          else if(!isLetter1 && isLetter2)
          {
              return 1;
          }
          else if(isLetter1 && !isLetter2)
              return -1;
          else
          {
              return 0;
          }
          
      }
  }
    public String[] reorderLogFiles(String[] logs) {
        
        Arrays.sort(logs, new CompareLog());
        return logs;
    }
}