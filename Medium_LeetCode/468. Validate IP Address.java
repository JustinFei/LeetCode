class Solution {
    public String validIPAddress(String IP) {
     if(IP ==null ||IP.length()==0) return "Neither";
        
        if(IP.contains(".")) return checkIPV4(IP);
        else if(IP.contains(":")) return checkIPV6(IP);
        
        return "Neither";
    }
    
    public String checkIPV4(String IP){
        String N ="Neither";
        if(IP.charAt(0) == '.' || IP.charAt(IP.length()-1) == '.') return N;
        
        String [] segments = IP.split("\\.");
        
        if(segments.length !=4) return N;
        
        for(String segment: segments){
            if(segment.length() == 0 || segment.length()>3 ||(segment.charAt(0)=='0' && segment.length()>1)) return N;
            
            for(int i=0;i<segment.length();i++){
                if(segment.charAt(i)<'0' || segment.charAt(i)>'9') return N;
            }
            
            if(Integer.valueOf(segment)>255) return N;
            
        }
        return "IPv4";
    }
    
    public String checkIPV6(String IP){
        String N = "Neither";
        
        if(IP.charAt(IP.length()-1) == ':') return N;
        
        String [] segments = IP.split(":");
        
        if(segments.length!=8) return N;
        
        for(String segment: segments){
            
            if(segment.length() ==0 ||segment.length() >4) return N;
            
            for(int i=0;i<segment.length();i++){
                char c = segment.charAt(i);
                
                if(!(c>='0' && c <='9') && !(c>='a' && c <='f') && !(c>='A' && c <='F') ) return N;
                
            }
        }
        
        return "IPv6";
    }
}