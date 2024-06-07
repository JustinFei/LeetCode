class Solution {
    public String reformatDate(String date) {
        String[] arr=date.split(" ");
        String ans="";
        ans+=arr[2];
        ans+="-";
        ans+=month(arr[1]);
        ans+="-";
        ans+=date(arr[0]);
        return ans;
        
    }
    public String month(String m){
	//here m=="jan" etc will not work as it will compare the address of 2 string whereas .equals compares the content of the strings...
        if(m.equals("Jan"))
            return "01";
        else if(m.equals("Feb"))
            return "02";
         else if(m.equals("Mar"))
            return "03";
         else if(m.equals("Apr"))
            return "04";
         else if(m.equals("May"))
            return "05";
         else if(m.equals("Jun"))
            return "06";
         else if(m.equals("Jul"))
            return "07";
         else if(m.equals("Aug"))
            return "08";
         else if(m.equals("Sep"))
            return "09";
         else if(m.equals("Oct"))
            return "10";
         else if(m.equals("Nov"))
            return "11";
         else 
            return "12";
    }
    public String date(String d)
    {
        if(d.length()==3)    //if date is between 1-9 its length will be 3 in the given format
            return "0"+d.charAt(0);
        else
            return d.substring(0,2);
    }
}