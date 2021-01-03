/* 
[프로그래머스] '기지국설치'
https://programmers.co.kr/learn/courses/30/lessons/12979
*/

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int bandWidth = w*2 + 1;

        int previousEndStation = 0;
        for(int i=0; i<stations.length; i++){
            int range = stations[i]-w-previousEndStation-1;
            if(range > 0){
                answer += getRequiredStationCount(range, bandWidth);
            }
            previousEndStation = stations[i]+w;
            if(previousEndStation >= n) break;
        }
        
        if(previousEndStation < n){
            int range = n-previousEndStation;
            answer += getRequiredStationCount(range, bandWidth);
        }

        return answer;
    }
    
    public int getRequiredStationCount(int range, int bandWidth){        
        if(range % bandWidth == 0){
                return (range/bandWidth);
        }else{
            return (range/bandWidth)+1; 
        }
    }
}
