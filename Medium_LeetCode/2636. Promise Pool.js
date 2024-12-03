/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Promise<any>}
 */
var promisePool = async function(functions, n) {
    return new Promise( (res, _rej) => {
        let count = 0;
        let i = 0;
        const helper = () => {
            if (i >= functions.length) {
                if (count === 0) res();
                return;
            }

            while (count < n && i < functions.length) {
                count++;
                functions[i++]().then(() => {
                    count--;
                    helper();
                })

            }
        }

        helper();
        // (() => {
            
        // })();
    })
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */

 // ---------------------------

 /**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Promise<any>}
 */
var promisePool = async function(functions, n) {
    let next = () => functions[n++]?.().then(next);
    return Promise.all(functions.slice(0, n).map(f => f().then(next)));
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */