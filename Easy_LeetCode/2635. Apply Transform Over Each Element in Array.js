/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var map = function(arr, fn) {
    const res = [];

    arr.forEach((elem, index) => {
        res.push(fn(elem, index));
    });

    return res;
};

// -----------------

var map = function(arr, fn) {
    return arr.map(fn);
};

// ------------------

var map = function(arr, fn) {
    const numbers = []
    for( let i = 0; i < arr.length; i++) {
        const result = fn(arr[i],i)
        numbers.push(result)
    }
    return numbers
};