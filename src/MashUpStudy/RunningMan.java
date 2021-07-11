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
        
		//�������� ���� ���
		String answer = "";
        //hash map (Key : ������ �̸� - Value : �ο� ��)
        Map<String , Integer> participantsMap = new HashMap<>();
        
        //put data in hash map
        for(int index=0; index<participant.length; index++) {
        	participantsMap.put(participant[index], participantsMap.getOrDefault(participant[index], 0) + 1);
        }
        
        //������ ���(key)�� value�� ���̱�
        for(int index=0; index<completion.length; index++) {
        	participantsMap.put(completion[index], participantsMap.get(completion[index])-1);
        }
        
        //�������� ���� ��� = value ���� 1�� ���
        for(String key : participantsMap.keySet()) {
        	if(participantsMap.get(key) == 1) {
        		answer = key;
        		break;
        	}
        }
        
        return answer;
    }
}
