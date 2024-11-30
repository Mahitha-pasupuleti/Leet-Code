class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        HashMap<Character, String> ch2S = new HashMap<>();
        HashMap<String, Character> s2Ch = new HashMap<>();

        String[] str = s.split(" ");

        if ( pattern.length() != str.length ) return false;

        for ( int i=0; i<pattern.length(); i++ ) {
            if ( ch2S.get( pattern.charAt(i) ) == null ) {
                ch2S.put( pattern.charAt(i),  str[i] );
            } else {
                if ( !ch2S.get( pattern.charAt(i) ).equals(str[i]) ) return false;
            }
        }

        for ( int i=0; i<str.length; i++ ) {
            if ( s2Ch.get( str[i] ) == null ) {
                s2Ch.put( str[i], pattern.charAt(i) );
            } else {
                if ( !s2Ch.get( str[i] ).equals(pattern.charAt(i)) ) return false;
            }
        }
        
        return true;

    }
}