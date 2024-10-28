/**
 * @param {number[]} nums
 * @return {number[][]}
 */
function subset(index, nums, subArr, result) {

    if ( index >= nums.length ) {
        result.push([...subArr]);
        return;
    }

    subArr.push(nums[index])
    subset(index+1, nums, subArr, result)
    subArr.pop()

    while (index + 1 < nums.length && nums[index] === nums[index + 1]) {
        index++;
    }
    
    subset(index+1, nums, subArr, result)

    return result;

}
var subsetsWithDup = function(nums) {
    nums.sort((a, b) => a - b);
    let subArr = [];
    let result = [];
    return subset(0, nums, subArr, result);
    
};