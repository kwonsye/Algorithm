package pck1.MashUpStudy;

/* 코딜리티 Lesson5_2 실행결과
 * 1차 (75% List<>): https://app.codility.com/demo/results/trainingWPBEUN-2M6/
 * 2차 (62%.....contains().,): https://app.codility.com/demo/results/trainingJ8G66K-NCJ/
 * 3차 (100% prefix sum https://codility.com/media/train/3-PrefixSums.pdf) :
 * 		https://app.codility.com/demo/results/trainingEHA73P-QB4/
 */
public class GenomicRangeQuery {

	public static void main(String[] args) {
		for(int result : solution("CAGCCTA",new int[] {2,5,0}, new int[] {4,5,6})) {
			System.out.print(result+" "); //expected 2 4 1
		}
	}

	public static int[] solution(String S, int[] P, int[] Q) {
		int[] result = new int[P.length];
		// 가장 처음 나온 문자열의 등장을 알기 위해 모든 누적합 배열 size+1, arr[0]=0으로 만들 것임.
		int[] accumulatedA = new int[S.length()+1]; 
		int[] accumulatedC = new int[S.length()+1];
		int[] accumulatedG = new int[S.length()+1];
		int[] accumulatedT = new int[S.length()+1];

		//누적 합
		int countA = 0;
		int countC = 0;
		int countG = 0;
		int countT = 0;
		
		for(int strIndex=0; strIndex<S.length(); strIndex++) {
			
			switch(S.charAt(strIndex)) {
				case 'A': countA++; break;
				case 'C': countC++; break;
				case 'G': countG++; break;
				default : countT++;
			}
			//누적 합 저장 : 인덱스 하나씩 뒤로 밀림
			accumulatedA[strIndex+1] = countA;
			accumulatedC[strIndex+1] = countC;
			accumulatedG[strIndex+1] = countG;
			accumulatedT[strIndex+1] = countT;
		}
		
		for(int arrIndex=0; arrIndex<P.length; arrIndex++) {
			int startIndex = P[arrIndex];
			int endIndex = Q[arrIndex];
			
			if(accumulatedA[startIndex+1]!=accumulatedA[endIndex+1]
					|| accumulatedA[startIndex+1]!=accumulatedA[startIndex]) {
				// 그 범위에 A가 나온 적이 있다면
				result[arrIndex] = 1;
			} else if(accumulatedC[startIndex+1]!=accumulatedC[endIndex+1]
					|| accumulatedC[startIndex+1]!=accumulatedC[startIndex]) {
				// 그 범위에 C가 나온 적이 있다면
				result[arrIndex] = 2;
			}else if(accumulatedG[startIndex+1]!=accumulatedG[endIndex+1]
					|| accumulatedG[startIndex+1]!=accumulatedG[startIndex]) {
				// 그 범위에 G가 나온 적이 있다면
				result[arrIndex] = 3;
			}else {
				// 그 범위에 T가 나온 적이 있다면
				result[arrIndex] = 4;
			}
		}
		
		return result;
	}
}
