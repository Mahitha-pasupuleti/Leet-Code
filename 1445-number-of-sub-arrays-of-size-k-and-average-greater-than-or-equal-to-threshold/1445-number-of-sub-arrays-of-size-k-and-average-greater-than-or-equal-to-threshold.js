/**
 * @param {number[]} arr
 * @param {number} k
 * @param {number} threshold
 * @return {number}
 */
var numOfSubarrays = function(nums, k, threshold) {
    // let l = 0, r = 0, sum = 0, count = 0;

    // while ( r < arr.length ) {
    //     sum += arr[r];
    //     if ( r-l+1 == k ) {
    //         if ( sum/k >= threshold ) {
    //             count++;
    //         }
    //         sum -= arr[l];
    //         l++;
    //     }
    //     r++;
    // }
    // return count



    let left = 0, right = k-1, sum = 0, count=0;

    for( let i=0; i<k-1; i++ ) {
        sum += nums[i];
    }

    while ( right < nums.length ) {
        sum += nums[right];
        if ( sum/k >= threshold ) count++
        sum -= nums[left];
        left++;
        right++;
    }

    return count;













};