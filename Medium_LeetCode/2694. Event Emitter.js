class EventEmitter {
  #map = new Map();
    
  /**
    * @param {string} eventName
    * @param {Function} callback
    * @return {Object}
    */
  subscribe(eventName, callback) {
    const callbacks = this.#map.get(eventName) ?? [];
    callbacks.push(callback);

    if (callbacks.length === 1) {
      this.#map.set(eventName, callbacks);
    }
      
    return {
      unsubscribe: () => {
        callbacks.splice(callbacks.indexOf(callback), 1);
        if (callbacks.length === 0) {
          this.#map.delete(callbacks);
        }
      }
    };
  }
  
  /**
    * @param {string} eventName
    * @param {Array} args
    * @return {Array}
    */
  emit(eventName, args = []) {
    const results = [];

    for (const callback of this.#map.get(eventName) ?? []) {
      results.push(callback(...args));
    }

    return results;
  }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */

 // --------------------------------------------------

class EventEmitter {
    constructor() {
        this.events = new Map();
    }
    
    /**
     * @param {string} eventName
     * @param {Function} callback
     * @return {Object}
     */
    subscribe(eventName, callback) {
        if (!this.events.has(eventName)) this.events.set(eventName, []);

        const listeners = this.events.get(eventName);
        listeners.push(callback);
        
        return {
            unsubscribe: () => {
                const index = listeners.indexOf(callback);
                if (index !== -1) {
                    listeners.splice(index, 1);
                }
            }
        };
    }
    
    /**
     * @param {string} eventName
     * @param {Array} args
     * @return {Array}
     */
    emit(eventName, args = []) {
        if (!this.events.has(eventName)) return [];

        const listeners = this.events.get(eventName);
        const result = [];

        for (const listener of listeners) {
            result.push(listener(...args));
        }

        return result;
    }
}

/**
 * const emitter = new EventEmitter();
 *
 * // Subscribe to the onClick event with onClickCallback
 * function onClickCallback() { return 99 }
 * const sub = emitter.subscribe('onClick', onClickCallback);
 *
 * emitter.emit('onClick'); // [99]
 * sub.unsubscribe(); // undefined
 * emitter.emit('onClick'); // []
 */