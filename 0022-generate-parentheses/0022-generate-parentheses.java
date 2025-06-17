class Solution {
    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;
        StringBuilder str = new StringBuilder();
        List<String> validParenth = new ArrayList<>();
        // Memoization
        // Map<String, List<String>> memo = new HashMap<>();
        generateValidParathesis(open, close, str, validParenth);
        return validParenth;
    }
    public void generateValidParathesis(int open, int close, StringBuilder str, List<String> validParenth) {
        // System.out.println(open + " " + close);
        if ( open == 0 && close == 0 ) {
            validParenth.add( str.toString() );
            return;
        }
        if ( open > 0 && open < close ) {
            generateValidParathesis( open-1, close, str.append('('), validParenth );
            str.deleteCharAt(str.length()-1);
            generateValidParathesis( open, close-1, str.append(')'), validParenth );
            str.deleteCharAt(str.length()-1);
        }
        if ( open == 0 && close > 0 ) {
            generateValidParathesis( open, close-1, str.append(')'), validParenth );
            str.deleteCharAt(str.length()-1);
        }
        if ( open == close ) {
             generateValidParathesis( open-1, close, str.append('('), validParenth );
             str.deleteCharAt(str.length()-1);
        }
    }
}