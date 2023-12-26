class Solution {
    public int numRollsToTarget(int n, int k, int target) {
       int prev[]=new int[target+1];
        int current[]=new int[target+1];

        prev[0]=1;

        for(int d=1;d<=n;d++){
            for(int t=1;t<=target;t++){
                int ans=0;
                for(int i=1;i<=k;i++){
                    if(t-i>=0){
                        ans= ans + prev[t-i];
                        ans=ans%1000000007;
                    }                 
                }
                current[t]=ans;   
                
            }
            for(int i=0;i<prev.length;i++){
                prev[i]=current[i];
            }
        }
        return prev[target]%1000000007;
    }
}