/**
 * @param {Array<Function>} functions
 * @param {number} ms
 * @return {Array<Function>}
 */
var delayAll = (functions, ms) => {
    return functions.map((func, i) => {
        return () => new Promise((res, rej) => {
            setTimeout(() => {
                (async() => {
                    try {
                        const result = await func();
                        res(result);
                    } catch (err) {
                        rej(err);
                    }
                })();
            }, ms);
        });
    });
};

// ---------------------------------

/**
 * @param {Array<Function>} functions
 * @param {number} ms
 * @return {Array<Function>}
 */
var delayAll = (functions, ms) => {
    return functions.map((func, i) => {
        return () => new Promise((res, rej) => {
            setTimeout(() => {
                (async() => {
                    func().then(res).catch(rej);
                    // func().then(res => {
                    //     resolve(res);
                    //     })
                    //     .catch(err => {
                    //     reject(err);
                    //     });
                })();
            }, ms);
        });
    });
};



// ------------------------------

function delayAll(functions, ms) {
  return functions.map((fn) => () => sleep(ms).then(fn));
}