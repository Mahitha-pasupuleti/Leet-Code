/**
 * @param {string} time
 * @return {string}
 */
var maximumTime = function(time) {
    // let time_split = time.split(":")
    // console.log(time_split[0])
    // console.log(time_split[1])

    // let index_time_split_0 = time_split[0].indexOf('?')
    // console.log(index_time_split_0)

    // let index = time.indexOf('?')
    // console.log(index)

    // while ( time.indexOf('?') > 0 ) {
    //     let index = time.indexOf('?')
    //     console.log(index)

    //     if ( index == 0 ) {
    //         if ( time[1] <= 3 ) {
    //             time[0] = 2
    //         } else {
    //             time[0] = 1
    //         }
    //     }
    //     if ( index == 1 ) {
    //         if ( time.charAt(0) == 2 ) {
    //             time.charAt(1) = '3'
    //         } else {
    //             time.charAt(1) = 9
    //         }
    //     }
    //     if ( index == 2 ) {
    //         time[2] = 5
    //     }
    //     if ( index == 3 ) {
    //         time[3] = 9
    //     }
    // }
    time = time.split('')
    console.log(time)
    if ( time.indexOf("?") == 0 ) {
        if ( time[1] > 3 ) {
            time[0] = "1"
        } else {
            time[0] = "2"
        }
    }
    if ( time.indexOf("?") == 1 ) {
         if ( time[0] == "2" ) {
            time[1] = "3"
        } else {
            time[1] = "9"
        }
    }
    if ( time.indexOf("?") == 3 ) {
            time[3] = "5"
    }
    if ( time.indexOf("?") == 4 ) {
            time[4] = "9"
    }

    // console.log(time.join(''))

    return time.join('')

};