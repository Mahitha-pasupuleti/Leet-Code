/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    // for ( let i=0; i<s.length; i++ ) {
    //     let subStr = ""
    //     for (let j=i; j<=s.length; j++ ) {
    //         subStr = subStr + (s.charAt(j));
    //     }
    //     console.log(subStr)

    // }

    // let l = 0, r = 0, maxlen = 0;
    // let hashMap = new Map();

    // while ( r < s.length ) {
    //     if ( hashMap.has(s[r]) ) {
    //         let value = hashMap.get(s[r]);
    //         value++;
    //         hashMap.set(s[r], value);
    //     } else {
    //         hashMap.set(s[r], 1)
    //     }

    //     if ( hashMap.get(s[r]) > 1 ) {
    //         let value = hashMap.get(s[l]);
    //         value--;
    //         hashMap.set(s[l], value);
    //         l++;
    //     }

    //     if ( hashMap.size > 0 ) {
    //         maxlen = Math.max(maxlen, r-l+1);
    //     }
    //     r++
    // }
    // return maxlen




    // let left=0, right=0, maxlen=0;
    // let hashMap = new Map();

    // while ( right < s.length ) {
    //     if ( hashMap.has(s[right]) ) {
    //         left = Math.max(hashMap.get(s[right])+1, left);
    //     } // once repeating character is encountered, shrink the window by moving a index+1 of the repeating character
    //     hashMap.set(s[right], right); // change the map-value of the repeating character to the current encountered value
        
    //     maxlen = Math.max(maxlen, right-left+1);
    //     right++
    // }
    // return maxlen



//   let l = 0, r = 0, maxlen = 0;
//   let mySet = new Set();

//   while ( r < s.length ) {
//     while ( mySet.has(s[r]) ) {
//         mySet.delete(s[l]);
//         l++;
//     }
//     mySet.add(s[r]);
//     maxlen = Math.max(maxlen, r-l+1);
//     r++;
//   }
//   return maxlen;


// let l=0, r=0, maxlen=0;
// let mySet = new Set();

// while(r<s.length) {
//     while(mySet.has(s[r])) {
//         mySet.delete(s[l])
//         l++
//     }
//     mySet.add(s[r]);
//     maxlen = Math.max(maxlen, r-l+1)
//     r++
// }

// return maxlen






    let left=0, right=0, maxlen=0;
    let mySet = new Set();

    while ( right < s.length ) {
        if ( !mySet.has(s[right]) ) mySet.add(s[right]);
        else {
            // console.log(mySet)
            while( mySet.has(s[right]) ) {
                mySet.delete(s[left]);
                left++;
            }
            mySet.add(s[right]);
        }
        maxlen = Math.max(maxlen, right-left+1);
        right++;
    }

    return maxlen;

























};