package pck1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

public class MinimumSpanningTree {

	public static void main(String[] args) {
		
		int[][] graphForPrims = { //그래프 array
				{ 0, 6, 4, -1, -1, -1, -1, -1 },
				{ 6, 0, -1, -1, 7, 3, -1, 10 },
				{ 4, -1, 0, 5, -1, 2, -1, -1 },
				{ -1, -1, 5, 0, -1, 9, 11, -1 },
				{ -1, 7, -1, -1, 0, -1, -1, 1 },
				{ -1, 3, 2, 9, -1, 0, -1, 8 }, 
				{ -1, -1, -1, 11, -1, -1, 0, -1 },
				{ -1, 10, -1, -1, 1, 8, -1, 0 } 
			};
			
		int[][] graphForKruskal = {
				{ 0, 6, 4, -1, -1, -1, -1, -1 },
				{ 6, 0, -1, -1, 7, 3, -1, 10 },
				{ 4, -1, 0, 5, -1, 2, -1, -1 },
				{ -1, -1, 5, 0, -1, 9, 11, -1 },
				{ -1, 7, -1, -1, 0, -1, -1, 1 },
				{ -1, 3, 2, 9, -1, 0, -1, 8 }, 
				{ -1, -1, -1, 11, -1, -1, 0, -1 },
				{ -1, 10, -1, -1, 1, 8, -1, 0 } 	
		};

		//Prims알고리즘 이용
		System.out.println("<Prims>");
		PrimsAlgo(graphForPrims);
		
		//Kruskal알고리즘 이용
		System.out.println("<Kruskals>");
		KruskalAlgo(graphForKruskal);
		
	}
	
	public static void PrimsAlgo(int[][] graph) {
		Vector<Integer> vertexes=new Vector<>(); //선택한 점들이 저장되는 벡터
		//Edge[] edges = new Edge[graph.length-1]; //선택한 경로들을 저장하는 배열
		
		HashMap<Integer,Edge> sortedEdges = new HashMap<>(); //오름차순으로 정렬된 edge들 <weight,해당 에지>
		
		int totalWeight=0;
		
		int startVertex = 0; //임의의 점은 1번 점으로 임의로 설정
		vertexes.add(startVertex);
		
		int tempVertex;
		while(true) {
			for(int vertexIndex = 0; vertexIndex<graph.length; vertexIndex++) {
				if(graph[startVertex][vertexIndex] > 0) { //점과 이어진 점을 찾아서
					sortedEdges.put(graph[startVertex][vertexIndex], new Edge(startVertex,vertexIndex));
				}
			}
			//해시맵정렬
			TreeMap<Integer,Edge> tm = new TreeMap<Integer,Edge>(sortedEdges);
			Iterator<Integer> iteratorKey = tm.keySet( ).iterator( );
			while(iteratorKey.hasNext()) {
				Integer key = iteratorKey.next();
				tempVertex=tm.get(key).rightVertex;
				//cycle이루는지 판단하고
				boolean isCycle = false;
				if(vertexes.contains(tempVertex)) {
					isCycle = true;
					continue;
				}
				//cycle을 이루지 않으면 그 vertex를 선택한다.
				if(!isCycle) {
					//System.out.println(key);
					totalWeight+=key;
					vertexes.add(tempVertex);
					startVertex = tempVertex;
					sortedEdges.remove(key);
					break;
				}
			}
			
			if(vertexes.size() == graph.length) {
				printResultForPrims(vertexes,totalWeight);
				break;
			}
		}
		
	}
	
	public static void KruskalAlgo(int[][] graph) {
		HashMap<Integer,Edge> edges = new HashMap<>(); //모든 edge들 저장해놓고 오름차순 정렬할 해시맵 <weight,edge>
		int[] vertexes = {0,1,2,3,4,5,6,7};//vertex들이 서로소인지  판단할 배열: 배열값이 같으면 서로소아님, 배열값이 다르면 서로소임
		Vector<Edge> selectedEdges = new Vector<>(); //선택한 edge들을 저장
		
		int totalWeight = 0;
		
		for(int rowIndex=0; rowIndex<graph.length; rowIndex++) {
			for(int colIndex=rowIndex+1; colIndex<graph[0].length; colIndex++) {
				if(graph[rowIndex][colIndex] > 0) { //연결되어있는 edge들을 저장한다.
					edges.put(graph[rowIndex][colIndex], new Edge(rowIndex,colIndex));
				}
			}
		}
		for(int key : edges.keySet()) { //오름차순으로 key값들 뽑아줌
			int leftVertex = edges.get(key).leftVertex;
			int rightVertex = edges.get(key).rightVertex;
			//서로소 이면
			if(vertexes[leftVertex] != vertexes[rightVertex]) {
				int temp = vertexes[rightVertex];
				for(int index=0;index<vertexes.length;index++) {
					if(vertexes[index] == temp) {
						vertexes[index] = vertexes[leftVertex];//작은 쪽 값으로 통일시켜줘서 둘이 서로소가 아님을 표시
					}
				}
				
				totalWeight += key; //선택한 경로의 weight더해줌
				selectedEdges.add(edges.get(key)); //정답 벡터에 해당 에지를 넣어줌
			}
		}
		
		printResultForKruskal(selectedEdges,totalWeight);
	}
	
	public static void printResultForKruskal(Vector<Edge> edges, int totalWeight) {
		//결과 경로의 edge를 출력한다.
		System.out.println("<minimum spanning tree에 edge가 포함되는 순서>");
		for(Edge edge : edges) {
			System.out.println("("+(edge.leftVertex+1)+","+(edge.rightVertex+1)+")");
		}
		
		System.out.println("total_Weight: " + totalWeight);
	}
	
	public static void printResultForPrims(Vector<Integer> vertexes, int totalWeight) {
		//결과 경로의 edge를 출력한다.
		System.out.println("<minimum spanning tree에 edge가 포함되는 순서>");
		for(int index=0;index<vertexes.size()-1;index++) {
			System.out.println("("+(vertexes.get(index)+1)+","+(vertexes.get(index+1)+1)+")");
		}
		
		System.out.println("total_Weight: " + totalWeight);
		
	}

}

class Edge{
	
	int leftVertex;
	int rightVertex;
	
	public Edge(int left, int right) {
		this.leftVertex = left;
		this.rightVertex = right;
	}
}
