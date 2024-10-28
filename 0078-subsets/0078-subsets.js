/**
 * @param {number[]} nums
 * @return {number[][]}
 */
function subset(index, subsetArr, nums, result) {

    if ( index >= nums.length ) {
        result.push([...subsetArr]);
        return;
    }
    
    subsetArr.push(nums[index]);
    subset(index+1, subsetArr, nums, result);

    subsetArr.pop();
    subset(index+1, subsetArr, nums, result);

    return result
}
var subsets = function(nums) {
    let subsetArr = [];
    let result = [];
    return subset(0, subsetArr, nums, result);
};