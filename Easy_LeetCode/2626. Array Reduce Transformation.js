/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let answer = init;
    for (let i = 0; i < nums.length; i++) {
        answer = fn(answer, nums[i])
    }
    return answer
};

// -------------------------------

/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    return nums.reduce((acc, ele) => fn(acc, ele), init);
};

// -------------------------------

/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    let acc = init;
    nums.forEach(num => acc = fn(acc, num));
    return acc;
};