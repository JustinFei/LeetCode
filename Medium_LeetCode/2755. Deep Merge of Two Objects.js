/**
 * @param {null|boolean|number|string|Array|Object} obj1
 * @param {null|boolean|number|string|Array|Object} obj2
 * @return {null|boolean|number|string|Array|Object}
 */
var deepMerge = function(obj1, obj2) {
    // If either input is not an object or their types differ (array vs. object), return obj2
    if (typeof obj1 !== 'object' || typeof obj2 !== 'object' || Array.isArray(obj1) !== Array.isArray(obj2)) {
        return obj2;
    }

    // If either input is null, return obj2
    if (obj1 === null || obj2 === null) {
        return obj2;
    }

    // Use the first object as the base for merging
    const res = JSON.parse(JSON.stringify(obj1));;

    for (const key in obj2) {
        if (key in res) {
            // If the property exists in both, recursively merge them
            res[key] = deepMerge(res[key], obj2[key]);
            continue;
        }

        // Otherwise, simply assign the value from obj2
        res[key] = obj2[key];
    }

    return res;
};

/**
 * let obj1 = {"a": 1, "c": 3}, obj2 = {"a": 2, "b": 2};
 * deepMerge(obj1, obj2); // {"a": 2, "c": 3, "b": 2}
 */
