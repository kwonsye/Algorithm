package MashUpStudy;

import java.util.HashMap;
import java.util.Map;

public class RunningMan {

	public static void main(String[] args) {
		
		//test case
		String[] participants = {"leo", "kiki", "eden"};
		String[] completions = {"eden", "kiki"};
		
		System.out.println(solution(participants, completions));
	}

	public static String solution(String[] participant, String[] completion) {
        
		//완주하지 못한 사람
		String answer = "";
        //hash map (Key : 참여자 이름 - Value : 인원 수)
        Map<String , Integer> participantsMap = new HashMap<>();
        
        //put data in hash map
        for(int index=0; index<participant.length; index++) {
        	participantsMap.put(participant[index], participantsMap.getOrDefault(participant[index], 0) + 1);
        }
        
        //완주한 사람(key)의 value값 줄이기
        for(int index=0; index<completion.length; index++) {
        	participantsMap.put(completion[index], participantsMap.get(completion[index])-1);
        }
        
        //완주하지 못한 사람 = value 값이 1인 사람
        for(String key : participantsMap.keySet()) {
        	if(participantsMap.get(key) == 1) {
        		answer = key;
        		break;
        	}
        }
        
        return answer;
    }
}
