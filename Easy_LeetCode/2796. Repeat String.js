/**
 * @param {number} times
 * @return {string}
 */
String.prototype.replicate = function(times) {
    if (times === 0) {
        return "";
    }
    //Here "this" refers to the string object on which the method is called
    return this + this.replicate(times - 1);
}

// --------------------------

String.prototype.replicate = function(times) {
    let result = "";
    for (let i = 0; i < times; i++) {
        result += this;
    }
    return result;
};

// -------------

String.prototype.replicate = function(times) {
    const result = [];
    for (let i = 0; i < times; i++) {
        result.push(this);
    }

    return result.join('');
};