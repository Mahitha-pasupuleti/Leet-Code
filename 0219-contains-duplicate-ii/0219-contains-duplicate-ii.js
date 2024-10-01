/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
    // let left = 0;
    // let mySet = new Set();
    // for ( let right = 0; right < nums.length; right++ ) {
    //     if ( right - left > k ) {
    //         mySet.delete(nums[left]);
    //         left++
    //     }
    //     if ( mySet.has(nums[right]) ) {
    //         return true;
    //     }
    //     mySet.add(nums[right])
    // }
    // return false;


    // let l = 0, r = 0;
    // let mySet = new Set();

    // while ( r < nums.length ) {
    //     if ( mySet.has(nums[r]) ) {
    //         return true;
    //     } else {
    //         mySet.add(nums[r]);
    //     }
    //     if ( r - l == k ) {
    //         mySet.delete(nums[l]);
    //         l++;
    //     }
    //     r++;
    // }
    // return false;





    // let left=0, right=1;

    // while ( right < nums.length ) {
    //     if ( right-left > k ) {
    //         left++;
    //     }
    //     if( left!=right && nums[left] == nums[right] ) return true
        // if ( right-left <= k ) {
        //     if( nums[left] == nums[right] ) return true
        // }
        // else {
        //     left++
        // }
    //     right++
    // }

    // return false





    let left = 0, right = 0;
    let mySet = new Set();

    while ( right < nums.length ) {
        if ( mySet.has(nums[right]) ) return true
        else {
            mySet.add(nums[right])
        }
        if( right-left >= k ) {
            mySet.delete(nums[left])
            left++;
        }
        right++
    }
    return false











};

// Trying to move the window of size k such that at a time only consecutive k elements are 
// present in the set data structure