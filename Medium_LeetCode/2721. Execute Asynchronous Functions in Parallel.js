/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = function(functions) {
      return new Promise((resolve, reject) => {
          if (functions.length === 0) {
              resolve([]);
              return;
          }
        // We know the resulting array will be the same length as functions
        const results = new Array(functions.length);
        let count = 0;
        functions.forEach(async (fn, i) => {
            // try {
            //     const res = await fn();
            //     results[i] = res;
            //     count++;
            //     if (count === functions.length) resolve(results);
            // } catch(err) {
            //     reject(err);
            // } 
            fn()
            .then(val => {
                results[i] = val;
                count++;
                if(count === functions.length) resolve(results);
            })
            .catch(err => reject(err));
        });
    });
};

/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */