/** 
 * @param {number} target
 * @return {number}
 */
Array.prototype.upperBound = function(target) {
    if (!this || this.length <= 0) return -1;
    let l = 0, m, r = this.length - 1;
    while (l <= r) {
        m =  l + ((r - l) >> 1); // Math.floor
        if (this[m] <= target) l = m + 1;
        else r = m - 1;
    }
    return --l >= 0 && this[l] === target ? l : -1;
};


// [3,4,5].upperBound(5); // 2
// [1,4,5].upperBound(2); // -1
// [3,4,6,6,6,6,7].upperBound(6) // 5

// --------------

/** 
 * @param {number} target
 * @return {number}
 */
Array.prototype.upperBound = function(target) {
    return this.lastIndexOf(target);
};

// -------------

Array.prototype.upperBound = function(target) {
    let res = -1
    this.forEach((val, id) => {
        if(val == target){
            res = id
        }
    })
    return res
};

// ----------------------------------------

/** 
 * @param {number} target
 * @return {number}
 */
Array.prototype.upperBound = function(target) {
  let result = -1;

  for (let i = 0; i < this.length; i++) {
    if (this[i] === target) {
      result = i;
    }
  }

  return result;
};


// [3,4,5].upperBound(5); // 2
// [1,4,5].upperBound(2); // -1
// [3,4,6,6,6,6,7].upperBound(6) // 5
