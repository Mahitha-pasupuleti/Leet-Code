class Solution {

    // Helper function to check if a substring is a palindrome
    public boolean checkPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;  // Not a palindrome
            }
        }
        return true;
    }

    // Main function to check if the string can be a palindrome after deleting at most one character
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                // Try skipping either the left or right character and check
                return checkPalindrome(s, i + 1, j) || checkPalindrome(s, i, j - 1);
            }
        }

        return true; // It's already a palindrome
    }
}


/* -------------------------------------------------------------------
   Notes: Leetcode 680 – Valid Palindrome II
   -------------------------------------------------------------------
   Problem:
   --------
   Check if a given string can become a palindrome by removing at most one character.

   Approach:
   ---------
   1. Use two pointers from both ends (`i` and `j`) to compare characters.
   2. If a mismatch occurs:
      - Try skipping one character from either end and check if the resulting string is a palindrome.
      - Use a helper function `checkPalindrome` to validate the substring.
   3. If no mismatches are found, the string is already a palindrome.

   Key Insight:
   ------------
   Only **one** character is allowed to be removed, so the mismatch is a critical decision point.

   Time Complexity:
   ----------------
   • O(n) — Each character is checked at most twice (in main + helper call).

   Space Complexity:
   -----------------
   • O(1) — No extra space used, everything is done in-place.

--------------------------------------------------------------------- */