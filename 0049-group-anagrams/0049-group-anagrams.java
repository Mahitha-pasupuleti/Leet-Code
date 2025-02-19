class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupMap = new HashMap<>();
        for ( String str : strs ) {
            char[] str2ChArr = str.toCharArray();
            Arrays.sort(str2ChArr);
            String sortedStr = new String(str2ChArr);
            if ( groupMap.containsKey(sortedStr) ) {
                groupMap.get(sortedStr).add(str);
            } else {
                List<String> value = new ArrayList();
                value.add(str);
                groupMap.put(sortedStr, value);
            }
        }
        List<List<String>> result = new ArrayList(groupMap.values());
        return result;
    }
}




















// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, List<String>> anagramMap = new HashMap<>();
        
//         for (String str : strs) {
//             // Handle empty strings correctly
//             char[] charArray = str.toCharArray();
//             Arrays.sort(charArray);
//             String sortedKey = new String(charArray);

//             // Check if the sorted key already exists in the map
//             if (anagramMap.containsKey(sortedKey)) {
//                 anagramMap.get(sortedKey).add(str);
//             } else {
//                 // If the key doesn't exist, create a new list and add it to the map
//                 List<String> newList = new ArrayList<>();
//                 newList.add(str);
//                 anagramMap.put(sortedKey, newList);
//             }
//         }

//         // Collect all grouped anagrams as a list of lists
//         List<List<String>> result = new ArrayList<>(anagramMap.values());
        
//         return result;
//     }
// }


// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         Map<String, String> myMap = new HashMap<>();
//         for ( int i=0; i<strs.length; i++ ) {
//             char[] arr = strs[i].toCharArray();
//             Arrays.sort(arr);
//             String current = new String(arr);
//             myMap.put(strs[i], current);
//         }
//         System.out.println(myMap);

//         Map<String, List<String>> groupMap = new HashMap<>();

//         for ( Map.Entry<String, String> entry : myMap.entrySet() ) {
//             String key = entry.getKey();
//             String value = entry.getValue();
//             if ( groupMap.containsKey(value) ) {
//                 List<String> valList = groupMap.get(value);
//                 valList.add(key);
//                 groupMap.put(value, valList);
//             } else {
//                 List<String> newValList = new ArrayList();
//                 newValList.add(key);
//                 groupMap.put(value, newValList);
//             }
//         }

//         System.out.println(groupMap);

//         List<List<String>> result = new ArrayList();

//         for ( Map.Entry<String, List<String>> entry : groupMap.entrySet() ) {
//             result.add(entry.getValue());
//         }

//         System.out.println(result);

//         return result;
//     }
// }