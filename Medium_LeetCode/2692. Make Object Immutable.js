/**
 * @param {Object|Array} obj
 * @return {Object|Array} immutable obj
 */
var makeImmutable = function(obj) {
  // Define the methods that we want to block on our immutable object
  const methods = new Set(['pop', 'push', 'shift', 'unshift', 'splice', 'sort', 'reverse'])

  // Depth-first search function to traverse and handle different types of elements in the object
  function dfs(obj) {
    // If the object is null, we just return it directly
    if(obj === null) return null

    // Handle function types separately to block mutating methods
    if(typeof obj === 'function') {
      return new Proxy(obj, {
        apply(func, thisArg, argumentList) {
          // Block the execution of certain methods
          if(methods.has(func.name)) {
            throw `Error Calling Method: ${func.name}`
          }
          return func.apply(thisArg, argumentList)
        }
      })
    }

    // Handle array types
    if(Array.isArray(obj)) {
      return  new Proxy(obj, {
        set(_, prop) {
          // Block the modification of the array
          throw `Error Modifying Index: ${prop}`
        },
        get(obj, prop) {
          // Continue the depth-first search for each element in the array
          return dfs(obj[prop])
        },
        apply(func, thisArg, argumentList) {
          // Block the execution of certain methods
          if(methods.has(func.name)) {
            throw `Error Calling Method: ${func.name}`
          }
          return func.apply(thisArg, argumentList)
        }
      })
    }

    // If it's not an object, we don't need to do anything special with it, so we return it directly
    if(typeof obj !== 'object') return obj

    // Handle object types
    return new Proxy(obj, {
      set(_, prop) {
        // Block the modification of the object
        throw `Error Modifying: ${prop}`
      },
      get(obj, prop) {
        // Continue the depth-first search for each property of the object
        return dfs(obj[prop])
      }
    })
  }

  // Start the depth-first search on the initial object
  return dfs(obj)
};


/**
 * const obj = makeImmutable({x: 5});
 * obj.x = 6; // throws "Error Modifying x"
 */

 // ------------------------------------

 /**
 * @param {Object|Array} obj
 * @return {Object|Array} immutable obj
 */
var makeImmutable = function(obj) {
  // Define a set of methods that mutate the object or array.
  const methods = new Set(['pop', 'push', 'shift', 'unshift', 'splice', 'sort', 'reverse']);

  // Define the proxy handler object.
  const handler = {
    // 'set' trap throws an error when an attempt is made to modify a property.
    set : function(target, prop) {
      throw Array.isArray(target) ? `Error Modifying Index: ${prop}` : `Error Modifying: ${prop}`;
    },

    // 'get' trap creates a new proxy for nested objects or functions,
    // while returning primitive values and 'prototype' property as is.
    get : function(target, prop) {
      const condition =
        // 'prototype' property is returned as is to avoid potential issues with inheritance.
        prop === 'prototype' ||
        // If property is null, return as is.
        target[prop] === null ||
        // If property is not an object or function, return as is.
        typeof target[prop] !== 'object' &&
        typeof target[prop] !== 'function';

      // If the condition is true, return the property as is, else create a new Proxy.
      return condition ? target[prop] : new Proxy(target[prop], this);
    },

    // 'apply' trap throws an error when a mutating method is called.
    apply : function(target, thisArg, argumentsList) {
      if(methods.has(target.name))
        throw `Error Calling Method: ${target.name}`
      return target.apply(thisArg, argumentsList);
    }
  }

  // Return a new Proxy with the defined handler.
  return new Proxy(obj, handler);
};



/**
 * const obj = makeImmutable({x: 5});
 * obj.x = 6; // throws "Error Modifying x"
 */