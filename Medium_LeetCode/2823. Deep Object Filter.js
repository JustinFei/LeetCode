/**
 * @param {Object|Array} obj
 * @param {Function} fn
 * @return {Object|Array|undefined}
 */
var deepFilter = function(obj, fn) {
    if (Array.isArray(obj))  {
        const arr = obj.map(item => deepFilter(item, fn)).filter(item => item !== undefined);
        return arr.length > 0 ? arr : undefined;
    }

    if (typeof obj === 'object' && obj !== null) {
        const res = {};
        for (const key in obj) {
            const val = deepFilter(obj[key], fn);
            if (val !== undefined) {
                res[key] = val;
            }
        }
        
        return Object.keys(res).length === 0 ? undefined : res;
    }

    return fn(obj) ? obj : undefined;
};