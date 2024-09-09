/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function(nums) {
    let len = nums.length
    if ( len == 1 ) return 0
    if ( nums[0] > nums[1] ) return 0
    if ( nums[len-2] < nums[len-1] ) return len-1

    let start=1, end=len-2, mid=0
    while ( start <= end ) {
        mid = Math.trunc( start + (end-start) / 2 )
        if ( nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1] ) return mid
        else if ( nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1] ) start = mid+1
        // else if ( nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1] ) end = mid-1
        else end = mid-1
    }

};