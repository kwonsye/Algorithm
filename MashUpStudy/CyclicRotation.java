package pck1.MashUpStudy;

public class CyclicRotation {

	public static void main(String[] args) {
		int[] A = {1,2,3,4};
		int K = 8;
		
		for(int v : solution(A,K)) {
			System.out.println(v);
		}
	}
	
	public static int[] solution(int[] A, int K) {
		
		int[] answer = new int[A.length];
		
		for(int arrIndex=0; arrIndex<A.length; arrIndex++) {
			
			answer[(arrIndex+K)%A.length] = A[arrIndex];
		}
		
		return answer;
	}

}
