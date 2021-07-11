package MashUpStudy;

/* �ڵ���Ƽ ������
 * https://app.codility.com/demo/results/trainingWVQXGP-JV8/
 * */
import java.util.Stack;
public class StoneWall {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 8, 8, 5, 7, 9, 8, 7, 4, 8 })); // expected 7
	}
	//�������� Ǫ�°� �Ⱦ˷������� �� Ǯ���� �� ����...
	public static int solution(int[] H) {
		Stack<Integer> stoneWallStack = new Stack<>();
		int stoneCount = 0;

		for (int stoneIndex =0; stoneIndex < H.length; stoneIndex++) {
			
			while(stoneWallStack.size()>0 && stoneWallStack.peek()>H[stoneIndex]) { 
				//������ top�� ���� stone���� ���ٸ�
				stoneCount++;
				stoneWallStack.pop();
			}
			if(stoneWallStack.size()==0 || stoneWallStack.peek() != H[stoneIndex]) { 
				//������ top�� ���� stone�� ���̰� ���ٸ� 1���� ��������ϹǷ� ���ÿ� �ȳ���
				stoneWallStack.push(H[stoneIndex]);
			}
		}
		return stoneCount + stoneWallStack.size();
	}

}
