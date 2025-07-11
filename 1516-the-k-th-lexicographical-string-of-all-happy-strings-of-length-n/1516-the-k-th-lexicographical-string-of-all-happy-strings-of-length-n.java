class Solution {
    private void getKthHappyString(String s, List<String> result, StringBuilder str, int n, int k, int start) {
        if ( result.size() == k ) return;
        if ( str.length() == n ) {
            result.add(str.toString());
            return;
        }
        for ( int i=0; i<s.length(); i++ ) {
            if ( i == start ) continue;
            str.append(s.charAt(i)); // ab
            getKthHappyString(s, result, str, n, k, i); // 0
            str.deleteCharAt(str.length()-1);
        }
    }
    public String getHappyString(int n, int k) {
        String s = "abc";
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        getKthHappyString(s, result, str, n, k, -1);
        // System.out.println(result);
        if ( result.size() < k ) return "";
        return result.get(result.size()-1);
    }
}