package MashUpStudy;
/*�ڵ���Ƽ ���� ��� 100%
 * https://app.codility.com/demo/results/training2K6PEK-DZV/
 * */
import java.util.HashSet;
import java.util.Set;

public class Distinct {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {2,1,1,2,3,1})); //expected 3
	}
	public static int solution(int[] A) {
		
		Set<Integer> answerSet = new HashSet<>();
		
		for(int arrIndex=0; arrIndex<A.length; arrIndex++) {
			answerSet.add(A[arrIndex]);
		}
		
		return answerSet.size();
	}
}
