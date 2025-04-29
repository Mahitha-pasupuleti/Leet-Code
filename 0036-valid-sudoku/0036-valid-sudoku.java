class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> mySet = new HashSet<>();
        
        for ( int i=0; i<9; i++ ) {
            int count = 0;
            for ( int j=0; j<9; j++ ) {
                char c = board[i][j];
                if ( c == '.' ) count++;
                else mySet.add( c );
            }
            if ( count + mySet.size() != 9 ) return false;
            mySet.clear();
        }

        for ( int j=0; j<9; j++ ) {
            int count = 0;
            for ( int i=0; i<9; i++ ) {
                char c = board[i][j];
                if ( c == '.' ) count++;
                else mySet.add( c );
            }
            if ( count + mySet.size() != 9 ) return false;
            mySet.clear();
        }

        int[] dotCount = new int[9];
        HashSet<Character>[] arrayOfSets = new HashSet[9];
        for (int i = 0; i < 9; i++) arrayOfSets[i] = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (c == '.') dotCount[boxIndex]++;
                else arrayOfSets[boxIndex].add(c);
            }
        }

        // for ( int i=0; i<9; i++ ) {
        //     for ( int j=0; j<9; j++ ) {
        //         if ( i/3 == 0 && j/3 == 0 ) {
        //             char c = board[i][j];
        //             if ( c == '.' ) dotCount[0]++;
        //             else arrayOfSets[0].add( c );
        //         }
        //         if ( i/3 == 0 && j/3 == 1 ) {
        //             char c = board[i][j];
        //             if ( c == '.' ) dotCount[1]++;
        //             else arrayOfSets[1].add( c );
        //         }
        //         if ( i/3 == 0 && j/3 == 2 ) {
        //             char c = board[i][j];
        //             if ( c == '.' ) dotCount[2]++;
        //             else arrayOfSets[2].add( c );
        //         }
        //         if ( i/3 == 1 && j/3 == 0 ) {
        //             char c = board[i][j];
        //             if ( c == '.' ) dotCount[3]++;
        //             else arrayOfSets[3].add( c );
        //         }
        //         if ( i/3 == 1 && j/3 == 1 ) {
        //             char c = board[i][j];
        //             if ( c == '.' ) dotCount[4]++;
        //             else arrayOfSets[4].add( c );
        //         }
        //         if ( i/3 == 1 && j/3 == 2 ) {
        //             char c = board[i][j];
        //             if ( c == '.' ) dotCount[5]++;
        //             else arrayOfSets[5].add( c );
        //         }
        //         if ( i/3 == 2 && j/3 == 0 ) {
        //             char c = board[i][j];
        //             if ( c == '.' ) dotCount[6]++;
        //             else arrayOfSets[6].add( c );
        //         }
        //         if ( i/3 == 2 && j/3 == 1 ) {
        //             char c = board[i][j];
        //             if ( c == '.' ) dotCount[7]++;
        //             else arrayOfSets[7].add( c );
        //         }
        //         if ( i/3 == 2 && j/3 == 2 ) {
        //             char c = board[i][j];
        //             if ( c == '.' ) dotCount[8]++;
        //             else arrayOfSets[8].add( c );
        //         }
        //     }
        // }

        for ( int i=0; i<9; i++ ) {
            if ( arrayOfSets[i].size() + dotCount[i] != 9 ) return false;
        }
        return true;
    }
}