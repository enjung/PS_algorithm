import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int n3 = n / 3;

        // 1. 초기 카드 설정
        // hand: 코인 소모 없이 바로 낼 수 있는 카드 쌍을 관리
        Set<Integer> hand = new HashSet<>();
        // draw: 코인을 소모하고 가져와야 하는 카드들을 관리
        Set<Integer> draw = new HashSet<>();

        // 초기 n/3장의 카드를 손에 든 카드(hand)에 넣음
        for (int i = 0; i < n3; i++) {
            hand.add(cards[i]);
        }

        int round = 1;
        int cardIndex = n3;

        while (cardIndex < n) {
            // 2. 매 라운드 시작
            // 2-1. 카드 2장 뽑기 (카드 뭉치가 비었으면 루프 종료)
            if (cardIndex + 1 >= n) {
                break;
            }
            draw.add(cards[cardIndex++]);
            draw.add(cards[cardIndex++]);

            boolean canProceed = false;

            // 3. 그리디 전략에 따른 카드 제출 우선순위
            
            // 3-1. 코인 0개 사용 (손에 든 카드 2장으로 n+1 쌍 만들기)
            if (checkAndRemovePair(hand, hand, n + 1)) {
                canProceed = true;
            }
            
            // 3-2. 코인 1개 사용 (손에 든 카드 1장, 뽑은 카드 1장으로 n+1 쌍 만들기)
            // 코인이 1개 이상 있을 때만 시도
            else if (coin >= 1 && checkAndRemovePair(hand, draw, n + 1)) {
                coin--; // 코인 1개 소모
                canProceed = true;
            }
            
            // 3-3. 코인 2개 사용 (뽑은 카드 2장으로 n+1 쌍 만들기)
            // 코인이 2개 이상 있을 때만 시도
            else if (coin >= 2 && checkAndRemovePair(draw, draw, n + 1)) {
                coin -= 2; // 코인 2개 소모
                canProceed = true;
            }

            // 4. 다음 라운드 진행 여부
            if (canProceed) {
                round++;
            } else {
                // 낼 수 있는 카드가 없으면 게임 종료
                break;
            }
        }
        
        return round;
    }
    
    // 두 Set에서 합이 target인 카드 쌍을 찾아 제거하는 헬퍼 함수
    private boolean checkAndRemovePair(Set<Integer> set1, Set<Integer> set2, int target) {
        for (int card : set1) {
            int needed = target - card;
            
            // 두 Set이 같을 경우 (손에 든 카드 두 장, 뽑은 카드 두 장)
            if (set1 == set2) {
                // 자기 자신을 제외하고 합이 target인 카드가 존재하는지 확인
                if (card != needed && set2.contains(needed)) {
                    set1.remove(card);
                    set2.remove(needed);
                    return true;
                }
            } else { // 두 Set이 다를 경우 (손에 든 카드 한 장, 뽑은 카드 한 장)
                if (set2.contains(needed)) {
                    set1.remove(card);
                    set2.remove(needed);
                    return true;
                }
            }
        }
        return false;
    }
}