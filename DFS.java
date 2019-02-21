package pck1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class DFS {
//DFS_Basic 라이님 블로그
//DFS 를 n*n 행렬로 풀면 시간복잡도가 커진다.
	
	public static void main(String[] args) {
		Graph graph = new Graph(9); //0~8까지의 노드가 있음
		//무방향 그래프 에지추가
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 5);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(2, 6);
		graph.addEdge(2, 8);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		
		graph.sortEdges(); //정렬
		/*
		for( List<Integer> list : graph.nodesArray) {
			System.out.println(list);
		}
		*/
		/*
		for(boolean b : graph.visited)
			System.out.println(b);
		*/
		graph.dfs(0);
		
	}

}

class Graph{
	
	//연결된 노드들의 집합 [node] : {ArrayList}
	List<Integer>[] nodesArray;
	
	//그래프 노드의 방문 여부
	boolean[] visited;
	
	//생성자
	public Graph(int size) {
		visited = new boolean[size];
		nodesArray = new ArrayList[size];
		
		for(int index=0; index<size; index++) {
			nodesArray[index] = new ArrayList<>();
		}
		
		for(int index=0;index<size;index++) {
			visited[index] = false;
		}
	}
	
	void addEdge(int from, int to) {
		nodesArray[from].add(to);
		nodesArray[to].add(from);
	}
	
	//에지별로 오름차순 정렬
	void sortEdges() {
		for(int index=0; index<nodesArray.length; index++) {
			Collections.sort(nodesArray[index]);
		}
	}

	void dfs(int curr) {
		visited[curr] = true;
		System.out.println("visit node#" + curr);
		for(int nextNode : nodesArray[curr]) {
			if(visited[nextNode]==false) {
				dfs(nextNode); //재귀는 함수들이 스택에 쌓이는 것과 같다.
			}
		}
	}
}
