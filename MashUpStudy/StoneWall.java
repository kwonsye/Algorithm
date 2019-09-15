package pck1.MashUpStudy;

/* 코딜리티 실행결과
 * https://app.codility.com/demo/results/trainingWVQXGP-JV8/
 * */
import java.util.Stack;
public class StoneWall {

	public static void main(String[] args) {
		System.out.println(solution(new int[] { 8, 8, 5, 7, 9, 8, 7, 4, 8 })); // expected 7
	}
	//스택으로 푸는걸 안알려줬으면 못 풀었을 것 같다...
	public static int solution(int[] H) {
		Stack<Integer> stoneWallStack = new Stack<>();
		int stoneCount = 0;

		for (int stoneIndex =0; stoneIndex < H.length; stoneIndex++) {
			
			while(stoneWallStack.size()>0 && stoneWallStack.peek()>H[stoneIndex]) { 
				//스택의 top이 현재 stone보다 높다면
				stoneCount++;
				stoneWallStack.pop();
			}
			if(stoneWallStack.size()==0 || stoneWallStack.peek() != H[stoneIndex]) { 
				//스택의 top이 현재 stone과 높이가 같다면 1번만 세어줘야하므로 스택에 안넣음
				stoneWallStack.push(H[stoneIndex]);
			}
		}
		return stoneCount + stoneWallStack.size();
	}

}
