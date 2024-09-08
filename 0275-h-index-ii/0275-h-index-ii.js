/**
 * @param {number[]} citations
 * @return {number}
 */
var hIndex = function(citations) {
    let len = citations.length
    let start=0, end=len-1, mid=0;

    while ( start <= end ) {
        mid = Math.trunc( start + (end - start) / 2 );
        if ( citations[mid] >= len-mid ) end = mid-1
        else start = mid+1
    }

    return len-start
};