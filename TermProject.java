package pck1;

import java.util.Scanner;
import java.util.Vector;

//DFS - cycle찾기
public class TermProject {

	static int cycleMemberCount;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		Vector<Integer> results = new Vector<>(testcase);
		
		for(int test=0; test < testcase; test++) {
			int students = sc.nextInt();
			int[] S = new int[students+1]; //짝꿍 학생 배열
			boolean[] visited = new boolean[students+1]; //방문여부 배열
			boolean[] finished = new boolean[students+1]; //사이클에 포함되는지에 대한 배열
			cycleMemberCount = 0;
			
			for(int student = 1; student <= students; student++) {
				S[student] = sc.nextInt();
			}
			//초기화
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
		visited[curr] = true; //방문
		int next = S[curr];
		
		if(!visited[next]) {
			dfs(S,next,visited,finished);
		}
		if(visited[next] && !finished[next]) { //사이클 성립
			for(int cycleMember = next; cycleMember!=curr ; cycleMember = S[cycleMember]) {
				cycleMemberCount++;	
			}
			cycleMemberCount++;
		}
		//****중요! 한개의 컴포넌트를 모두 돌음
		finished[curr] = true;
	}

}
