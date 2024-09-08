/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
// function getFirstOccurance(nums, target) {

//     let start = 0;
//     let end = nums.length-1;
//     let mid = 0;
//     let result = -1;

//     while ( start <= end ) {
//         mid = Math.trunc(start + ( ( end - start ) / 2 ));
//         if ( target == nums[mid] ) {
//             result = mid;
//             end = mid - 1;
//         }
//         else if ( target < nums[mid] )
//             end = mid - 1;
//         else
//             start = mid + 1;
//     }

//     return result;

// }
// function getLastOccurance(nums, target) {

//     let start = 0;
//     let end = nums.length-1;
//     let mid = 0;
//     let result = -1;

//     while ( start <= end ) {
//         mid = Math.trunc(start + ( (end - start) / 2 ));
//         if ( target == nums[mid] ) {
//             result = mid;
//             start = mid + 1;
//         }
//         else if ( target < nums[mid] )
//             end = mid - 1;
//         else
//             start = mid + 1;
//     }

//     return result;

// }

var searchRange = function(nums, target) {

    let firstOccurance = getFirstOccurance(nums, target);
    let lastOccurance = getLastOccurance(nums, target);

    return [firstOccurance, lastOccurance];

};



function getFirstOccurance(nums, target) {
    let start=0, end=nums.length-1, mid=0;

    while ( start <= end ) {
        mid = Math.trunc( start + (end-start)/2 )
        if ( nums[mid] >= target) end = mid-1
        else start = mid + 1
    }
    
    if ( nums[start] == target) return start
    return -1
}

function getLastOccurance(nums, target) {
    let start=0, end=nums.length-1, mid=0;

    while ( start <= end ) {
        mid = Math.trunc( start + (end-start)/2 )
        if ( nums[mid] <= target ) start = mid+1
        else end = mid-1
    }

    if ( nums[end] == target ) return end
    return -1
}