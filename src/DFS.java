import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class DFS {
//DFS_Basic ���̴� ��α�
//DFS �� n*n ��ķ� Ǯ�� �ð����⵵�� Ŀ����.
	
	public static void main(String[] args) {
		Graph graph = new Graph(9); //0~8������ ��尡 ����
		//������ �׷��� �����߰�
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
		
		graph.sortEdges(); //����
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
	
	//����� ������ ���� [node] : {ArrayList}
	List<Integer>[] nodesArray;
	
	//�׷��� ����� �湮 ����
	boolean[] visited;
	
	//������
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
	
	//�������� �������� ����
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
				dfs(nextNode); //��ʹ� �Լ����� ���ÿ� ���̴� �Ͱ� ����.
			}
		}
	}
}
