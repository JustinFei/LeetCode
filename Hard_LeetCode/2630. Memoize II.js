const RES = Symbol("result");
/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const globalCache = new Map();
    return function(...args) {
        let currentCache = globalCache;
        for (const a of args) {
            if (!currentCache.has(a)) {
                currentCache.set(a, new Map());
            }
            currentCache = currentCache.get(a);
        }
        if (currentCache.has(RES)) return currentCache.get(RES);

        const result = fn(...args);

        currentCache.set(RES, result);
        return result;
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