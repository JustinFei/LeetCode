/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    return arr.filter((a, i) => fn(a, i));
};

// --------------------------------

/**
 * @param {number[]} arr
 * @param {Function} fn
 * @return {number[]}
 */
var filter = function(arr, fn) {
    const res = [];
    arr.forEach((ele, i) => {
        if (fn(ele, i)) res.push(ele);
    });

    return res;
};