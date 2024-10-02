/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    return Promise.all([promise1, promise2]).then(value => value.reduce((acc, v) => acc + v, 0));
};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */

// --------------------------------

/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    // Wait for both promises to resolve and retrieve their values
    const [value1, value2] = await Promise.all([promise1, promise2]);

    // Return a new promise that resolves with the sum of the values
    return value1 + value2;

};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */

// -----------

/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    const result = await Promise.all([promise1,promise2])
    return result.reduce((acc,cur)=>acc+cur,0)
};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */

// ----------------------------------------

/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
    let p1 = await promise1;
    let p2 = await promise2;

    return p1+p2;
};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */

 // -----------------------------------------------

 /**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
 
var addTwoPromises = async function(promise1, promise2) {
    return new Promise ((res, rej) => {
        promise1.then((val1)=>{
            promise2.then((val2)=> res(val1 + val2))
        })
    })
};

// -------------------------------------------------------

/**
 * @param {Promise} promise1
 * @param {Promise} promise2
 * @return {Promise}
 */
var addTwoPromises = async function(promise1, promise2) {
     return await Promise.all([promise1, promise2]).then(
        ([val1, val2]) => val1 + val2
    );
};

/**
 * addTwoPromises(Promise.resolve(2), Promise.resolve(2))
 *   .then(console.log); // 4
 */