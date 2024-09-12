/**
 * // This is the MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * function MountainArray() {
 *     @param {number} index
 *     @return {number}
 *     this.get = function(index) {
 *         ...
 *     };
 *
 *     @return {number}
 *     this.length = function() {
 *         ...
 *     };
 * };
 */

/**
 * @param {number} target
 * @param {MountainArray} mountainArr
 * @return {number}
 */
var findInMountainArray = function(target, mountainArr) {
    
    let len = mountainArr.length();
    let peek = 0;

    if ( mountainArr.get(0) > mountainArr.get(1) ) peek = 0
    if ( mountainArr.get(len-1) < mountainArr.get(len-2) ) peek = mountainArr.get(len-1)

    let start = 1, end = len-2, mid = 0
    while ( start <= end ) {
        mid = Math.trunc(start + (end - start)/2);
        if ( mountainArr.get(mid-1) < mountainArr.get(mid) && mountainArr.get(mid) > mountainArr.get(mid+1) ) {
            peek = mid;
            if ( mountainArr.get(peek) == target ) return mid
            if ( mountainArr.get(peek) < target ) return -1
            break;
        }
        else if ( mountainArr.get(mid-1) < mountainArr.get(mid) && mountainArr.get(mid) < mountainArr.get(mid+1) ) start = mid+1
        else end = mid-1
    }

    start = 0, end = peek-1, mid = 0
    while ( start <= end ) {
        mid = Math.trunc( start + (end-start)/2 );
        if ( mountainArr.get(mid) == target ) return mid
        else if ( mountainArr.get(mid) < target ) start = mid+1
        else end = mid-1
    }

    start = peek+1, end = mountainArr.length()-1, mid = 0
    while ( start <= end ) {
        mid = Math.trunc( start + (end-start)/2 );
        if ( mountainArr.get(mid) == target ) return mid
        else if ( mountainArr.get(mid) < target ) end = mid-1
        else start = mid+1
    }

    return -1
};