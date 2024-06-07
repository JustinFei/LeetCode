public class Solution {
    public int compareVersion(String version1, String version2) {
         String[]v1=version1.split("\\."),v2=version2.split("\\.");
        int i;
        for( i =0;i<v1.length&&i<v2.length;i++)
        if(Integer.parseInt(v1[i])!=Integer.parseInt(v2[i]))return Integer.parseInt(v1[i])>Integer.parseInt(v2[i])?1:-1;
        for(;i<v1.length;i++)if(Integer.parseInt(v1[i])!=0)return 1;
        for(;i<v2.length;i++)if(Integer.parseInt(v2[i])!=0)return -1;
        return 0;
    }
}
--------------------------------------
public class Solution {
    public int compareVersion(String version1, String version2) {
      String [] version1Arrs = version1.split("\\.");
  String [] version2Arrs = version2.split("\\.");

  int l1 = version1Arrs.length;
  int l2 = version2Arrs.length;

  for(int i = 0; i < (l1<=l2?l2:l1); i++) {

    int val1 = i < l1?Integer.parseInt(version1Arrs[i]):0;
    int val2 = i < l2?Integer.parseInt(version2Arrs[i]):0;

    if(val1 > val2) return 1;
    else if(val1 < val2) return -1;

  }
  return 0;
    }
}