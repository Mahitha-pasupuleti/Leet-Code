/**
 * @param {number[]} fruits
 * @return {number}
 */
var totalFruit = function(fruits) {
    // fruits = [3,3,3,1,2,1,1,2,3,3,4]
    // let l = 0, r = 0, maxlen = 0;
    // const myMap = new Map();

    // while ( right < fruits.length ) {
    //     myMap.set(fruits[right], right);
    //     if ( myMap.size > 2 ) {
    //         left = Math.max(myMap.get(fruits[right])+1, left);
    //     }
    //     if ( myMap.size <= 2 ) {
    //         maxlen = Math.max(maxlen, right-left+1)
    //     }
    //     right++;
    // }
    // return maxlen;

    // while ( r < fruits.length ) {
    //     if ( myMap.has(fruits[r]) ) {
    //         let value = myMap.get(fruits[r])
    //         myMap.set(fruits[r], ++value);
    //     } else {
    //         myMap.set(fruits[r], 1)
    //     }
    //     while ( myMap.size > 2 ) {
    //         let value = myMap.get(fruits[l])
    //         myMap.set(fruits[l], --value);
    //         if ( value == 0 ) {
    //             myMap.delete(fruits[l]);
    //         }
    //         l++;
    //     }
    //     if ( myMap.size <= 2 ) {
    //         maxlen = Math.max(maxlen, r-l+1);
    //     }
    //     r++;
    // }
    // return maxlen;





    // let l = 0, r = 0, maxlen = 0;
    // const myMap = new Map();

    // while ( r < fruits.length ) {
    //     if ( myMap.has(fruits[r]) ) {
    //         let value = myMap.get(fruits[r])
    //         myMap.set(fruits[r], ++value);
    //     } else {
    //         myMap.set(fruits[r], 1)
    //     }
    //     if ( myMap.size > 2 ) {
    //         let value = myMap.get(fruits[l])
    //         myMap.set(fruits[l], --value);
    //         if ( value == 0 ) {
    //             myMap.delete(fruits[l]);
    //         }
    //         l++;
    //     }
    //     if ( myMap.size <= 2 ) {
    //         maxlen = Math.max(maxlen, r-l+1);
    //     }
    //     r++;
    // }
    // return maxlen;



    let left = 0, right = 0, maxlen = 0;
    const myMap = new Map();

    while ( right < fruits.length ) {

        if ( myMap.has(fruits[right]) ) {
            let value = myMap.get(fruits[right]);
            value++
            myMap.set(fruits[right], value)
        } else {
            myMap.set(fruits[right], 1)
        }

        if ( myMap.size <= 2 ) {
            maxlen = Math.max(maxlen, right-left+1)
        } else {
            let value = myMap.get(fruits[left])
            value--
            myMap.set(fruits[left], value)
            if ( value == 0 ) {
                myMap.delete(fruits[left])
            }
            left++
        }

        // console.log(myMap)

        right++
    }

    return maxlen

















};