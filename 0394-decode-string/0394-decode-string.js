/**
 * @param {string} s
 * @return {string}
 */
var decodeString = function(s) {
    let stack = [];
    let result = "";
    let subResult = ""
    let num = 0;
    for ( let i=0; i<s.length; i++ ) {
        if (s[i] !== ']') {
            // Collect digits for the number multiplier
            if (!isNaN(s[i])) {
                num += s[i];
            } else {
                // If it's a letter or '[', push the accumulated number (if any) first
                if (num) {
                    stack.push(parseInt(num));
                    num = "";
                }
                stack.push(s[i]);
            }
        }
        else {
            subResult = ""
            while ( stack[stack.length-1] != '[' ) {
                subResult = stack.pop() + subResult;
            }
            stack.pop();

            // Get the repeat count
            let repeatCount = stack.pop();
            result = subResult.repeat(repeatCount);
            stack.push(result);
            result = ""

        }
    }
    while ( stack.length != 0 ) {
        result = stack.pop() + result;
    }
    return result;
};