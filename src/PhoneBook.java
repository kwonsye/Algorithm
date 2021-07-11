import java.util.Scanner;
/*Trie �ڷᱸ�� �̿�
 * ���� : https://www.acmicpc.net/problem/5052
 * Trie �̷� : https://m.blog.naver.com/kks227/220938122295
 * */
public class PhoneBook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int testCase=0; testCase<t; testCase++) {
			int n = sc.nextInt();
			//��Ʈ ��� ����
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
	Trie[] child = new Trie[10]; //�Ѱ��� ���� 0~9 �ڽ� ������ ����ִ� �迭
	boolean isEnd = false; // ���⼭ ��������
	boolean hasChild = false; // �ڽ��� ��������
	
	//�ڽ� ��� insert
	void insert(char[] nodes) {
	
		int childIndex = Character.getNumericValue(nodes[0]); // char -> int
		
		if(child[childIndex]==null) {
			//�ڽ� ��� ����
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
			child[childIndex].insert(nextNodes); // ��� �ڿ� ��� ����
		}
		
	}
	
	//�ϰ��� �ִ��� Ȯ��
	boolean isConsistent() {
		//�ڽ� ��� ������ isEnd�� �ϰ��� ����
		if(hasChild == true && isEnd == true) {
			return false;
		}
		
		for(int childCount=0; childCount<child.length; childCount++) {
			if(child[childCount]!=null && !child[childCount].isConsistent()) 
				return false; //�ڽĳ��� �߿����� �ϰ��� ���°� �ִٸ� �ϰ��� ����
		}
		return true;
	}
}
