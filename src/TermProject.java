import java.util.Scanner;
import java.util.Vector;

//DFS - cycleã��
public class TermProject {

	static int cycleMemberCount;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		Vector<Integer> results = new Vector<>(testcase);
		
		for(int test=0; test < testcase; test++) {
			int students = sc.nextInt();
			int[] S = new int[students+1]; //¦�� �л� �迭
			boolean[] visited = new boolean[students+1]; //�湮���� �迭
			boolean[] finished = new boolean[students+1]; //����Ŭ�� ���ԵǴ����� ���� �迭
			cycleMemberCount = 0;
			
			for(int student = 1; student <= students; student++) {
				S[student] = sc.nextInt();
			}
			//�ʱ�ȭ
			for(int student = 1; student <= students; student++) {
				visited[student] = false;
				finished[student] = false;
			}

			//dfs
			for(int student=1; student<=students; student++) {
				if(!visited[student]) {
					dfs(S, student, visited ,finished);
				}
			}
			results.add(students-cycleMemberCount);
		}
		
		for(int result : results) {
			System.out.println(result);
		}
		
		sc.close();
	}
	
	public static void dfs(int[] S, int curr, boolean[] visited, boolean[] finished) {
		visited[curr] = true; //�湮
		int next = S[curr];
		
		if(!visited[next]) {
			dfs(S,next,visited,finished);
		}
		if(visited[next] && !finished[next]) { //����Ŭ ����
			for(int cycleMember = next; cycleMember!=curr ; cycleMember = S[cycleMember]) {
				cycleMemberCount++;	
			}
			cycleMemberCount++;
		}
		//****�߿�! �Ѱ��� ������Ʈ�� ��� ����
		finished[curr] = true;
	}

}
