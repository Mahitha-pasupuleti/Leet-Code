class Solution {
    public int[][] highFive(int[][] items) {
        // Two priority queues
        PriorityQueue<int[]> pqPair = new PriorityQueue<>(
            (a, b) -> {
                if ( a[0] == b[0] ) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        );

        List<int[]> mainResult = new ArrayList<>();

        for ( int i=0; i<items.length; i++ ) {
            pqPair.add(items[i]);
        }

        while ( !pqPair.isEmpty() ) {
            int x = pqPair.peek()[0];
            int count = 0;
            int sum = 0;
            while ( !pqPair.isEmpty() && pqPair.peek()[0] == x ) {
                if ( count < 5 ) {
                    sum += pqPair.poll()[1];
                    count++;
                } else {
                    pqPair.poll();
                }
            }
            mainResult.add(new int[]{x, sum/5});
        }

        // Sort the resultList by ID in ascending order
        Collections.sort(mainResult, (a, b) -> Integer.compare(a[0], b[0]));

        // Convert the list to a 2D array
        int[][] result = new int[mainResult.size()][2];
        for (int i = 0; i < mainResult.size(); i++) {
            result[i] = mainResult.get(i);
        }

        return result;
    }
}