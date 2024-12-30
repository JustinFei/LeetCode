/**
 * @param {Object} obj
 * @return {Function}
 */

Function.prototype.bindPolyfill = function(obj) {
    return this.bind(obj);
}

// --------------------------------


Function.prototype.bindPolyfill = function(obj) {
    return (...args) => this.call(obj, ...args);
}

// --------------------------------


Function.prototype.bindPolyfill = function(obj) {
  const self = this;  // Reference to the original function using closure

  return function(...args) {     // Return a new function
    return self.apply(obj, args);  // Invoke original function with obj context using apply
  }
}

// --------------------------------


Function.prototype.bindPolyfill = function(obj) {
  const self = this;  // Reference to the original function using closure

  return function(...args) {     // Return a new function
    return self.call(obj, ...args);  // Invoke original function with obj context using call
  }
}

// ---------------------------------------


Function.prototype.bindPolyfill = function(obj) {
  const sym = Symbol()  // Create a unique symbol
  obj[sym] = this       // Assign the function to the symbol property of obj

  return (...args) => {     // Return a new function
    return obj[sym](...args)  // Invoke the original function, which is now a method on the object
  }
}
