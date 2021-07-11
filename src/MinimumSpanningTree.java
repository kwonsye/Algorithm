import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Vector;

public class MinimumSpanningTree {

	public static void main(String[] args) {
		
		int[][] graphForPrims = { //�׷��� array
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

		//Prims�˰��� �̿�
		System.out.println("<Prims>");
		PrimsAlgo(graphForPrims);
		
		//Kruskal�˰��� �̿�
		System.out.println("<Kruskals>");
		KruskalAlgo(graphForKruskal);
		
	}
	
	public static void PrimsAlgo(int[][] graph) {
		Vector<Integer> vertexes=new Vector<>(); //������ ������ ����Ǵ� ����
		//Edge[] edges = new Edge[graph.length-1]; //������ ��ε��� �����ϴ� �迭
		
		HashMap<Integer,Edge> sortedEdges = new HashMap<>(); //������������ ���ĵ� edge�� <weight,�ش� ����>
		
		int totalWeight=0;
		
		int startVertex = 0; //������ ���� 1�� ������ ���Ƿ� ����
		vertexes.add(startVertex);
		
		int tempVertex;
		while(true) {
			for(int vertexIndex = 0; vertexIndex<graph.length; vertexIndex++) {
				if(graph[startVertex][vertexIndex] > 0) { //���� �̾��� ���� ã�Ƽ�
					sortedEdges.put(graph[startVertex][vertexIndex], new Edge(startVertex,vertexIndex));
				}
			}
			//�ؽø�����
			TreeMap<Integer,Edge> tm = new TreeMap<Integer,Edge>(sortedEdges);
			Iterator<Integer> iteratorKey = tm.keySet( ).iterator( );
			while(iteratorKey.hasNext()) {
				Integer key = iteratorKey.next();
				tempVertex=tm.get(key).rightVertex;
				//cycle�̷���� �Ǵ��ϰ�
				boolean isCycle = false;
				if(vertexes.contains(tempVertex)) {
					isCycle = true;
					continue;
				}
				//cycle�� �̷��� ������ �� vertex�� �����Ѵ�.
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
		HashMap<Integer,Edge> edges = new HashMap<>(); //��� edge�� �����س��� �������� ������ �ؽø� <weight,edge>
		int[] vertexes = {0,1,2,3,4,5,6,7};//vertex���� ���μ�����  �Ǵ��� �迭: �迭���� ������ ���μҾƴ�, �迭���� �ٸ��� ���μ���
		Vector<Edge> selectedEdges = new Vector<>(); //������ edge���� ����
		
		int totalWeight = 0;
		
		for(int rowIndex=0; rowIndex<graph.length; rowIndex++) {
			for(int colIndex=rowIndex+1; colIndex<graph[0].length; colIndex++) {
				if(graph[rowIndex][colIndex] > 0) { //����Ǿ��ִ� edge���� �����Ѵ�.
					edges.put(graph[rowIndex][colIndex], new Edge(rowIndex,colIndex));
				}
			}
		}
		for(int key : edges.keySet()) { //������������ key���� �̾���
			int leftVertex = edges.get(key).leftVertex;
			int rightVertex = edges.get(key).rightVertex;
			//���μ� �̸�
			if(vertexes[leftVertex] != vertexes[rightVertex]) {
				int temp = vertexes[rightVertex];
				for(int index=0;index<vertexes.length;index++) {
					if(vertexes[index] == temp) {
						vertexes[index] = vertexes[leftVertex];//���� �� ������ ���Ͻ����༭ ���� ���μҰ� �ƴ��� ǥ��
					}
				}
				
				totalWeight += key; //������ ����� weight������
				selectedEdges.add(edges.get(key)); //���� ���Ϳ� �ش� ������ �־���
			}
		}
		
		printResultForKruskal(selectedEdges,totalWeight);
	}
	
	public static void printResultForKruskal(Vector<Edge> edges, int totalWeight) {
		//��� ����� edge�� ����Ѵ�.
		System.out.println("<minimum spanning tree�� edge�� ���ԵǴ� ����>");
		for(Edge edge : edges) {
			System.out.println("("+(edge.leftVertex+1)+","+(edge.rightVertex+1)+")");
		}
		
		System.out.println("total_Weight: " + totalWeight);
	}
	
	public static void printResultForPrims(Vector<Integer> vertexes, int totalWeight) {
		//��� ����� edge�� ����Ѵ�.
		System.out.println("<minimum spanning tree�� edge�� ���ԵǴ� ����>");
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
