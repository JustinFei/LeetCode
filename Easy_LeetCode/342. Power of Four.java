public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 1) return true;
        if(num < 1 || num == 2 || num == 3) return false;
        if(num%4 > 0) return false;
        return isPowerOfFour(num/4);
    }
}

------------------------------------------------
public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num == 1) return true;
        if(num < 1 || num == 2 || num == 3) return false;
        if(num%4 > 0) return false;
        
        String binary = Integer.toBinaryString(num);
        char c[] = binary.toCharArray();
        int count = 0;
        for(int i =1;i<c.length;i++){
            if(c[i] != '0') return false;
            else count++;
        }
        
        if(count != 0 && count%2 == 0) return true;
        else return false;
    }
}
---------------------------------------------
 return num > 0 && (num & (num-1)) === 0 && (num & 0xAAAAAAAA) === 0;
 ---------------------------------
 public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num<0 || num==0) return false;
        if(num==1 || num==4) return true;
        String strNum=Integer.toBinaryString(num);
        if(strNum.length()<3 || (strNum.length()-1)%2!=0) return false;
        strNum=strNum.replace("00","");
        return strNum.equals("1");

    }
}
-----------------------------------
public class Solution {
    public boolean isPowerOfFour(int num) {
        String number = Integer.toBinaryString(num);
        if(number=="1")return true;
        return number.length()%2==1&&num==(1<<(number.length()-1));
    }
}