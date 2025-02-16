class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alphabet = new int[26];

        for ( char x : s.toCharArray() ) {
            alphabet[x - 'a']++;
        }
        for ( char y : t.toCharArray() ) {
            alphabet[y - 'a']--;
        }
        for ( int val : alphabet ) {
            if ( val!=0 ) return false;
        }

        return true;
    }
}


// public boolean isAnagram(String s, String t) {
//         char[] sChArr = s.toCharArray();
//         Arrays.sort(sChArr);
        
//         char[] tChArr = t.toCharArray();
//         Arrays.sort(tChArr);

//         return new String(sChArr).equals(new String(tChArr));
//     }