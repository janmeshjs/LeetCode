class Solution {
    public List<Integer> getRow(int rowIndex) {
     if(rowIndex ==0) return Arrays.asList(1);
        
        List<Integer> currow = new ArrayList<>(Arrays.asList(1));
        List<Integer> prerow = getRow(rowIndex-1);
        
        for(int i =1;i<rowIndex; i++){
            currow.add(prerow.get(i-1)+prerow.get(i));
        }
        currow.add(1);
        return currow;
    }
}
