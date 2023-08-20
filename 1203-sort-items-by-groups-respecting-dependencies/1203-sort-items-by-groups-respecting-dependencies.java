class Solution {
    int[] ret;
    int[] group;
    List<List<Integer>> beforeItems;
    int cnt = 0;
    List<Integer>[] groups;
    boolean[] checked;
    boolean[] preparing;
    boolean cycle = false;
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        groups = new List[m];
        ret = new int[n];
        checked = new boolean[n];
        preparing = new boolean[n];
        this.group = group;
        this.beforeItems = beforeItems;
        for (int i = 0; i < m; i++) {
            groups[i] = new LinkedList<>();
        }

        for (int i = 0; i < n; i++) {
            if (group[i] != -1) groups[group[i]].add(i);
        }
        for (int i = 0; i < n; i++) {
            if (!checked[i]) prepare(i, true);
        }
        return cycle ? new int[0] : ret;
    }
    void prepare(int i, boolean passOn) {
        if (preparing[i] || cycle) {
            cycle = true;
            return;
        }
        preparing[i] = true;

        if (group[i] == -1) {
            for (Integer item: beforeItems.get(i)) {
                if (!checked[item]) prepare(item, true);
            }
            checked[i] = true;
            ret[cnt++] = i;
        } else {
            for (Integer item: groups[group[i]]) {
                if (item == i) continue;
                for (Integer beforeItem : beforeItems.get(item)) {
                    if (group[beforeItem] != group[item] && !checked[beforeItem])
                        prepare(beforeItem, true);
                }
            }

            for (Integer item: beforeItems.get(i)) {
                if (!checked[item]) prepare(item, group[item] != group[i]);
            }
            checked[i] = true;
            ret[cnt++] = i;
            
       
            if (passOn)
                for (Integer item: groups[group[i]]) {
                    if (!preparing[item]) prepare(item, false);
                }
        }
    }
}