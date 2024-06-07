public class Solution {
  public boolean checkRecord(String s) {
        if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL"))
            return false;
        return true;
    }
}
//---------------------------------------
public class Solution {
  public boolean checkRecord(String s) {
    return !s.matches(".*LLL.*|.*A.*A.*");
  }
}