/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function(nums, target) {
    // let start = 0;
    // let end = nums.length-1;
    // let currMid = 0, prevMid = 0;

    // while ( start <= end ) {
    //     currMid = Math.trunc( start + ( end - start ) / 2 );
    //     if ( target == nums[currMid] )
    //         return currMid;
    //     else if ( target < nums[currMid] )
    //         end = currMid - 1;
    //     else
    //         start = currMid + 1;
    // }

    // return start;








  let start = 0, end = nums.length-1, mid = 0;

  while ( start <= end ) {
    mid = Math.trunc( start + ( end - start ) / 2 );
    if ( target == nums[mid] ) return mid
    else if ( target < nums[mid]) end = mid - 1
    else start = mid + 1
  }

  return start


















    

};