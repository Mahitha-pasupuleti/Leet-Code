/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    let m = matrix.length;
    let n = matrix[0].length;
    let start = 0, end = m * n - 1, mid = 0;

    while ( start <= end ) {
        mid = Math.trunc( start + ( end - start ) / 2 )
        let mid_value = matrix[ Math.trunc(mid/n) ][ Math.trunc(mid%n) ]
        if ( mid_value == target ) return true
        else if ( mid_value < target ) start = mid + 1
        else end = mid - 1
    }

    return false
};