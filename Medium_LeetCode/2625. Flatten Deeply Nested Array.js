/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    if (n <= 0) return arr; //  || arr.every(x => typeof x === 'number')

    const ans = []; 
    for (var x of arr) {
        if (Array.isArray(x) && n > 0) ans.push(...flat(x, n-1)); 
        else ans.push(x); 
    }
    return ans; 
};

// -------------------------------------------

/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    const ans=[];
    function recur(arr, depth){
        for(const val of arr){
            if(Array.isArray(val) && depth<n){
                recur(val,depth+1);
            }else{
                ans.push(val);
            }
        }
        return ans; 
    }
    return recur(arr,0);
};