class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
            - For each string, sort the characters. 
            - Use the sorted string as the key because anagrams have the same sorted form.
            - Group all strings with the same sorted form.
            - Finally, return all grouped values.
        */
        Map<String, List<String>> groupAnagram = new HashMap<>();

        for (String str : strs) {
            // Convert string to character array and sort it to get the key
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String key = new String(ch); // sorted version of the string

            // If this key is not in the map, initialize a new list
            if (!groupAnagram.containsKey(key)) {
                groupAnagram.put(key, new ArrayList<>());
            }

            // Add the original string to its anagram group.
            // Since map stores key → list, we fetch the list using the key and add the string to it.
            groupAnagram.get(key).add(str);

        }

        // Return all grouped anagrams as a list of lists
        return new ArrayList<>(groupAnagram.values());
    }
}
