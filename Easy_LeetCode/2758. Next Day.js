/** 
 * @return {string}
 */
Date.prototype.nextDay = function() {
    const newDate = new Date(this);
    newDate.setDate(this.getDate() + 1);
    return `${newDate.getUTCFullYear()}-${String(newDate.getMonth() + 1).padStart(2, '0')}-${String(newDate.getUTCDate()).padStart(2, '0')}`;
}

/**
 * const date = new Date("2014-06-20");
 * date.nextDay(); // "2014-06-21"
 */

 // ------------------------------

 /** 
 * @return {string}
 */
Date.prototype.nextDay = function() {
    // this.setDate(this.getDate() + 1);
    // return this.toISOString().substring(0, 10);
    // 24 * 60 * 60 * 1000 = 86400000
    return new Date(this.getTime() + 86400000).toISOString().split('T')[0];
}

/**
 * const date = new Date("2014-06-20");
 * date.nextDay(); // "2014-06-21"
 */