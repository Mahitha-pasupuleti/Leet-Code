class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for ( int i=0; i<n; i++ ) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        if ( parent[node] == node ) return node;
        return parent[node] = find( parent[node] );
    }

    public void union(int a, int b) {
        int leader_a = find(a);
        int leader_b = find(b);

        if ( leader_a != leader_b ) {
            if ( rank[leader_a] < rank[leader_b] ) {
                rank[leader_b] += rank[leader_a];
                parent[leader_a] = leader_b;
            } else {
                rank[leader_a] += rank[leader_b];
                parent[leader_b] = leader_a;
            }
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        DSU disjoin = new DSU(accounts.size());
        Map<String, Integer> emailMap = new HashMap<>();

        for ( int i=0; i<accounts.size(); i++ ) {
            for ( int j=1; j<accounts.get(i).size(); j++ ) {

                String key = accounts.get(i).get(j);
                if ( !emailMap.containsKey( key ) ) {
                    emailMap.put( key, i );
                } else {
                    disjoin.union( emailMap.get(key) , i );
                }

            }
        }

        Map<Integer, List<String>> emailMapToIndex = new HashMap<>();

        for ( String key : emailMap.keySet() ) {
            int indexValue = disjoin.find( emailMap.get( key ) );
            emailMapToIndex.putIfAbsent( indexValue, new ArrayList<>() );
            emailMapToIndex.get(indexValue).add(key);
        }

        // Step 3: Build result
        List<List<String>> result = new ArrayList<>();
        for (int index : emailMapToIndex.keySet()) {
            List<String> emails = emailMapToIndex.get(index);
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(accounts.get(index).get(0)); // Add name
            account.addAll(emails); // Add sorted emails
            result.add(account);
        }

        return result;
    }
}