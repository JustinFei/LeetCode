/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var compactObject = function(obj) {
    // These three if statements deal with when obj is not an iterable object
    // Steps 1-3 as described above
    if (obj === null) return null;
    if (Array.isArray(obj)) return obj.filter(Boolean).map(compactObject);
    if (typeof obj !== "object") return obj;

    // This for loop deals with when obj is an iterable object
    // Steps 4-5 as described above
    const compacted = {};
    for (const key in obj) {
        let value = compactObject(obj[key]);
        if (value) compacted[key] = value;
    }

    return compacted;
};

// ---------------------

const compactObj = Array.isArray(obj) ? [] : {};
    for(const key in obj) {
        let elem = obj[key];
        if(elem) {
            if(typeof elem === "object") elem = compactObject(elem);
            Array.isArray(obj) ? compactObj.push(elem) : compactObj[key] = elem;
        }
    }
    return compactObj;