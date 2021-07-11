package MashUpStudy;
/* �ڵ���Ƽ ���� ���
 * https://app.codility.com/demo/results/trainingST7X9H-KQ6/
 * */
import java.util.Stack;

public class Nesting {

	public static void main(String[] args) {
		System.out.println(solution("(()(())())")); //expected 1
		System.out.println(solution("())")); //expected 0
		System.out.println(solution("(()")); //expected 0
		System.out.println(solution("))((")); //expected 0
	}
	
	public static int solution(String S) {
		Stack<Character> leftBracketStack = new Stack<>();
		
		for(char bracket : S.toCharArray()) {
			if(bracket == '(') {
				leftBracketStack.push(bracket);
			} else { // ')'�̸�
				if(leftBracketStack.size() == 0) return 0;
				leftBracketStack.pop();
			}
		}
		
		return leftBracketStack.size() == 0 ? 1 : 0;
	}

}
