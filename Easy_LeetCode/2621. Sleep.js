/**
 * @param {number} millis
 */
async function sleep(millis) {
    // await new Promise(resolve => setTimeout(resolve, millis));

    await new Promise((resolve, reject) => {
        setTimeout(() => resolve(), millis);
    })

}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */


// ---------------------------------------------------------

/**
 * @param {number} millis
 * @return {Promise}
 */
async function sleep(millis) {
    return new Promise((res, _rej) => setTimeout(res, millis));
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */