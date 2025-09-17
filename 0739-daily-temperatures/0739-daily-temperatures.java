class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // to find the next largest value
        int[] result = new int[temperatures.length];
        int index = 0;
        Deque<Integer> decreasingDq = new ArrayDeque<>();

        // decreasing queue, the first element will always be maximum
        for ( int i=0; i<temperatures.length; i++ ) {
            while ( !decreasingDq.isEmpty() && temperatures[ decreasingDq.peekLast() ] < temperatures[i] ) {
                int pastDay = decreasingDq.pollLast();
                result[ pastDay ] = i - pastDay;
            }
            decreasingDq.addLast( i );
        }
        result[ decreasingDq.pollLast() ] = 0;

        return result;
    }
}