/**
 * @param {Function} fn
 * @return {Function}
 */
var curry = function(fn) {
     return function curried(...args) {
        if (args.length < fn.length) { // The curry isn't ready yet!
            return (...newArgs) => curried(...args, ...newArgs);
        }
        
        return fn(...args); // The curry is ready! :D
    };
};

/**
 * function sum(a, b) { return a + b; }
 * const csum = curry(sum);
 * csum(1)(2) // 3
 */

// --------------------------

var curry = function (fn) {
  return function curried(...args) {
    if (args.length >= fn.length) {
      return fn.apply(this, args);
    }

    return curried.bind(this, ...args);
  };
};