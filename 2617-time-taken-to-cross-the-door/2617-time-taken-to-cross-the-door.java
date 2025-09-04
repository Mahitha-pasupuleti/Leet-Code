class Solution {
    public int[] timeTaken(int[] arrival, int[] state) {

        Queue<int[]> entry = new ArrayDeque<>();
        Queue<int[]> exit = new ArrayDeque<>();

        int initialState = -1;
        int time = arrival[0];
        int[] result = new int[arrival.length];

        for ( int i=0; i<arrival.length; i++ ) {
            if ( state[i] == 0 ) entry.add(new int[]{i, arrival[i]});
            else exit.add(new int[]{i, arrival[i]});
        }

        while ( !entry.isEmpty() || !exit.isEmpty() ) {
            if ( initialState == -1 ) {
                if ( !exit.isEmpty() && exit.peek()[1] <= time ) {
                    int[] personChosen = exit.poll();
                    result[ personChosen[0] ] = time;
                    initialState = 1;
                } else if ( !entry.isEmpty() && entry.peek()[1] <= time ) {
                    int[] personChosen = entry.poll();
                    result[ personChosen[0] ] = time;
                    initialState = 0;
                }
                time++;
            } else if ( initialState == 0 ) {
                if ( !entry.isEmpty() && entry.peek()[1] <= time ) {
                    int[] personChosen = entry.poll();
                    result[ personChosen[0] ] = time;
                } else if ( !exit.isEmpty() && exit.peek()[1] <= time ) {
                    int[] personChosen = exit.poll();
                    result[ personChosen[0] ] = time;
                    initialState = 1;
                } else {
                    initialState = -1;
                }
                time++;
            } else { // exit
                if ( !exit.isEmpty() && exit.peek()[1] <= time ) {
                    int[] personChosen = exit.poll();
                    result[ personChosen[0] ] = time;
                } else if ( !entry.isEmpty() && entry.peek()[1] <= time ) {
                    int[] personChosen = entry.poll();
                    result[ personChosen[0] ] = time;
                    initialState = 0;
                } else {
                    initialState = -1;
                }
                time++;
            }
        }

        return result;
    }
}