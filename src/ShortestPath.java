import java.util.Scanner;
import java.util.Vector;

public class ShortestPath {
	final static int MAX=1000; //���Ѵ븦 �ǹ�
	
	public static void main(String[] args) {
		int[][] graph = {
				{0,12,15,MAX,MAX,MAX,MAX,MAX,MAX,MAX},
				{12,0,MAX,MAX,4,10,MAX,MAX,MAX,MAX},
				{15,MAX,0,21,MAX,MAX,7,MAX,MAX,MAX},
				{MAX,MAX,21,0,MAX,MAX,MAX,25,MAX,MAX},
				{4,MAX,MAX,MAX,0,3,MAX,MAX,13,MAX},
				{MAX,10,MAX,MAX,3,0,10,MAX,MAX,MAX},
				{MAX,MAX,7,MAX,MAX,10,0,19,MAX,9},
				{MAX,MAX,MAX,25,MAX,MAX,19,0,MAX,5},
				{MAX,MAX,MAX,MAX,13,MAX,MAX,MAX,0,15},
				{MAX,MAX,MAX,MAX,MAX,MAX,9,5,15,0}
		};
		
		int temp=0; //���￡�� ����
		Vector<Integer> vertexes = new Vector<>(); //���������� ����Ǵ� temp���� ����Ǵ� ����
		int[] dist = new int[graph.length]; //���￡�� �� index���������� �Ÿ��� �����ϴ� �迭
		boolean[] isVisit = new boolean[graph.length]; //�湮�ߴ��� ���� üũ�� 
		
		//dist�迭 �ʱ�ȭ
		dist = graph[0];
		
		//isVisit �ʱ�ȭ
		for(int index=0;index<isVisit.length;index++) {
			isVisit[index] = false;
		}
		//vertexes�� isVisit�ʱ�ȭ
		vertexes.add(temp);
		isVisit[temp]=true;
		
		while(true) {
			if(vertexes.size() == graph.length)
				break;
			
			//dist�߿� 0�� ������ ���� ���� ���� �ε����� �����´�.
			int min = Integer.MAX_VALUE;
			for(int index=0;index<dist.length;index++) {
				if(isVisit[index]==false && dist[index]<min) {
					min = index;
				}
			}
			temp = min; //temp�� ������Ʈ
			vertexes.add(temp);
			isVisit[temp]=true;
			
			//dist������Ʈ
			for(int index=0; index<graph[0].length; index++) {
				if(!isVisit[index]) //�湮���� ������츸
					dist[index]=Math.min(dist[index], dist[temp]+graph[temp][index]);
			}
			
		}
		
		//����� �Էºκ�
		Scanner sc = new Scanner(System.in);

		while(true) {
			String destination = sc.next();

			System.out.print("�ִ� ����� ����:");

			switch (destination) {
			case "����":
				System.out.println(dist[0]);
				break;
			case "õ��":
				System.out.println(dist[1]);
				break;
			case "����":
				System.out.println(dist[2]);
				break;
			case "����":
				System.out.println(dist[3]);
				break;
			case "���":
				System.out.println(dist[4]);
				break;
			case "����":
				System.out.println(dist[5]);
				break;
			case "�뱸":
				System.out.println(dist[6]);
				break;
			case "����":
				System.out.println(dist[7]);
				break;
			case "����":
				System.out.println(dist[8]);
				break;
			case "�λ�":
				System.out.println(dist[9]);
				break;
			}
		}
		//sc.close();
	}
		
}


