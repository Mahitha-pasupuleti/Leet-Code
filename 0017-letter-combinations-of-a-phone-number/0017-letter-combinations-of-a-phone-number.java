class Solution {
    public void backtracking(int index, String digits, StringBuilder subResult, List<String> result, HashMap<Character, String> map) {
        if ( subResult.length() == digits.length() ) {
            result.add(subResult.toString());
            return;
        }
            String letters = map.get(digits.charAt(index));
            for ( int i=0; i<letters.length(); i++ ) {
                subResult.append(letters.charAt(i));
                backtracking(index+1, digits, subResult, result, map);
                subResult.deleteCharAt(subResult.length()-1);
            }
    }
    public List<String> letterCombinations(String digits) {
        
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }

        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        StringBuilder subResult = new StringBuilder();
        List<String> result = new ArrayList<>();

        backtracking(0, digits, subResult, result, map);

        return result;
    }
}