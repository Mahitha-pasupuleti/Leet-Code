class Solution {
    // can go one step back or front
    public int openLock(String[] deadends, String target) {
        Queue<String> bfs = new ArrayDeque<>();

        Set<String> visited = new HashSet<>();

        Set<String> dead = new HashSet<>();
        for ( int i=0; i<deadends.length; i++ ) dead.add(deadends[i]);

        if ( dead.contains("0000") ) return -1;

        bfs.add("0000");
        visited.add("0000");

        int level = 0;

        while ( !bfs.isEmpty() ) {
            int size = bfs.size();
            for ( int j=0; j<size; j++ ) {
                String curr = bfs.poll();
                if ( curr.equals(target) ) return level;

                for ( int i=0; i<4; i++ ) {

                    char c = curr.charAt(i);
                    StringBuilder back = new StringBuilder(curr);
                    StringBuilder front = new StringBuilder(curr);

                    back.setCharAt(i, c == '0' ? '9' : (char)(curr.charAt(i) - 1));
                    front.setCharAt(i, c == '9' ? '0' : (char)(curr.charAt(i) + 1));

                    // if ( curr.charAt(i) == '0' ) {
                    //     back.setCharAt(i, '9');
                    // } else {
                    //     back.setCharAt(i, (char)(curr.charAt(i) - 1));
                    // }

                    // if ( curr.charAt(i) == '9' ) {
                    //     front.setCharAt(i, '0');
                    // } else {
                    //     front.setCharAt(i, (char)(curr.charAt(i) + 1));
                    // }
                    
                    if ( !dead.contains(back.toString()) && !visited.contains(back.toString()) ) {
                        bfs.add(back.toString());
                        visited.add(back.toString());
                    }

                    if ( !dead.contains(front.toString()) && !visited.contains(front.toString()) ) {
                        bfs.add(front.toString());
                        visited.add(front.toString());
                    }

                }
            }
            level++;
        }

        return -1;
    }
}