public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) return list;
        for (int i = 1; i <= n; i++) {
            list.add(getString(i));
        }
        return list;
    }
    private String getString(int i) {
        if ((i % 3 == 0) && (i % 5 == 0)) {
            return "FizzBuzz";
        } else if (i % 3 == 0) {
            return "Fizz";
        } else if (i % 5 == 0) return "Buzz";
        else return  Integer.toString(i);
    }
}

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<String>(n);
        for(int i=1,fizz=0,buzz=0;i<=n ;i++){
            fizz++;
            buzz++;
            if(fizz==3 && buzz==5){
                ret.add("FizzBuzz");
                fizz=0;
                buzz=0;
            }else if(fizz==3){
                ret.add("Fizz");
                fizz=0;
            }else if(buzz==5){
                ret.add("Buzz");
                buzz=0;
            }else{
                ret.add(String.valueOf(i));
            }
        } 
        return ret;
    }
}