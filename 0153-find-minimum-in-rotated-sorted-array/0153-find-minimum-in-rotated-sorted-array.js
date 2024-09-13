/**
 * @param {number[]} nums
 * @return {number}
 */

var findMin = function(nums) {
    
    // let len = nums.length
    // let start = 0;
    // let end = len - 1;
    // let mid = 0;
    // // console.log(nums)

    // while ( start <= end ) {

    //     mid = Math.trunc(start + ( (end - start) / 2 ) );
    //     let prev = (mid + len - 1)%len
    //     let next = (mid + 1)%len
    //     // console.log(prev + ' ' + mid + ' ' + next);

    //     if ( nums[mid] <= nums[prev] && nums[mid] <= nums[next] )
    //         return nums[mid];
    //     if ( nums[mid] <= nums[end] )
    //         end = mid-1;
    //     else if ( nums[start] <= nums[mid] )
    //         start = mid+1;

    // }


let len = nums.length
let start = 0, end = len-1, mid = 0, prev = 0, next = 0;

while ( start <= end ) {
    mid = Math.trunc(start + (end-start)/2 )
    prev = (mid+len-1)%len
    next = (mid+1)%len
    
    // console.log(prev + ":" + mid + ":" + next)
    if ( nums[prev] >= nums[mid] && nums[mid] <= nums[next] ) return nums[mid]
    else if ( nums[mid] <= nums[end] ) end = mid-1
    else start = mid+1
}

    
};