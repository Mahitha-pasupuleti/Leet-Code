class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        /*
        - To get the length of the Shortest Common Subsequence(SCS)
          - Take both string lengths s1(n) & s2(m)
          - SCS = s1.length(n) + s2.length(m) - LCS
        - Why this works?
          - When we do n + m, we basically do 
          - s1(other characters of s1) + LCS(from s1) + s2(other characters of s2) + LCS(from s2)
          - so LCS is repeating twice, so remove LCS once will give us SCS
        */

        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for ( int i=0; i<n+1; i++ ) {
            for ( int j=0; j<m+1; j++ ) {
                if ( i==0 || j==0 ) dp[i][j] = 0;
                else if ( str1.charAt(i-1) == str2.charAt(j-1) ) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max( dp[i-1][j], dp[i][j-1] );
                }
            }
        }

        // int SCS = n + m - dp[n][m] ----- this gives the length of Shortest Common Subsequence

        /*
        - Now how to print this SCS, 
        - this is fairly similar to how LCS is printed
          - While printing in LCS
            - We only print when same character is found b/w both strings
          - While printing in SCS this differs
            - Along with printing when a same character arises (*** only once ***)
            - When a different character arises, we usually go in the direction of max character
            - Before moving towards max cahracter, we add the current character and then move
            
            - By the end, there are chances where either s1 or s2 characters are remaining in those cases
            - we check if antyhing is remaining and we add them to fianl result
        
        Note: result of both LCS & SCS using above technique should be reversed to get our final result
        */

        int i=n, j=m;
        StringBuilder str = new StringBuilder();

        while ( i>0 && j>0 ) {
            if ( str1.charAt(i-1) == str2.charAt(j-1) ) {
                str.append( str1.charAt(i-1) );
                i--;
                j--;
            } else {
                if ( dp[i-1][j] > dp[i][j-1] ) {
                    /*
                        - we are planning to move to "i-1" row,          remaining in the same column "j"
                        - so we are planning to leave the current row "i", remaining in the same column "j"
                        - since we are leaving row "i", we need to add character at "i" before leaving
                        - "i" belongs to str1, so we append str1.charAt(i-1) [since indexing in dp table and string works differently]
                        - once added we can move to "i-1" row
                    */
                    str.append( str1.charAt(i-1) );
                    i--;
                } else {
                    /*
                        - we are planning to move to "j-1" column,                   remaining in the same row "i"
                        - so we are planning to leave the current column "j",        remaining in the same row "i"
                        - since we are leaving column "j",          we need to add character at "j" before leaving
                        - "j" belongs to str2, so we append str2.charAt(j-1) [since indexing in dp table and string works differently]
                        - once added we can move to "j-1" column
                    */
                    str.append( str2.charAt(j-1) );
                    j--;
                }
            }
        }

        /*
            - If i>0, it means still characters exist in str1
            - Generally in LCS we omit because, we only want common characters
            - But SCS demands these characters be used
            - If any characters are remaining in "i", i.e in str1, since "i" rows belong to str1
            - we process and add them
        */
        while ( i>0 ) {
            str.append ( str1.charAt(i-1) );
            i--;
        }

        /*
            - If j>0, it means still characters exist in str2
            - Generally in LCS we omit because, we only want common characters
            - But SCS demands these characters be used
            - If any characters are remaining in "j" , i.e in str2, since "j" columns belong to str2
            - we process and add them
        */
        while ( j>0 ) {
            str.append( str2.charAt(j-1) );
            j--;
        }

        return str.reverse().toString();
    }
}