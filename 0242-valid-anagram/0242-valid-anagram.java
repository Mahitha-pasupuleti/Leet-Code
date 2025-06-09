class Solution {
    public boolean isAnagram(String s, String t) {
        int[] chArray = new int[26];
        Arrays.fill(chArray, 0);

        for ( char ch : s.toCharArray() ) {
            chArray[ ch - 'a' ]++;
        }

        for ( char ch : t.toCharArray() ) {
            chArray[ ch - 'a' ]--;
        }

        for ( int i=0; i<chArray.length; i++ ) {
            if ( chArray[i] != 0 ) return false;
        }

        return true;
    }
}

/*

class Solution {
    public boolean isAnagram(String s, String t) {

            Approach:
            - Count the frequency of each character in string 's' and store it in a HashMap.
            - Then iterate through string 't':
                - If a character doesn't exist in the map → return false (extra char in t).
                - If a character exists:
                    - Decrease its count by 1.
                    - If the count becomes 0, remove the character from the map.
            - Finally, if the map is empty → it's a valid anagram.

        Map<Character, Integer> validAnagram = new HashMap<>();

        // Count character frequencies in 's'
        for (char ch : s.toCharArray()) {
            validAnagram.put(ch, validAnagram.getOrDefault(ch, 0) + 1);
        }

        // Decrease frequencies based on characters in 't'
        for (char ch : t.toCharArray()) {
            Integer count = validAnagram.get(ch);
            if (count == null) return false; // char in 't' not found in 's'
            if (count == 1) validAnagram.remove(ch); // last occurrence, remove key
            else validAnagram.put(ch, count - 1); // decrement count
        }

        // If map is empty, all characters matched perfectly
        return validAnagram.isEmpty();
    }
}

*/