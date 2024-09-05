/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
//     let start = 0, currMid = 0, prevMid = 0
//     let end = x
//     while ( start <= end ) {
//         prevMid = currMid
//         currMid = ((start+end)/2);
//         console.log(currMid)
//         if ( currMid * currMid == x ) {
//             return currMid;
//         }
//         else if ( currMid * currMid > x ) {
//             end = currMid-1
//         }
//         else {
//             start = currMid+1
//         }
//     }
//     return prevMid







let start = 0, end = x, mid = 0;

while ( start <= end ) {
    mid = Math.trunc( start + ( end - start ) / 2 )
    if ( mid*mid == x ) return mid
    else if ( mid*mid < x ) start = mid + 1
    else end = mid - 1
}

return end






};