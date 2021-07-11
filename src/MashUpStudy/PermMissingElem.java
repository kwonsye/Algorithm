package MashUpStudy;
/* �ڵ���Ƽ Lesson3_2 ���� ���
 * 1)sort �̿�
 * https://app.codility.com/demo/results/training5KFH5N-VFT/
 * 
 * 2)array�̿�
 * https://app.codility.com/demo/results/trainingA9PRTU-BV7/
 * 
*/
public class PermMissingElem {

	public static void main(String[] args) {
		
		int[] A = {2,3,1,5};
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
	
		/* 
		 * 1)���� �̿�
		Arrays.sort(A);
		for(int arrIndex=0; arrIndex<A.length; arrIndex++) {
			if(A[arrIndex]-arrIndex != 1) {
				return arrIndex+1;
			}
		}
		
		return A.length+1; //for �� �Ȱɷȴٸ� ������ ���Ұ� ���ٴ� ��
		*/
		
		// 2)�迭 �̿�
		boolean[] isExist = new boolean[A.length+2];// false : ���� �� ����, true : ���� �� ����
		//�迭 �ʱ�ȭ
		for(int arrIndex=0; arrIndex<isExist.length; arrIndex++) {
			isExist[arrIndex] = false;
		}
		
		//���°� üũ
		for(int arrIndex=0; arrIndex<A.length; arrIndex++) {
			isExist[A[arrIndex]] = true;
		}
		
		//false ������ index ����
		for(int arrIndex=1; arrIndex<isExist.length; arrIndex++) {
			if(!isExist[arrIndex]) {
				return arrIndex;
			}
		}
		return -1;
	}
}
