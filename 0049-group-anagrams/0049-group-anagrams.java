class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
            - For each string, sort the characters. 
            - Use the sorted string as the key because anagrams have the same sorted form.
            - Group all strings with the same sorted form.
            - Finally, return all grouped values.
        */
        Map<String, List<String>> groupAnagram = new HashMap<>();

        for (String str : strs) { // TC: O(n), n = strs.length
           
            // Convert string to character array and sort it to get the key
            char[] ch = str.toCharArray(); // SC : O(m) -> reusable/temporary
            
            Arrays.sort(ch); // TC : O(mlogm), m = str.length
            
            String key = new String(ch); // sorted version of the string

            // If this key is not in the map, initialize a new list
            if (!groupAnagram.containsKey(key)) { // TC : O(1)
                groupAnagram.put(key, new ArrayList<>()); // TC : O(1), SC : O(n * m)
            }

            // Add the original string to its anagram group.
            // Since map stores key → list, we fetch the list using the key and add the string to it.
            groupAnagram.get(key).add(str);

        }

        // Return all grouped anagrams as a list of lists
        return new ArrayList<>(groupAnagram.values()); // SC : O(n * m)
    }

    /*
        Let:
        n = number of strings in `strs`
        m = maximum length of a string in `strs`

        Time Complexity:
        - For each string: 
            - Convert to char array: O(m)
            - Sort the array: O(m log m)
            - Put/get from HashMap: O(1) average
        - Total TC: O(n * m log m)

        Space Complexity:
        - HashMap stores n entries each with a key (sorted string of length m) and list of strings.
        - Total space for keys and values: O(n * m)
        - Char array for sorting each string is temporary and reused per iteration.
        - Final result (list of lists): also O(n * m)
        
        Total SC: O(n * m)
    */

}
