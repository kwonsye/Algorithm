package pck1;

import java.util.Scanner;
/*Trie 자료구조 이용
 * 문제 : https://www.acmicpc.net/problem/5052
 * Trie 이론 : https://m.blog.naver.com/kks227/220938122295
 * */
public class PhoneBook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int testCase=0; testCase<t; testCase++) {
			int n = sc.nextInt();
			//루트 노드 생성
			Trie root = new Trie();
			for(int numberCount = 0; numberCount<n; numberCount++) {
				char[] phone = sc.next().toCharArray();
				root.insert(phone);
			}
			
			System.out.println(root.isConsistent()?"YES": "NO");
			
		}
	}

}

class Trie{
	Trie[] child = new Trie[10]; //한개의 노드당 0~9 자식 노드들이 들어있는 배열
	boolean isEnd = false; // 여기서 끝나는지
	boolean hasChild = false; // 자식을 가지는지
	
	//자식 노드 insert
	void insert(char[] nodes) {
	
		int childIndex = Character.getNumericValue(nodes[0]); // char -> int
		
		if(child[childIndex]==null) {
			//자식 노드 생성
			child[childIndex] = new Trie();
		}
		
		hasChild = true;
		
		if(nodes.length == 1) {
			child[childIndex].isEnd = true;
		} else {
			char[] nextNodes = new char[nodes.length-1];
			for(int next=1; next<nodes.length; next++) {
				nextNodes[next-1]= nodes[next];
			} //nodes = {'1', '2', '3'} -> nextNodes = {'2','3'} 
			child[childIndex].insert(nextNodes); // 노드 뒤에 계속 붙임
		}
		
	}
	
	//일관성 있는지 확인
	boolean isConsistent() {
		//자식 노드 있지만 isEnd면 일관성 없음
		if(hasChild == true && isEnd == true) {
			return false;
		}
		
		for(int childCount=0; childCount<child.length; childCount++) {
			if(child[childCount]!=null && !child[childCount].isConsistent()) 
				return false; //자식노드들 중에서도 일관성 없는게 있다면 일관성 없음
		}
		return true;
	}
}
