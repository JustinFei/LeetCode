/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
    const map = new Map();
    arr1.forEach(a => map.set(a.id, a));
    arr2.forEach(a => map.has(a.id) ? map.set(a.id, {...map.get(a.id), ...a}) : map.set(a.id, a));
    return Array.from(map.values()).sort((a, b) => a.id - b.id);
};

// ------------------------------------------------------------------

/**
 * @param {Array} arr1
 * @param {Array} arr2
 * @return {Array}
 */
var join = function(arr1, arr2) {
  const res = {};

    arr1.forEach((v) => res[v.id] = v);

    arr2.forEach((v) => {        
        if (v.id in res) { // (res[v.id])
            Object.assign(res[v.id], v);
        } else {
            res[v.id] = v;
        }
    })

    return Object.values(res);
};