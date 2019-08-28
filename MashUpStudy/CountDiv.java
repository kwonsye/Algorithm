package pck1.MashUpStudy;
/* 코딜리티 실행 결과 100%
 * 1) https://app.codility.com/demo/results/training39FWEX-FT7/
 * 2) https://app.codility.com/demo/results/trainingCJCCJ8-33T/
 * */
public class CountDiv {

	public static void main(String[] args) {
		System.out.println(solution(6,11,2)); // expected 3
	}
	
	 public static int solution(int A, int B, int K) {

		 return A==0 ? B/K + 1 : B/K-(A-1)/K;
	 }
	 
}
