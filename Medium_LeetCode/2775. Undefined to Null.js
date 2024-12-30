/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var undefinedToNull = function(obj) {
    if (typeof obj !== 'object') {
        return obj === undefined ? null : obj;
    }
    // if (Array.isArray(obj)) return obj.map(undefinedToNull);
    for (const key in obj) {
        obj[key] = undefinedToNull(obj[key]);
    }
    return obj;
};

/**
 * undefinedToNull({"a": undefined, "b": 3}) // {"a": null, "b": 3}
 * undefinedToNull([undefined, undefined]) // [null, null] 
 */