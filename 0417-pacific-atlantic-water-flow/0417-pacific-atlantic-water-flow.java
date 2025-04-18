class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Multi-source reverse BFS

        int m = heights.length, n = heights[0].length;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        Queue<int[]> BFSPacific = new ArrayDeque<>();
        Queue<int[]> BFSAtlantic = new ArrayDeque<>();

        boolean[][] visitedPacific = new boolean[m][n];
        boolean[][] visitedAtlantic = new boolean[m][n];

        Set<List<Integer>> resultPacific = new HashSet<>();
        Set<List<Integer>> resultAtlantic = new HashSet<>();

        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( i == 0 || j == 0 ) {
                    BFSPacific.add(new int[]{i, j});
                    resultPacific.add(Arrays.asList(i, j));
                    visitedPacific[i][j] = true;
                }
                if ( i == m-1 || j == n-1 ) {
                    BFSAtlantic.add(new int[]{i, j});
                    resultAtlantic.add(Arrays.asList(i, j));
                    visitedAtlantic[i][j] = true;
                }
            }
        }

        while ( !BFSPacific.isEmpty() ) {
            int[] node = BFSPacific.poll();
            int x = node[0], y = node[1];
            for ( int[] dir : directions ) {
                int dx = x + dir[0];
                int dy = y + dir[1];

                if ( dx<0 || dy<0 || dx>=m || dy>=n || visitedPacific[dx][dy] || heights[dx][dy] < heights[x][y] ) continue;
                resultPacific.add(Arrays.asList(dx, dy));
                visitedPacific[dx][dy] = true;
                BFSPacific.add(new int[]{dx, dy});
            }
        }

        while ( !BFSAtlantic.isEmpty() ) {
            int[] node = BFSAtlantic.poll();
            int x = node[0], y = node[1];
            for ( int[] dir : directions ) {
                int dx = x + dir[0];
                int dy = y + dir[1];

                if ( dx<0 || dy<0 || dx>=m || dy>=n || visitedAtlantic[dx][dy] || heights[dx][dy] < heights[x][y] ) continue;
                resultAtlantic.add(Arrays.asList(dx, dy));
                visitedAtlantic[dx][dy] = true;
                BFSAtlantic.add(new int[]{dx, dy});
            }
        }


            // for (int[] cell : resultPacific) {
            //     System.out.print(Arrays.toString(cell) + " ");
            // }

            // System.out.println();

            // for (int[] cell : resultAtlantic) {
            //     System.out.print(Arrays.toString(cell) + " ");
            // }


        List<List<Integer>> result = new ArrayList();

        for ( List<Integer> cell : resultPacific ) {
            if ( resultAtlantic.contains(cell) ) result.add(cell);
        }

        return result;
    }
}




/*
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // connection direction available only if the neighbour node is less than or equal to current node
        // [0, 0], [0, 1], [0, 2], [0, 3], [0, 4], [1, 0], [2, 0], [3, 0], [4, 0]
        // if row=0 || col=0 , pacific
        // [0, 4], [1, 4], [2, 4], [3, 4], [4, 4], [4, 0], [4, 1], [4, 2], [4, 3]
        // if row=n-1 || col=n-1 , atlantic

        // if-else if

        // A node is un-directed if neighboring node is same value as current node -> (EqualNode ---- EqualNode)
        // A node is directed if neighbouring node is smaller than current node -> (LargerNode ----> Smaller Node)

        // BFS

        int m = grid.length;
        int n = grid[0].length;

        List<int[]> pacific = new ArrayList();
        List<int[]> atlantic = new ArrayList();

        Queue<int[]> BFS = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };

        // BFS.add(new int[0, 0]);
        
        for ( int i=0; i<m; i++ ) {
            for ( int j=0; j<n; j++ ) {
                if ( !visited[i][j] ) {
                    BFS.add(new int[i, j]);
                    visited[i][j] = true;
                    if ( dx==0 || dy==0) {
                                pacific.add(new int[]{dx, dy});
                            } else if ( dx==m-1 || dy==n-1 ) {
                                atlantic.add(new int[]{dx, dy});
                            }

                    while ( !BFS.isEmpty() ) {
                        int[] node = BFS.poll();
                        int nodeVal = heights[node[0]][node[1]];
                        for ( int[] dir : directions ) {
                            int dx = node[0] + dir[0];
                            int dy = node[1] + dir[1];

                            if ( dx==0 || dy==0) {
                                pacific.add(new int[]{dx, dy});
                                heights[dx][dy] = -1;
                            }
                            if ( dx==m-1 || dy==n-1 ) {
                                atlantic.add(new int[]{dx, dy});
                                if ( heights[dx][dy] = -1 ) heights[dx][dy] = -3;
                                else heights[dx][dy] = -2;
                            }

                            if ( dx<0 || dy<0 || dx>=m || dy>=n || visted[dx][dy] ) continue;
                            if ( nodeVal < heights[dx][dy] ) continue;

                            visited[dx][dy] = true;
                            BFS.add(new int[]{dx, dy});
                        } 
                    } 

                }
            }
        }

    }
}
*/