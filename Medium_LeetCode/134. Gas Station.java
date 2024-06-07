class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int cur = 0;
        int fuelLeftAfterComplete = 0;
        
        int start = 0;
        
        for(int i = 0; i < gas.length; i++){
            cur += gas[i] - cost[i];
            fuelLeftAfterComplete += gas[i] - cost[i];
            
            if(cur < 0){
                //Its time to find next start station. 
                cur = 0;
                start = i+1;
            }
        }
        return fuelLeftAfterComplete < 0 ? -1 : start;
    }
}