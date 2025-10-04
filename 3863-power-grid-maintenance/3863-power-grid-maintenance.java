class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        List<Integer>[] graph = new List[c+1];

        for (int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] con: connections) {
            int a = con[0];
            int b = con[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int[] arr = new int[c+1];
        Arrays.fill(arr, -1);

        // DFS from each node
        // since we are going 1 to c, 
        for (int i=1; i<=c; i++) {
            dfs(i, i, arr, graph);
        }
        // After DFS every index is pointing to its master node.

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i=1; i<arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], new TreeSet<>());
            }
            map.get(arr[i]).add(i);
        }
        // --------   Pre-processing Done   --------

        List<Integer> ans = new ArrayList<>();
        for (int[] query: queries) {
            int type = query[0];
            int node = query[1];
            if (type == 1) {
                var set = map.get(arr[node]);
                if (set.contains(node)) {
                    // self heal
                    ans.add(node);
                } else {
                    if (set.isEmpty()) ans.add(-1);
                    else ans.add(set.getFirst());
                }
            }
            else {
                // 2: node goes offline
                map.get(arr[node]).remove(node);
            }
        }

        // List to array conversion
        int[] ansarr = new int[ans.size()];
        for (int i=0; i<ans.size(); i++) {
            ansarr[i] = ans.get(i);
        }
        return ansarr;
    }

    /**
    * Every node it visits marks the master node.
    **/
    void dfs(int i, int master, int[] arr, List<Integer>[] graph) {
        if (arr[i] != -1) return;
        arr[i] = master;

        for (int next: graph[i]) {
            dfs(next, master, arr, graph);
        }
    }
}