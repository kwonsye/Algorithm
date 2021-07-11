package MashUpStudy;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {

	public static void main(String[] args) {
		//test case
		String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
		
		System.out.println(solution(clothes));
	}

	public static int solution(String[][] clothes) {
        int answer = 1;
        //hash map (Key : �� ���� - Value : �ش� ������ �� ����) ex> headgear:2, eyewear:1
        Map<String, Integer> clothesMap = new HashMap<>();
        
        //put data in hash map
        for(int rowIndex=0; rowIndex<clothes.length; rowIndex++) {
        	clothesMap.put(clothes[rowIndex][1], clothesMap.getOrDefault(clothes[rowIndex][1], 0) + 1);
        }
        
        //����� �� ���
        for(String key : clothesMap.keySet()) {
        	answer *= (clothesMap.get(key) + 1);
        }
        
        return answer - 1; //��� ���Դ� ��� ����
    }
}
