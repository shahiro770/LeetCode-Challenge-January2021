/*
 * Counter
 *
 * Top 97% (45ms)
 * 
 * There's javascript only questions too!
 * 
 * Time Complexity: O(1)
 */

/**
 * @param {number} n
 * @return {Function} counter
 */
var createCounter = function(n) {
    let x = n - 1;
    return function() {
        x += 1;
        return x;
    };
};

/** 
 * const counter = createCounter(10)
 * counter() // 10
 * counter() // 11
 * counter() // 12
 */