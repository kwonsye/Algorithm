package pck1.MashUpStudy;

import java.awt.peer.PopupMenuPeer;
import java.util.Stack;

/*�ڵ���Ƽ ������
 * https://app.codility.com/demo/results/trainingHWQDSE-ZFN/
 * */
public class Brackets {

	public static void main(String[] args) {
		System.out.println(solution("{[()()]}")); //expected 1
		System.out.println(solution("([)()]")); //expected 0
	}
	
	 public static int solution(String S) {
		 Stack<Character> bracketStack = new Stack<>();
		 
		 for(char bracket : S.toCharArray()) {
			 if(bracket == '{' || bracket == '[' || bracket == '(') {
				 bracketStack.push(bracket);
			 } else {
				if(bracketStack.isEmpty()) { //�ش�Ǵ� ��� {()}]
					return 0;
				}
				
				char poppedBracket = bracketStack.pop();
				
				if(bracket == ')' && poppedBracket != '(') return 0;
				if(bracket == '}' && poppedBracket != '{') return 0;
				if(bracket == ']' && poppedBracket != '[') return 0;
			 }
		 }
		 
		 if(!bracketStack.isEmpty()) //�ش�Ǵ� ��� {()}[
			 return 0;
		 
		 return 1;
	 }

}
