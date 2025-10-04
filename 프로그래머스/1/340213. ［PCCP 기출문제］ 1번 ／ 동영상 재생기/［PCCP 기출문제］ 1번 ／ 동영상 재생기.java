import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int video = Integer.parseInt(video_len.split(":")[0])*60 + Integer.parseInt(video_len.split(":")[1]);
        int cur = Integer.parseInt(pos.split(":")[0])*60 + Integer.parseInt(pos.split(":")[1]);
        int os = Integer.parseInt(op_start.split(":")[0])*60 + Integer.parseInt(op_start.split(":")[1]);
        int oe = Integer.parseInt(op_end.split(":")[0])*60 + Integer.parseInt(op_end.split(":")[1]);
        
        //현재가 오프닝인지 확인
        if(cur>=os && cur<oe) cur=oe;
        for(int i=0;i<commands.length;i++){
            
            //next
            if(commands[i].equals("next")){
                cur += 10;
                if (cur > video) cur = video;
            }
            
            //prev
            else{    
                cur -= 10;
                if (cur < 0) cur = 0;
            }
            
            // 이동 후 오프닝 구간이면 건너뛰기
            if (cur >= os && cur < oe) cur = oe;
            
        }
        String answer;
        int min = cur/60;
        int sec = cur%60;
        if(min<10){
            if(sec<10){
                answer="0"+Integer.toString(min)+":0"+Integer.toString(sec);
            }
            else answer="0"+Integer.toString(min)+":"+Integer.toString(sec);
        }
        else if(sec<10){
             answer=Integer.toString(min)+":0"+Integer.toString(sec);
        }
        else answer=Integer.toString(min)+":"+Integer.toString(sec);
        
        return answer;
    }
}

//String->Int
//왜 split('')은 안 되는가