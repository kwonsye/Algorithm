package MashUpStudy;

/* �ڵ���Ƽ Lesson5_2 ������
 * 1�� (75% List<>): https://app.codility.com/demo/results/trainingWPBEUN-2M6/
 * 2�� (62%.....contains().,): https://app.codility.com/demo/results/trainingJ8G66K-NCJ/
 * 3�� (100% prefix sum https://codility.com/media/train/3-PrefixSums.pdf) :
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
		// ���� ó�� ���� ���ڿ��� ������ �˱� ���� ��� ������ �迭 size+1, arr[0]=0���� ���� ����.
		int[] accumulatedA = new int[S.length()+1]; 
		int[] accumulatedC = new int[S.length()+1];
		int[] accumulatedG = new int[S.length()+1];
		int[] accumulatedT = new int[S.length()+1];

		//���� ��
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
			//���� �� ���� : �ε��� �ϳ��� �ڷ� �и�
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
				// �� ������ A�� ���� ���� �ִٸ�
				result[arrIndex] = 1;
			} else if(accumulatedC[startIndex+1]!=accumulatedC[endIndex+1]
					|| accumulatedC[startIndex+1]!=accumulatedC[startIndex]) {
				// �� ������ C�� ���� ���� �ִٸ�
				result[arrIndex] = 2;
			}else if(accumulatedG[startIndex+1]!=accumulatedG[endIndex+1]
					|| accumulatedG[startIndex+1]!=accumulatedG[startIndex]) {
				// �� ������ G�� ���� ���� �ִٸ�
				result[arrIndex] = 3;
			}else {
				// �� ������ T�� ���� ���� �ִٸ�
				result[arrIndex] = 4;
			}
		}
		
		return result;
	}
}
