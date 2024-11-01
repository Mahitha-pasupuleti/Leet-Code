class Solution {
    public List<String> generateParenthesis(int n) {
        int open = n;
        int close = n;
        String OP = "";
        List<String> result = new ArrayList<>();;
        return Parenthesis(open, close, OP, result);
    }
    public List<String> Parenthesis(int open, int close, String OP, List<String> result) {
        if ( open == 0 && close == 0 ) {
            result.add(OP);
            return result;
        }
        else if ( open != 0 && open < close ) {
            String OP1 = OP + "(";
            String OP2 = OP + ")";
            Parenthesis(open-1, close, OP1, result);
            Parenthesis(open, close-1, OP2, result);
        }
        else if ( open == close && open != 0 ) {
            String OP1 = OP + "(";
            Parenthesis(open-1, close, OP1, result);
        }
        else if ( open == 0 && close > 0 ) {
            String OP2 = OP + ")";
            Parenthesis(open, close-1, OP2, result);
        }
        return result;
    }
}