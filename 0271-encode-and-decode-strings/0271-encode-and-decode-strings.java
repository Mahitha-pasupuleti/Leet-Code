public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for ( String str : strs ) {
            result.append(str.length()).append('#').append(str);
        }
        System.out.println(result);
        return result.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList();
        int i=0;
        while ( i<s.length() ) {
            int hashIndex = s.indexOf('#', i);
            System.out.println(hashIndex);
            int strLen = Integer.parseInt(s.substring(i, hashIndex));
            System.out.println(strLen);
            i = hashIndex + 1;
            result.add( s.substring(i, i + strLen) );
            i = i + strLen;
        }
        return result;
    }
}

// public class Codec {

//     // Encodes a list of strings to a single string.
//     public String encode(List<String> strs) {
//         StringBuilder result = new StringBuilder();
//         for( int i=0; i<strs.size(); i++ ) {
//             for ( int j=0; j<strs.get(i).length(); j++ ) {
//                 result.append(strs.get(i).charAt(j));
//             }
//             result.append("क");
//         }
//         return result.toString();
//     }

//     // Decodes a single string to a list of strings.
//     public List<String> decode(String s) {
//         List<String> result = new ArrayList();
//         StringBuilder curr = new StringBuilder();
//         for ( int i=0; i<s.length(); i++ ) {
//             if ( s.charAt(i) != 'क' ) {
//                 curr.append(s.charAt(i));
//             } else {
//                 result.add(curr.toString());
//                 curr = new StringBuilder();;
//             }
//         }

//         return result;
//     }
// }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));