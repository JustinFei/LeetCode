class Solution {
    public boolean canMeasureWater(int jug1, int jug2, int target) {
        if(jug1 + jug2 < target) return false;

        //cannot measure odd capacity using even capacity jugs 
        if(jug1 % 2 == 0 && jug2 % 2 == 0 && target % 2 != 0) return false;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        HashSet visited = new HashSet<>();
        int[] curr;
        int x, y;
        while(!q.isEmpty()){
            curr = q.poll();
            x = curr[0];
            y = curr[1];
            if(visited.contains(x+","+y)) continue;
            if(x + y == target) return true;
            visited.add(x+","+y);
            //expty x   ********************* option 1
            q.add(new int[]{0, y});

            //expty y   ********************* option 2
            q.add(new int[]{x, 0});

            //fill x    ********************* option 3
            q.add(new int[]{jug1, y});

            //fill y    ********************* option 4
            q.add(new int[]{x, jug2});
            
            //pour x->y ********************* option 5
            q.add(new int[]{x - Math.min(x, jug2 - y), y + Math.min(x, jug2 - y)});

            //pour y->x ********************* option 6
            q.add(new int[]{x + Math.min(y, jug1 - x), y - Math.min(y, jug1 - x)});
        }
        return false;
    }
}

// ----------------------------------------------------------------------------------

class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if(x + y < z) return false;
        //case x or y is zero
        if(x == z || y == z || x + y == z) return true;
        
        //get GCD, then we can use the property of Bézout's identity
        return z % GCD(x, y) == 0;
    }

    public int GCD(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
}

// -----------------------------------------
class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return z == 0 || (long)x + y >= z && z % gcd(x, y) == 0;
    }
    public int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}