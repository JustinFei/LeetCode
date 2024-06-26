/**
 * @param {Function} fn
 */
function memoize(fn) {
    const cache = {};
    return function(...args) {
        const key = args.join(".").toString();
        if (cache[key] !== undefined) {
            return cache[key];
        }
        
        return cache[key] = Number(fn(...args));


        // const key = String(args);
        // if (key in cache) {
        //     return cache[key];
        // }
        // return cache[key] = fn(...args);
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */