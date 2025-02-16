class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String firstString = strs[0];
        String lastString = strs[strs.length-1];
        int index = 0;

        while ( index < firstString.length() && index < lastString.length() ) {
            if ( firstString.charAt(index) == lastString.charAt(index) ) index++;
            else break;
        }

        return firstString.substring(0, index);
    }
}

//  public String longestCommonPrefix(String[] strs) {
//         Arrays.sort(strs);

//         String result = "";
//         int index = 0;
//         if ( strs.length > 0 ) {
//             for ( int i=0; i<strs[0].length(); i++ ) {
//                 if ( strs.length > 1 ) {
//                     if ( strs[0].charAt(i) == strs[strs.length-1].charAt(i) ) index++;
//                     else break;
//                 } else {
//                     index++;
//                 }
//             }
//         }
//         return strs[0].substring(0, index);
//     }