/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    
    // let L = 0, R = 1;
    // let max = 0;

    // while( R < prices.length ) {
    //     if ( prices[R] - prices[L] < 0 ) {
    //         // console.log(prices[R] - prices[L])
    //         L = R;
    //     } else {
    //         if ( prices[R] - prices[L] > max ) {
    //             // console.log(prices[R] - prices[L])
    //             max = prices[R] - prices[L];
    //         }
    //     }
    //     R++;
    // }
    // return max
    

//    let left = 0, right = 1, max = 0;
//    while ( right < prices.length ) {
//         if ( prices[right] - prices[left] < 0 ) {
//             left = right;
//         } else {
//             max = Math.max(max, prices[right] - prices[left])
//         }
//      right++;
//    }
//    return max;





    let left=0, right=1, max=0;
    while ( right < prices.length ) {
        if ( prices[left] > prices[right] ) {
            left = right;
        }
        else {
            max = Math.max(max, prices[right]-prices[left]);
            right++;
        }
    }

    return max;








};