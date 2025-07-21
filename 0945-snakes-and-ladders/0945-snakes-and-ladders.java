class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flattened = new int[n * n + 1]; // 1-based indexing

        int index = 1;
        boolean leftToRight = true;

        // Flatten the board into 1D
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    flattened[index++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    flattened[index++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        queue.add(1);
        visited[1] = true;
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n * n) return moves;

                for (int dice = 1; dice <= 6; dice++) {
                    int next = curr + dice;
                    if (next > n * n) continue;

                    int dest = (flattened[next] == -1) ? next : flattened[next];

                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.add(dest);
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}