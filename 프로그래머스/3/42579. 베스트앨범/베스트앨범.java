import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> res = new ArrayList<>();
        HashMap<String,Integer> map1 = new HashMap<>();
        HashMap<String,HashMap<Integer,Integer>> map2 = new HashMap<>();
        

        for(int i=0;i<plays.length;i++){
            if(map1.containsKey(genres[i])){
                map1.replace(genres[i], map1.get(genres[i])+plays[i]);
                map2.get(genres[i]).put(i,plays[i]);
            }
            else{
                map1.put(genres[i],plays[i]);
                HashMap<Integer,Integer> map3 = new HashMap<>();
                map3.put(i,plays[i]);
                map2.put(genres[i],map3);
            }
        }
        
        //장르는 총 재생 수 내림차순으로 정렬
        List<String> genreList = new ArrayList<>(map1.keySet());
        genreList.sort((a, b) -> map1.get(b) - map1.get(a));
        
        for(String genre : genreList){
            //해당 장르의 고유번호-재생수
            HashMap<Integer, Integer> map3 = map2.get(genre);
            
            //map3를 재생수 내림차순으로 정렬, 단 재생수가 같으면 고유번호 오름차순
            List<Map.Entry<Integer, Integer>> songList = new ArrayList<>(map3.entrySet());
            songList.sort((a, b) -> {
                if (!a.getValue().equals(b.getValue())) {
                    return b.getValue() - a.getValue(); //재생 수 내림차순
                } else {
                    return a.getKey() - b.getKey(); //고유번호 오름차순
                }
            });
            
            //장르별 최대 2곡 선택
            res.add(songList.get(0).getKey());
            if (songList.size() > 1) { //한 곡만 있는 게 아니라면, 그 다음 재생 수 높은 한 곡 더 추가
                res.add(songList.get(1).getKey());
            }
        }
        
            
        //List<Integer> res를 int[] answer로 변환하여 출력폼 맞추기
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }
        return answer;
    }
}