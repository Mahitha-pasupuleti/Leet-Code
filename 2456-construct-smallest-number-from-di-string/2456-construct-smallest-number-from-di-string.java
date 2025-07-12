class Solution {
    String result = "";
    private boolean dfs(boolean[] visited, StringBuilder str, String pattern, int start, int index) {
        if ( str.length() == pattern.length()+1 ) {
            result = new String(str.toString());
            return true;
        }
        if ( pattern.charAt(index) == 'D' ) {
            for ( int i=1; i<start; i++ ) {
                if ( !visited[i-1] ) {
                    visited[i-1] = true;
                    str.append(i);
                    if ( dfs(visited, str, pattern, i, index+1) ) return true;
                    visited[i-1] = false;
                    str.deleteCharAt(str.length()-1);
                }
            }
        } else {
            for ( int i=start+1; i<=9; i++ ) {
                if ( !visited[i-1] ) {
                    visited[i-1] = true;
                    str.append(i);
                    if ( dfs(visited, str, pattern, i, index+1) ) return true;
                    visited[i-1] = false;
                    str.deleteCharAt(str.length()-1);
                }
            }
        }
        return false;
    }
    public String smallestNumber(String pattern) {
        boolean[] visited = new boolean[9]; // all false;
        StringBuilder str = new StringBuilder();
        for ( int i=1; i<=9; i++ ) {
            visited[i-1] = true;
            str.append(i);
            if ( dfs(visited, str, pattern, i, 0) ) return result;
            visited[i-1] = false;
            str.deleteCharAt(str.length()-1);
        }
        return result;
    }
}