import java.util.*;

class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        UnionFind uf = new UnionFind();

        // email -> name
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Union emails in same account
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                emailToName.put(account.get(i), name);
                uf.add(account.get(i)); // ensure exists

                if (i > 1) {
                    uf.union(account.get(1), account.get(i));
                }
            }
        }

        // Step 2: Group emails by parent
        Map<String, List<String>> groups = new HashMap<>();

        for (String email : emailToName.keySet()) {
            String parent = uf.find(email);
            groups.computeIfAbsent(parent, k -> new ArrayList<>()).add(email);
        }

        // Step 3: Build result
        List<List<String>> result = new ArrayList<>();

        for (String parent : groups.keySet()) {
            List<String> emails = groups.get(parent);
            Collections.sort(emails);

            List<String> account = new ArrayList<>();
            account.add(emailToName.get(parent)); // name
            account.addAll(emails);

            result.add(account);
        }

        return result;
    }

    // ================= UNION FIND =================
    class UnionFind {
        private Map<String, String> parent = new HashMap<>();

        public void add(String x) {
            parent.putIfAbsent(x, x);
        }

        public String find(String x) {
            if (!parent.get(x).equals(x)) {
                parent.put(x, find(parent.get(x))); // path compression
            }
            return parent.get(x);
        }

        public void union(String x, String y) {
            String px = find(x);
            String py = find(y);
            if (!px.equals(py)) {
                parent.put(px, py);
            }
        }
    }
}
