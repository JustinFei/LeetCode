/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var throttle = function(fn, t) {
    let intervalInProgress = null;
    let argsToProcess = null;

    const intervalFunc = () => {
        if (argsToProcess === null) {
            clearInterval(intervalInProgress);
            intervalInProgress = null;
        } else {
            fn(...argsToProcess);
            argsToProcess = null;
        }
    }
    return function(...args) {
        if (intervalInProgress) {
            argsToProcess = args;
        } else {
            fn(...args); // enter the looping phase
            intervalInProgress = setInterval(intervalFunc, t);
        }
    }
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */

// -----------------------------------------------------

/**
 * @param {Function} fn
 * @param {number} t
 * @return {Function}
 */
var throttle = function(fn, t) {
    let timeout = null;
    let nextTimeToCallFn = 0;
    return function(...args) {
        const delay = Math.max(0, nextTimeToCallFn - Date.now());
        clearTimeout(timeout);
        timeout = setTimeout(() => { 
        fn(...args);
        nextTimeToCallFn = Date.now() + t;
        }, delay);
    }
};

/**
 * const throttled = throttle(console.log, 100);
 * throttled("log"); // logged immediately.
 * throttled("log"); // logged at t=100ms.
 */