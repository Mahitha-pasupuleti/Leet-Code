class Pair {
    int key;
    int value;
    char action;

    public Pair(int key, int value, char action) {
        this.key = key;
        this.value = value;
        this.action = action;
    }
}
class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if ( a.key == b.key ) {
                    return Character.compare(b.action, a.action);
                }
                else return a.key - b.key;
            }
        );
        for ( int i=0; i<times.length; i++ ) {
            pq.add(new Pair(times[i][0], i, 'A'));
            pq.add(new Pair(times[i][1], i, 'D'));
        }

        // while ( !pq.isEmpty() ) {
        //     Pair myPair = pq.poll();
        //     System.out.println(myPair.key + " " + myPair.value + " " + myPair.action);
        // }

        // 
        PriorityQueue<Integer> avaialableChairs = new PriorityQueue<>();
        for ( int i=0; i<times.length; i++ ) {
            avaialableChairs.add(i);
        }

        int[] chairsFilledBy = new int[times.length];
        Arrays.fill(chairsFilledBy, -1);


        while ( !pq.isEmpty() ) {
            Pair myPair = pq.poll();
            if ( myPair.action == 'A'  ) {
                int highPriorityAvaialbleChair = avaialableChairs.poll();
                chairsFilledBy[highPriorityAvaialbleChair] = myPair.value;
            } else {
                for ( int i=0; i<chairsFilledBy.length; i++ ) {
                    if ( chairsFilledBy[i] == myPair.value ) {
                        if ( chairsFilledBy[i] == targetFriend ) {
                            return i;
                        }
                        avaialableChairs.add(i);
                        chairsFilledBy[i] = -1;
                        break;
                    }
                }
            }
        }

        return 0;
    }
}