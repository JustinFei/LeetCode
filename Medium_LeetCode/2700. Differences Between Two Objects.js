/**
 * @param {Object|Array} obj1
 * @param {Object|Array} obj2
 * @return {Object|Array}
 */
function objDiff(obj1, obj2) {
    if (obj1 === obj2) return {};
    if (obj1 === null || obj2 === null) return [obj1, obj2];
    if (typeof obj1 !== 'object' || typeof obj2 !== 'object') return [obj1, obj2];
    if (Array.isArray(obj1) !== Array.isArray(obj2)) return [obj1, obj2];

    const res = {};
    for (const key in obj1) {
        if (key in obj2) {
            const subDiff = objDiff(obj1[key], obj2[key]);
            if (Object.keys(subDiff).length > 0) {
                res[key] = subDiff;
            }
        }
    }

    return res;
}; 