import java.io.*;
import java.util.*;

class Solution {
    public static int[] numbers = new int[20];
    public static int[] visited;
    public static int target = 0;
    public static int res = 0;
    
    public static void dfs(int i, int n, int sum){
        if(i==n && sum==target){
            res++;
            return;
        }
        if(i==n && sum!=target) return;
        
        dfs(i+1,n,sum+numbers[i]);
        dfs(i+1,n,sum-numbers[i]);
    }
    
    public int solution(int[] numbers, int target) {
        int n = numbers.length;
        for(int i=0;i<n;i++){
            Solution.numbers[i]=numbers[i];
        }
        
        Solution.target = target;
        System.out.println(Solution.target);
        dfs(0,n,0);
        return res;
    }
}