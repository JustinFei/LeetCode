/**
 * @param {Function} fn
 * @param {number} delay
 * @param {number} period
 * @return {number} id
 */

let intervalIdCounter = 0;
const intervalMap = new Map(); // To store timer IDs

function customInterval(fn, delay, period){
    let count = 0;
    const customId = intervalIdCounter++; // Generate a unique ID
    function dfs() {
        const timerId = setTimeout(() => {
        fn();
        dfs();
        }, delay + period * count);
        count++;
        intervalMap.set(customId, timerId); // Store timer ID
    }

    dfs();

    return customId;
}

/**
 * @param {number} id
 * @return {void}
 */
function customClearInterval(id) {
    // Retrieve the timer ID associated with the custom ID
    const timerId = intervalMap.get(id);
    clearTimeout(timerId);
    intervalMap.delete(id);
}

// --------------------------------

const CustomInterval = (() => {
   let intervalIdCounter = 0;
   const intervalMap = new Map();

   function setCustomInterval(fn, delay, period) {
      let count = 0;
      const customId = intervalIdCounter++;

      function dfs() {
         const timerId = setTimeout(() => {
            fn();
            dfs();
         }, delay + period * count);
         count++;
         intervalMap.set(customId, timerId);
      }

      dfs();

      return customId;
   }

   function clearCustomInterval(id) {
      const timerId = intervalMap.get(id);
      clearTimeout(timerId);
      intervalMap.delete(id);
   }

   return {
      setCustomInterval,
      clearCustomInterval
   };
})();

function customInterval(fn, delay, period) {
   return CustomInterval.setCustomInterval(fn, delay, period);
}

function customClearInterval(id) {
   CustomInterval.clearCustomInterval(id);
}
