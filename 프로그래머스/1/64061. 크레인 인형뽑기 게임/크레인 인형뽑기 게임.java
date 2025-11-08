import java.util.*;

class Solution {
    int cnt = 0;
    Stack<Integer> st = new Stack<>();
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        
        for(int i=0;i<moves.length;i++){
            int m = moves[i];
            for(int j=0;j<n;j++){
                if(board[j][m-1]!=0){
                    int doll = board[j][m-1];
                    board[j][m-1]=0; // 인형 빼기
                    move(doll);
                    break;
                }
            }
        }
        return cnt;
    }
    
    public void move(int doll){
        if(st.isEmpty()) st.push(doll);
        else{
            if(st.peek()==doll){
                st.pop();
                cnt+=2;
            }
            else{
                st.push(doll);
            }
        }
    }
}