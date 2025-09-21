class Solution {
    public int solution(String name) {
        int n = name.length();
        int ud = 0;
        int cur = 0;
        int minCur = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            char c = name.charAt(i);
            ud += Math.min(c-'A','Z'-c+1);
        }
        //반환점 없는 경우
        int noSwitch = (n-1);
        
        //반환점 설정
        for(int i=0;i<n;i++){
            int next = i+1;
            while( next<n && name.charAt(next)=='A') next++;
            
            int forBack = i+i+n-next;
            int backFor = n-next+n-next+i;
            int m = Math.min(forBack,backFor);
            cur = Math.min(m,noSwitch);
            minCur = Math.min(cur,minCur);
            
        }
        
        return minCur+ud;
    }
}