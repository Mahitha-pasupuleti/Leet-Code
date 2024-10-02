/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
function checkMaps(myMap1, myMap2) {
    for ( const [key, map1Value] of myMap1 ) {
        let map2Value = myMap2.get(key);
        if ( map1Value != map2Value || ( map2Value === undefined && (!myMap2.has(key)) ) ) {
            return false
        }
    }
    return true
}
var checkInclusion = function(s1, s2) {
    
//     // Map-1 for s1
//     let myMap1 = new Map();
//     for ( let i = 0; i < s1.length; i++ ) {
//         if ( myMap1.has(s1[i]) ) {
//             let value = myMap1.get(s1[i]);
//             myMap1.set(s1[i], ++value);
//         } else {
//             myMap1.set(s1[i], 1);
//         }
//     }
//     console.log(myMap1);

//     let l = 0;
//     let myMap2 = new Map();

//     for ( let r = 0; r < s2.length; r++ ) {

//         if ( myMap2.has(s2[r]) ) {
//             let value = myMap2.get(s2[r]);
//             myMap2.set(s2[r], ++value);
//         } else {
//             myMap2.set(s2[r], 1);
//         }

//         if ( r-l+1 == s1.length ) {
//             console.log(myMap2);
//             // if ( myMap1 == myMap2 ) {
//             //     return true;
//             // }
//             if ( checkMaps(myMap1, myMap2) ) {
//                 return true;
//             }
//             let value = myMap2.get(s2[l]);
//             value--;
//             if ( value == 0 ) {
//                 myMap2.delete(s2[l]);
//             } else {
//                 myMap2.set(s2[l], value);
//             }
//             l++;
//         }

//     }
//     return false;




    let map1 = new Map();
    let map2 = new Map();

    for( let i=0; i<s1.length; i++ ) {
        if( map1.has(s1[i])) {
            let value = map1.get(s1[i])
            map1.set(s1[i], ++value)
        } else {
            map1.set(s1[i], 1);
        }
    }

    for( let i=0; i<s1.length; i++ ) {
        if( map2.has(s2[i])) {
            let value = map2.get(s2[i])
            value++
            map2.set(s2[i], value)
        } else {
            map2.set(s2[i], 1);
        }
    }

    if ( checkMaps(map1, map2) ) {
        return true;
    }

    let l=0, r=s1.length;

    while ( r<s2.length ) {

        if( map2.has(s2[r])) {
            let value = map2.get(s2[r])
            map2.set(s2[r], ++value)
        } else {
            map2.set(s2[r], 1);
        }

        let value = map2.get(s2[l])
        map2.set(s2[l], --value)
        if ( value == 0 ) {
            map2.delete(s2[l]);
        }

        if ( checkMaps(map1, map2) ) {
            return true;
        }

        l++;
        r++;

    }

    return false;




















};