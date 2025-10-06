class Solution {
    private String swap(int i, int j, String main) {
        StringBuilder str = new StringBuilder(main);
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);  
        return str.toString();
    }
    public int slidingPuzzle(int[][] board) {
        int m = board.length, n = board[0].length;

        String target = "123450";
        int[][] directions = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};

        StringBuilder str = new StringBuilder();
        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                str.append(board[i][j]);
            }
        }

        String initial = str.toString();

        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        queue.add(initial);
        visited.add(initial);

        int level = 0;

        while ( !queue.isEmpty() ) {
            int size = queue.size();
            for ( int i=0; i<size; i++ ) {
                String current = queue.poll();
                if ( current.equals(target) ) return level;

                int zeroIndex = current.indexOf('0');
                for ( int dir : directions[zeroIndex] ) {
                        String swapped = swap(zeroIndex, dir, current);
                        if ( visited.contains(swapped) ) continue;
                        queue.add(swapped);
                        visited.add(swapped);
                }
            }
            level++;
        }
        return -1;
    }
}