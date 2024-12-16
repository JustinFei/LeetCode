/**
 * @param {any} object
 * @return {string}
 */
var jsonStringify = function(object) {
    if (object === null) return 'null';

    // return the string value surrounded by double quotes.
    if (typeof object === 'string') return `"${object}"`;

    if (typeof object === 'number' || typeof object === 'boolean') return String(object);

    // Recursively convert each item to a JSON string and join them with commas.
    // if (Array.isArray(object)) {
    //     // Recursively convert each item to a JSON string and join them with commas.
    //     const items = object.map(item => jsonStringify(item)).join(',');
    //     return '[' + items + ']';
    // }
    if (Array.isArray(object)) 
        return `[${object.map(item => jsonStringify(item)).join(',')}]`;
    
    // Recursively convert each value to a JSON string and pair it with the corresponding key.
    // if (typeof object === 'object') {
    //     const keys = Object.keys(object);
    //     const items = keys.map(key => '"' + key + '":' + jsonStringify(object[key]));
    //     return '{' + items.join(',') + '}';
    // }
    return `{${Object.keys(object).map(key => `"${key}":${jsonStringify(object[key])}`).join(',')}}`;
};